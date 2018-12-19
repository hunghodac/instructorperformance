/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.tdmu.baont.datamodel;

/**
 *
 * @author User
 */
public class AttributeValue<T> {
    private Attribute attribute;
    private T value;

    public AttributeValue() {
    }

    public AttributeValue(Attribute attribute, T value) {
        this.attribute = attribute;
        this.value = value;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    
    
}
