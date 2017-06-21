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
@Named(value = "userAccountController")
@SessionScoped
public class UserAccountController implements Serializable {

    @Inject
    private CrudService crudService;
    @Inject
    private IdService idService;
    @Inject
    private CommonService commonService;
    @Inject
    private StaffSearchController staffSearchController;
    @Inject private UserSession userSession;
    private UserAccount userAccount = new UserAccount();
    private List<UserAccount> userAccountList = new ArrayList<>();
    private Staff selectedStaff = null;
    private String confirmPwd = "";

    public void selectStaffAction() {
        selectedStaff = staffSearchController.getSelectedStaff();
    }

    public void saveUserAccount() {
        try {
            crudService.setCurrentUserID(userSession.getLoginUser().getId());
            if (null != crudService.save(userAccount)) {
                Msg.successSave();
                clearForm();
            } else {
                Msg.failedSave();
            }
        } catch (Exception e) {
        }

    }

    public void clearForm() {
        userAccount = new UserAccount();
    }

    public void selectUserAccount(UserAccount c) {
        userAccount = c;
    }

    public void deleteUserAccount(UserAccount selectedUserAccount) {

        if (crudService.delete(selectedUserAccount, false)) {
            Msg.successDelete();
        } else {
            Msg.failedDelete();
        }
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public List<UserAccount> getUserAccountsList() {
        userAccountList = commonService.getUserAccountsList();
        return userAccountList;
    }

    public void setUserAccountsList(List<UserAccount> userAccountList) {
        this.userAccountList = userAccountList;
    }

    public Staff getSelectedStaff() {
        return selectedStaff;
    }

    public void setSelectedStaff(Staff selectedStaff) {
        this.selectedStaff = selectedStaff;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }
    
}
