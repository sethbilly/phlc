/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.controllers;

import com.macphelasystem.phlc.entities.Consignment;
import com.macphelasystem.phlc.entities.Staff;
import com.macphelasystem.phlc.jsf.services.CommonService;
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
@Named(value = "staffSearchController")
@SessionScoped
public class StaffSearchController implements Serializable
{
    @Inject private CommonService commonService;
    private Staff selectedStaff;
    private String searchText;
    private List<Staff> staffsList = new ArrayList<>();
    
    public void searchConsignment()
    {
        try
        {
           Staff staffQP = new Staff();
           staffQP.setEmail(searchText);
           staffQP.setMobileNumber(searchText);
           staffsList = commonService.staffsListFindByAttribute(staffQP);
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

    public Staff getSelectedStaff()
    {
        return selectedStaff;
    }

    public void setSelectedStaff(Staff selectedStaff)
    {
        this.selectedStaff = selectedStaff;
    }

    public List<Staff> getStaffsList()
    {
        return staffsList;
    }

    public void setStaffsList(List<Staff> staffsList)
    {
        this.staffsList = staffsList;
    }

    
}
