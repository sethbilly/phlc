/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.entities;

import com.latlab.common.jpa.CommonModel;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Billy
 */
@Entity
@Table(name = "consignment")
@Cacheable(false)
public class Consignment extends CommonModel implements Serializable
{
    public static final String _consignmentNo = "jobNo";
    @Column(name = "job_no")
    private String jobNo;
    
    @Column(name = "hbl")
    private String hbl;
    
    @Column(name = "mbl_no")
    private String mblNo;
    
    @Column(name = "vessel_number")
    private String vesselNumber;
    
    @Column(name = "vessel_name")
    private String vesselName;
    
    @Column(name = "cargo_location")
    private String cargoLocation;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "pol_pod")
    private String polPod;
    
    @Column(name = "weight_vol")
    private double weightVol;
    
    @Column(name = "eta_date")
    @Temporal(TemporalType.DATE)
    private Date etaDate;
    
    public static final String  _client = "client";
    @JoinColumn(name = "client")
    @ManyToOne
    private Client client;

    public String getJobNo()
    {
        return jobNo;
    }

    public void setJobNo(String jobNo)
    {
        this.jobNo = jobNo;
    }

    public String getHbl()
    {
        return hbl;
    }

    public void setHbl(String hbl)
    {
        this.hbl = hbl;
    }

    public String getMblNo()
    {
        return mblNo;
    }

    public void setMblNo(String mblNo)
    {
        this.mblNo = mblNo;
    }

    public String getVesselNumber()
    {
        return vesselNumber;
    }

    public void setVesselNumber(String vesselNumber)
    {
        this.vesselNumber = vesselNumber;
    }

    public String getVesselName()
    {
        return vesselName;
    }

    public void setVesselName(String vesselName)
    {
        this.vesselName = vesselName;
    }

    public String getCargoLocation()
    {
        return cargoLocation;
    }

    public void setCargoLocation(String cargoLocation)
    {
        this.cargoLocation = cargoLocation;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getPolPod()
    {
        return polPod;
    }

    public void setPolPod(String polPod)
    {
        this.polPod = polPod;
    }

    public double getWeightVol()
    {
        return weightVol;
    }

    public void setWeightVol(double weightVol)
    {
        this.weightVol = weightVol;
    }

    public Date getEtaDate()
    {
        return etaDate;
    }

    public void setEtaDate(Date etaDate)
    {
        this.etaDate = etaDate;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }
    
    
}
