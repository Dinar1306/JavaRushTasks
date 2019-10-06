package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods someInterfaceWithMethodsOriginal;
//CustomInvocationHandler должен иметь один публичный конструктор с одним аргументом типа SomeInterfaceWithMethods.
    public CustomInvocationHandler (SomeInterfaceWithMethods oridginal){
        someInterfaceWithMethodsOriginal = oridginal;
    }

    @Override   //перехват
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+" in");
        Object obj = method.invoke(someInterfaceWithMethodsOriginal, args);
        System.out.println(method.getName()+" out");
        return obj;
    }
}
