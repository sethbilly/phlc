/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macphelasystem.phlc.constants;

import com.latlab.common.constants.EnumResolvable;

/**
 *
 * @author Billy
 */
public enum UserAccountCategory implements EnumResolvable
{
    FINANCE("Finance", "FINANCE"),
    DOCUMENTATION_MANAGER("Documentation Manger", "DOCUMENTATION_MANAGER"),
    ADMINISTRATOR("Administrator", "ADMINISTRATOR");
    

    private UserAccountCategory(String label, String code) {
        this.label = label;
        this.code = code;
    }
    
    String label, code;

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getCode() {
        return code;
    }
}
