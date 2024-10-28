package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
public class BudgetTracker {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ExpenseStorage expenseStorage = new ExpenseStorage();
        IncomeStorage incomeStorage = new IncomeStorage();

//
        expenseStorage.loadFromFile();
        incomeStorage.loadFromFile();


        System.out.println("Enter Your First Name");
        String firstName = scanner.nextLine();
        System.out.println("Enter Your Last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter Your Username");
        String username = scanner.nextLine();


        System.out.println("Welcome " + username + "!");

        ArrayList<String> usernames = new ArrayList<>();
        usernames.add(username);

        while (true) {  // main meu loop ( list)
            System.out.println("1. Add Expense");
            System.out.println("2. Add Income");
            System.out.println("3. View Expense");
            System.out.println("4. View Income");
            System.out.println("5. Exit");
            System.out.println("Choose an option:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter amount");
                    double expenseAmount = scanner.nextDouble();
                    System.out.println("Enter Category");
                    System.out.println(" 1. FOOD/t" + "2.TRANSPORT/t" + "3.BILLS/t" + "4.ENTERTAINMENT/t" + "5.OTHER/n");
                    int expenseCategoryChoice = scanner.nextInt();
                    EExpenseCategory expenseCategory = EExpenseCategory.values()[expenseCategoryChoice];
                    Expense expense = new Expense(expenseAmount, new Date(), expenseCategory);
                    expenseStorage.addExpense(expense);

                    break;

                case 2:
                    System.out.println("Enter amount");
                    double incomeAmount = scanner.nextDouble();
                    System.out.println("Enter Category");
                   System.out.println("1. SALARY/t" + "2.FREELANCE/t" + "3.GIFT/t" + "4.OTHER/n");
int incomeCategoryChoice = scanner.nextInt();
                  EIncomeCategory incomeCategory = EIncomeCategory.values()[incomeCategoryChoice];
                    Income income = new Income(incomeAmount, new Date());
                    incomeStorage.addIncome(income);
                    break;
                case 3:
                    System.out.println("Expense");
                    for (Expense exp : expenseStorage.getExpenses()) {
                        System.out.println(exp.getAmount() + "-" + exp.getCategory());
                    }
                    break;
                case 4:
                    System.out.println("Income");
                    for (Income inc : incomeStorage.getIncomes()) {
                        System.out.println(inc.getAmount() + "-");
                    }
                    break;
                case 5:
                    System.exit(0);

            }


        }
    }
}

