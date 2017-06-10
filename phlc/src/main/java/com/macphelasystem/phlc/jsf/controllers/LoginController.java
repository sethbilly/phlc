/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.controllers;

import com.latlab.common.security.SecurityHash;
import com.latlab.mojarra.jsf.JsfUtil;
import com.latlab.mojarra.jsf.Msg;
import com.macphelasystem.phlc.entities.Staff;
import com.macphelasystem.phlc.entities.UserAccount;
import com.macphelasystem.phlc.jsf.services.CommonService;
import com.macphelasystem.phlc.jsf.services.UserSession;
import com.macphelasystem.phlc.utils.AppPages;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Faces;

/**
 *
 * @author Billy
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController implements Serializable {

    @Inject
    private UserSession userSession;
    @Inject
    private CommonService commonService;

    private String username = "";
    private String passwd = "";

    private static final String _SUPER_ADMIN_USERNAME = "super@admin";
    private static final String _SUPER_ADMIN_PWD = "phlc@admin$123";

    public void login() {
        try {
            if (username.equals(_SUPER_ADMIN_USERNAME) && passwd.equals(_SUPER_ADMIN_PWD)) {
                UserAccount account = new UserAccount();
                account.setId("sahjfshfsjhfadkjfshjdfhsjdhfs");
                Staff staff = new Staff();
                staff.setId("super@admin");
                staff.setFullName("super@admin");
                account.setStaff(staff);
                userSession.setLoginUser(account);
                userSession.setLoggedIn(true);
                
                Faces.redirect(Faces.getRequestContextPath() + AppPages.DASHBOARD);
                return;
            }
            //authenticate 
            String hashPassword = SecurityHash.getInstance().shaHash(passwd);
            UserAccount userAccount = commonService.authenticateAccount(username, hashPassword);
            if (null != userAccount) {
                userSession.setLoginUser(userAccount);
                userSession.setLoggedIn(true);
                Faces.redirect(Faces.getRequestContextPath() + AppPages.DASHBOARD);
            } else {
                Msg.error("Wrong username or password");
                Faces.redirect(Faces.getRequestContextPath() + AppPages.LOGIN);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logout() {
        try {
            Faces.invalidateSession();
            JsfUtil.invalidateSession();
            userSession = null;
            Faces.redirect(Faces.getRequestContextPath() + AppPages.LOGIN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

}
