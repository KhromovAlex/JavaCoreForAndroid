package ru.geekbrains.lesson5;

public class Person {
    private final String fullName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Person(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private void setAge() {
        this.age++;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Сотрудник: " + fullName +
                ", " + age + " лет. " +
                "Должность " + position +
                ", зарплата " + salary + ". " +
                "Контакты: email " + email +
                ", телефон " + phone +
                '.';
    }
}
