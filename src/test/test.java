/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

<<<<<<< HEAD
import Controller.SimulatedAnnealing;
import controller.EuclideanDistance;
=======
import controller.SimulatedAnnealing;
import Entity.ReadExcel;
import controller.DistanceMeasure;
>>>>>>> fd838d33718269e10e55f967d713d00ea5e264ac
import controller.K_Means;
import controller.MatrixOperator;
import controller.Pembobotan;
import controller.Coba;
<<<<<<< HEAD
import controller.DBI;
=======
>>>>>>> fd838d33718269e10e55f967d713d00ea5e264ac
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

<<<<<<< HEAD
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

=======
        ReadExcel e = new ReadExcel();
<<<<<<< HEAD

        ArrayList<ArrayList> data = e.load_excel_format_xls("E:\\testing.xlsx");
=======
>>>>>>> ef392f493dcf461ca855c46b79fae93e859e4628
        SimulatedAnnealing sa = new SimulatedAnnealing();
        DistanceMeasure ed = new DistanceMeasure();
        MatrixOperator matrix = new MatrixOperator();

<<<<<<< HEAD
//        String path = "E://dataset";
//        Pembobotan bobot = new Pembobotan(path);
//        bobot.doPembobotan();
//        double[][] data_bobot = bobot.getHasilPembobotan();
//        ArrayList<ArrayList> data = bobot.array_to_arraylist(matrix.transpose(data_bobot));
          sa.do_sa(data);
//        Coba coba = new Coba();
//        coba.do_sa(data);

=======
      ArrayList<ArrayList> data = e.load_excel_format_xls("D:\\testing.xlsx");

//        String path = "D://dataset";
//        Pembobotan bobot = new Pembobotan(path);
//        bobot.doPembobotan();
//        double[][] data_bobot = bobot.getHasilPembobotan();
//        ArrayList<ArrayList> data = sa.array_to_arraylist(matrix.transpose(data_bobot));

//        int cluster = 3;
//        int ti = 100;
//        
//        int iterasi = 3;
//        double cr = 0.5;
//        double mr = 0.2;
//        
//        ArrayList<ArrayList> centeroid_algen = algen.do_algen(data, cluster, popsize, iterasi, cr, mr);
//        ArrayList<ArrayList> centeroid = algen.kromosom(cluster, data.get(0).size(), matrix.nilai_minimum(data), matrix.nilai_maksimum(data));
//
//        K_Means km = new K_Means();
//
//        km.do_k_means(centeroid_algen, data);
        sa.do_sa(data);
>>>>>>> ef392f493dcf461ca855c46b79fae93e859e4628
>>>>>>> fd838d33718269e10e55f967d713d00ea5e264ac
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

