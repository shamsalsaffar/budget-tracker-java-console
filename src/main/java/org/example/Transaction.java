package org.example;

import java.util.Date;

public class Transaction {  // use abstract class helps to improve organization , maintainability

    protected double amount; // use protected for more facilitates inheritance, allow subclasses
    protected Date date;

    public Transaction (double amount, Date date){   // contractor
        this.amount = amount;
        this.date = date;
    }
// getter and setter

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getData() {
        return date;
    }

    public void setData(Date date) {
        this.date = date;
    }
}
