package ru.netology.mmoguchev;


import java.util.Scanner;

public class Main {
    // Предположим, что у нас есть список операций
    static Operation[] operations = {
            new Operation("2022-02-24",100,"Buy"),
            new Operation("2022-03-13",100,"Buy"),
            new Operation("2024-07-24",100,"Buy"),
            new Operation("2024-08-09",100,"Buy"),
            new Operation("2023-05-19",100,"Buy")
    };
    // Предположим, что у нас есть список клиентов
    static Customer[] customers = {
            new Customer("Mat","1234"),
            new Customer("Tom","2456"),
            new Customer("Steve","5432")
    };
    

    public static void main(String[] args) {

        // /Соответствие операциии клиенту
        int[][] statement = new int[100][10];
        statement[1][0] = 1; // Операция с ID = 1 является первой операцией клиента с ID 1
        statement[1][1] = 2; // Операция с ID = 2 является второй операцией клиента с ID 1
        statement[2][0] = 3; // Операция с ID = 3 является первой операцией клиента с ID 2
        statement[3][0] = 4; // Операция с ID = 4 является первой операцией клиента с ID 3
        statement[3][1] = 5; // Операция с ID = 5 является первой операцией клиента с ID 3

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать клиента");
            System.out.println("2. Создать операцию");
            System.out.println("3. Найти операции по датам");
            System.out.println("4. Найти операции клиента");
            System.out.println("5. Завершить работу");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                Customer.createCustomerFromConsole();
            } else if (choice == 2) {
                int[] result = Operation.createOperationWithClientFromConsole(customers);

                int operationId = result[0];
                int clientId = result[1];

                int customersOperationsCount = Operation.countClientOperations(statement,clientId);
                System.out.println(STR."Кол-во операций клиента: \{customersOperationsCount}");
                statement[clientId][customersOperationsCount] = operationId;
                System.out.print("Создана операция");

            } else if (choice == 3) {
                Operation.findOperationsByDateRange(operations);

            } else if (choice == 4) {
                Operation.findOperationsByClientID(statement,operations);

            } else if (choice == 5) {
                System.out.println("Работа завершена.");
                break;
            } else {
                System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            }
        }

        scanner.close();
    }
}