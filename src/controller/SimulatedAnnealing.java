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
//            System.out.println("i: "+i);
            double total = 0;
            for (int j = 0; j < label_energi_state.get(i).size(); j++) {
//                System.out.println("j: "+j);
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
        int i = 0;
        int numTemp = 200;
        double acc_ratio = 0.75;

        new_temperatur = (ti * acc_ratio) * ((t_rendah / ti) * 1 / numTemp);
//        new_temperatur= Math.pow((ti*acc_ratio)*(t_rendah/ti), 1/numTemp);

        return new_temperatur;
    }

    public double prob_boltzman(double perub_energi, double ti) {
        double prob_boltzman;
        int k = 1;

        prob_boltzman = (-perub_energi) / ti;

        return prob_boltzman;
    }

    public void do_sa(ArrayList<ArrayList> data) {
        controller.DistanceMeasure ed = new controller.DistanceMeasure();
        controller.MatrixOperator matrix = new controller.MatrixOperator();

        int cluster = 3;
        int maxIterasi = 20;
        double ti = 100;
        double t_rendah = 0.9;
        double minimum = matrix.nilai_minimum(data);
        double maksimum = matrix.nilai_maksimum(data);
        ArrayList<ArrayList> state = new ArrayList<ArrayList>();
        ArrayList<ArrayList> jarak = new ArrayList<ArrayList>();
        ArrayList<ArrayList> label_state = new ArrayList<ArrayList>();
        ArrayList<ArrayList> update_centroid = new ArrayList<ArrayList>();
        ArrayList<Double> ji = new ArrayList<>();
        double energi_awal;

        //step 1 --> generate random     
        state = state(cluster, data.get(0).size(), matrix.nilai_minimum(data), matrix.nilai_maksimum(data));
        System.out.println(state);
        //hitung jarak
        jarak = ed.jarak_euclidean(state, data);
        //labeling
        label_state = ed.label_state(jarak);
        System.out.println("label_state1");
        System.out.println(label_state);
        //step 2 --> hitung energi
        //hitung ji
        ji = ji(jarak, label_state);
        System.out.println("Ji");
        System.out.println(ji);
        //hitung energi awal
        energi_awal = sum_araylist(ji);
//      System.out.println("energi_awal");
//      System.out.println(energi_awal);
        ArrayList<ArrayList> new_state = state;

        //step 3
        ArrayList<ArrayList> state_update = new ArrayList<ArrayList>();
        ArrayList<ArrayList> label_state_update = new ArrayList<ArrayList>();
        while (ti >= t_rendah) {

            for (int i = 0; i < maxIterasi; i++) {

                System.out.println("energi_awal");
                System.out.println(energi_awal);
                ArrayList<ArrayList> temp = new ArrayList<ArrayList>();
                System.out.println("i= " + i);
                for (int j = 0; j < state.size(); j++) {
                    System.out.println("j= " + j);
                    //update
                    //state_update 
                    ArrayList<ArrayList> update_state = new ArrayList<>();
                    if (i == 0) {
                        if (j > 0) {
                            update_state = ed.update_centeroid(label_state_update, data);
                        } else {
                            update_state = ed.update_centeroid(label_state, data);
                        }
                    } else {
                            update_state = ed.update_centeroid(label_state_update, data);
                    }

//                    if (i==0 && j==0) {
//                        update_state = ed.update_centeroid(label_state, data);
//                    }else{
//                        update_state = ed.update_centeroid(label_state_update, data);
//                    }

                    System.out.println("update_state");
                    System.out.println(update_state);

                    ArrayList<ArrayList> update_state_row = update_state.get(j);

                    System.out.println("update_state_row");
                    System.out.println(update_state_row);

                    new_state.set(j, update_state_row);

//                    for(int k=0; k<state.size(); k++){
//                        if (k>0) {
//                            new_state.add(state.get(k));
//                        }else{
//                            new_state.add(update_state_row);
//                        }
//                    }
                    System.out.println("state baru");
                    System.out.println(new_state);
                    temp = new_state;

                    ArrayList<ArrayList> jarak_state_update = ed.jarak_euclidean(new_state, data);
                    label_state_update = ed.label_state(jarak_state_update);
                    System.out.println("label_state");
                    System.out.println(label_state_update);
                    ArrayList<Double> ji_update = ji(jarak_state_update, label_state_update);
                    double energi_akhir = sum_araylist(ji_update);
                    System.out.println("energi akhir");
                    System.out.println(energi_akhir);
                    double energi = energi_akhir - energi_awal;
                    energi_awal = energi_akhir;
                    System.out.println("perubahan energi");
                    System.out.println(energi);

//                if (i > 0) {
//                    energi_awal = energi_akhir;
//                    System.out.println("energi_awal2");
//                    System.out.println(energi_awal);
//                }
                    if (energi > 0) {
                        if (i > 0) {
                            new_state = temp;
                        } else {
                            new_state = state;
                        }
                    }

                }
                System.out.println("Temperatur");
                System.out.println(ti);

                ti = temperatur(ti, t_rendah);

            }
//         state_hasil_SA = new ArrayList<ArrayList<ArrayList>>(new_state);     
//
//            ArrayList<ArrayList> centroid_fix=kromosom_hasil_mutasi.get(0);
//            System.out.println(kromosom_hasil_mutasi.get(0));
//            return centroid_fix;

        }
//         
    }
}
