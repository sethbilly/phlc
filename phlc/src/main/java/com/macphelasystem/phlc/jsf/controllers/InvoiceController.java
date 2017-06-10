/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.controllers;

import com.macphelasystem.phlc.entities.Consignment;
import com.macphelasystem.phlc.entities.Invoice;
import com.macphelasystem.phlc.jsf.services.CrudService;
import com.macphelasystem.phlc.jsf.services.IdService;
import com.macphelasystem.phlc.jsf.services.InvoiceService;
import com.macphelasystem.phlc.jsf.services.UserSession;
import com.macphelasystem.phlc.utils.Msg;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Faces;

/**
 *
 * @author Billy
 */
@Named(value = "invoiceController")
@SessionScoped
public class InvoiceController implements Serializable {

    @Inject
    private CrudService crudService;
    @Inject
    private IdService idService;
    @Inject
    private ConsignmentSearch consignmentSearch;
    @Inject
    private InvoiceItemController invoiceItemController;
    @Inject
    private InvoicePaymentController invoicePaymentController;
    @Inject
    private InvoiceService invoiceService;
    @Inject
    private ReportController reportController;
    @Inject
    private UserSession userSession;

    private Invoice invoice = new Invoice();
    private List<Invoice> invoicesList = new ArrayList<>();
    private Consignment selectedConsignment = new Consignment();
    private boolean renderInvoiceItemInput = false;
    private boolean renderPaymentInput = false;
    private boolean renderChargeInput = false;
    private boolean renderForm = true;

    public void selectConsignmentAction() {
        selectedConsignment = consignmentSearch.getSelectedConsignment();
    }

    public void addItemToInvoice(Invoice inv) {
        invoiceItemController.setSelectedInovice(inv);
        renderForm = false;
        renderInvoiceItemInput = true;
    }

    public void addInvoicePayment(Invoice inv) {
        renderPaymentInput = true;
        renderForm = false;
        renderInvoiceItemInput = false;
        invoicePaymentController.setSelectedInovice(inv);
    }

    public void cancelInvoiceItem() {
        Faces.responseReset();
        renderInvoiceItemInput = false;
        renderPaymentInput = false;
        renderChargeInput = false;
        renderForm = true;
    }

    public void createInvoice() {
        if (selectedConsignment == null) {
            Msg.genericError("Select a job to add an invoice");
        }
        invoice.setConsignment(selectedConsignment);
        invoice.setInvoiceNumber(idService.generateRandomNumber());
        crudService.setCurrentUserID(userSession.getLoginUser().getId());
        if (null != crudService.save(invoice)) {
            Msg.successSave();
            clearForm();
        } else {
            Msg.failedSave();
        }
    }

    public void clearForm() {
        invoice = new Invoice();
    }

    public void selectInvoice(Invoice inv) {
        invoice = inv;
    }

    public void deleteInvoice(Invoice inv) {
        if (!invoiceService.getInvoicePaymentList(invoice).isEmpty()) {
            Msg.genericError("Sorry cannot delete invoice, it has payments.");
            return;
        }
        if (crudService.delete(inv, false)) {
            Msg.successDelete();
        } else {
            Msg.failedDelete();
        }
    }

    public void printInvoice(Invoice selectedInvoice) {
        try {
            reportController.generateProformaInvoice(selectedInvoice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<Invoice> getInvoicesList() {
        invoicesList = invoiceService.invoicesList(false);
        return invoicesList;
    }

    public void setInvoicesList(List<Invoice> invoicesList) {
        this.invoicesList = invoicesList;
    }

    public Consignment getSelectedConsignment() {
        return selectedConsignment;
    }

    public void setSelectedConsignment(Consignment selectedConsignment) {
        this.selectedConsignment = selectedConsignment;
    }

    public boolean isRenderInvoiceItemInput() {
        return renderInvoiceItemInput;
    }

    public void setRenderInvoiceItemInput(boolean renderInvoiceItemInput) {
        this.renderInvoiceItemInput = renderInvoiceItemInput;
    }

    public boolean isRenderPaymentInput() {
        return renderPaymentInput;
    }

    public void setRenderPaymentInput(boolean renderPaymentInput) {
        this.renderPaymentInput = renderPaymentInput;
    }

    public boolean isRenderChargeInput() {
        return renderChargeInput;
    }

    public void setRenderChargeInput(boolean renderChargeInput) {
        this.renderChargeInput = renderChargeInput;
    }

    public boolean isRenderForm() {
        return renderForm;
    }

    public void setRenderForm(boolean renderForm) {
        this.renderForm = renderForm;
    }

}
