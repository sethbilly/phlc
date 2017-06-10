/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.controllers;

import com.macphelasystem.phlc.entities.Staff;
import com.macphelasystem.phlc.jsf.services.CommonService;
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
@Named(value = "staffController")
@SessionScoped
public class StaffController implements Serializable {

    @Inject
    private CrudService crudService;
    @Inject
    private CommonService commonService;
    @Inject
    private UserSession userSession;
    private Staff client = new Staff();
    private List<Staff> clientsList = new ArrayList<>();

    public void saveStaff() {
        try {
            crudService.setCurrentUserID(userSession.getLoginUser().getId());
            if (null != crudService.save(client)) {
                Msg.successSave();
                clearForm();
            } else {
                Msg.failedSave();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clearForm() {
        client = new Staff();
    }

    public void selectStaff(Staff c) {
        client = c;
    }

    public void deleteStaff(Staff selectedStaff) {

        if (crudService.delete(selectedStaff, false)) {
            Msg.successDelete();
        } else {
            Msg.failedDelete();
        }
    }

    public Staff getStaff() {
        return client;
    }

    public void setStaff(Staff client) {
        this.client = client;
    }

    public List<Staff> getStaffsList() {
        clientsList = commonService.staffList();
        return clientsList;
    }

    public void setStaffsList(List<Staff> clientsList) {
        this.clientsList = clientsList;
    }

}
