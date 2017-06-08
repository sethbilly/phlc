/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.utils;

import org.omnifaces.util.Messages;

/**
 *
 * @author Billy
 */
public class Msg
{
    public static void successSave(){
        Messages.addGlobalInfo("Saved successfully");
    }
    
    public static void msg(boolean result)
    {
        if(result)
        {
            Messages.addGlobalInfo("Action Successful");
        }
        else
        {
            Messages.addGlobalFatal("Action Failed");
        }
    }
    
    public static void failedSave(){
        Messages.addGlobalError("Saving failed");
    }
    
    public static void successDelete(){
        Messages.addGlobalInfo("Deleted successfully");
    }
    
    public static void failedDelete(){
        Messages.addGlobalError("Deleting failed");
    }
    
    public static void reportInitiated(){
        Messages.addGlobalInfo("Report generation initiated");
    }
    
    public static void genericInfo(String info){
        Messages.addGlobalInfo(info);
    }
    
    
    public static void info(String info){
        Messages.addGlobalInfo(info);
    }
    
    public static void error(String info){
        Messages.addGlobalError(info);
    }
    
    public static void genericError(String error){
        Messages.addGlobalError(error);
    }
}
