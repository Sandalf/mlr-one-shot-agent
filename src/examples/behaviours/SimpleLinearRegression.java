/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.behaviours;

/**
 *
 * @author luissandoval
 */
public class SimpleLinearRegression {

    double intercept; // B0
    double slope; //  B1
    Dataset dataset;

    public SimpleLinearRegression(Dataset _dataset) {
        this.dataset = _dataset;
        this.slope = this.calculateSlope();
        this.intercept = this.calculateIntercept();    
    }

    private double calculateSlope() {
        double[][] data = dataset.getData();
        int n = data.length;
        double sumOfX = 0;
        double sumOfY = 0;
        double sumOfProductXY = 0;
        double sumOfXSquare = 0;

        for (int i = 0; i < n; i++) {
            sumOfX += data[i][0];
            sumOfY += data[i][1];
            sumOfProductXY += data[i][0] * data[i][1];
            sumOfXSquare += data[i][0] * data[i][0];
        }                           
        
        return (n * sumOfProductXY - (sumOfX * sumOfY)) / ((n * sumOfXSquare) - (sumOfX * sumOfX));
    }
    
    private double calculateIntercept() {
        double[][] data = dataset.getData();
        int n = data.length;
        double sumOfX = 0;
        double sumOfY = 0;

        for (int i = 0; i < n; i++) {
            sumOfX += data[i][0];
            sumOfY += data[i][1];
        }            
                
        return (sumOfY - (this.slope * sumOfX)) / n;
    }
    
    public void printEquation() {
        System.out.println("y = " + this.intercept + " + " + this.slope  + "x");
    }
    
    public void predict(double x) {
        double y = this.intercept + this.slope * x;
        System.out.println("Prediction:");
        System.out.println("x: " + x + ", y: " + y);
    }

    public double getIntercept() {
        return intercept;
    }

    public void setIntercept(double intercept) {
        this.intercept = intercept;
    }

    public double getSlope() {
        return slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

}
