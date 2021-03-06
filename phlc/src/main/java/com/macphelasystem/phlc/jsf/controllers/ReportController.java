/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.controllers;

import com.latlab.common.formating.NumberToWords;
import com.latlab.common.imageutils.ImageResource;
import com.latlab.common.reporting.ReportData;
import com.macphelasystem.phlc.entities.Invoice;
import com.macphelasystem.phlc.entities.InvoiceItem;
import com.macphelasystem.phlc.entities.InvoicePayment;
import com.macphelasystem.phlc.jsf.services.CommonService;
import com.macphelasystem.phlc.jsf.services.InvoiceService;
import com.macphelasystem.phlc.jsf.services.UserSession;
import com.macphelasystem.phlc.models.InvoiceDetailReport;
import com.macphelasystem.phlc.models.InvoiceItemReport;
import com.macphelasystem.phlc.models.InvoicePaymentReceipt;
import com.macphelasystem.phlc.utils.ReportGenerator;
import com.stately.common.utils.ImageUtils;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ICSGH-BILLY
 */
@Named
@RequestScoped
public class ReportController extends ReportGenerator implements Serializable
{

    @Inject
    private CommonService commonService;
    @Inject
    private InvoiceService invoiceService;
    @Inject
    private UserSession userSession;

    @PostConstruct
    private void init()
    {
        addParam("companyLogo", ImageResource.getResourceImage("/com/macphelasystem/phlc/resources/images/phc_ltd.png"));
    }
    
    public void generateProformaInvoice(Invoice selectedInvoice)
    {
        try
        {
            InvoiceDetailReport invoiceDetailReport = new InvoiceDetailReport();
            invoiceDetailReport.processInvoice(selectedInvoice);
            List<InvoiceItem> invoiceItemsList = invoiceService.invoiceItemsFindByInvoice(selectedInvoice, false);
            
            if (invoiceItemsList.isEmpty())
            {
                return;
            }
            List<InvoiceItemReport> invoiceItemReportsList = InvoiceDetailReport.convertInvoiceItems(invoiceItemsList);
            double grandTotal = invoiceItemReportsList.stream()
                    .mapToDouble(s -> s.getAmount()).sum();
            addParam("invoiceNumber", invoiceDetailReport.getInvoiceNumber());
            addParam("jobNumber", invoiceDetailReport.getInvoiceNumber());
            addParam("etaDate", invoiceDetailReport.getEtaDate());
            addParam("consignee", invoiceDetailReport.getConsignee());
            addParam("invoiceDate", invoiceDetailReport.getInvoiceDate());
            addParam("vesselName", invoiceDetailReport.getVesselName());
            addParam("containerNumber", invoiceDetailReport.getContainerNumber());
            addParam("polPod", invoiceDetailReport.getPolPod());
            addParam("hbl", invoiceDetailReport.getHbl());
            addParam("mbl", invoiceDetailReport.getMbl());
            addParam("invoiceNumber", invoiceDetailReport.getInvoiceNumber());
            addParam("amountInWord", NumberToWords.getInstance().convertToWords(grandTotal));
            addParam("printedBy", userSession.getLoginUser().getStaff().getFullName());
            
            InputStream invoiceReportStream = this.getClass().getResourceAsStream(ReportFiles.proforma_invoice);
            
            showReport(invoiceItemReportsList, invoiceReportStream);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    
    public void printInvoicePaymentReceipt(InvoicePayment selectedInvoice)
    {
        try {
            InvoicePaymentReceipt invoicePaymentReceipt = new InvoicePaymentReceipt();
            invoicePaymentReceipt.processInvoice(selectedInvoice);
            
            addParam("invoiceNumber", invoicePaymentReceipt.getInvoiceNumber());
            addParam("jobNumber", invoicePaymentReceipt.getJobFileNo());
            addParam("receiptNumber", invoicePaymentReceipt.getReceiptNumber());
            addParam("paymentMethod", invoicePaymentReceipt.getPaymentMode());
            addParam("receiptDate", invoicePaymentReceipt.getReceiptDate());
            addParam("consignee", invoicePaymentReceipt.getConsignee());
            addParam("receivedBy", invoicePaymentReceipt.getReceivedBy());
            
            addParam("invoiceAmount", invoicePaymentReceipt.getInvoiceAmount());
            addParam("balance", invoicePaymentReceipt.getBalance());
            addParam("amountPaid", invoicePaymentReceipt.getAmountPaid());
            addParam("amountInWord", NumberToWords.getInstance().convertToWords(invoicePaymentReceipt.getAmountPaid()));
            
            
            InputStream receiptReportStream = this.getClass().getResourceAsStream(ReportFiles.invoice_receipt);
            ReportData reportData = new ReportData(invoicePaymentReceipt, "");
           
            showReport(reportData, receiptReportStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
