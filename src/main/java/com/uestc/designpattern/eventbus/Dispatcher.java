package com.uestc.designpattern.eventbus;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @author CLthinking
 * @date 2019/7/11 下午 10:09
 */
public class Dispatcher {

    private final Executor executor;
    private final EventExceptionHandler exceptionHandler;

    public static final Executor SEQ_EXECUTOR = SeqExectorService.INSTANCE;
    public static final Executor PER_THREAD_EXECUTOR = PerThreadExectorService.INSTANCE;


    private Dispatcher(Executor executor, EventExceptionHandler exceptionHandler) {
        this.executor = executor;
        this.exceptionHandler = exceptionHandler;
    }

    public void dispatch(Bus bus, Registry registry, Object event, String topic) {
        ConcurrentLinkedQueue<Subscriber> subscribers = registry.scanSubscriber(topic);
        if (null == subscribers) {
            if (exceptionHandler != null) {
                exceptionHandler.handle(new IllegalArgumentException("The topic " + topic + " not bind yet"),
                        new BaseEventContext(bus.getBusName(), null, event));
            }
            return;
        }
        subscribers.stream()
                .filter(Subscriber::isNotDisable)
                .filter(s -> {
                    Class<?> cls = s.getSubscriberMethod().getParameterTypes()[0];
                    return cls.isAssignableFrom(event.getClass());
                }).forEach(subscriber -> realInvokeSubscribe(subscriber, event, bus));
    }

    private void realInvokeSubscribe(Subscriber subscriber, Object event, Bus bus) {
        Method subscriberMethod = subscriber.getSubscriberMethod();
        Object subscriberObject = subscriber.getSubscriberObject();

        executor.execute(() -> {
            try {
                subscriberMethod.invoke(subscriberObject, event);
            } catch (Exception e) {
                if (null != exceptionHandler) {
                    exceptionHandler.handle(e, new BaseEventContext(bus.getBusName(), subscriber, event));
                }
            }
        });
    }

    public void close() {
        if (executor instanceof ExecutorService) {
            ((ExecutorService)executor).shutdown();
        }
    }
    static Dispatcher newDispatcher( Executor executor, EventExceptionHandler handler) {
        return new Dispatcher(executor, handler);
    }

    static Dispatcher newSeqDispatcher(EventExceptionHandler handler) {
        return new Dispatcher(SeqExectorService.INSTANCE, handler);
    }

    static Dispatcher newPerThreadDispatcher(EventExceptionHandler handler) {
        return new Dispatcher(PerThreadExectorService.INSTANCE, handler);
    }


    private static class SeqExectorService implements Executor {

        private final static SeqExectorService INSTANCE = new SeqExectorService();
        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }

    private static class PerThreadExectorService implements Executor {

        private final static PerThreadExectorService INSTANCE = new PerThreadExectorService();

        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }

//    public static void main(String[] args) {
//        System.out.println(Object.class.isAssignableFrom(Integer.class));
//        System.out.println(Object.class.isInstance(Integer.valueOf(1)));
//    }

    private static class BaseEventContext implements EventContext {
        private final String eventBusName;

        private final Subscriber subscriber;

        private  final Object event;

        public BaseEventContext(String eventBusName, Subscriber subscriber, Object event) {
            this.eventBusName = eventBusName;
            this.subscriber = subscriber;
            this.event = event;
        }

        @Override
        public String getSource() {
            return eventBusName;
        }

        @Override
        public Object getSubscriber() {
            return subscriber == null ? null :  subscriber.getSubscriberObject() ;
        }

        @Override
        public Method getSubscribe() {
            return subscriber == null ? null : subscriber.getSubscriberMethod();
        }

        @Override
        public Object getEvent() {
            return event;
        }
    }
}
