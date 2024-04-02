package ru.netology.mmoguchev;


import java.util.Scanner;

public class Customer {
    private static int nextId = 1;
    private int id;
    private String name;
    private String phone;


    // Конструктор без аргументов
    public Customer(String name, String phone) {
        this.id = nextId++;
        this.name = name;
        this.phone = phone;
    }

    // Метод для ввода информации о клиенте из консоли
    public static Customer createCustomerFromConsole() {
        Scanner input = new Scanner(System.in);


        System.out.print("Введите имя клиента: ");
        String name = input.next();

        System.out.print("Введите телефон клиента: ");
        String phone = input.next();

        Customer customer = new Customer(name, phone);

        return customer;
    }

    public Customer print() {
        System.out.println(STR."Клиент: ID: \{id} Name: \{name} Phone: \{phone}");
        return null;
    }

    // Геттеры и сеттеры для id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Геттеры и сеттеры для name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Геттеры и сеттеры для phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}