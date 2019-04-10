/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.impl.DenseDoubleMatrix2D;
import cern.colt.matrix.linalg.SingularValueDecomposition;
import controller.Pembobotan;
import controller.MatrixOperator;
import controller.Praproses;
import controller.ReduksiDimensiSvd;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import static java.util.Locale.US;
/**
 *
 * @author User
 */
public class ClusterTest {
     public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException{
        String path = "D:\\dataset";
        Pembobotan bobot = new Pembobotan(path);
        MatrixOperator matrix = new MatrixOperator();
        
        bobot.doPembobotan();
        
        System.out.println("Awal");
        System.out.println("Hasil Pembobotan : " + bobot.getHasilPembobotan().length + " x " + bobot.getHasilPembobotan()[0].length);
        bobot.tampil_bobot(bobot.getHasilPembobotan());
         
        System.out.println("Transpose : ");
        System.out.println("Hasil Pembobotan : " + bobot.getHasilPembobotan()[0].length + " x " + bobot.getHasilPembobotan().length);
        matrix.transpose(bobot.getHasilPembobotan());
        System.out.println("");        
         
          DoubleMatrix2D data = new DenseDoubleMatrix2D(bobot.getHasilPembobotan());
          SingularValueDecomposition svd = new SingularValueDecomposition(data);
          
          svd.getU();
          svd.getS();
          svd.getV().viewDice();
          System.out.println("Matriks U*S : ");
          double[][] US = matrix.multiply(svd.getU(), svd.getS());
          System.out.println("Matriks S*V : ");
          double[][] SV = matrix.multiply(svd.getS(), svd.getV().viewDice());
          System.out.println("\n");
          
          ReduksiDimensiSvd reduksi = new ReduksiDimensiSvd(bobot.getGlobalTermList(), bobot.getListDocument(), US);
          reduksi.doReduksiDimensi();
                    
          System.out.println("Matriks S*V Transpose : ");
          double[][] data_reduksi =  matrix.transpose(SV);
          System.out.println(data_reduksi);
     }
}
