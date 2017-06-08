/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.entities;

import com.latlab.common.jpa.CommonModel;
import com.macphelasystem.phlc.constants.InvoiceItemType;
import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Billy
 */
@Entity
@Table(name = "consignment_invoice_items")
@Cacheable(false)
public class InvoiceItem extends CommonModel implements Serializable
{
    @Column(name = "item_description")
    private String itemDescription;
    
    @Column(name = "ex_rate")
    private double exRate;
    
    @Column(name = "rate")
    private double rate;
    
    @Column(name = "amount")
    private double amount;
    
    public static final String _invoice = "invoice";
    public static final String _invoice_invoiceNo = "invoice";
    @JoinColumn(name = "invoice")
    @ManyToOne
    private Invoice invoice;

    @Column(name = "invoice_item_type")
    @Enumerated(EnumType.STRING)
    private InvoiceItemType invoiceItemType;
    
    public String getItemDescription()
    {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
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

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public Invoice getInvoice()
    {
        return invoice;
    }

    public void setInvoice(Invoice invoice)
    {
        this.invoice = invoice;
    }

    public InvoiceItemType getInvoiceItemType()
    {
        return invoiceItemType;
    }

    public void setInvoiceItemType(InvoiceItemType invoiceItemType)
    {
        this.invoiceItemType = invoiceItemType;
    }
    
    
}
