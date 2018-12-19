/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.tdmu.baont.classifier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.tdmu.baont.arffprocessing.InstancesHelper;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.BayesNet;
import weka.core.Instances;
import weka.classifiers.bayes.NaiveBayes;

/**
 *
 * @author User
 */
public class NaiveBayesClassifier extends Classifier {

    
    private NaiveBayes naiveBayes = null;

    public NaiveBayes getNaiveBayes() {
        return naiveBayes;
    }
    
    public NaiveBayesClassifier() {
    }

    public NaiveBayesClassifier(String trainingFileName, String testingFileName) {
        super(trainingFileName, testingFileName);
    }

    public NaiveBayesClassifier(String trainingFileName, String testingFileName, String resultFileName) {
        super(trainingFileName, testingFileName, resultFileName);
    }

    public void setNaiveBayes(NaiveBayes naiveBayes) {
        this.naiveBayes = naiveBayes;
    }

    @Override
    public void buildClassifier() {
        if (naiveBayes == null && trainingInstances != null) {
            try {
                naiveBayes = new NaiveBayes();
                naiveBayes.buildClassifier(trainingInstances);
            } catch (Exception ex) {
                Logger.getLogger(NaiveBayesClassifier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void evaluate() {
        if (resultFileName != null && trainingInstances != null
                && testingInstances != null && naiveBayes != null) {
            try {
                evaluation = new Evaluation(trainingInstances);
                evaluation.evaluateModel(naiveBayes, testingInstances);
            } catch (Exception ex) {
                Logger.getLogger(NaiveBayesClassifier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        NaiveBayesClassifier naiveBayesClassifier = new NaiveBayesClassifier("F:\\Research\\TDMU\\2018\\HTK_Instructor Performance\\Code\\InstructorPerformance\\train.arff"
                , "F:\\Research\\TDMU\\2018\\HTK_Instructor Performance\\Code\\InstructorPerformance\\test.arff"
                , "");
        naiveBayesClassifier.buildTestingInstances();
        naiveBayesClassifier.buildTrainingInstances();
        naiveBayesClassifier.buildClassifier();
        naiveBayesClassifier.evaluate();
        System.out.println(naiveBayesClassifier.getEvaluation().toSummaryString());
//        System.out.println(naiveBayesClassifier.getEvaluation().getMetricsToDisplay());
//        System.out.println(naiveBayesClassifier.getEvaluation().correct());
        
        

    }
}
