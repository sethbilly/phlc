/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.controllers;

import com.macphelasystem.phlc.entities.Client;
import com.macphelasystem.phlc.entities.Consignment;
import com.macphelasystem.phlc.jsf.services.ClientService;
import com.macphelasystem.phlc.jsf.services.IdService;
import com.macphelasystem.phlc.jsf.services.CrudService;
import com.macphelasystem.phlc.jsf.services.UserSession;
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
@Named(value = "clientController")
@SessionScoped
public class ClientController implements Serializable
{
    
    @Inject private CrudService crudService;
    @Inject private IdService idService;
    @Inject private ClientService clientService;
    @Inject private ConsignmentController consignmentController;
    @Inject private UserSession userSession;
    private Client client = new Client();
    private List<Client> clientsList = new ArrayList<>();
    
    
    public void saveClient()
    {
       crudService.setCurrentUserID(userSession.getLoginUser().getId());
        if(null != crudService.save(client))
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
        client = new Client();
    }
    
    public void selectClient(Client c)
    {
        client = c;
    }
    
    public void deleteClient(Client selectedClient)
    {
        List<Consignment> consignmentsList = clientService.findConsignmentsOfClient(selectedClient);
        if(!consignmentsList.isEmpty())
        {
            Msg.genericError("Sorry cannot delete this client. Consignments associated with client");
        }
        if(crudService.delete(selectedClient, false))
        {
            Msg.successDelete();
        }else
        {
            Msg.failedDelete();
        }
    }
    
    public void addClientConsignment(Client c)
    {
        consignmentController.setSelectedClient(c);
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public List<Client> getClientsList()
    {
        clientsList = clientService.clientsList(false);
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList)
    {
        this.clientsList = clientsList;
    }
    
    
}
