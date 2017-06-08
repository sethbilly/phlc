/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.utils;

import com.latlab.common.reporting.JasperReportManager;
import com.latlab.common.reporting.ReportDesignFileType;
import com.latlab.common.reporting.ReportOutputEnvironment;
import com.latlab.common.reporting.ReportOutputFileType;

/**
 *
 * @author ICSGH-BILLY
 */
public class ReportGenerator extends JasperReportManager
{

    public ReportGenerator()
    {
        setReportEnvironment(ReportOutputEnvironment.WEB_APPLICATION);
        setReportFileType(ReportDesignFileType.INPUTSTREAM);
        setReportOutput(ReportOutputFileType.PDF);
    }
}
