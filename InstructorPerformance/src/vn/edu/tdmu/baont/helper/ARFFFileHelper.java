/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.tdmu.baont.helper;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;
import java.util.List;
import vn.edu.tdmu.baont.arffprocessing.ARFFFile;
import vn.edu.tdmu.baont.datamodel.Attribute;
import vn.edu.tdmu.baont.datamodel.AttributeSet;
import vn.edu.tdmu.baont.datamodel.AttributeValue;
import vn.edu.tdmu.baont.datamodel.AttributeValueSet;
import vn.edu.tdmu.baont.datamodel.CSVFile;

/**
 *
 * @author User
 */
public class ARFFFileHelper {

    public static ARFFFile convertCSVToARFF(String name) {
        CSVFile csvFile = new CSVFile(name);
        ARFFFile arffFile = new ARFFFile();
        List<Attribute> attributes = null;
        AttributeSet attributeSet = null;
        List<AttributeValue> attributeValues = null;
        List<AttributeValueSet> attributeValueSets = null;

        if (!csvFile.readFromDisk()) {
            return null;
        }

        String[] names = csvFile.getLines().get(0).split(",");
        String[] dataTypes = csvFile.getLines().get(1).split(",");

        attributes = new ArrayList<Attribute>();

        for (int i = 0; i < names.length; i++) {
            if (i == names.length - 1) {
                String s = "";
                for (int j = i; j < dataTypes.length; j++) {
                    s += dataTypes[j];
                    if (j != dataTypes.length - 1) {
                        s += ",";
                    }
                }
                attributes.add(new Attribute(names[i], s));
            } else {
                attributes.add(new Attribute(names[i], dataTypes[i]));
            }
        }

        attributeValueSets = new ArrayList<AttributeValueSet>();

        for (int i = 2; i < csvFile.getLines().size(); i++) {
            attributeValues = new ArrayList<AttributeValue>();
            String[] strs = csvFile.getLines().get(i).split(",");
            for (int j = 0; j < strs.length; j++) {
                switch (dataTypes[j]) {
                    case "numeric":
                        attributeValues.add(new AttributeValue<Double>(attributes.get(j), Double.parseDouble(strs[j])));
                        break;
                    default:
                        attributeValues.add(new AttributeValue<String>(attributes.get(j), strs[j]));
                }
            }
            attributeValueSets.add(new AttributeValueSet(attributeValues));
        }

        attributeSet = new AttributeSet(attributes);

        return new ARFFFile("", "", attributeSet, attributeValueSets);
    }

    public static void main(String[] args) {
        ARFFFile arffFile = convertCSVToARFF("F:\\Research\\TDMU\\2018\\HTK_Instructor Performance\\Code\\InstructorPerformance\\train.csv");
        arffFile.setName("F:\\Research\\TDMU\\2018\\HTK_Instructor Performance\\Code\\InstructorPerformance\\train.arff");
        arffFile.setRelation("SURVEY");
        arffFile.truncateAttribute(0,1,2,3,4);
        arffFile.writeToDisk();
        
        arffFile = convertCSVToARFF("F:\\Research\\TDMU\\2018\\HTK_Instructor Performance\\Code\\InstructorPerformance\\test.csv");
        arffFile.setName("F:\\Research\\TDMU\\2018\\HTK_Instructor Performance\\Code\\InstructorPerformance\\test.arff");
        arffFile.setRelation("SURVEY");
        arffFile.truncateAttribute(0,1,2,3,4);
        arffFile.writeToDisk();
    }
}
