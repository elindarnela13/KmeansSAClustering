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
                double total_jarak = Math.sqrt(total);
                jarak_c.add(total_jarak);
            }
            jarak_euclidean.add(jarak_c);
        }
        return jarak_euclidean;
    }

    public ArrayList<ArrayList> update_centeroid(ArrayList<ArrayList> label_state, ArrayList<ArrayList> data) {
        ArrayList<ArrayList> update_centeroid = new ArrayList<>();
        for (int i = 0; i < label_state.size(); i++) {
//            System.out.println("label_state.size()");
//            System.out.println(label_state.size());
//            System.out.println("label_state.get(i).size()");
//            System.out.println(label_state.get(i).size());
            ArrayList<Double> averages = new ArrayList<>();
            for (int l = 0; l < data.get(0).size(); l++) {
//                System.out.println("data.get(0).size()");
//                System.out.println(data.get(0).size());
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

    public ArrayList<Double> update_state_row(ArrayList<Double> label_state, ArrayList<ArrayList> data) {
        ArrayList<Double> update_state_row = new ArrayList<Double>();

        double averages = 0;   
        for (int l = 0; l < data.get(0).size(); l++) {
//            System.out.println("data.get(0).size()");
//            System.out.println(data.get(0).size());
            double total = 0;
            for (int j = 0; j < label_state.size(); j++) {
                total = Double.parseDouble(data.get(Integer.parseInt(label_state.get(j).toString())).get(l).toString()) + total;
            }
            if (total != 0) {
                averages = (total / (label_state.size() * 1.0));
            } else {
                averages = 0.0;
            }
            update_state_row.add(averages);
        }
        return update_state_row;
    }

    public ArrayList<ArrayList> label_state(ArrayList<ArrayList> jarak_euclidean_1) {

        ArrayList<ArrayList> label_state = new ArrayList<>();

        ArrayList<Integer> labeling = new ArrayList<>();
        for (int i = 0; i < jarak_euclidean_1.size(); i++) {
            double jarak = Double.parseDouble(jarak_euclidean_1.get(i).get(0).toString());
            int index = 0;
            for (int j = 0; j < jarak_euclidean_1.get(i).size(); j++) {
                if (Double.parseDouble(jarak_euclidean_1.get(i).get(j).toString()) <= jarak) {
                    jarak = Double.parseDouble(jarak_euclidean_1.get(i).get(j).toString());
                    index = j;
                }
            }
            labeling.add(index);
        }

        for (int i = 0; i < jarak_euclidean_1.get(0).size(); i++) {
            ArrayList<Integer> label_kromosom_s = new ArrayList<>();

            for (int j = 0; j < labeling.size(); j++) {
                if (labeling.get(j) == i) {
                    label_kromosom_s.add(j);
                }
            }
            label_state.add(label_kromosom_s);
        }
        return label_state;
    }

}
