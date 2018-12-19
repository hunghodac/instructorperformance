/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.tdmu.baont.datamodel;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author User
 */
public class AttributeValueSet {
    private List<AttributeValue> attributeValues;

    public AttributeValueSet() {
    }

    public AttributeValueSet(List<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }

    public List<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }
    
    
}
