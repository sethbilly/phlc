/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.controllers;

import com.macphelasystem.phlc.entities.Client;
import com.macphelasystem.phlc.entities.Consignment;
import com.macphelasystem.phlc.jsf.services.ClientService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Billy
 */
@Named(value = "clientSearch")
@SessionScoped
public class ClientSearch implements Serializable
{
    @Inject private ClientService clientService;
    private Client selectedClient = null;
    private String searchText;
    private List<Client> clientsList = new ArrayList<>();
    
    public void searchClient()
    {
        try
        {
           Client clientQP = new Client();
           clientQP.setFullName(searchText);
           clientQP.setMobileNumber(searchText);
           clientsList = clientService.clientsListFindByAttribute(clientQP);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getSearchText()
    {
        return searchText;
    }

    public void setSearchText(String searchText)
    {
        this.searchText = searchText;
    }

    public Client getSelectedClient()
    {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient)
    {
        this.selectedClient = selectedClient;
    }

    public List<Client> getClientsList()
    {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList)
    {
        this.clientsList = clientsList;
    }
    
}
