package org.example;

import java.util.Date;

public class Income extends Transaction {
    public Income(double amount, Date date) {
        super(amount, date);
    }
    //private EIncomeCategory category;



    /* public Income (double amount, Date date, EIncomeCategory category){
         super(amount, date);
         this.category = category;
     }*/
    // getter and setter
   /* public EIncomeCategory getCategory(){
        return category;
    }

    public void setCategory(EIncomeCategory category) {
        this.category = category;
    }*/
}
