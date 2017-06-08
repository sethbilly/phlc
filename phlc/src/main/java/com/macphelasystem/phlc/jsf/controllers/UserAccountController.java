/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.controllers;

import com.macphelasystem.phlc.entities.Staff;
import com.macphelasystem.phlc.entities.UserAccount;
import com.macphelasystem.phlc.jsf.services.CommonService;
import com.macphelasystem.phlc.jsf.services.IdService;
import com.macphelasystem.phlc.jsf.services.CrudService;
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
@Named(value = "userAccountController")
@SessionScoped
public class UserAccountController implements Serializable
{

    @Inject
    private CrudService crudService;
    @Inject
    private IdService idService;
    @Inject
    private CommonService commonService;
    @Inject
    private StaffSearchController staffSearchController;
    private UserAccount client = new UserAccount();
    private List<UserAccount> clientsList = new ArrayList<>();
    private Staff selectedStaff = null;

    public void selectStaffAction()
    {
        selectedStaff = staffSearchController.getSelectedStaff();
    }

    public void saveUserAccount()
    {
        if (null != crudService.save(client))
        {
            Msg.successSave();
            clearForm();
        } else
        {
            Msg.failedSave();
        }
    }

    public void clearForm()
    {
        client = new UserAccount();
    }

    public void selectUserAccount(UserAccount c)
    {
        client = c;
    }

    public void deleteUserAccount(UserAccount selectedUserAccount)
    {

        if (crudService.delete(selectedUserAccount, false))
        {
            Msg.successDelete();
        } else
        {
            Msg.failedDelete();
        }
    }

    public UserAccount getUserAccount()
    {
        return client;
    }

    public void setUserAccount(UserAccount client)
    {
        this.client = client;
    }

    public List<UserAccount> getUserAccountsList()
    {
        clientsList = commonService.getUserAccountsList();
        return clientsList;
    }

    public void setUserAccountsList(List<UserAccount> clientsList)
    {
        this.clientsList = clientsList;
    }

    public Staff getSelectedStaff()
    {
        return selectedStaff;
    }

    public void setSelectedStaff(Staff selectedStaff)
    {
        this.selectedStaff = selectedStaff;
    }

}
