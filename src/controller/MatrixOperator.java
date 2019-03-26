/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author User
 */

import cern.colt.matrix.DoubleMatrix1D;
import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.impl.DenseDoubleMatrix2D;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixOperator {
    
    public double[][] transpose(double[][] data){
        System.out.println("--------------transpose----------------");
        double[][] transposedMatrix = new double[data[0].length][data.length];
        for(int rows = 0; rows < data.length; rows++){
            for(int cols = 0; cols < data[0].length; cols++){
                transposedMatrix[cols][rows] = data[rows][cols];
            }
        }
        for(double[] i:transposedMatrix){//2D arrays are arrays of arrays
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        return transposedMatrix;
    }
    
//    Perkalian matriks
    public double[][] multiply(DoubleMatrix2D data1, DoubleMatrix2D data2){
        System.out.println("------------multiply1------------");
        double[][] multipliedMatrix = new double[data1.rows()][data2.columns()];
        for(int i=0; i<data1.rows(); i++){
            for(int j=0; j<data2.columns(); j++){
                for(int k=0; k<data1.columns(); k++){
                    multipliedMatrix[i][j] += data1.get(i, k) * data2.get(k, j);
//                    System.out.println(data1.get(i, k) + " * " + data2.get(k, j) + " = " + data1.get(i, k) * data2.get(k, j));
                }System.out.print(multipliedMatrix[i][j] + "  ");
            }System.out.print("\n");
        }
        return multipliedMatrix;
    }
     
    public double min(ArrayList<ArrayList> data){
        double min = 0;
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).size(); j++) {
                if (min > Double.parseDouble(data.get(i).get(j).toString())) {
                    Double.parseDouble(data.get(i).get(j).toString());
                }
            }
        }
        return min;
    }
    
    public double max(ArrayList<ArrayList> data){
        double max = 0;
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).size(); j++) {
                if (max < Double.parseDouble(data.get(i).get(j).toString())) {
                    Double.parseDouble(data.get(i).get(j).toString());
                }
            }
        }
        return max;
    }

}
