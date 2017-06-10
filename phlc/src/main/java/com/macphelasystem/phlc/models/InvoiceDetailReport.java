/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.models;

import com.macphelasystem.phlc.entities.Invoice;
import com.macphelasystem.phlc.entities.InvoiceItem;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ICSGH-BILLY
 */
public class InvoiceDetailReport
{
    private String vesselName;
    private String containerNumber;
    private String hbl;
    private String mbl;
    private String invoiceNumber;
    private String consignee;
    private double weightVol;
    private String polPod;
    private String cargoLocation;
    private Date etaDate;
    private Date invoiceDate;
    private double amountPaid;
    private double balance;
    
    public void processInvoice(Invoice invoice)
    {
        try
        {
            if(null != invoice.getConsignment())
            {
                this.vesselName = invoice.getConsignment().getVesselName();
                this.etaDate = invoice.getConsignment().getEtaDate();
                this.hbl = invoice.getConsignment().getHbl();
                this.mbl = invoice.getConsignment().getMblNo();
                this.weightVol = invoice.getConsignment().getWeightVol();
                this.polPod = invoice.getConsignment().getPolPod();
                this.cargoLocation = invoice.getConsignment().getCargoLocation();
                this.hbl = invoice.getConsignment().getHbl();
                this.invoiceNumber = invoice.getInvoiceNumber();
                this.consignee = invoice.getConsignment().getClient().getFullName();
                this.containerNumber = invoice.getConsignment().getVesselNumber();
            }
            
            //Find all invoice items for selected invoice
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static List<InvoiceItemReport> convertInvoiceItems(List<InvoiceItem> invoiceItems)
    {
        List<InvoiceItemReport> invoiceItemsList = new LinkedList<>();
        for (InvoiceItem invoiceItem : invoiceItems)
        {
            InvoiceItemReport invoiceItemReport = new InvoiceItemReport();
            
            invoiceItemReport.setAmount(invoiceItem.getAmount());
            invoiceItemReport.setItemDescription(invoiceItem.getItemDescription());
            invoiceItem.setExRate(invoiceItem.getExRate());
            invoiceItem.setRate(invoiceItem.getRate());
            
            invoiceItemsList.add(invoiceItemReport);
        }
        return invoiceItemsList;
    }

    public String getVesselName()
    {
        return vesselName;
    }

    public void setVesselName(String vesselName)
    {
        this.vesselName = vesselName;
    }

    public String getHbl()
    {
        return hbl;
    }

    public void setHbl(String hbl)
    {
        this.hbl = hbl;
    }

    public String getMbl()
    {
        return mbl;
    }

    public void setMbl(String mbl)
    {
        this.mbl = mbl;
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
    
    public Date getEtaDate()
    {
        return etaDate;
    }

    public void setEtaDate(Date etaDate)
    {
        this.etaDate = etaDate;
    }

    public Date getInvoiceDate()
    {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate)
    {
        this.invoiceDate = invoiceDate;
    }
    
    public String getContainerNumber()
    {
        return containerNumber;
    }

    public void setContainerNumber(String containerNumber)
    {
        this.containerNumber = containerNumber;
    }

    public double getWeightVol()
    {
        return weightVol;
    }

    public void setWeightVol(double weightVol)
    {
        this.weightVol = weightVol;
    }

    public String getPolPod()
    {
        return polPod;
    }

    public void setPolPod(String polPod)
    {
        this.polPod = polPod;
    }

    public String getCargoLocation()
    {
        return cargoLocation;
    }

    public void setCargoLocation(String cargoLocation)
    {
        this.cargoLocation = cargoLocation;
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
    
    
}
