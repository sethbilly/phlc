/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.services;

import com.latlab.common.jpa.QryHelper;
import com.macphelasystem.phlc.entities.Client;
import com.macphelasystem.phlc.entities.Consignment;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

/**
 *
 * @author Billy
 */
@Stateless
public class ClientService implements Serializable
{
    private static final Logger LOGGER = Logger.getLogger(ClientService.class.getName());
    
    @Inject private CrudService crudService;
    
    public List<Client> clientsList(boolean deleted)
    {
        String qry = "";
        try
        {
            qry = "Select c From Client c Where c.deleted =:deleted";
            Query query = crudService.getEm().createQuery(qry, Client.class);
            query.setParameter("deleted", deleted);
            return query.getResultList();
        } catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<Consignment> findConsignmentsOfClient(Client client)
    {
        try
        {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), Consignment.class);
            qryHelper.addObjectParam(Consignment._client, client);
            qryHelper.orderByDesc(Consignment._createdDate);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<Client> clientsListFindByAttribute(Client searchClient)
    {
        String qry = "";
        try 
        {
             qry = "SELECT c FROM " + Client.class.getSimpleName() + " c "
                + "WHERE c.fullName LIKE '%" + searchClient.getFullName() + "%' "
                + "OR c.mobileNumber LIKE '%" + searchClient.getMobileNumber() + "%' "
                + "ORDER BY c.fullName ";
            return crudService.getEm().createQuery(qry).getResultList();
        }
        catch (Exception e) 
        {
            LOGGER.log(Level.SEVERE, "Error searching for account " + e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }
}
