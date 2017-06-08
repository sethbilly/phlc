/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.services;

import com.latlab.common.jpa.QryHelper;
import com.macphelasystem.phlc.entities.Consignment;
import com.macphelasystem.phlc.entities.Invoice;
import com.macphelasystem.phlc.entities.Staff;
import com.macphelasystem.phlc.entities.UserAccount;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Billy
 */
@Stateless
public class CommonService implements Serializable
{
    @Inject private CrudService crudService;
    
    
    public List<Consignment> consignmentsList()
    {
        return crudService.findAll(Consignment.class, false);
    }
    
    public List<Invoice> invoicesList()
    {
        return crudService.findAll(Invoice.class, false);
    }
    
    public List<Staff> staffList()
    {
        return crudService.findAll(Staff.class, false);
    }
    
    public List<UserAccount> getUserAccountsList()
    {
        return crudService.findAll(UserAccount.class, false);
    }
    
    public UserAccount authenticateAccount(String username, String passwd)
    {
        UserAccount foundUser = null;
        try
        {
          
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return foundUser;
    }
    
    public List<Staff> staffsListFindByAttribute(Staff staffQP)
    {
        try 
        {
             QryHelper  qryHelper = new QryHelper(crudService.getEm(), Staff.class);
             qryHelper.addStringQryParam(Staff._email, staffQP.getEmail(), QryHelper.ComparismCriteria.LIKE, QryHelper.IncludeCriteria.AND);
             qryHelper.addStringQryParam(Staff._mobileNumber, staffQP.getMobileNumber(), QryHelper.ComparismCriteria.LIKE);
            return qryHelper.buildQry().getResultList();
        }
        catch (Exception e) 
        {
           e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
