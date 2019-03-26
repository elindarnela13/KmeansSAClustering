/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entity.ReadExcel;
import controller.EuclideanDistance;
import controller.MatrixOperator;
import controller.Pembobotan;
import controller.SA;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SA sa = new SA();
        MatrixOperator matrix = new MatrixOperator();
        
        System.out.println("data : ");
//        ReadExcel e = new ReadExcel();
//        ArrayList<ArrayList> data = e.load_excel_format_xls("D:\\testing.xlsx");
//        System.out.println(data);
//        System.out.println();
////    
        String path = "D://dataset";
        Pembobotan bobot = new Pembobotan(path);
        bobot.doPembobotan();
        double[][] data_bobot = bobot.getHasilPembobotan();
        ArrayList<ArrayList> data = sa.array_to_arraylist(matrix.transpose(data_bobot));
      
        ArrayList<ArrayList> state = sa.state(3, data.get(0).size(), matrix.min(data), matrix.max(data));
        System.out.println(state);
//          sa.do_sa(data);
    }
    
}
