/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.services;

import com.latlab.common.jpa.QryHelper;
import com.macphelasystem.phlc.entities.Invoice;
import com.macphelasystem.phlc.entities.InvoiceItem;
import com.macphelasystem.phlc.entities.InvoicePayment;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

/**
 *
 * @author Billy
 */
@Stateless
public class InvoiceService implements Serializable
{
    private static final Logger LOG = Logger.getLogger(InvoiceService.class.getName());
    
    @Inject private CrudService crudService;
    
    
    public List<InvoiceItem> invoiceItemsFindByInvoice(Invoice invoice, boolean deleted)
    {
        String qry = "";
        try
        {
            qry = "Select c From " + InvoiceItem.class.getSimpleName() + " c Where c.invoice =:invoice "
                    + "And c.deleted =:deleted";
            Query query = crudService.getEm().createQuery(qry, InvoiceItem.class);
            query.setParameter("invoice", invoice);
            query.setParameter("deleted", deleted);
            return query.getResultList();
        } catch (Exception e)
        {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<Invoice> invoicesList(boolean deleted)
    {
        String qry = "";
        try
        {
            qry = "Select c From " + Invoice.class.getSimpleName() + " c Where c.deleted =:deleted "
                    + "Order By c.invoiceDate DESC";
            Query query = crudService.getEm().createQuery(qry, InvoiceItem.class);
            query.setParameter("deleted", deleted);
            return query.getResultList();
        } catch (Exception e)
        {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<InvoicePayment> getInvoicePaymentList(Invoice invoice)
    {
        try
        {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), InvoicePayment.class);
            qryHelper.addObjectParam(InvoicePayment._invoice, invoice);
            qryHelper.orderByDesc(InvoicePayment._paymentDate);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e)
        {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }
    
}
