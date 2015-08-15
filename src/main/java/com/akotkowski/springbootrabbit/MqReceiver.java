package com.akotkowski.springbootrabbit;

import java.util.concurrent.CountDownLatch;

/**
 * Created by adam on 16/08/15.
 */
public class MqReceiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
