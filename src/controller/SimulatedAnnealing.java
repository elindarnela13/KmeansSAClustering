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
   double energi_akhir;
   double final_energi;
   double final_temperatur;
   
    ArrayList<ArrayList> state_akhir = new ArrayList<ArrayList>();
    
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

    public double temperatur(double ti, double t_rendah,int iterasi) {
        double new_temperatur;
        double i = iterasi;
        double numTemp = 200;
        double acc_ratio = 0.75;

//        new_temperatur = (ti * acc_ratio) * ((t_rendah / ti) * i / numTemp);
        new_temperatur= Math.pow((ti*acc_ratio)*(t_rendah/ti), i/numTemp);
//        System.out.println("new temperatur = "+new_temperatur);
        return new_temperatur;
    }

    public double prob_boltzman(double perub_energi, double ti) {
        double prob_boltzman;
        int k = 1;

        prob_boltzman = (-perub_energi) / k*ti;

        return prob_boltzman;
    }

    public void do_sa(ArrayList<ArrayList> data, int cluster, int maxIterasi, double ti, double t_rendah) {
        controller.EuclideanDistance ed = new controller.EuclideanDistance();
        controller.MatrixOperator matrix = new controller.MatrixOperator();

//        int cluster = 3;
//        int maxIterasi = 2;
        int iterasi =0;
//        double ti = 100;
//        double t_rendah = 0.9;
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
        ArrayList<ArrayList> temp_new_state = state;

        //step 3
        ArrayList<ArrayList> state_update = new ArrayList<ArrayList>();
        ArrayList<ArrayList> label_state_update = new ArrayList<ArrayList>();
        
        while (ti >= t_rendah) {
            iterasi++;
//            System.out.println("ti = "+ ti);
//            System.out.println("t_rendah = "+t_rendah);
//            System.out.println("=============\n\n");
            for (int i = 0; i < maxIterasi; i++) {

//                System.out.println("energi_awal");
//                System.out.println(energi_awal);
                ArrayList<ArrayList> temp = new ArrayList<ArrayList>();
//                System.out.println("i= " + i);
                for (int j = 0; j < state.size(); j++) {
//                    System.out.println("j= " + j);
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
//                    System.out.println("update_state");
//                    System.out.println(update_state);

                    ArrayList<ArrayList> update_state_row = update_state.get(j);
                    ArrayList<ArrayList> temp_update_state_row = temp_new_state.get(j);

//                    System.out.println("update_state_row");
//                    System.out.println(update_state_row);

                    new_state.set(j, update_state_row);

//                    System.out.println("state baru");
//                    System.out.println(new_state);
                    temp = new_state;

                    ArrayList<ArrayList> jarak_state_update = ed.jarak_euclidean(new_state, data);
                    label_state_update = ed.label_state(jarak_state_update);
//                    System.out.println("label_state");
//                    System.out.println(label_state_update);
                    ArrayList<Double> ji_update = ji(jarak_state_update, label_state_update);
                    energi_akhir = sum_araylist(ji_update);
//                    System.out.println("energi akhir");
//                    System.out.println(energi_akhir);
                    double energi = energi_akhir - energi_awal;
                    energi_awal = energi_akhir;
//                    System.out.println("perubahan energi");
//                    System.out.println(energi);

                    //state diterima
                    if (energi <= 0) {
                        if (i == 0) {
                            new_state = state;
                        } else {
                            new_state = temp;
                        }
//                        System.out.println("Diterima");
                    } else {//state ditolak
                        double p = Math.random();
                        double prob = prob_boltzman(energi, ti);
//                        System.out.println("p: "+ p);
//                        System.out.println("probabilitas: "+prob);
                        if (p > prob) {
                            new_state.set(j, temp_update_state_row);
//                            System.out.println("Ditolak");
                        } else {
                            if (i == 0) {
                                new_state = state;
                            } else {
                                new_state = temp;
                            }
//                            System.out.println("Diterima");
                        }
                    }

                    temp_new_state = new_state;
//                    System.out.println("state baru temp ");
//                    System.out.println(new_state);
//                    System.out.println("");
                }

            }
            
//            System.out.println("ti = "+ti);
//            System.out.println("t_rendah ="+t_rendah);
            
            ti = temperatur(ti, t_rendah,iterasi);
            
//            System.out.print("\nTemperatur Akhir: ");
//            System.out.print(ti);
            
            final_temperatur = ti;
            
//            System.out.println("\nEnergi Akhir1= ");
            final_energi = energi_akhir;
//            System.out.println(final_energi);
//  System.out.println("\n");
        }
        
//        System.out.println("State akhir: ");
        state_akhir = new_state;
//        System.out.println(state_akhir);
//        
//        System.out.println("energi terakhir= ");
//        System.out.println(get_energi_akhir());
          System.out.println("termperatur akhir = "+final_temperatur);
    }
    
    public ArrayList<ArrayList> getState_akhir(){
        return state_akhir;
    }
    
    public double get_energi_akhir(){
        return final_energi;
    }
}
