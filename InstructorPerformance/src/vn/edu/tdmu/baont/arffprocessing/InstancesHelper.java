/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.tdmu.baont.arffprocessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.tdmu.baont.classifier.NaiveBayesClassifier;
import weka.core.Instances;

/**
 *
 * @author User
 */
public class InstancesHelper {
    
    public static Instances buildInstances(String name){
         try {
            BufferedReader breader = new BufferedReader(new FileReader(name));
            Instances instances = new Instances(breader);
            breader.close();
            instances.setClassIndex(instances.numAttributes() - 1);
            return instances;
        } catch (Exception ex) {
            Logger.getLogger(NaiveBayesClassifier.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
