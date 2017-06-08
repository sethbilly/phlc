/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.entities;

import com.latlab.common.jpa.CommonModel;
import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Billy 
 */
@Entity
@Table(name = "staff")
@Cacheable(false)
public class Staff extends CommonModel implements Serializable
{
    @Column(name = "address")
    private String address;
    
    public static final String _fullName = "fullName";
    @Column(name = "full_name")
    private String fullName;
    
    public static final String _email = "email";
    @Column(name = "email")
    private String email;
    
    public static final String _mobileNumber = "mobileNumber";
    @Column(name = "mobile_number")
    private String mobileNumber;
    
    @Column(name = "telephone_number")
    private String telephoneNumber;

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber)
    {
        this.telephoneNumber = telephoneNumber;
    }
    
    
}
