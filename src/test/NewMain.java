/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.impl.DenseDoubleMatrix2D;
import cern.colt.matrix.linalg.SingularValueDecomposition;
<<<<<<< HEAD
import Controller.SimulatedAnnealing;
import controller.EuclideanDistance;
=======
import controller.SimulatedAnnealing;
import controller.DistanceMeasure;
>>>>>>> fd838d33718269e10e55f967d713d00ea5e264ac
import controller.DBI;
import controller.K_Means;
import controller.MatrixOperator;
import controller.Pembobotan;
import controller.ReduksiDimensiSvd;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//         ReadExcel e = new ReadExcel();
//         ArrayList<ArrayList> data = e.load_excel_format_xls("D:\\testing.xlsx");
//        SimulatedAnnealing sa = new SimulatedAnnealing();
//        DistanceMeasure ed = new DistanceMeasure();
//        MatrixOperator matrix = new MatrixOperator();
//        
//        String path = "D://dataset";
//        Pembobotan bobot = new Pembobotan(path);
//        bobot.doPembobotan();
//        double[][] data_bobot = bobot.getHasilPembobotan();
//        ArrayList<ArrayList> data = sa.array_to_arraylist(matrix.transpose(data_bobot));
//
//        sa.do_sa(data);
        
        //-----------------------------       
        

        String path = "D://dataset";
        Pembobotan bobot = new Pembobotan(path);
        MatrixOperator matrix = new MatrixOperator();
        
        bobot.doPembobotan();  
         
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
          ArrayList<ArrayList> data_hsl_reduksi = bobot.array_to_arraylist(matrix.transpose(data_reduksi));
          
          K_Means km = new K_Means();
          SimulatedAnnealing sa = new SimulatedAnnealing();
          
          int cluster = 3;
          ArrayList<ArrayList> centeroid = sa.state(cluster, data_hsl_reduksi.get(0).size(), matrix.nilai_minimum(data_hsl_reduksi), matrix.nilai_maksimum(data_hsl_reduksi));
                  
          km.do_k_means(centeroid, data_hsl_reduksi);
          ArrayList<ArrayList> centroid_akhir = km.get_centroid();

//        System.out.println("centroid akhir :");
////        System.out.println(centroid_akhir.size());

        DBI dbi = new DBI();
        dbi.hitung_dbi(data_hsl_reduksi, centroid_akhir);
        System.out.println(dbi.get_dbi());
    }

}


