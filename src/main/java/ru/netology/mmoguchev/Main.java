package ru.netology.mmoguchev;

import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

class Operation {
    private double amount;
    private Date date;
    private String category;

    public Operation(double amount, Date date, String category) {
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Operation> transactions = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {

            System.out.println("Options: \n1. Continue entering transactions\n2. Search transactions\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Enter amount of transaction:");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Enter date of transaction (dd/MM/yyyy):");
                String dateString = scanner.nextLine();
                Date date = null;
                try {
                    date = sdf.parse(dateString);
                } catch (Exception e) {
                    System.out.println("Invalid date format. Please enter date in format dd/MM/yyyy.");
                    continue;
                }

                System.out.println("Enter category of transaction:");
                String category = scanner.nextLine();

                Operation newTransaction = new Operation(amount, date, category);
                transactions.add(newTransaction);
            } else if (choice == 2) {
                searchTransactions(transactions, scanner, sdf);
            } else if (choice == 3) {
                for (Operation trans : transactions) {
                    System.out.println("Your transactions:");
                    System.out.println(STR."Amount: \{trans.getAmount()} Date: \{sdf.format(trans.getDate())} Category: \{trans.getCategory()}");
                }
                break;
            }
        }

        scanner.close();
    }

    public static void searchTransactions(ArrayList<Operation> transactions, Scanner scanner, SimpleDateFormat sdf) {
        System.out.println("Enter start date for search (dd/MM/yyyy):");
        String startDateString = scanner.nextLine();
        Date startDate = null;
        try {
            startDate = sdf.parse(startDateString);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter date in format dd/MM/yyyy.");
            return;
        }

        System.out.println("Enter end date for search (dd/MM/yyyy):");
        String endDateString = scanner.nextLine();
        Date endDate = null;
        try {
            endDate = sdf.parse(endDateString);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter date in format dd/MM/yyyy.");
            return;
        }

        for (Operation trans : transactions) {
            if (trans.getDate().after(startDate) && trans.getDate().before(endDate)) {
                System.out.println(STR."Amount: \{trans.getAmount()} Date: \{sdf.format(trans.getDate())} Category: \{trans.getCategory()}");
            }
        }
    }
}
