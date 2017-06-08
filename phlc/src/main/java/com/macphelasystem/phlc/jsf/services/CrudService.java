/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.jsf.services;

import com.latlab.common.jpa.CrudController;
import com.latlab.common.jpa.Enviroment;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Billy
 */
@Stateless
public class CrudService extends CrudController implements Serializable
{

    @PersistenceContext(unitName = "phlcPU")
    private EntityManager em;

    @PostConstruct
    public void init()
    {
        setEnviroment(Enviroment.JAVA_EE);
        setEm(em);
    }
}
