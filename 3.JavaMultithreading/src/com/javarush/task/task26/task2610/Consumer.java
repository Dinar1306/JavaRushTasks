package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private BlockingQueue queue;

    @Override
    public void run() {

            try {
                while (true) {
                    System.out.println(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }




    }


    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }
}
