package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class ExpenseStorage {
    private List<Expense>expenses;

   Gson gson = new Gson();
   public ExpenseStorage(){
            // incomes = new ArrayList<>();
        }

        public void loadFromFile() throws FileNotFoundException {
            Type type = new TypeToken<ArrayList<Expense>>() {}.getType();
            Reader reader = new FileReader("src/main/incomes.json");
            expenses = gson.fromJson(reader, type);

            System.out.println("Loaded file");
        }

        public void saveToFile() throws IOException {
            // incomes.add(income);
            FileWriter fw = new FileWriter("src/main/incomes.json");
            gson.toJson(expenses, fw);
            fw.close();
            System.out.println("saved file");
        }
/*        try(Writer writer = new FileWriter("incomes.json")){
            Gson gson = new Gson();
            gson.toJson(incomes,writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        try(Reader reader = new FileReader("src/main/incomes.json")) {
            Gson gson = new Gson();
            Income[] incomeArray = gson.fromJson(reader, Income[].class);
            incomes = new ArrayList<>(List.of(incomeArray));
        }catch (IOException e){
            e.printStackTrace();
        }
    }*/


        public void addExpense(Expense expense) throws IOException {
            expenses.add(expense);
            saveToFile();
        }
        public void removeExpense(Expense expense) throws IOException {
            expenses.remove(expense);
            saveToFile();
        }

        public List<Expense> getExpenses() {
            return expenses;
        }
        public boolean updateExpense(int index, Expense newExpense) throws IOException {
            if (index >= 0 && index < expenses.size()) {
                expenses.set(index, newExpense);
                saveToFile();
                return true;
            } return false;
        }
    }



/*
    private void saveToFile(){    // file in json to save files
        try(Writer writer = new FileWriter("expenses.json")) {
            Gson gson = new Gson();
            gson.toJson(expenses, writer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loadFromFile(){
        try(Reader reader = new FileReader("src/main/expense.json")) {
            Gson gson = new Gson();
            Expense[] expensesArray = gson.fromJson(reader, Expense[].class);
            expenses = new ArrayList<>(List.of(expensesArray));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public ExpenseStorage(){
        expenses = new ArrayList<>();
    }
    public void addExpense(Expense expense){
        expenses.add(expense);
        saveToFile();

    }
    public void removeExpense(Expense expense){
        expenses.remove(expense);
        saveToFile();
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
    public boolean updateIncome(int index, Expense newExpense){
        if (index >= 0 && index < expenses.size()) {
            expenses.set(index, newExpense);
            saveToFile();
            return true;
        } return false;
    }

}
*/