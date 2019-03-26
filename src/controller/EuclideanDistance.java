/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class EuclideanDistance {
    public ArrayList<ArrayList> jarak_euclidean(ArrayList<ArrayList> state, ArrayList<ArrayList> data) {

        ArrayList<ArrayList> jarak_euclidean = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) { 
            ArrayList<Double> jarak_c = new ArrayList<>();
            for (int j = 0; j < state.size(); j++) {

                double total = 0.0;
                for (int k = 0; k < state.get(j).size(); k++) {
                    total = total + (Math.pow(
                            (Double.parseDouble(data.get(i).get(k).toString())
                            - Double.parseDouble(state.get(j).get(k).toString())), 2)); //pegurangansebanyak data ke-i dengan centroid sebanyak j
                }
                double total_jarak = 0.0;
                total_jarak = Math.sqrt(total);
                jarak_c.add(total_jarak);
            }
            jarak_euclidean.add(jarak_c);
        }
        return jarak_euclidean;
    }
    
    public ArrayList<ArrayList> update_centeroid(ArrayList<ArrayList> label_kromosom, ArrayList<ArrayList> data) {

        ArrayList<ArrayList> update_centeroid = new ArrayList<>();
        for (int i = 0; i < label_kromosom.size(); i++) {
            ArrayList<Double> averages = new ArrayList<>();
            for (int l = 0; l < data.get(0).size(); l++) {
                double total = 0;
                for (int j = 0; j < label_kromosom.get(i).size(); j++) {
                    total = Double.parseDouble(data.get(Integer.parseInt(label_kromosom.get(i).get(j).toString())).get(l).toString()) + total;
                }
                if (total != 0) {
                    averages.add(total / (label_kromosom.get(i).size() * 1.0));
                } else {
                    averages.add(0.0);
                }
            }
            update_centeroid.add(averages);
        }
        return update_centeroid;

    }
}
