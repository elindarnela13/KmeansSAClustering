/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author ASUS
 */
public class SimulatedAnnealing {

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

        ArrayList<ArrayList> w_random = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            ArrayList<Double> w_random_tes = new ArrayList<>();
            for (int j = 0; j < column; j++) {
                double random = ThreadLocalRandom.current().nextDouble(0, 1);
                w_random_tes.add(random);
            }
            w_random.add(w_random_tes);
        }
        return w_random;
    }

    public ArrayList<Double> ji(ArrayList<ArrayList> energi_state, ArrayList<ArrayList> label_energi_state) {

        ArrayList<Double> ji = new ArrayList<>();
        for (int i = 0; i < label_energi_state.size(); i++) {
            double total = 0;
            for (int j = 0; j < label_energi_state.get(i).size(); j++) {
                total = Double.parseDouble(energi_state.get(Integer.parseInt(label_energi_state.get(i).get(j).toString())).get(i).toString()) + total;
            }
            if (total != 0) {
                ji.add(total / (label_energi_state.get(i).size() * 1.0));
            } else {
                ji.add(0.0);
            }
        }
        return ji;
    }

    public double sum_araylist(ArrayList<Double> ji) {
        double sum = 0;
        for (int i = 0; i < ji.size(); i++) {
            sum += ji.get(i);
        }
        return sum;
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

    public void do_sa(ArrayList<ArrayList> data) {
        controller.EuclideanDistance ed = new controller.EuclideanDistance();
        controller.MatrixOperator matrix = new controller.MatrixOperator();

        int centroid = 3;
        int maxIterasi = 10;
        double ti = 100;
        double t_rendah = 0.9;
        double min = matrix.min(data);
        double max = matrix.max(data);
        ArrayList<ArrayList> state = new ArrayList<ArrayList>();
        ArrayList<ArrayList> jarak = new ArrayList<ArrayList>();
        ArrayList<ArrayList> label_state = new ArrayList<ArrayList>();
        ArrayList<ArrayList> update_centroid = new ArrayList<ArrayList>();
        ArrayList<Double> ji = new ArrayList<>();
        double energi_awal;

        //step 1 --> generate random     
        state = state(centroid, data.get(0).size(), matrix.min(data), matrix.max(data));
        System.out.println(state);
        //hitung jarak
        jarak = ed.jarak_euclidean(state, data);
        //labeling
        label_state = ed.label_state(jarak);

        //step 2 --> hitung energi
        //hitung ji
        ji = ji(jarak, label_state);
        System.out.println("Ji");
        System.out.println(ji);
        //hitung energi awal
        energi_awal = sum_araylist(ji);
        System.out.println("sum_Ji");
        System.out.println(energi_awal);

        //step 3
        ArrayList<ArrayList> state_update = new ArrayList<ArrayList>();
        while (ti < t_rendah) {
            for (int i = 0; i < maxIterasi; i++) {

                ArrayList<ArrayList> state_new = new ArrayList<ArrayList>();
                ArrayList<ArrayList> state_gabung = new ArrayList<ArrayList>();
                for (int j = 0; j < centroid; j++) {
                    //update
                    //state_update = ...
                    
                    //gabung state baris yg sdh di update(state_update) dgn sisa baris dr state sebelumnya
                    //state_gabung = ... 
                    
                    //hitung energi
                    //hitung jarak
                    ArrayList<ArrayList> jarak_update = ed.jarak_euclidean(state_gabung, data);
                    //labeling
                    ArrayList<ArrayList> label_update = ed.label_state(jarak_update);
                    //hitung ji
                    ArrayList<Double> ji_update = ji(jarak_update, label_state);
                    //hitung sum_ji
                    double energi_akhir = sum_araylist(ji_update);

                    if ((energi_akhir - energi_awal) <= 0) {//state accepted
                        state_new = state_update;
                    } else {
                        if (i > 0) {
//                            state_new = state_1.get(j);
                        }else{
                            state_new = state.get(j);
                        }
                    }
                }
                ArrayList<ArrayList> state_1 = state_new;
            }
        }
    }
}

