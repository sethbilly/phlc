/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.controllers;

import com.latlab.common.imageutils.ImageResource;
import com.macphelasystem.phlc.entities.Invoice;
import com.macphelasystem.phlc.entities.InvoiceItem;
import com.macphelasystem.phlc.jsf.services.CommonService;
import com.macphelasystem.phlc.jsf.services.InvoiceService;
import com.macphelasystem.phlc.models.InvoiceDetailReport;
import com.macphelasystem.phlc.models.InvoiceItemReport;
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
            System.out.println("invoiceItemsList " + invoiceItemsList.size());
            
            if (invoiceItemsList.isEmpty())
            {
                return;
            }
            List<InvoiceItemReport> invoiceItemReportsList = InvoiceDetailReport.convertInvoiceItems(invoiceItemsList);
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
            
            InputStream invoiceReportStream = this.getClass().getResourceAsStream(ReportFiles.proforma_invoice);
            
            showReport(invoiceItemReportsList, invoiceReportStream);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
