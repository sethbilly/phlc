/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.services;

import com.macphelasystem.phlc.entities.Consignment;
import com.macphelasystem.phlc.entities.Invoice;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Billy
 */
@Stateless
public class IdService implements Serializable
{
    @Inject CrudService crudService;
    
    public String getId()
    {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }
    
    public String generateConsignmentJobNo()
    {
        int count = crudService.count(Consignment.class) + 1;
        String accountCount = StringUtils.leftPad(count + "", 3, "0");
        String fileNo = "PHC" + accountCount + new Date().getYear();
        System.out.println("account code " + fileNo);
        return fileNo;
    }
    
    public void generateInvoiceNo(Invoice invoice)
    {
        
    }
    
    public String generateRandomNumber()
    {
        try {
            return randomstring();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private  static String randomstring(int lo, int hi)
    {
        int n = rand(lo, hi);
        byte b[] = new byte[n];
        for (int i = 0; i < n; i++)
        {
            b[i] = (byte) rand('0', '9');
        }
        return new String(b, 0);
    }

    private static int rand(int lo, int hi)
    {
        java.util.Random rn = new java.util.Random();
        int n = hi - lo + 1;
        int i = rn.nextInt(n);
        if (i < 0)
        {
            i = -i;
        }
        return lo + i;
    }

    private static String randomstring()
    {
        return randomstring(9, 9);
    }
    
    public static void main(String[] args)
    {
        
        System.out.println("random string " + randomstring());
    }
}
