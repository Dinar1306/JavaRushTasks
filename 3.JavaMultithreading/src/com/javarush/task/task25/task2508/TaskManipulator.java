package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName());
                Thread.currentThread().sleep(100);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void start(String threadName) {

        thread = new Thread(new TaskManipulator());
        thread.setName(threadName);
        thread.start();
        //System.out.println(threadName);
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
