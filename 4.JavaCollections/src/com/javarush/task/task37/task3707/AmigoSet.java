package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.lang.reflect.*;

/*
1. Создай приватную константу Object PRESENT, которую инициализируй объектом Object, это будет наша заглушка.

2. Создай private transient поле HashMap<E,Object> map. Список ключей будет нашим сэтом, а вместо значений будем пихать в мапу заглушку PRESENT.

Напомню, нам нужны только ключи, а вместо значений для всех ключей будем вставлять PRESENT. Там же должно что-то быть :)

Посмотрим, что из этого получится :)

Коллекции обычно имеют несколько конструкторов, поэтому:

3. Создай конструктор без параметров, в котором инициализируй поле map.

4. Создай конструктор с одним параметром Collection<? extends E> collection.

Для инициализации поля map воспользуйся конструктором, в который передается Capacity.

Вычисли свою Capacity по такой формуле: максимальное из 16 и округленного в большую сторону значения (collection.size()/.75f)

Добавь все элементы из collection в нашу коллекцию.

Нужный метод добавления всех элементов у нас есть благодаря тому, что AbstractSet наследуется от AbstractCollection.

5. Напиши свою реализацию для метода метод add(E e): добавь в map элемент 'e' в качестве ключа и PRESENT в качестве значения.

Верни true, если был добавлен новый элемент, иначе верни false.
 */

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    //консутруктор1 без параметорв
    public AmigoSet() {
        map = new HashMap<>();
    }

    //консутруктор2
    public AmigoSet(Collection<? extends E> collection) {
        //Вычисли свою Capacity по такой формуле: максимальное из 16 и округленного в большую сторону значения (collection.size()/.75f)
        //int Capacity = (int)((16>collection.size()/0.75f)? 16:collection.size()/0.75f);
        int capacity = (int)Math.max(16, collection.size()/0.75f + 1); // +1 для того что бы округлилось в большую сторону
        map = new HashMap<>(capacity);

        for (E e : collection) {
            map.put(e, PRESENT);
        }
    }

    @Override
    public Iterator iterator() {
        //Метод iterator должен возвращать итератор для множества ключей поля map.
        return map.keySet().iterator();
    }

    @Override
    public boolean add(Object o) {
        return null==map.put((E) o, PRESENT);
    }

    @Override
    public void forEach(Consumer action) {

    }

//    @Override
//    public boolean contains(Object o) {  return super.contains(o);  }

    @Override
    public boolean remove(Object o) {
        //Метод remove должен удалять из map полученный в качестве параметра элемент.
        return super.remove(map.get(o)); }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public void clear(){
         map.clear();
    }
    @Override
    public boolean removeIf(Predicate filter) {
        return false;
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public Stream stream() {
        return null;
    }

    @Override
    public Stream parallelStream() {
        return null;
    }

    @Override
    public int size() {
        return map.size();
    }

    //Напиши свою реализацию метода Object clone(), сделай поверхностное клонирование.

    @Override
    public Object clone() /*throws CloneNotSupportedException*/ {
        try {
            //1) В методе клон создаем новый AmigoSet<E>.
            //2) Клонируем методом клон мапу старого сета и заносим в новый сет
            //3) возвращаем АмигоСет.
            AmigoSet copy = (AmigoSet)super.clone();
            copy.map = (HashMap) map.clone();
           return copy;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    //Первым делом в сериализации и обратно вызывается defaultWriteObject и defaultReadObject соотвественно.
    //Они запишут/прочитают ваш текущий объект, поэтому не надо его отдельно пытаться читать, писать.
    //Но это только по умолчанию.
    //Т.к. наш map отмечен transient, сериализовать и восстанавливать его придется самим.
    //Тут все просто:
    //пишем capacity, loadFactor и размер map. Первые два достаем через рефлексию, они по другому не доступны.
    //Далее в цикле пишем keySet мапы.
    //Пишем keySet а не Entry, т.к. сериализовать values нет смысла, они же одинаковые.
    //
    //В readObject читаем все в том же порядке.
    //Теперь у нас есть все, чтобы восстановить map.
    //Создаем новый объект с capacity и loadFactor в конструкторе.
    //В цикле читаем и добавляем в новый map восстановленные объекты E.
    //В качестве value используем PRESENT.
    //Profit.

    private void writeObject(ObjectOutputStream oos) throws Exception{

            oos.defaultWriteObject();
            oos.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
            oos.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
            oos.writeInt(map.size());

            for (E e : map.keySet()) oos.writeObject(e);


    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{ // чтение/десериализация.

            ois.defaultReadObject();
            int capacity  = (int) ois.readInt();
            float loadFactor = (float) ois.readFloat();
            int size = (int) ois.readInt();

            map = new HashMap<>(capacity,loadFactor);

            for (int i = 0; i < size; i++)
            {
                E e = (E) ois.readObject();
                map.put(e,PRESENT);
            }

    }

}
