/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.tdmu.baont.classifier;

import vn.edu.tdmu.baont.arffprocessing.InstancesHelper;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

/**
 *
 * @author User
 */
public abstract class Classifier {
    protected String trainingFileName;
    protected String testingFileName;
    protected String resultFileName;

    protected Instances trainingInstances = null;
    protected Instances testingInstances = null;
    protected Evaluation evaluation = null;
    
    public Classifier() {
    }

    public Classifier(String trainingFileName, String testingFileName) {
        this.trainingFileName = trainingFileName;
        this.testingFileName = testingFileName;
    }

    public Classifier(String trainingFileName, String testingFileName, String resultFileName) {
        this.trainingFileName = trainingFileName;
        this.testingFileName = testingFileName;
        this.resultFileName = resultFileName;
    }
    
    public String getTrainingFileName() {
        return trainingFileName;
    }

    public void setTrainingFileName(String trainingFileName) {
        this.trainingFileName = trainingFileName;
    }

    public String getTestingFileName() {
        return testingFileName;
    }

    public void setTestingFileName(String testingFileName) {
        this.testingFileName = testingFileName;
    }

    public String getResultFileName() {
        return resultFileName;
    }

    public void setResultFileName(String resultFileName) {
        this.resultFileName = resultFileName;
    }

    public Instances getTrainingInstances() {
        return trainingInstances;
    }

    public void setTrainingInstances(Instances trainingInstances) {
        this.trainingInstances = trainingInstances;
    }

    public Instances getTestingInstances() {
        return testingInstances;
    }

    public void setTestingInstances(Instances testingInstances) {
        this.testingInstances = testingInstances;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }
    
     public void buildTrainingInstances() {
        if (trainingInstances == null) {
            trainingInstances = InstancesHelper.buildInstances(trainingFileName);
        }
    }

    public void buildTestingInstances() {
        if (testingInstances == null) {
            testingInstances = InstancesHelper.buildInstances(testingFileName);
        }
    }
    
    public abstract void buildClassifier();
    public abstract void evaluate();
}
