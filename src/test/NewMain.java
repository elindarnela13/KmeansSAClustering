/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Controller.SimulatedAnnealing;
import Entity.ReadExcel;
import controller.EuclideanDistance;
import controller.K_Means;
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
         ReadExcel e = new ReadExcel();
         ArrayList<ArrayList> data = e.load_excel_format_xls("D:\\testing.xlsx");
        SimulatedAnnealing sa = new SimulatedAnnealing();
        EuclideanDistance ed = new EuclideanDistance();
        MatrixOperator matrix = new MatrixOperator();
        
//        String path = "D://dataset";
//        Pembobotan bobot = new Pembobotan(path);
//        bobot.doPembobotan();
//        double[][] data_bobot = bobot.getHasilPembobotan();
//        ArrayList<ArrayList> data = sa.array_to_arraylist(matrix.transpose(data_bobot));

        sa.do_sa(data);
        
        //-----------------------------
//       
        
//
    }
}
