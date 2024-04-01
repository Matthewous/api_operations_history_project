package ru.netology.mmoguchev;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> transactions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите данные для транзакции:");

            System.out.print("Сумма: ");
            double amount = scanner.nextDouble();

            System.out.print("Дата: ");
            String date = scanner.next();

            System.out.print("Категория: ");
            String category = scanner.next();

            transactions.add(STR."Сумма: \{amount}, Дата: \{date}, Категория: \{category}");

            System.out.println("Желаете продолжить ввод? (да/нет)");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("нет")) {
                System.out.println("Список введенных за сессию транзакций:");
                for (String transaction : transactions) {
                    System.out.println(transaction);
                }
                break;
            }
        }

        scanner.close();
    }
}
