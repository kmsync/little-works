package com.bilgeadam;

public class Main {

    public static void main(String[] args) {

        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    producerConsumer.produce();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    producerConsumer.consume();
                }
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        }catch (InterruptedException interruptedException){
            System.err.println(interruptedException.getMessage());
        }
        System.out.println("main thread sonlandı.");
    }
}