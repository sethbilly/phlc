/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.models;

import com.macphelasystem.phlc.entities.Invoice;
import com.macphelasystem.phlc.entities.InvoicePayment;
import java.util.Date;

/**
 *
 * @author ICSGH-BILLY
 */
public class InvoicePaymentReceipt
{
   
    private String invoiceNumber;
    private String jobFileNo;
    private String consignee;
    private double amountPaid;
    private double balance;
    private String receiptNumber;
    private double previousBalance;
    private String paymentMode;
    private String receivedBy;
    private Date receiptDate;
    private double invoiceAmount;
    
    
    public void processInvoice(InvoicePayment invoicePayment)
    {
        try
        {
            if(null != invoicePayment.getInvoice())
            {
                Invoice invoice = invoicePayment.getInvoice();
                
                this.jobFileNo = invoice.getConsignment().getJobNo();
                this.paymentMode = invoicePayment.getPaymentType().toString();
                this.invoiceNumber = invoice.getInvoiceNumber();
                this.receiptNumber = invoicePayment.getReceiptNumber();
                this.receiptDate = invoicePayment.getPaymentDate();
                this.receivedBy = invoicePayment.getCreatedBy();
                if(invoice.getConsignment() != null){
                    this.consignee = invoice.getConsignment().getClient().getFullName();
                }
                
                this.invoiceAmount = invoice.getTotalAmount();
//                this.previousBalance = invoice.getRemainingBalance();
                
                this.amountPaid = invoicePayment.getAmountPaying();
                this.balance = invoice.getRemainingBalance();
            }
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getInvoiceNumber()
    {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber)
    {
        this.invoiceNumber = invoiceNumber;
    }

    public String getConsignee()
    {
        return consignee;
    }

    public void setConsignee(String consignee)
    {
        this.consignee = consignee;
    }

    public double getAmountPaid()
    {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid)
    {
        this.amountPaid = amountPaid;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public String getJobFileNo() {
        return jobFileNo;
    }

    public void setJobFileNo(String jobFileNo) {
        this.jobFileNo = jobFileNo;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public double getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(double previousBalance) {
        this.previousBalance = previousBalance;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }
    
    
}
