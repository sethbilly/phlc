/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.entities;

import com.latlab.common.jpa.CommonModel;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Billy 
 */
@Entity
@Table(name = "user_account")
public class UserAccount extends CommonModel implements Serializable
{
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String passwd;
    
    @Column(name = "telephone_number")
    private String telephoneNumber;
    
    @JoinColumn(name = "staff")
    @OneToOne
    private Staff staff;
    
    @Column(name = "last_logged_in")
    @Temporal(TemporalType.DATE)
    private Date lastLoggedIn;
    
    @Column(name = "last_logged_out")
    @Temporal(TemporalType.DATE)
    private Date lastLoggedOut;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPasswd()
    {
        return passwd;
    }

    public void setPasswd(String passwd)
    {
        this.passwd = passwd;
    }

    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber)
    {
        this.telephoneNumber = telephoneNumber;
    }

    public Staff getStaff()
    {
        return staff;
    }

    public void setStaff(Staff staff)
    {
        this.staff = staff;
    }

    public Date getLastLoggedIn()
    {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Date lastLoggedIn)
    {
        this.lastLoggedIn = lastLoggedIn;
    }

    public Date getLastLoggedOut()
    {
        return lastLoggedOut;
    }

    public void setLastLoggedOut(Date lastLoggedOut)
    {
        this.lastLoggedOut = lastLoggedOut;
    }
    
    
}
