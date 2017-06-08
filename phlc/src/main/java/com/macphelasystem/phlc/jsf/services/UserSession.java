/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.services;

import com.macphelasystem.phlc.entities.UserAccount;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Billy
 */
@Named
@SessionScoped
public class UserSession implements Serializable
{
    private boolean loggedIn = false;
    private UserAccount loginUser;
    
    public boolean isLoggedIn()
    {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn)
    {
        this.loggedIn = loggedIn;
    }

    public UserAccount getLoginUser()
    {
        return loginUser;
    }

    public void setLoginUser(UserAccount loginUser)
    {
        this.loginUser = loginUser;
    }
    
    
}
