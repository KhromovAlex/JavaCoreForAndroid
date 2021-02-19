package ru.geekbrains.lesson5;

public class Main {
    public static void main(String[] args) {
        Person[] personList = new Person[5];
        personList[0] = new Person("Иван Иванов", "Тестировщик", "ivivan@mail.com", "892312312", 30000, 30);
        personList[1] = new Person("Анжела Карловна", "Секретарь", "an@bk.ru", "83540323540", 15000, 41);
        personList[2] = new Person("Вася Пупкин", "Программист", "vasya@ya.ru", "88005553535", 50000, 45);
        personList[3] = new Person("Алекс Петров", "Программист", "alexpetrov@mail.ru", "85553335500", 46000, 25);
        personList[4] = new Person("Дуся Форточкина", "Дизайнер", "dusya@mail.ru", "89000000000", 40000,38);

        for (Person person : personList) {
            if (person.getAge() > 40) {
                person.printInfo();
            }
        }
    }
}
