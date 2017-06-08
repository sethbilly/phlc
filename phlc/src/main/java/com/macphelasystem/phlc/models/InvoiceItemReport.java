/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.models;

import java.io.Serializable;

/**
 *
 * @author ICSGH-BILLY
 */
public class InvoiceItemReport implements Serializable
{
    private String itemDescription;
    private double amount;
    private double exRate;
    private double rate;

    public String getItemDescription()
    {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public double getExRate()
    {
        return exRate;
    }

    public void setExRate(double exRate)
    {
        this.exRate = exRate;
    }

    public double getRate()
    {
        return rate;
    }

    public void setRate(double rate)
    {
        this.rate = rate;
    }
    
}
