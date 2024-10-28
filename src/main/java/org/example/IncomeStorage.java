package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class IncomeStorage {
    private List<Income>incomes;
    Gson gson = new Gson();
    public IncomeStorage(){
       // incomes = new ArrayList<>();
    }

    public void loadFromFile() throws FileNotFoundException {
        Type type = new TypeToken<ArrayList<Income>>() {}.getType();
        Reader reader = new FileReader("src/main/incomes.json");
        incomes = gson.fromJson(reader, type);

        System.out.println("Loaded file");
    }

    public void saveToFile() throws IOException {
       // incomes.add(income);
        FileWriter fw = new FileWriter("src/main/incomes.json");
        gson.toJson(incomes, fw);
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


    public void addIncome(Income income) throws IOException {
        incomes.add(income);
        saveToFile();
    }
    public void removeIncome(Income income) throws IOException {
        incomes.remove(income);
        saveToFile();
    }

    public List<Income> getIncomes() {
        return incomes;
    }
    public boolean updateIncome(int index, Income newIncome) throws IOException {
        if (index >= 0 && index < incomes.size()) {
            incomes.set(index, newIncome);
            saveToFile();
            return true;
        } return false;
    }
}


