/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.controllers;

import com.macphelasystem.phlc.entities.Client;
import com.macphelasystem.phlc.entities.Consignment;
import com.macphelasystem.phlc.entities.Invoice;
import com.macphelasystem.phlc.jsf.services.ConsignmentService;
import com.macphelasystem.phlc.jsf.services.CrudService;
import com.macphelasystem.phlc.jsf.services.IdService;
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
@Named(value = "consignmentController")
@SessionScoped
public class ConsignmentController implements Serializable
{
    @Inject private CrudService crudService;
    @Inject private IdService idService;
    @Inject private ConsignmentService consignmentService;
    @Inject private ClientSearch clientSearch;
    private Client selectedClient;
    private Consignment consignment = new Consignment();
    private List<Consignment> consignmentsList = new ArrayList<>();
    
    public void createConsignment()
    {
        if(selectedClient == null)
        {
            Msg.genericError("Please select a client to create job for.");
            return;
        }
        if(consignment.getEtaDate() == null)
        {
            Msg.genericError("ETA Date is required");
            return;
        }
        consignment.setClient(selectedClient);
        if(null != crudService.save(consignment))
        {
            Msg.successSave();
            clearForm();
        }else
        {
            Msg.failedSave();
        }
    }
    
    public void clearForm()
    {
        consignment = new Consignment();
    }
    
    public void selectConsignment(Consignment c)
    {
        consignment = c;
    }
    
    public void deleteConsignment(Consignment c)
    {
        Invoice invoice  = consignmentService.findConsignmentInvoice(c);
        if(null != invoice)
        {
            Msg.genericError("Sorry cannot delete consignment. Invoice already created for it");
        }
        if(crudService.delete(c, false))
        {
            Msg.successDelete();
        }else
        {
            Msg.failedDelete();
        }
    }
    
    public void selectClientAction()
    {
        selectedClient = clientSearch.getSelectedClient();
        consignment.setJobNo(idService.generateConsignmentJobNo());
    }

    public Consignment getConsignment()
    {
        return consignment;
    }

    public void setConsignment(Consignment consignment)
    {
        this.consignment = consignment;
    }

    public List<Consignment> getConsignmentsList()
    {
        consignmentsList = crudService.findAll(Consignment.class,false);
        return consignmentsList;
    }

    public void setConsignmentsList(List<Consignment> consignmentsList)
    {
        this.consignmentsList = consignmentsList;
    }
    
    public Client getSelectedClient()
    {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient)
    {
        this.selectedClient = selectedClient;
    }
    
    
}
