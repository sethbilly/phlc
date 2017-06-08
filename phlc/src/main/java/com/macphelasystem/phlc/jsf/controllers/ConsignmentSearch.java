/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.controllers;

import com.macphelasystem.phlc.entities.Consignment;
import com.macphelasystem.phlc.jsf.services.ConsignmentService;
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
@Named(value = "consignmentSearch")
@SessionScoped
public class ConsignmentSearch implements Serializable
{
    @Inject private ConsignmentService consignmentService;
    private Consignment selectedConsignment;
    private String searchText;
    private List<Consignment> consinConsignmentsList = new ArrayList<>();
    
    public void searchConsignment()
    {
        try
        {
           Consignment consignmentQP = new Consignment();
           consignmentQP.setJobNo(searchText);
           consignmentQP.setVesselNumber(searchText);
           consignmentQP.setVesselName(searchText);
           consinConsignmentsList = consignmentService.consignmentsListFindByAttribute(consignmentQP);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Consignment getSelectedConsignment()
    {
        return selectedConsignment;
    }

    public void setSelectedConsignment(Consignment selectedConsignment)
    {
        this.selectedConsignment = selectedConsignment;
    }

    public String getSearchText()
    {
        return searchText;
    }

    public void setSearchText(String searchText)
    {
        this.searchText = searchText;
    }

    public List<Consignment> getConsinConsignmentsList()
    {
        return consinConsignmentsList;
    }

    public void setConsinConsignmentsList(List<Consignment> consinConsignmentsList)
    {
        this.consinConsignmentsList = consinConsignmentsList;
    }
    
    
}
