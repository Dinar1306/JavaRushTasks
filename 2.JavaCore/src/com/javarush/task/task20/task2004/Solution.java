package com.javarush.task.task20.task2004;

import java.io.*;

/* 
Читаем и пишем в файл статики
Реализуй логику записи в файл и чтения из файла для класса ClassWithStatic.
Метод load должен инициализировать объект включая статические поля данными из файла.
Метод main не участвует в тестировании.


Требования:
1. Должна быть реализована возможность сохранения/загрузки объектов типа Solution.ClassWithStatic с помощью методов save/load.
2. Класс Solution не должен поддерживать интерфейс Serializable.
3. Класс Solution.ClassWithStatic не должен поддерживать интерфейс Serializable.
4. Класс Solution.ClassWithStatic должен быть публичным.
5. Класс Solution.ClassWithStatic не должен поддерживать интерфейс Externalizable.



*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            //here check that the classWithStatic object is equal to the loadedObject object - проверьте тут, что classWithStatic и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(Solution.ClassWithStatic.staticString);
            writer.newLine();
            writer.write(String.valueOf(i));
            writer.newLine();
            writer.write(String.valueOf(j));
            writer.newLine();
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()){
                /*ClassWithStatic statics = new ClassWithStatic();
                statics.staticString = reader.readLine();
                statics.i = Integer.parseInt(reader.readLine());
                statics.j = Integer.parseInt(reader.readLine());*/
                Solution.ClassWithStatic.staticString = reader.readLine();
                this.i = Integer.parseInt(reader.readLine());
                this.j = Integer.parseInt(reader.readLine());

            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassWithStatic that = (ClassWithStatic) o;

            if (i != that.i) return false;
            return j == that.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}
