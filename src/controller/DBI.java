/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import controller.SimulatedAnnealing;

/**
 *
 * @author ASUS
 */
public class DBI {
    double dbi;

    public ArrayList<Double> hitung_si(ArrayList<ArrayList> energi_state, ArrayList<ArrayList> label_state, int cluster) {

        ArrayList<Double> ji = new ArrayList<>();
        for (int i = 0; i < label_state.size(); i++) {
            double total = 0;
            for (int j = 0; j < label_state.get(i).size(); j++) {
                total = Double.parseDouble(energi_state.get(Integer.parseInt(label_state.get(i).get(j).toString())).get(i).toString()) + total;
            }

            ji.add(total / cluster);

        }
        return ji;
    }

    public ArrayList<Double> si(ArrayList<ArrayList> data, ArrayList<ArrayList> centroid) {
        DistanceMeasure distance = new DistanceMeasure();

        ArrayList<ArrayList> jarak = distance.jarak_euclidean(centroid, data);
        ArrayList<ArrayList> label = distance.label_state(jarak);
        ArrayList<Double> si = hitung_si(jarak, label, centroid.size());

        return si;
    }

    public ArrayList<Double> rij(ArrayList<Double> si, ArrayList<Double> dij) {
        ArrayList<Double> ri = new ArrayList<>();

        for (int i = 0; i < si.size() - 1; i++) {
            if(dij.get(i)!=0){
                ri.add((si.get(i) + si.get(i + 1)) / dij.get(i));
            }else{
                ri.add(0.0);
            }
            
        }
        if (si.size() > 2) {
            if(dij.get(dij.size() - 1)!=0){
                ri.add((si.get(si.size() - 1) + si.get(0)) / dij.get(dij.size() - 1));
            }else{
                ri.add(0.0);
            }
           
        }

        return ri;
    }

    public ArrayList<Double> hitung_dij(ArrayList<ArrayList> centroid) {
        ArrayList<Double> dij = new ArrayList<>();
        for (int i = 0; i < centroid.size() - 1; i++) {

            double temp = 0.0;
            for (int j = 0; j < centroid.get(i).size(); j++) {
                temp = temp + (Math.pow((Double.parseDouble(centroid.get(i).get(j).toString())
                        - Double.parseDouble(centroid.get(i + 1).get(j).toString())), 2));
            }
            dij.add(Math.sqrt(temp));

        }
        if (centroid.size() > 2) {

            double temp = 0.0;
            for (int j = 0; j < centroid.get(0).size(); j++) {
                temp = temp + (Math.pow((Double.parseDouble(centroid.get(centroid.size() - 1).get(j).toString())
                        - Double.parseDouble(centroid.get(0).get(j).toString())), 2));
            }
            dij.add(Math.sqrt(temp));
        }

        return dij;
    }

    public void hitung_dbi(ArrayList<ArrayList> data, ArrayList<ArrayList> centroid) {
        ArrayList<Double> si = si(data, centroid);
        ArrayList<Double> dij = hitung_dij(centroid);
        ArrayList<Double> rij = rij(si, dij);
                
        System.out.println("si");
        System.out.println(si);
        System.out.println("dij");
        System.out.println(dij);
        System.out.println("rij");
        System.out.println(rij);
        
        SimulatedAnnealing sa = new SimulatedAnnealing();

        double sum_rij = sa.sum_araylist(rij);
        System.out.println("sum_rij");
        System.out.println(sum_rij);
        
        dbi = sum_rij/centroid.size();
        System.out.println("dbi : ");
        System.out.println(dbi);
        
    }
    
    public double get_dbi(){
        return dbi;
    }
}
