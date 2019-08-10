package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
CrUD - Create, Update, Delete.

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990


Требования:
1. Класс Solution должен содержать public static поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.

*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        // args[0] - команда. Дальше ifы в зависимости от неё.
        Person person = null;
        Date personBD = new Date();




        if (args[0].equals("-c")) { // если команда на добавление
            // нужно подготовить дату - перевести из String в Date
            String[] bd = args[3].split("/");
            personBD.setDate(Integer.parseInt(bd[0]));      // первое число
            personBD.setMonth(Integer.parseInt(bd[1])-1);   // месяц, нумерация для месяцев 0-11
            personBD.setYear(Integer.parseInt(bd[2])-1900);      // год

            switch (args[2]){
                case "м": {
                    person = Person.createMale(args[1], personBD);
                    break;
                }
                case "ж": {
                    person = Person.createFemale(args[1], personBD);
                    break;
                }
            }

            allPeople.add(person);
            System.out.println(allPeople.size()-1);
        } else if (args[0].equals("-u")){ //обновляем данные человека с данным id

            // нужно подготовить дату - перевести из String в Date
            String[] bd = args[4].split("/");
            personBD.setDate(Integer.parseInt(bd[0]));      // первое число
            personBD.setMonth(Integer.parseInt(bd[1])-1);   // месяц, нумерация для месяцев 0-11
            personBD.setYear(Integer.parseInt(bd[2])-1900);      // год

            // берем человека
            person = allPeople.get(Integer.parseInt(args[1]));
            person.setBirthDate(personBD);
            person.setName(args[2]);
            // готовим пол человека для обновления
            Sex sex = null;
            switch (args[3]){
                case "м": {
                    sex = Sex.MALE;
                    break;
                }
                case "ж": {
                    sex = Sex.FEMALE;
                    break;
                }
            }
            // устанавливаем пол человека при обновлении
            person.setSex(sex);
            //allPeople.add(Integer.parseInt(args[1]), person);

        } else if (args[0].equals("-d")){
            person = allPeople.get(Integer.parseInt(args[1]));
            person.setSex(null);
            person.setName(null);
            person.setBirthDate(null);
            //allPeople.add(Integer.parseInt(args[1]), person);
        } else if (args[0].equals("-i")){
            person = allPeople.get(Integer.parseInt(args[1]));
            String sex = null;
            String[] fullname;
            String lastname = null;
            switch (person.getSex()){
                case MALE: {
                    sex = "м";
                    break;
                }
                case FEMALE: {
                    sex = "ж";
                    break;
                }
            }
//            fullname = person.getName().split(" ");
//            lastname = fullname[0];
            personBD = person.getBirthDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            System.out.println(person.getName() + " " + sex + " " +  sdf.format(personBD));
        }


    }
}
