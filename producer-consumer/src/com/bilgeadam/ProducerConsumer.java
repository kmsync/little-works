package com.bilgeadam;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {

    Random random = new Random();

    private ArrayBlockingQueue<Integer> queue new=

    ArrayBlockingQueue(10);


    public void produce() {
        if (this.queue.size() == 10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Integer value = this.random.nextInt();
        try {
            this.queue.put(value);
            System.out.println("Producer üretiliyor. " + value);
        } catch (InterruptedException interruptedException) {
            System.err.println(interruptedException.getMessage());
        }
    }


    public void consume() {
        try {
            Integer value = this.queue.take();
            System.out.println("Consumer tüketiliyor. " + value);
        } catch (InterruptedException interruptedException) {
            System.err.println(interruptedException.getMessage());
        }


    }

}
