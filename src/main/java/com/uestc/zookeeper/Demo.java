package com.uestc.zookeeper;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Demo implements Watcher {
    private ZooKeeper zk;
    private String host = "127.0.0.1:2181";
    private static CountDownLatch countDownLatch = new CountDownLatch(1);


    public void startZK() throws Exception {
        zk = new ZooKeeper(host, 15000, this);
        System.out.println(zk.getState());
        countDownLatch.await();
        System.out.println("ZK session established");
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("Receive watched event: " + event);
        if (Event.KeeperState.SyncConnected == event.getState()) {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws Exception{
        Demo demo = new Demo();
        demo.startZK();
        //TimeUnit.SECONDS.sleep(60);
    }

}
