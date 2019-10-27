package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

/* 
ClassLoader - что это такое?
Реализуй логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.


Требования:
1. Размер множества возвращаемого методом getAllAnimals должен быть равен количеству классов поддерживающих интерфейс Animal и имеющих публичный конструктор без параметров (среди классов расположенных в директории переданной в качестве параметра).
2. В множестве возвращаемом методом getAllAnimals должны присутствовать все классы поддерживающие интерфейс Animal и имеющие публичный конструктор без параметров (среди классов расположенных в директории переданной в качестве параметра).
3. В множестве возвращаемом методом getAllAnimals НЕ должен присутствовать ни один класс не поддерживающий интерфейс Animal или не имеющий публичного конструктора без параметров (среди классов расположенных в директории переданной в качестве параметра).
4. Метод getAllAnimals должен быть статическим.
*/
public class Solution extends ClassLoader{
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }
    // если это папка
    //добавить их во временный сет
    //в цикле перебора временного сета
    //читать содержимое файлов
    //если есть implements Animal & публичный конструктор без параметров
    //то создать этот объект
    //добавить его в выходной сет
    //вернуть сет
    //иначе вернуть пустой сет
    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<Animal> result = new HashSet();

        File file = new File(pathToAnimals);
        File[] files = file.listFiles();
        Set<Animal> animals = new HashSet<>();

        for (File f: files) {
            Solution solution = new Solution();
            Class clazz = solution.findClass(f.getAbsolutePath());
            Constructor [] constructors = clazz.getConstructors();


            for (Constructor c : constructors) {
                if (c.getModifiers() == Modifier.PUBLIC) {
                    if (c.getParameterTypes().length == 0) {
                        if (Animal.class.isAssignableFrom(clazz)) {
                            c.setAccessible(true);
                            animals.add((Animal) c.newInstance());
                        }
                    }
                }
            }
        }
        return animals;
    }



    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            Path file = Paths.get(name);
            byte[] bytes = Files.readAllBytes(file);
            return defineClass(null, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
