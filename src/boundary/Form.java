/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.impl.DenseDoubleMatrix2D;
import cern.colt.matrix.linalg.SingularValueDecomposition;
import Controller.SimulatedAnnealing;
import controller.DBI;
import controller.K_Means;
import controller.MatrixOperator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import controller.Pembobotan;
import controller.ReduksiDimensiSvd;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Form extends javax.swing.JFrame {

    private Pembobotan bobot;
    

    public Form() {
        initComponents();

        ButtonMuat.setEnabled(true);
        RadioButtonKMeans.setEnabled(false);
        RadioButtonSAKMeans.setEnabled(false);
        RadioButtonSVDKmeans.setEnabled(false);
        RadioButtonSVDSAKMeans.setEnabled(false);
        ButtonMulai.setEnabled(false);
        TextFieldJlhK.setEnabled(false);
        TextFieldIterasi.setEnabled(false);
        TextFieldTemperaturAkhir.setEnabled(false);
        TextFieldTemperaturAwal.setEnabled(false);
       
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupMetodeCluster = new javax.swing.ButtonGroup();
        ButtonMuat = new javax.swing.JButton();
        folderPath = new javax.swing.JTextField();
        ScrollPanelCentroid = new javax.swing.JScrollPane();
        ButtonMulai = new javax.swing.JButton();
        LabelDBI = new javax.swing.JLabel();
        TextFieldDBI = new javax.swing.JTextField();
        PanelMetodeCluster = new javax.swing.JPanel();
        RadioButtonKMeans = new javax.swing.JRadioButton();
        RadioButtonSAKMeans = new javax.swing.JRadioButton();
        RadioButtonSVDKmeans = new javax.swing.JRadioButton();
        RadioButtonSVDSAKMeans = new javax.swing.JRadioButton();
        LabelMetodeCluster = new javax.swing.JLabel();
        PanelKmeans = new javax.swing.JPanel();
        TextFieldJlhK = new javax.swing.JTextField();
        LabelJlhK = new javax.swing.JLabel();
        PanelSimulatedAnnealing = new javax.swing.JPanel();
        TextFieldIterasi = new javax.swing.JTextField();
        LabelIterasi = new javax.swing.JLabel();
        TextFieldTemperaturAwal = new javax.swing.JTextField();
        LabelTemperaturAwal = new javax.swing.JLabel();
        TextFieldTemperaturAkhir = new javax.swing.JTextField();
        LabelTemperaturAkhir = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCluster = new javax.swing.JTable();
        LabelCentroid = new javax.swing.JLabel();
        LabelHasilCluster = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        waktuKomputasi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ButtonMuat.setText("Muat");
        ButtonMuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMuatActionPerformed(evt);
            }
        });

        ButtonMulai.setText("Mulai");
        ButtonMulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMulaiActionPerformed(evt);
            }
        });

        LabelDBI.setText("Nilai DBI");

        TextFieldDBI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldDBIActionPerformed(evt);
            }
        });

        PanelMetodeCluster.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroupMetodeCluster.add(RadioButtonKMeans);
        RadioButtonKMeans.setText("K-Means");
        RadioButtonKMeans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonKMeansActionPerformed(evt);
            }
        });

        buttonGroupMetodeCluster.add(RadioButtonSAKMeans);
        RadioButtonSAKMeans.setText("SA + K-Means");

        buttonGroupMetodeCluster.add(RadioButtonSVDKmeans);
        RadioButtonSVDKmeans.setText("SVD + K-Means");

        buttonGroupMetodeCluster.add(RadioButtonSVDSAKMeans);
        RadioButtonSVDSAKMeans.setText("SVD + SA + K-Means ");

        javax.swing.GroupLayout PanelMetodeClusterLayout = new javax.swing.GroupLayout(PanelMetodeCluster);
        PanelMetodeCluster.setLayout(PanelMetodeClusterLayout);
        PanelMetodeClusterLayout.setHorizontalGroup(
            PanelMetodeClusterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMetodeClusterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMetodeClusterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RadioButtonKMeans)
                    .addComponent(RadioButtonSAKMeans)
                    .addComponent(RadioButtonSVDKmeans)
                    .addComponent(RadioButtonSVDSAKMeans))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        PanelMetodeClusterLayout.setVerticalGroup(
            PanelMetodeClusterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMetodeClusterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RadioButtonKMeans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioButtonSAKMeans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioButtonSVDKmeans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioButtonSVDSAKMeans, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        LabelMetodeCluster.setText("Metode Clustering");

        PanelKmeans.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TextFieldJlhK.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        TextFieldJlhK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldJlhKActionPerformed(evt);
            }
        });

        LabelJlhK.setText("Jumlah kluster(k)");

        javax.swing.GroupLayout PanelKmeansLayout = new javax.swing.GroupLayout(PanelKmeans);
        PanelKmeans.setLayout(PanelKmeansLayout);
        PanelKmeansLayout.setHorizontalGroup(
            PanelKmeansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKmeansLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelJlhK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextFieldJlhK, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        PanelKmeansLayout.setVerticalGroup(
            PanelKmeansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKmeansLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(PanelKmeansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelJlhK)
                    .addComponent(TextFieldJlhK, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        PanelSimulatedAnnealing.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LabelIterasi.setText("Iterasi");

        TextFieldTemperaturAwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldTemperaturAwalActionPerformed(evt);
            }
        });

        LabelTemperaturAwal.setText("Temperatur Awal");

        LabelTemperaturAkhir.setText("Temperatur Akhir");

        javax.swing.GroupLayout PanelSimulatedAnnealingLayout = new javax.swing.GroupLayout(PanelSimulatedAnnealing);
        PanelSimulatedAnnealing.setLayout(PanelSimulatedAnnealingLayout);
        PanelSimulatedAnnealingLayout.setHorizontalGroup(
            PanelSimulatedAnnealingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSimulatedAnnealingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSimulatedAnnealingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelIterasi)
                    .addComponent(LabelTemperaturAwal)
                    .addComponent(LabelTemperaturAkhir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(PanelSimulatedAnnealingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextFieldTemperaturAwal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldIterasi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldTemperaturAkhir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        PanelSimulatedAnnealingLayout.setVerticalGroup(
            PanelSimulatedAnnealingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSimulatedAnnealingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSimulatedAnnealingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldIterasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelIterasi))
                .addGap(9, 9, 9)
                .addGroup(PanelSimulatedAnnealingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTemperaturAwal)
                    .addComponent(TextFieldTemperaturAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelSimulatedAnnealingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldTemperaturAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelTemperaturAkhir))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel7.setText("Parameter k-means");

        jLabel8.setText("Parameter Algoritma SImulated Annealing");

        jTableCluster.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableCluster);

        LabelCentroid.setText("Centroid");

        LabelHasilCluster.setText("Hasil Clustering");

        jLabel2.setText("Waktu Komputasi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(ButtonMuat)
                        .addGap(18, 18, 18)
                        .addComponent(folderPath))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelMetodeCluster))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(PanelMetodeCluster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(ButtonMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(PanelKmeans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PanelSimulatedAnnealing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollPanelCentroid)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelCentroid)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(waktuKomputasi, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                                .addComponent(LabelDBI)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextFieldDBI, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelHasilCluster)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonMuat)
                    .addComponent(folderPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDBI)
                    .addComponent(TextFieldDBI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(waktuKomputasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelMetodeCluster)
                    .addComponent(LabelCentroid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelMetodeCluster, javax.swing.GroupLayout.PREFERRED_SIZE, 122, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScrollPanelCentroid, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(LabelHasilCluster)
                        .addGap(5, 5, 5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelKmeans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelSimulatedAnnealing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonMulai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonMuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMuatActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select Folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                String selectedFolder = String.valueOf(chooser.getSelectedFile());
                folderPath.setText(selectedFolder);
                System.out.println("getSelectedFile() : " + selectedFolder);
                bobot = new Pembobotan(selectedFolder);
                bobot.doPembobotan();
                if (bobot.getListDocument().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "File di dalam folder terpilih tidak dapat diproses",
                            "Gagal Muat", JOptionPane.ERROR_MESSAGE);
                } else {
//				JlhDokumen.setText(String.valueOf(bobot.getGlobalTermList().getTotalTerm()));
//				JlhTerm.setText(String.valueOf(bobot.getListDocument().size()));
                    RadioButtonSVDKmeans.setEnabled(true);
                    RadioButtonKMeans.setEnabled(true);
                    RadioButtonSAKMeans.setEnabled(true);
                    RadioButtonSVDSAKMeans.setEnabled(true);

                    TextFieldJlhK.setEnabled(true);
                    TextFieldIterasi.setEnabled(true);
                    TextFieldTemperaturAkhir.setEnabled(true);
                    TextFieldTemperaturAwal.setEnabled(true);
                    ButtonMulai.setEnabled(true);
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "File tidak dapat diproses", "Gagal Muat", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("Gagal Muat");
        }
    }//GEN-LAST:event_ButtonMuatActionPerformed

    private void ButtonMulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMulaiActionPerformed
        // TODO add your handling code here:
        if (TextFieldJlhK.getText().isEmpty() || Integer.valueOf(TextFieldJlhK.getText()) <= 1) {
            JOptionPane.showMessageDialog(null, "Nilai k tidak boleh kosong atau sama dengan satu",
                    "gagal", JOptionPane.ERROR_MESSAGE);
        } else if (Integer.valueOf(TextFieldJlhK.getText()) >= bobot.getListDocument().size()) {
            JOptionPane.showMessageDialog(null, "Nilai k tidak boleh lebih dari atau sama dengan jumlah dokumen",
                    "gagal", JOptionPane.ERROR_MESSAGE);
        } else {
            if (RadioButtonKMeans.isSelected()) {

//                TextFieldIterasi.setEnabled(true);
//                TextFieldPopsize.setEnabled(true);
//                TextFieldCr.setEnabled(true);
//                TextFieldMr.setEnabled(true);
                MatrixOperator matrix = new MatrixOperator();
                K_Means km = new K_Means();
                SimulatedAnnealing sa = new SimulatedAnnealing();
                double[][] data_bobot = bobot.getHasilPembobotan();
                ArrayList<ArrayList> data = bobot.array_to_arraylist(matrix.transpose(data_bobot));
                double min = matrix.nilai_minimum(data);
                double max = matrix.nilai_maksimum(data);
                int cluster = Integer.valueOf(TextFieldJlhK.getText());

                ArrayList<ArrayList> centroid = sa.state(cluster, data.get(0).size(),min, max);
                km.do_k_means(centroid, data);

                ArrayList<ArrayList> centroid_akhir = km.get_centroid();

                DBI dbi = new DBI();
                dbi.hitung_dbi(data, centroid_akhir);
                TextFieldDBI.setText(String.valueOf(dbi.get_dbi()));

            } else if (RadioButtonSAKMeans.isSelected()) {
                TextFieldIterasi.setEnabled(true);
                TextFieldTemperaturAkhir.setEnabled(true);
               
                

                if (TextFieldIterasi.getText().isEmpty() || TextFieldTemperaturAwal.getText().isEmpty()
                        || TextFieldTemperaturAkhir.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Parameter Algoritma Simulated Annealing tidak boleh kosong",
                            "gagal", JOptionPane.ERROR_MESSAGE);
                } else if ((Double.valueOf(TextFieldTemperaturAwal.getText()) < 0) || (Double.valueOf(TextFieldTemperaturAwal.getText()) > 1)) {
                    JOptionPane.showMessageDialog(null, "Nilai Temperatur Awal harus dalam range 0-1",
                            "gagal", JOptionPane.ERROR_MESSAGE);
                } else if ((Double.valueOf(TextFieldTemperaturAkhir.getText()) < 0) || (Double.valueOf(TextFieldTemperaturAkhir.getText()) > 1)) {
                    JOptionPane.showMessageDialog(null, "Nilai Temperatur Akhir harus dalam range 0-1",
                            "gagal", JOptionPane.ERROR_MESSAGE);
                } else {
                    MatrixOperator matrix = new MatrixOperator();
                    K_Means km = new K_Means();
                    SimulatedAnnealing sa = new SimulatedAnnealing();
//
//                    double[][] data_bobot = bobot.getHasilPembobotan();
//                    ArrayList<ArrayList> data = bobot.array_to_arraylist(matrix.transpose(data_bobot));
//                    int cluster = Integer.valueOf(TextFieldJlhK.getText());
//                    int iterasi = Integer.valueOf(TextFieldIterasi.getText());
//                    double TemperaturAwal = Double.valueOf(TextFieldTemperaturAwal.getText());
//                    double TemperaturAkhir = Double.valueOf(TextFieldTemperaturAkhir.getText());
//                   
//
//                    ArrayList<ArrayList> centroid = sa.do_sa(data, cluster, iterasi, TemperaturAwal, TemperaturAkhir);
//                    km.do_k_means(centroid, data);
//
//                    ArrayList<ArrayList> centroid_akhir = km.get_centroid();
//
//                    DBI dbi = new DBI();
//                    dbi.hitung_dbi(data, centroid_akhir);
//                    TextFieldDBI.setText(String.valueOf(dbi.get_dbi()));
                }

            } else if (RadioButtonSVDKmeans.isSelected()) {

                MatrixOperator matrix = new MatrixOperator();
                K_Means km = new K_Means();
                SimulatedAnnealing sa = new SimulatedAnnealing();
                bobot.doPembobotan();

                DoubleMatrix2D data = new DenseDoubleMatrix2D(bobot.getHasilPembobotan());
                SingularValueDecomposition svd = new SingularValueDecomposition(data);

                svd.getU();
                svd.getS();
                svd.getV().viewDice();
                System.out.println("Matriks U*S : ");
                double[][] US = matrix.multiply(svd.getU(), svd.getS());
                System.out.println("Matriks S*V : ");
                double[][] SV = matrix.multiply(svd.getS(), svd.getV().viewDice());
                System.out.println("\n");

                ReduksiDimensiSvd reduksi = new ReduksiDimensiSvd(bobot.getGlobalTermList(), bobot.getListDocument(), US);
                reduksi.doReduksiDimensi();

                System.out.println("Matriks S*V Transpose : ");
                double[][] data_reduksi = matrix.transpose(SV);
                ArrayList<ArrayList> data_hsl_reduksi = bobot.array_to_arraylist(data_reduksi);

                double min = matrix.nilai_minimum(data_hsl_reduksi);
                double max = matrix.nilai_maksimum(data_hsl_reduksi);
                int cluster = Integer.valueOf(TextFieldJlhK.getText());

                ArrayList<ArrayList> centroid = sa.state(cluster, data_hsl_reduksi.get(0).size(), min, max);
                km.do_k_means(centroid, data_hsl_reduksi);

                ArrayList<ArrayList> centroid_akhir = km.get_centroid();

                DBI dbi = new DBI();
                dbi.hitung_dbi(data_hsl_reduksi, centroid_akhir);
                TextFieldDBI.setText(String.valueOf(dbi.get_dbi()));

            } else if (RadioButtonSVDSAKMeans.isSelected()) {
//                MatrixOperator matrix = new MatrixOperator();
//                K_Means km = new K_Means();
//                SimulatedAnnealing sa = new SimulatedAnnealing();
//                bobot.doPembobotan();
//
//                DoubleMatrix2D data = new DenseDoubleMatrix2D(bobot.getHasilPembobotan());
//                SingularValueDecomposition svd = new SingularValueDecomposition(data);
//
//                svd.getU();
//                svd.getS();
//                svd.getV().viewDice();
//                System.out.println("Matriks U*S : ");
//                double[][] US = matrix.multiply(svd.getU(), svd.getS());
//                System.out.println("Matriks S*V : ");
//                double[][] SV = matrix.multiply(svd.getS(), svd.getV().viewDice());
//                System.out.println("\n");
//
//                ReduksiDimensiSvd reduksi = new ReduksiDimensiSvd(bobot.getGlobalTermList(), bobot.getListDocument(), US);
//                reduksi.doReduksiDimensi();
//
//                System.out.println("Matriks S*V Transpose : ");
//                double[][] data_reduksi = matrix.transpose(SV);
//                ArrayList<ArrayList> data_hsl_reduksi = bobot.array_to_arraylist(data_reduksi);
//
//                double min = matrix.nilai_minimum(data_hsl_reduksi);
//                double max = matrix.nilai_maksimum(data_hsl_reduksi);
//                int cluster = Integer.valueOf(TextFieldJlhK.getText());
//
//                int iterasi = Integer.valueOf(TextFieldIterasi.getText());
//                double TemperaturAwal = Integer.valueOf(TextFieldTemperaturAwal.getText());
//                double TemperaturAkhir = Double.valueOf(TextFieldTemperaturAkhir.getText());
//                
//
//                ArrayList<ArrayList> centroid = sa.do_sa(data_hsl_reduksi,iterasi, cluster, TemperaturAwal, TemperaturAkhir);
//                km.do_k_means(centroid, data_hsl_reduksi);
//
//                ArrayList<ArrayList> centroid_akhir = km.get_centroid();
//
//                DBI dbi = new DBI();
//                dbi.hitung_dbi(data_hsl_reduksi, centroid_akhir);
//                TextFieldDBI.setText(String.valueOf(dbi.get_dbi()));
            }
        }
    }//GEN-LAST:event_ButtonMulaiActionPerformed

    private void TextFieldJlhKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldJlhKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldJlhKActionPerformed

    private void RadioButtonKMeansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonKMeansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonKMeansActionPerformed

    private void TextFieldDBIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldDBIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldDBIActionPerformed

    private void TextFieldTemperaturAwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldTemperaturAwalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldTemperaturAwalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonMuat;
    private javax.swing.JButton ButtonMulai;
    private javax.swing.JLabel LabelCentroid;
    private javax.swing.JLabel LabelDBI;
    private javax.swing.JLabel LabelHasilCluster;
    private javax.swing.JLabel LabelIterasi;
    private javax.swing.JLabel LabelJlhK;
    private javax.swing.JLabel LabelMetodeCluster;
    private javax.swing.JLabel LabelTemperaturAkhir;
    private javax.swing.JLabel LabelTemperaturAwal;
    private javax.swing.JPanel PanelKmeans;
    private javax.swing.JPanel PanelMetodeCluster;
    private javax.swing.JPanel PanelSimulatedAnnealing;
    private javax.swing.JRadioButton RadioButtonKMeans;
    private javax.swing.JRadioButton RadioButtonSAKMeans;
    private javax.swing.JRadioButton RadioButtonSVDKmeans;
    private javax.swing.JRadioButton RadioButtonSVDSAKMeans;
    private javax.swing.JScrollPane ScrollPanelCentroid;
    private javax.swing.JTextField TextFieldDBI;
    private javax.swing.JTextField TextFieldIterasi;
    private javax.swing.JTextField TextFieldJlhK;
    private javax.swing.JTextField TextFieldTemperaturAkhir;
    private javax.swing.JTextField TextFieldTemperaturAwal;
    private javax.swing.ButtonGroup buttonGroupMetodeCluster;
    private javax.swing.JTextField folderPath;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCluster;
    private javax.swing.JTextField waktuKomputasi;
    // End of variables declaration//GEN-END:variables
}
