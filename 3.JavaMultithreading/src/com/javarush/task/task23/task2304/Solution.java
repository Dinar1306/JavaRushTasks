package com.javarush.task.task23.task2304;

import java.util.List;
import java.util.Map;

/*
Inner 3
Внутри класса Solution:
1) реализуйте private class TaskDataProvider используя Task и MockDB, цель которого - обновить поле tasks.
2) реализуйте private class NameDataProvider используя String и MockDB, цель которого - обновить поле names.


Требования:
1. Класс TaskDataProvider должен быть создан внутри класса Solution и быть приватным.
2. Класс NameDataProvider должен быть создан внутри класса Solution и быть приватным.
3. Класс TaskDataProvider должен реализовывать интерфейс DbDataProvider с параметром типа Task.
4. Класс NameDataProvider должен реализовывать интерфейс DbDataProvider с
*/
public class Solution {

    private class TaskDataProvider extends MockDB implements DbDataProvider {
        @Override
        public void refreshAllData(Map criteria) { //должен сохранять в список tasks результат работы метода getFakeTasks класса MockDB.
            tasks = MockDB.getFakeTasks(criteria);
        }
    }
    private class NameDataProvider implements DbDataProvider{
        @Override
        public void refreshAllData(Map criteria) {
            names = MockDB.getFakeNames(criteria);
        }
    }
    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = MockView.getFakeTaskCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = MockView.getFakeNameCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    public static void main(String[] args) {

    }
}
