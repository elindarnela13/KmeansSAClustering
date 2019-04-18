/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class K_Means {
    ArrayList<ArrayList> centroid_akhir;
    ArrayList<ArrayList>  hasil_cluster;

    public void do_k_means(ArrayList<ArrayList> centroid_fix, ArrayList<ArrayList> data) {
        DistanceMeasure dm = new DistanceMeasure();
        boolean check = false;
        ArrayList<ArrayList> centroid_lama = new ArrayList<>(centroid_fix);
        ArrayList<ArrayList> euclidean = dm.jarak_euclidean(centroid_lama, data);
        ArrayList<ArrayList> label_euclidean = dm.label_state(euclidean);
        int maks_iterasi = 0;
        
        
//        System.out.println("label sebelum");
//        System.out.println(label_euclidean);

        while (check == false) {
            check = true;
            
        System.out.println("cenroid:");
        System.out.println(centroid_lama);
        System.out.println("label sesudah");
        System.out.println(label_euclidean);
            ArrayList<ArrayList> update_centroid = dm.update_centeroid(label_euclidean, data);
            ArrayList<ArrayList> euclidean_update = dm.jarak_euclidean(update_centroid, data);
            ArrayList<ArrayList> label_euclidean_update = dm.label_state(euclidean_update);

            for (int i = 0; i < label_euclidean_update.size(); i++) {
                if (label_euclidean.get(i).size() == label_euclidean_update.get(i).size()) {
                    for (int j = 0; j < label_euclidean_update.get(i).size(); j++) {
                        if (!label_euclidean_update.get(i).get(j).toString().equals(label_euclidean.get(i).get(j).toString())) {
                            check = false;
                            break;
                        }
                    }
                }else{
                    check=false;
                    break;
                }
            }
               
            centroid_lama = new ArrayList<>(update_centroid);
            euclidean = dm.jarak_euclidean(centroid_lama, data);
            label_euclidean = dm.label_state(euclidean);
            maks_iterasi++;
          
            if (maks_iterasi == 1000) {
                check = true;
            }
        }
        
        centroid_akhir = centroid_lama;
        hasil_cluster = label_euclidean;
        
        System.out.println("centroid:");
        System.out.println(centroid_akhir);
        System.out.println("label sesudah");
        System.out.println(hasil_cluster);

    }
    
    public ArrayList<ArrayList> get_centroid(){
        return centroid_akhir;
    }
    
    public ArrayList<ArrayList> get_hasil_cluster(){
        return hasil_cluster;
    }

}
