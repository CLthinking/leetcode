package com.uestc.designpattern.creational.singlton;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author CLthinking
 * @date 2019/7/16 上午 11:06
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        LazySingleton lazySingleton = LazySingleton.getInstance();

        System.out.println(Thread.currentThread().getName() +" " + ThreadLocalInstance.getInstance());
        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());

        t1.start();
        t2.start();

        System.out.println("main end");

//        HungrySingleton instance = HungrySingleton.getInstance();

//        EnumInstance instance = EnumInstance.getInstance();
//        instance.setDate(new Object());
//
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
//        oos.writeObject(instance);
//
//        File file = new File("singleton_file");
//
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//
//        EnumInstance newInstance = (EnumInstance) ois.readObject();
//
//        System.out.println(instance.getDate());
//        System.out.println(newInstance.getDate());
//
//        System.out.println(instance.getDate() == newInstance.getDate());

//        Class cls = HungrySingleton.class;
//        Class cls = EnumInstance.class;
//
//        Class cls = LazySingleton.class;
//        Constructor constructor = cls.getDeclaredConstructor(String.class, int.class);
//        constructor.setAccessible(true);
//
//
//        EnumInstance obj = (EnumInstance)constructor.newInstance("CLthinking", 1);
//        EnumInstance instance = EnumInstance.getInstance();
//
//        System.out.println(instance);
//        System.out.println(obj);
//
//        System.out.println(instance == obj);

//        EnumInstance instance = EnumInstance.INSTANCE;
//        instance.printTest();



    }
}
