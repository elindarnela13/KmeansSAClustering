/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Document;
import entity.TermList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author User
 */
public class Pembobotan {
    private List<Document> lstDoc;
    private DocReader docreader;
    private TermList globaltermlist;
    private ArrayList<double[]> vecspace;
    private int nCluster;
    private double[][] hasilPembobotan;
    
    public Pembobotan(String folderpath){
        docreader = new DocReader(folderpath);
        readDocument();
    }
    
    private void readDocument(){
        try{
            docreader.readDocuments();
            lstDoc = docreader.getListDocuments();
            Praproses tokenizer = new Praproses();
            for(int i=0; i<lstDoc.size(); i++){
                Document doc = lstDoc.get(i);
                tokenizer.doPraproses(doc); //sampe sini
                doc.setTermlist(tokenizer.getCurrentTokenList());
                //System.out.println(doc.getJudul() + " = " + Arrays.toString(tokenizer.getCurrentTokenList().toStringArray()) + "\n");
//                System.out.println(doc.getJudul() + " = " + doc.getIsi() + "\n");
            }
            globaltermlist = tokenizer.getTokenList();
            nCluster = docreader.getNumberofCategory();
        }catch(FileNotFoundException ex){
            
        }catch(IOException ex){
            
        }
    }
    
    public int getNumberOfClusterDoc(){
        return nCluster;
    }
    
    public void doPembobotan(){
        hasilPembobotan = new double[globaltermlist.getTotalTerm()][lstDoc.size()];
        
        for(int i=0; i<lstDoc.size(); i++){
            String sdocs[] = lstDoc.get(i).getTermList().toStringArray();
            //hasil stemming per dokumen
//            System.out.println(lstDoc.get(i).getJudul() + " : " + Arrays.toString(lstDoc.get(i).getTermList().toStringArray()));
            
            for(int j=0; j<hasilPembobotan.length; j++){
                hasilPembobotan[j][i] = tf(sdocs, globaltermlist.getTermAt(j).getTerm()) * 
                        idf(lstDoc, globaltermlist.getTermAt(j).getTerm());
                //bobot per-kata  
               // System.out.print(globaltermlist.getTermAt(j).getTerm() + ": ");
                
                //tampilkan hasil pembobotan
//                System.out.println(hasilPembobotan[j][i]); //[term][doc]               
            }
            //System.out.println("\n");
        }
    }
    
    public void tampil_bobot(double[][] data){
        for(double[] i:data){
            System.out.println(Arrays.toString(i));
        }
    }
        
    public double[][] getHasilPembobotan(){
        return hasilPembobotan;
    }
    
    public List<Document> getListDocument(){
        return lstDoc;
    }
    
    public TermList getGlobalTermList(){
        return globaltermlist;
    }
    
    static double tf(String[] doc, String term){
        double n = 0;
        for(String s: doc){
            if(s.equalsIgnoreCase(term)){
                n++;
            }
        }
        return n;
//        return n/doc.length;
    }
    
    static double idf(List<Document> listdoc, String term){
        double n = 0;
//        System.out.println("n = "+listdoc.size());
        for(int i=0; i<listdoc.size(); i++){
            for(int j=0; j<listdoc.get(i).getTermList().getTotalTerm(); j++){
                String s = listdoc.get(i).getTermList().getTermAt(j).getTerm();
                if(s.equalsIgnoreCase(term)){
                    n++;
                    break;
                }
            }
        }
//        System.out.println("df = "+n);
//        System.out.println("idf = "+Math.log10(2));
        return Math.log10(listdoc.size()/n);
    }
}
