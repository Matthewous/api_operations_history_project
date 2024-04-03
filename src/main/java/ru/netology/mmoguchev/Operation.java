package ru.netology.mmoguchev;

import java.util.Scanner;

public class Operation {
    private static int nextId = 1;
    private int id;
    //private int clientId;
    private String date;
    private double amount;
    private String category;

    // Конструктор без аргументов
    public Operation(String date, double amount, String category) {
        this.id = nextId++;
        //this.clientId = clientId;
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    // Метод для ввода информации об операции из консоли и указания связанного клиента
    public static Operation createOperationWithClientFromConsole(Customer[] customers, Operation[] operations) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите дату операции: ");
        String date = input.next();

        System.out.print("Введите сумму операции: ");
        double amount = input.nextDouble();

        System.out.print("Введите категорию операции: ");
        String category = input.next();

        Operation newOperation = new Operation(date, amount, category);

        return newOperation;
    }

    public static int clientIdCheck(Customer[] customers) {
        Scanner input = new Scanner(System.in);


        int final_client_id = -1; // Инициализация переменной final_client_id за пределами цикла

        while (true) {
            System.out.print("Введите ID клиента: ");
            int client_id = input.nextInt();
            Customer client = null;

            boolean check = false;

            for (Customer customer : customers) {
                if (customer.getId() == client_id) {
                    client = customer;
                    final_client_id = client_id; // Присвоение значения final_client_id при нахождении клиента
                    check = true;
                    break;
                }
            }

            if (check == true) break;

            if (client == null) {
                System.out.println("Клиент с ID " + client_id + " не найден.");
                System.out.println("1. Создать нового клиента.");
                System.out.println("2. Изменить введенный ID.");

                int choice = input.nextInt();

                if (choice == 1) {
                    Customer newCustomer = Customer.createCustomerFromConsole();
                    final_client_id = newCustomer.getId();
                    break;
                }
            }
        }
        return final_client_id;
    }

    public static int countClientOperations(int[][] statement, int clientID) {
        int operationCount = 0;

        for (int i = 0; i < statement.length; i++) {
            if (i == clientID) {
                for (int j = 0; j < statement[i].length; j++) {
                    if (statement[i][j] != 0) { // Проверка, что операция присутствует (не равна 0)
                        operationCount++;
                    }
                }
            }
        }

        return operationCount;
    }

    public static void findOperationsByDateRange(Operation[] operations) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальную дату в формате yyyy-MM-dd:");
        String startDate = scanner.next();

        System.out.println("Введите конечную дату в формате yyyy-MM-dd:");
        String endDate = scanner.next();

        // Проходим по всем операциям и проверяем, попадает ли текущая операция в заданный диапазон дат
        for (Operation operation : operations) {
            if (operation.getDate().compareTo(startDate) >= 0 && operation.getDate().compareTo(endDate) <= 0) {
                // Если операция попадает в диапазон дат, выводим информацию об операции
                System.out.println(STR."ID: \{operation.getId()}, Дата: \{operation.getDate()}, Сумма: \{operation.getAmount()}, Категория: \{operation.getCategory()}");
            }
        }
    }

    public static void findOperationsByClientID(int[][] statement,Operation[] operations) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID клиента:");
        int clientId = scanner.nextInt();

        System.out.println(STR."Операции для клиента с ID \{clientId}:");

        for (Operation operation : operations) {
            for (int j = 0; j < statement[clientId].length; j++) {
                if (operation.getId() == statement[clientId][j]) {
                    System.out.println(STR."Дата: \{operation.getDate()}, Сумма: \{operation.getAmount()}, Категория: \{operation.getCategory()}");
                    break;
                }
            }
        }
    }

    public void print(Operation operation) {
        System.out.println(STR."ID: \{operation.getId()}, Дата: \{operation.getDate()}, Сумма: \{operation.getAmount()}, Категория: \{operation.getCategory()}");
    }

    public interface ConsolePrintable {
        void print();
    }

    public class CashbackOperation extends Operation implements ConsolePrintable{
        private int cashbackAmount;

        public CashbackOperation(String date, double amount, String category) {
            super(date, amount, category);
        }

        @Override
        public void print() {
            System.out.println(STR."Кэшбэк: ID: \{getId()}, Дата: \{getDate()}, Сумма: \{getAmount()} Кэшбэк: \{cashbackAmount}, Категория: \{getCategory()}");
        }
    }

    public class LoanOperation extends Operation implements ConsolePrintable {
        private int loanId;

        public LoanOperation(String date, double amount, String category) {
            super(date, amount, category);
        }

        @Override
        public void print() {
            System.out.println(STR."Кэшбэк: ID: \{getId()}, Дата: \{getDate()}, Сумма: \{getAmount()} ID кредита: \{loanId}, Категория: \{getCategory()}");
        }
    }

    // Геттеры и сеттеры для id, clientId, date, amount, category
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //public int getClientId() {
        //return clientId;
    //}

    //public void setClientId(int clientId) {
        //this.clientId = clientId;
    //}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}