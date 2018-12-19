/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.tdmu.baont.arffprocessing;

import java.util.ArrayList;
import java.util.List;
import vn.edu.tdmu.baont.datamodel.Attribute;
import vn.edu.tdmu.baont.datamodel.AttributeSet;
import vn.edu.tdmu.baont.datamodel.AttributeValueSet;
import vn.edu.tdmu.baont.helper.FileHelper;

/**
 *
 * @author User
 */
public class ARFFFile {

    private String name;
    private String relation;
    private AttributeSet attributeSet;
    private List<AttributeValueSet> attributeValueSets;

    public ARFFFile() {
    }

    public ARFFFile(String name) {
        this.name = name;
    }

    public ARFFFile(String name, String relation, AttributeSet attributeSet, List<AttributeValueSet> attributeValueSets) {
        this.name = name;
        this.relation = relation;
        this.attributeSet = attributeSet;
        this.attributeValueSets = attributeValueSets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public AttributeSet getAttributeSet() {
        return attributeSet;
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        this.attributeSet = attributeSet;
    }

    public List<AttributeValueSet> getAttributeValueSet() {
        return attributeValueSets;
    }

    public void setAttributeValueSets(List<AttributeValueSet> attributeValueSet) {
        this.attributeValueSets = attributeValueSets;
    }

    public boolean readFromDisk() {
        List<String> lines = FileHelper.readAllLines(name);
        return convertFromLines(lines);
    }

    public boolean writeToDisk() {
        return FileHelper.writeAllLines(name, convertToLines());
    }

    public List<String> convertToLines() {
        List<String> lines = new ArrayList<String>();
        lines.add("@RELATION " + relation);
        for (Attribute a : attributeSet.getAttributes()) {
            lines.add("@ATTRIBUTE " + a.getName() + " " + a.getDataType());
        }
        lines.add("@DATA");
        for (AttributeValueSet avs : attributeValueSets) {
            String s = "";
            for (int i = 0; i < avs.getAttributeValues().size(); i++) {
                s += avs.getAttributeValues().get(i).getValue();
                if (i < avs.getAttributeValues().size() - 1) {
                    s += ",";
                }
            }
            lines.add(s);
        }
        return lines;
    }

    public boolean convertFromLines(List<String> lines) {
        return false;
    }
    
    public void truncateAttribute(int... inds){
        for(int i = inds.length - 1; i>=0; i--)
        {
            for(AttributeValueSet as : attributeValueSets){
                for(int j = as.getAttributeValues().size()-1; j>=0; j--)
                    if(j==inds[i])
                        as.getAttributeValues().remove(j);
            }
            attributeSet.getAttributes().remove(inds[i]);
        }
    }
}
