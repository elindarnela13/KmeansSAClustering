/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Controller.SimulatedAnnealing;
import Entity.ReadExcel;
import controller.EuclideanDistance;
import controller.MatrixOperator;
import controller.Pembobotan;
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
//         ArrayList<ArrayList> data = e.load_excel_format_xls("D:\\AlgenKmeans\\data\\testing.xlsx");
        SimulatedAnnealing sa = new SimulatedAnnealing();
        EuclideanDistance ed = new EuclideanDistance();
        MatrixOperator matrix = new MatrixOperator();
        
        String path = "D://dataset";
        Pembobotan bobot = new Pembobotan(path);
        bobot.doPembobotan();
        double[][] data_bobot = bobot.getHasilPembobotan();
        ArrayList<ArrayList> data = sa.array_to_arraylist(matrix.transpose(data_bobot));

        sa.do_sa(data);
        
        //-----------------------------
        System.out.println();
        ArrayList<ArrayList> state = sa.state(3, data.get(0).size(), matrix.min(data), matrix.max(data));
        System.out.println(state);

        ArrayList<ArrayList> jarak1 = ed.jarak_euclidean(state, data);

        ArrayList<ArrayList> label_kromosom1 = sa.label_state(jarak1);

        ArrayList<ArrayList> update_centroid_k1 = ed.update_centeroid(label_kromosom1, data);

        ArrayList<ArrayList> jarak_energi = ed.jarak_euclidean(update_centroid_k1, data);

        System.out.println("Jarak Minimum: ");
        System.out.println(jarak_energi);

        ArrayList<ArrayList> label_state = sa.label_state(jarak_energi);
        System.out.println("Cluster :");
        System.out.println(label_state);
//
        ArrayList<Double> Ji_k1 = sa.ji(jarak_energi, label_state);
        System.out.println("Ji");
        System.out.println(Ji_k1);
    }
}
