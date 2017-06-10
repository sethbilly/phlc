/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.controllers;

import com.macphelasystem.phlc.constants.PaymentType;
import com.macphelasystem.phlc.entities.Invoice;
import com.macphelasystem.phlc.entities.InvoicePayment;
import com.macphelasystem.phlc.jsf.services.CrudService;
import com.macphelasystem.phlc.jsf.services.IdService;
import com.macphelasystem.phlc.jsf.services.InvoiceService;
import com.macphelasystem.phlc.jsf.services.UserSession;
import com.macphelasystem.phlc.utils.Msg;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Billy
 */
@Named(value = "invoicePaymentController")
@SessionScoped
public class InvoicePaymentController implements Serializable
{

    @Inject
    private CrudService crudService;
    @Inject
    private IdService idService;
    @Inject
    private InvoiceService invoiceService;
    @Inject
    private ReportController reportController;
    @Inject private UserSession userSession;
    private List<InvoicePayment> invoicePaymentsList = new ArrayList<>();
    private Invoice selectedInovice;
    private InvoicePayment invoicePayment = new InvoicePayment();
    private boolean renderPaymentNumberInput = false;

   
    public void clearForm()
    {
        invoicePayment = new InvoicePayment();
    }


    public void saveInvoicePayment()
    {
        if (selectedInovice == null)
        {
            Msg.genericError("Cancel and Select an invoice to add payment");
            return;
        }
        try
        {
            invoicePayment.setValueDate(new Date());
            invoicePayment.setInvoice(selectedInovice);
            invoicePayment.setReceiptNumber(idService.generateRandomNumber());
            crudService.setCurrentUserID(userSession.getLoginUser().getId());
            crudService.save(invoicePayment);
            //TODO update invoice payments here
            invoiceService.updateInvoice(invoicePayment);
            clearForm();
            Msg.successSave();
        } catch (Exception e)
        {
            e.printStackTrace();
            Msg.failedSave();
        }
    }

    public void selectInvoicePayment(InvoicePayment invPayment)
    {
        invoicePayment = invPayment;
    }

    public void deleteInvoicePayment(InvoicePayment invPayment)
    {
        if (crudService.delete(invPayment, false))
        {
            Msg.successDelete();
        } else
        {
            Msg.failedDelete();
        }
    }
    
    public void paymentTypeChange()
    {
        if( invoicePayment.getPaymentType() == PaymentType.CHEQUE | invoicePayment.getPaymentType() ==PaymentType.TRANSFER)
        {
            renderPaymentNumberInput = true;
        }else
        {
            renderPaymentNumberInput = false;
        }
    }
    
    public void printInvoiceReceipt(InvoicePayment selectedInvoicePayment) {
        try {
            //fetch invoice payments for selected invoice
            reportController.printInvoicePaymentReceipt(selectedInvoicePayment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<InvoicePayment> getInvoicePaymentsList()
    {
        invoicePaymentsList = invoiceService.getInvoicePaymentList(selectedInovice);
        return invoicePaymentsList;
    }

    public void setInvoicePaymentsList(List<InvoicePayment> invoiceItemsList)
    {
        this.invoicePaymentsList = invoiceItemsList;
    }

    public Invoice getSelectedInovice()
    {
        return selectedInovice;
    }

    public void setSelectedInovice(Invoice selectedInovice)
    {
        this.selectedInovice = selectedInovice;
    }

    public InvoicePayment getInvoicePayment()
    {
        return invoicePayment;
    }

    public void setInvoicePayment(InvoicePayment invoicePayment)
    {
        this.invoicePayment = invoicePayment;
    }

    public boolean isRenderPaymentNumberInput()
    {
        return renderPaymentNumberInput;
    }

    public void setRenderPaymentNumberInput(boolean renderPaymentNumberInput)
    {
        this.renderPaymentNumberInput = renderPaymentNumberInput;
    }
    
}
