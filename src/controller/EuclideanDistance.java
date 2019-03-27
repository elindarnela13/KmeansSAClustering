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
     public ArrayList<ArrayList> jarak_euclidean(ArrayList<ArrayList> kromosom, ArrayList<ArrayList> data) {

        ArrayList<ArrayList> jarak_euclidean = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            ArrayList<Double> jarak_c = new ArrayList<>();
            for (int j = 0; j < kromosom.size(); j++) {

                double total = 0.0;
                for (int k = 0; k < kromosom.get(j).size(); k++) {
                    total = total + (Math.pow(
                            (Double.parseDouble(data.get(i).get(k).toString())
                            - Double.parseDouble(kromosom.get(j).get(k).toString())), 2));
                }
                jarak_c.add(total);
            }
            jarak_euclidean.add(jarak_c);
        }
        return jarak_euclidean;
    }
    
    public ArrayList<ArrayList> update_centeroid(ArrayList<ArrayList> label_state, ArrayList<ArrayList> data) {
        ArrayList<ArrayList> update_centeroid = new ArrayList<>();
        for (int i = 0; i < label_state.size(); i++) {
            ArrayList<Double> averages = new ArrayList<>();
            for (int l = 0; l < data.get(0).size(); l++) {
                double total = 0;
                for (int j = 0; j < label_state.get(i).size(); j++) {
                    total = Double.parseDouble(data.get(Integer.parseInt(label_state.get(i).get(j).toString())).get(l).toString()) + total;
                }
                if (total != 0) {
                    averages.add(total / (label_state.get(i).size() * 1.0));
                } else {
                    averages.add(0.0);
                }
            }
            update_centeroid.add(averages);
        }
        return update_centeroid;
    }
    
    public ArrayList<ArrayList> update_state_row(ArrayList<ArrayList> label_state, ArrayList<ArrayList> data){
        ArrayList<ArrayList> update_state_row = new ArrayList<ArrayList>();
        for (int i = 0; i < label_state.size(); i++) {
            ArrayList<Double> averages = new ArrayList<>();
            for (int l = 0; l < data.get(0).size(); l++) {
                double total = 0;
                    total = Double.parseDouble(data.get(Integer.parseInt(label_state.get(i).toString())).get(l).toString()) + total;
                
                if (total != 0) {
                    averages.add(total / (label_state.get(i).size() * 1.0));
                } else {
                    averages.add(0.0);
                }
            }
            update_state_row.add(averages);
        }
        return update_state_row;
    }
}
