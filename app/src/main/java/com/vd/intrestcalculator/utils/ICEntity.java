package com.vd.intrestcalculator.utils;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by Vinod Dirishala on 06-11-2021 21:29
 **/
@Entity
public class ICEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "personName")
    private String name;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "amount")
    private String amount;

    @ColumnInfo(name = "percentage")
    private String percentage;

    public ICEntity(int id, String name, String date, String amount, String percentage) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
