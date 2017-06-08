/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.controllers;

import com.macphelasystem.phlc.entities.Invoice;
import com.macphelasystem.phlc.entities.InvoiceItem;
import com.macphelasystem.phlc.jsf.services.CrudService;
import com.macphelasystem.phlc.jsf.services.IdService;
import com.macphelasystem.phlc.jsf.services.InvoiceService;
import com.macphelasystem.phlc.utils.Msg;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Billy
 */
@Named(value = "invoiceItemController")
@SessionScoped
public class InvoiceItemController implements Serializable
{
    @Inject private CrudService crudService;
    @Inject private IdService idService;
    @Inject private InvoiceService invoiceService;
    private InvoiceItem invoiceItem = new InvoiceItem();
    private List<InvoiceItem> invoiceItemsList = new ArrayList<>();
    private Invoice selectedInovice;
    private List<InvoiceItem> invoiceItems = new ArrayList<>();
    
    public void addInvoiceItem()
    {
        invoiceItemsList.add(invoiceItem);
        clearForm();
    }
    
    public void  clearForm()
    {
        invoiceItem = new InvoiceItem();
    }
    
    public void removeInvoiceItem(InvoiceItem item)
    {
        invoiceItemsList.remove(item);
    }
    
    public void clearInvoiceItemsList()
    {
        invoiceItemsList.clear();
    }
    
    public void saveInvoiceItems()
    {
        if(selectedInovice == null)
        {
            Msg.genericError("Cancel and Select an invoice to add items");
        }
        try
        {
            for(InvoiceItem invItem : invoiceItemsList)
            {
//                InvoiceItem item = new InvoiceItem();
                invItem.setExRate(invItem.getExRate());
                invItem.setInvoice(selectedInovice);
                crudService.save(invItem);
            }
            clearInvoiceItemsList();
            Msg.successSave();
        } catch (Exception e)
        {
            e.printStackTrace();
            Msg.failedSave();
        }  
    }
    
    public void selectInvoiceItem(InvoiceItem invItem)
    {
        invoiceItem = invItem;
    }
    
    public void deleteInvoiceItem(InvoiceItem invItem)
    {
        if(crudService.delete(invItem, false))
        {
            Msg.successDelete();
        }else
        {
            Msg.failedDelete();
        }
    }

    public InvoiceItem getInvoiceItem()
    {
        return invoiceItem;
    }

    public void setInvoiceItem(InvoiceItem invoiceItem)
    {
        this.invoiceItem = invoiceItem;
    }

    public List<InvoiceItem> getInvoiceItemsList()
    {
        return invoiceItemsList;
    }

    public void setInvoiceItemsList(List<InvoiceItem> invoiceItemsList)
    {
        this.invoiceItemsList = invoiceItemsList;
    }

    public Invoice getSelectedInovice()
    {
        return selectedInovice;
    }

    public void setSelectedInovice(Invoice selectedInovice)
    {
        this.selectedInovice = selectedInovice;
    }

    public List<InvoiceItem> getInvoiceItems()
    {
        invoiceItems = invoiceService.invoiceItemsFindByInvoice(selectedInovice, false);
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems)
    {
        this.invoiceItems = invoiceItems;
    }
    
    
}
