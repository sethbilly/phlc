/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.services;

import com.latlab.common.jpa.QryHelper;
import com.macphelasystem.phlc.entities.Client;
import com.macphelasystem.phlc.entities.Consignment;
import com.macphelasystem.phlc.entities.Invoice;
import com.macphelasystem.phlc.entities.Staff;
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
public class ConsignmentService implements Serializable
{
    private static final Logger LOGGER = Logger.getLogger(ConsignmentService.class.getName());
    
    @Inject private CrudService crudService;
    
    public List<Consignment> consignmentsListFindByAttribute(Consignment searchConsignment)
    {
        String qry = "";
        try 
        {
             qry = "SELECT c FROM " + Consignment.class.getSimpleName() + " c "
                + "WHERE c.jobNo LIKE '%" + searchConsignment.getJobNo() + "%' "
                + "OR c.vesselNumber LIKE '%" + searchConsignment.getVesselNumber() + "%' "
                + "OR c.vesselName LIKE '%" + searchConsignment.getVesselName()  + "%' "
                 + "AND c.deleted = " + false + " "
                + "ORDER BY c.vesselName ";
            return crudService.getEm().createQuery(qry).getResultList();
        }
        catch (Exception e) 
        {
            LOGGER.log(Level.SEVERE, "Error searching for account " + e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }
    
    public Invoice findConsignmentInvoice(Consignment consignment)
    {
        Invoice invoice = null;
        
        try
        {
           QryHelper qryHelper = new QryHelper(crudService.getEm(), Invoice.class);
           qryHelper.addObjectParam(Invoice._consignment, consignment);
           invoice = qryHelper.getSingleResult(Invoice.class);
        } catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return invoice;
    }
    
}
