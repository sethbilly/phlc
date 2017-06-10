/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.entities;

import com.latlab.common.jpa.DateRecord;
import com.macphelasystem.phlc.constants.PaymentType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Billy
 */
@Entity
@Table(name = "invoice_payment")
@Cacheable(false)
public class InvoicePayment extends DateRecord implements Serializable
{

    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(name = "amount_paying")
    private double amountPaying;

    public static final String _invoice = "invoice";
    @JoinColumn(name = "invoice")
    @ManyToOne
    private Invoice invoice;

    public static final String _paymentDate = "paymentDate";
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate = new Date();
    
    @Column(name = "payment_number")
    private String paymentNumber;
    
    @Column(name = "receipt_number")
    private String receiptNumber;
    
    @Column(name = "receipt_printed")
    private boolean receiptPrinted;

    public PaymentType getPaymentType()
    {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }

    public double getAmountPaying()
    {
        return amountPaying;
    }

    public void setAmountPaying(double amountPaying)
    {
        this.amountPaying = amountPaying;
    }

    public Invoice getInvoice()
    {
        return invoice;
    }

    public void setInvoice(Invoice invoice)
    {
        this.invoice = invoice;
    }

    public Date getPaymentDate()
    {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate)
    {
        this.paymentDate = paymentDate;
    }

    public String getPaymentNumber()
    {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber)
    {
        this.paymentNumber = paymentNumber;
    }

    public boolean isReceiptPrinted() {
        return receiptPrinted;
    }

    public void setReceiptPrinted(boolean receiptPrinted) {
        this.receiptPrinted = receiptPrinted;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }
    
}
