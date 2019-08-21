package com.javarush.task.task28.task2805;



public class MyThread extends Thread{
    private static int priority = 0;
    //блок не статической инициализации
    {
        if (this.getThreadGroup() != null) { //если поток принадлежит группе
            if (priority < this.getThreadGroup().getMaxPriority() && priority < MAX_PRIORITY) { //если и приоритет.макс. потока и макс.приоритет больше текущего приоритета
                this.setPriority(++priority);       // назначаем приоритет
            } else if(priority < MAX_PRIORITY){
                priority = ++priority;
                this.setPriority(this.getThreadGroup().getMaxPriority());
            } else{
                priority = 1;
                this.setPriority(MIN_PRIORITY);
            }
        }
    }

    public MyThread() {
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
        super(group, target, name, stackSize, inheritThreadLocals);
    }
}
