/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.services;

import com.macphelasystem.phlc.constants.InvoiceItemType;
import com.macphelasystem.phlc.constants.PaymentType;
import com.macphelasystem.phlc.constants.UserAccountCategory;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Billy
 */
@Named
@ApplicationScoped
public class CommonOptions
{
    @Inject private CrudService crudService;
    
    public List<PaymentType> getPaymentTypesList()
    {
        return Arrays.asList(PaymentType.values());
    }
    
    public List<InvoiceItemType> getInvoiceItemTypesList()
    {
        return Arrays.asList(InvoiceItemType.values());
    }
    
    public List<UserAccountCategory> getUserAccountCategoryList(){
        return Arrays.asList(UserAccountCategory.values());
    }
}
