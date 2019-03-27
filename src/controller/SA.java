/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author User
 */
public class SA {

    public ArrayList<ArrayList> array_to_arraylist(double[][] data) {
        ArrayList<ArrayList> data_arraylist = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            ArrayList<Double> temp = new ArrayList<>();
            for (int j = 0; j < data[i].length; j++) {
                temp.add(data[i][j]);
            }
            data_arraylist.add(temp);
        }
        return data_arraylist;
    }

    public ArrayList<ArrayList> state(int row, int column, double min, double max) {

        ArrayList<ArrayList> centroid = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            ArrayList<Double> centroid_tes = new ArrayList<>();
            for (int j = 0; j < column; j++) {
                double random = ThreadLocalRandom.current().nextDouble(0, 1);
                centroid_tes.add(random);
            }
            centroid.add(centroid_tes);
        }
        return centroid;
    }

    public ArrayList<ArrayList> label_state(ArrayList<ArrayList> jarak_euclidean) {

        ArrayList<ArrayList> label_state = new ArrayList<>();

        ArrayList<Integer> labeling = new ArrayList<>();
        for (int i = 0; i < jarak_euclidean.size(); i++) {
            double jarak = Double.parseDouble(jarak_euclidean.get(i).get(0).toString());
            int index = 0;
            for (int j = 0; j < jarak_euclidean.get(i).size(); j++) {
                if (jarak <= Double.parseDouble(jarak_euclidean.get(i).get(j).toString())) {
                    jarak = Double.parseDouble(jarak_euclidean.get(i).get(j).toString());
                    index = j;
                }
            }
            labeling.add(index);
        }

        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> label_state_s = new ArrayList<>();

            for (int j = 0; j < labeling.size(); j++) {
                if (labeling.get(j) == i) {
                    label_state_s.add(j);
                }
            }
            label_state.add(label_state_s);
        }
        return label_state;
    }

    public ArrayList<Double> ji(ArrayList<ArrayList> energi_akhir, ArrayList<ArrayList> label_enerrgi_state) {

        ArrayList<Double> ji = new ArrayList<>();
        for (int i = 0; i < label_enerrgi_state.size(); i++) {
            double total = 0;
            for (int j = 0; j < label_enerrgi_state.get(i).size(); j++) {
                total = Double.parseDouble(energi_akhir.get(Integer.parseInt(label_enerrgi_state.get(i).get(j).toString())).get(i).toString()) + total;
            }
            if (total != 0) {
                ji.add(total / (label_enerrgi_state.get(i).size() * 1.0));
            } else {
                ji.add(0.0);
            }
        }
        return ji;
    }

    public double temperatur(double ti, double t_rendah) {
        double new_temperatur;
        int numTemp = 200;

        new_temperatur = ti * ((t_rendah / ti) * 1 / numTemp);

        return new_temperatur;
    }

    public double prob_boltzman(double perub_energi, double ti) {
        double prob_boltzman;
        int k = 1;

        prob_boltzman = (-perub_energi) / ti;

        return prob_boltzman;
    }

    public double sum_ji(ArrayList<Double> ji){
        double sum = 0;
        ji.size();
        for (int i = 0; i < ji.size(); i++) {
            sum += ji.get(i);
            System.out.println(ji.get(i));
        }
    
        return sum;
    }
    
    public void do_sa(ArrayList<ArrayList> data) {
        MatrixOperator matrix = new MatrixOperator();
        int centroid = 3;
        int maxIterasi = 10;
        double ti = 100;
        double t_rendah = 0.9;
        double min = matrix.min(data);
        double max = matrix.max(data);
        ArrayList<ArrayList> label_state_update = null;
//        boolean cek = false;

        EuclideanDistance ed = new EuclideanDistance();

        //step 1
        //generate random centroid
        ArrayList<ArrayList> state = state(centroid, data.get(0).size(), min, max);
//step 2
//hitung energi
        //distance measure (ngitung jarak)
        ArrayList<ArrayList> jarak_euclide = ed.jarak_euclidean(state, data);

        //labeling
        ArrayList<ArrayList> label_state = label_state(jarak_euclide);

        //hitung ji
        ArrayList<Double> ji_state = ji(state, label_state);

        //energi awal (sum(ji)??? TANYO IPUL

        
        //step 3 
        while (ti >= t_rendah) {
            for (int i = 0; i < maxIterasi; i++) {
                label_state_update = new ArrayList<ArrayList>(label_state);
                for (int j = 0; j < centroid; j++) {
                    //update state per row
                    ArrayList<ArrayList> update_state = ed.jarak_euclidean(label_state_update, data);//update satu2 perbaris ?

                    //distance measure
                    ArrayList<ArrayList> jarak_euclide_update = ed.jarak_euclidean(update_state, data);

                    //labeling
                    label_state_update = label_state(jarak_euclide_update);

                    //hitung energi
                    ArrayList<ArrayList> energi_state_update = ed.jarak_euclidean(update_state, data);

                    ArrayList<ArrayList> label_energi_state_update = label_state(energi_state_update);

                    ArrayList<Double> ji_state_update = ji(energi_state_update, label_energi_state_update);

                    //energi akhir (sum(ji_update)
                    
                    //cek state  
                }

            }

        }
    }
}
// cakmano caro ngesum energi SUM_JI
// 
