/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.entities;

import com.latlab.common.jpa.DateRecord;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Billy
 */
@Entity
@Table(name = "consignment_invoice")
@Cacheable(false)
public class Invoice extends DateRecord implements Serializable
{
    public static final String _invoiceNumber = "invoiceNumber";
    @Column(name = "invoice_number")
    private String invoiceNumber;
    
    @Column(name = "total_amount")
    private Double totalAmount;
    
    @Column(name = "remaining_balance")
    private Double remainingBalance;
    
    public static final String _consignment = "consignment";
    public static final String _consignment_consignmentNo = _consignment + "."+ Consignment._consignmentNo;
    @JoinColumn(name = "consignment")
    @OneToOne
    private Consignment consignment;
    
    @Column(name = "invoice_date")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    
    @Column(name = "processed")
    private boolean processed;

    public String getInvoiceNumber()
    {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber)
    {
        this.invoiceNumber = invoiceNumber;
    }

    public Double getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public Double getRemainingBalance()
    {
        return remainingBalance;
    }

    public void setRemainingBalance(Double remainingBalance)
    {
        this.remainingBalance = remainingBalance;
    }
    
    public Consignment getConsignment()
    {
        return consignment;
    }

    public void setConsignment(Consignment consignment)
    {
        this.consignment = consignment;
    }

    public Date getInvoiceDate()
    {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate)
    {
        this.invoiceDate = invoiceDate;
    }

    public boolean isProcessed()
    {
        return processed;
    }

    public void setProcessed(boolean processed)
    {
        this.processed = processed;
    }
    
    
}
