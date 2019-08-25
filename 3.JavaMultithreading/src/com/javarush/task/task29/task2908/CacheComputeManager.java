package com.javarush.task.task29.task2908;

import java.util.concurrent.*;

/* Argument and Value are generic types*/
public class CacheComputeManager<Argument, Value> implements Computable<Argument, Value> {
    private final ConcurrentHashMap<Argument, Future<Value>> cache = new ConcurrentHashMap<>();
    private final Computable<Argument, Value> computable;

    public CacheComputeManager(Computable<Argument, Value> computable) {
        this.computable = computable;
    }

    @Override
    public Value compute(final Argument arg) throws InterruptedException {
        Future<Value> f = cache.get(arg);
        if (f == null) {
            FutureTask<Value> ft = createFutureTaskForNewArgumentThatHasToComputeValue(arg);
            cache.putIfAbsent(arg, ft);
            f = ft;
            ft.run();
            System.out.print(arg + " will be cached  ");
        } else {
            System.out.print(arg + " taken from cache  ");
        }
        try {
            return f.get();
        } catch (CancellationException e) {
            cache.remove(arg, f);
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
        return null;
    }

    public FutureTask<Value> createFutureTaskForNewArgumentThatHasToComputeValue(final Argument arg) throws InterruptedException {

        FutureTask<Value> futureTask = new FutureTask<Value>(new Callable() { //в конструкторе FutureTask создаваем объект анонимного класса, реализующего интерфейс Callable
            @Override
            public Object call() throws Exception {
                return computable.compute(arg);
            }
        });
        return futureTask;
    }

    /***
    При использовании Callable и Future, нам необходимо было для каждого объекта Callable создавать объект принимающий результат работы
    Future. Таким образом мы были вынуждены хранить и обрабатывать два списка: один список задач (Callable) и второй с результатами
    (Future). FutureTask позволяет одновременно контролировать запуск задачи, её состояние и результат всего одним объектом, который
    к тому же запускается на исполнение методом run() как объекта Runnable.
    Таким образом, создав объект Callable и поместив его в FutureTask, можно в дальнейшем работать в только с эти объектом не
    вспоминая о Callable вообще.
     ***/
}
