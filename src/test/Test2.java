/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import controller.EuclideanDistance;
import entity.ReadFiles;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        ReadFiles f = new ReadFiles();
        f.Read();
//        System.out.println(data);
        
//        Algen algen = new Algen();
//        ArrayList<ArrayList> kromosom_1 = algen.kromosom(3, data.length);
//        ArrayList<ArrayList> kromosom_2 = algen.kromosom(3, data.length);
//        ArrayList<ArrayList> kromosom_3 = algen.kromosom(3, data.length);
//        
//        System.out.println(kromosom_1);
//        System.out.println(kromosom_2);
//        System.out.println(kromosom_3);
//        System.out.println();
//        
//        EuclideanDistance jarak = new EuclideanDistance();
//        ArrayList<ArrayList> jarak_1 = jarak.EuclidDistance(kromosom_1, data);
    }
    
}
