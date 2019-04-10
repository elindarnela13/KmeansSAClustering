/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Controller.SimulatedAnnealing;
import Entity.ReadExcel;
import controller.EuclideanDistance;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ReadExcel ex = new ReadExcel();
        ArrayList<ArrayList> data = ex.load_excel_format_xls("D:\\testing.xlsx");
        
        SimulatedAnnealing sa = new SimulatedAnnealing();
        ArrayList<ArrayList> centroid = sa.state(3, data.get(0).size(), 0, 1);
        System.out.println(centroid);
        
        EuclideanDistance ed = new EuclideanDistance();
        ArrayList<ArrayList> jarak = ed.jarak_euclidean(centroid, data);
        System.out.println("jarak: ");
        System.out.println(jarak);
        
        ArrayList<ArrayList> labeling = ed.label_state(jarak);
        System.out.println("label");
        System.out.println(labeling);
        
        ArrayList<ArrayList> update_state = ed.update_centeroid(labeling, data);
        System.out.println("update state: ");
        System.out.println(update_state);
        
//        ArrayList<ArrayList> update_row = update_state.get(0);
        ArrayList<ArrayList> update_row = ed.update_state_row(update_state.get(0), data);
        System.out.println("update state row");
        System.out.println(update_row);
    }
    
}
