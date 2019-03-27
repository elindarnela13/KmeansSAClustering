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

    public ArrayList<ArrayList> label_state(ArrayList<ArrayList> jarak_euclidean_1) {

        ArrayList<ArrayList> label_state = new ArrayList<>();

        ArrayList<Integer> labeling = new ArrayList<>();
        for (int i = 0; i < jarak_euclidean_1.size(); i++) {
            double jarak = Double.parseDouble(jarak_euclidean_1.get(i).get(0).toString());
            int index = 0;
            for (int j = 0; j < jarak_euclidean_1.get(i).size(); j++) {
                if (jarak <= Double.parseDouble(jarak_euclidean_1.get(i).get(j).toString())) {
                    jarak = Double.parseDouble(jarak_euclidean_1.get(i).get(j).toString());
                    index = j;
                }
            }
            labeling.add(index);
        }

        for (int i = 0; i < 3; i++) {
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
        ArrayList<ArrayList> jarak_energi_update = new ArrayList<ArrayList>();
        ArrayList<ArrayList> label_state_update = new ArrayList<ArrayList>();
        ArrayList<Double> ji = new ArrayList<>();
        
    //step 1 --> generate random     
        state = state(centroid, data.get(0).size(), matrix.min(data), matrix.max(data));
        System.out.println(state);
        //hitung jarak
        jarak = jarak_euclidean(state, data);
        //labeling
        label_state = label_state(jarak);
        //update state
        update_centroid = update_centeroid(label_state, data);
        
    //step 2 --> hitung energi
        //hitung 
        jarak_energi_update = jarak_euclidean(update_centroid, data);
        System.out.println("Jarak Minimum: ");
        System.out.println(jarak_energi_update);
        //labeling
        label_state_update = label_state(jarak_energi_update);
        System.out.println("Cluster :");
        System.out.println(label_state_update);
        //hitung ji
        ji = ji(jarak_energi_update, label_state);
        System.out.println("Ji");
        System.out.println(ji);
        //hitung energi awal
        
    //step 3
        while (true) {            
            
        }
    }
}
