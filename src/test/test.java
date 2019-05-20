/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Controller.SimulatedAnnealing;
import controller.EuclideanDistance;
import controller.K_Means;
import controller.MatrixOperator;
import controller.Pembobotan;
import controller.Coba;
import controller.DBI;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SimulatedAnnealing sa = new SimulatedAnnealing();
        EuclideanDistance ed = new EuclideanDistance();
        MatrixOperator matrix = new MatrixOperator();
        K_Means km = new K_Means();
        DBI dbi = new DBI();

        String path = "D://Dataset";
        Pembobotan bobot = new Pembobotan(path);
        bobot.doPembobotan();
        double[][] data_bobot = bobot.getHasilPembobotan();
        ArrayList<ArrayList> data = bobot.array_to_arraylist(matrix.transpose(data_bobot));

        int cluster = 3;
        int maxIterasi = 2;
        double ti = 100;
        double t_rendah = 0.9;
        
        sa.do_sa(data, cluster, maxIterasi, ti, t_rendah);
        ArrayList<ArrayList> centroid_fix = new ArrayList<ArrayList>();
        centroid_fix = sa.getState_akhir();

//        ArrayList<ArrayList> centroid = new ArrayList<ArrayList>();
//        centroid = sa.state(3, data.get(0).size(), matrix.nilai_minimum(data), matrix.nilai_maksimum(data));

        km.do_k_means(centroid_fix, data);
////          
//        dbi.hitung_dbi(data, km.get_centroid());

    }
}

//    public static void main(String[] args) {
// TODO code application logic here
//        ReadExcel ex = new ReadExcel();
//        ArrayList<ArrayList<Double>> data = ex.load_excel_format_xls("D:\\testing.xlsx");
//        
//        SimulatedAnnealing sa = new SimulatedAnnealing();
//        ArrayList<ArrayList> centroid = sa.state(3, data.get(0).size(), 0, 1);
//        System.out.println(centroid);
//        
//        DistanceMeasure ed = new DistanceMeasure();
//        ArrayList<ArrayList> jarak = ed.jarak_euclidean(centroid, data);
//        System.out.println("jarak: ");
//        System.out.println(jarak);
//        
//        ArrayList<ArrayList> labeling = ed.label_state(jarak);
//        System.out.println("label");
//        System.out.println(labeling);
//        
//        //hitung ji
//        ArrayList<Double> ji = sa.ji(jarak,labeling);
//        System.out.println("Ji");
//        System.out.println(ji);
//        
//        //hitung energi awal
//       
//        double energi_awal = sa.sum_araylist(ji);
//        System.out.println("sum_Ji");
//        System.out.println(energi_awal);
//        
////        ArrayList<ArrayList> update_state = ed.update_centeroid(labeling, data);
//        System.out.println("update state: ");
//        System.out.println(update_state);
//        
//        ArrayList<Double> update_row = update_state.get(0);
//        ArrayList<ArrayList<Double>> new_state = new ArrayList<>();
//        
//        for(int i=0; i<centroid.size(); i++){
//            if(i>0){
//                new_state.add(centroid.get(i));
//            }else{
//                new_state.add(update_row);
//            }
//        }
////        ArrayList<ArrayList> update_row = ed.update_state_row(update_state.get(0), data);
//        System.out.println("update state row");
//        System.out.println(new_state);
//    }
//    
//}

