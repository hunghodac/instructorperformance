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
public class AttributeSet {
    private List<Attribute> attributes;

    public AttributeSet() {
    }

    public AttributeSet(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
    
    
}
