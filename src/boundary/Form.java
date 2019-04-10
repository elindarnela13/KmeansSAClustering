/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import controller.Pembobotan;

/**
 *
 * @author User
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonMuat = new javax.swing.JButton();
        folderPath = new javax.swing.JTextField();
        ScrollPanelCentroid = new javax.swing.JScrollPane();
        ButtonMulai = new javax.swing.JButton();
        LabelJlhDokumen = new javax.swing.JLabel();
        JlhDokumen = new javax.swing.JTextField();
        LabelJlhTerm = new javax.swing.JLabel();
        JlhTerm = new javax.swing.JTextField();
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
        jumlahK = new javax.swing.JLabel();
        PanelAlgen = new javax.swing.JPanel();
        TextFieldIterasi = new javax.swing.JTextField();
        LabelIterasi = new javax.swing.JLabel();
        TextFieldCr = new javax.swing.JTextField();
        LabelCr = new javax.swing.JLabel();
        LabelCr1 = new javax.swing.JLabel();
        TextFieldCr1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LabelCentroid = new javax.swing.JLabel();
        LabelHasilCluster = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        iterasi = new javax.swing.JTextField();
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

        LabelJlhDokumen.setText("Jumlah Dokumen");

        JlhDokumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JlhDokumenActionPerformed(evt);
            }
        });

        LabelJlhTerm.setText("Jumlah Term");

        JlhTerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JlhTermActionPerformed(evt);
            }
        });

        LabelDBI.setText("Nilai DBI");

        PanelMetodeCluster.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        RadioButtonKMeans.setText("K-means");
        RadioButtonKMeans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonKMeansActionPerformed(evt);
            }
        });

        RadioButtonSAKMeans.setText("SA + K-means");
        RadioButtonSAKMeans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonSAKMeansActionPerformed(evt);
            }
        });

        RadioButtonSVDKmeans.setText("SVD + K-means");

        RadioButtonSVDSAKMeans.setText("SVD + SA + K-means ");
        RadioButtonSVDSAKMeans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonSVDSAKMeansActionPerformed(evt);
            }
        });

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelMetodeClusterLayout.setVerticalGroup(
            PanelMetodeClusterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMetodeClusterLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(RadioButtonKMeans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioButtonSAKMeans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioButtonSVDKmeans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioButtonSVDSAKMeans)
                .addGap(9, 9, 9))
        );

        LabelMetodeCluster.setText("Metode Clustering");

        PanelKmeans.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jumlahK.setText("Jumlah k");

        javax.swing.GroupLayout PanelKmeansLayout = new javax.swing.GroupLayout(PanelKmeans);
        PanelKmeans.setLayout(PanelKmeansLayout);
        PanelKmeansLayout.setHorizontalGroup(
            PanelKmeansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKmeansLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jumlahK)
                .addGap(38, 38, 38)
                .addComponent(TextFieldJlhK, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelKmeansLayout.setVerticalGroup(
            PanelKmeansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKmeansLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(PanelKmeansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahK)
                    .addComponent(TextFieldJlhK, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PanelAlgen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LabelIterasi.setText("Iterasi");

        TextFieldCr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldCrActionPerformed(evt);
            }
        });

        LabelCr.setText("Temperatur Awal");

        LabelCr1.setText("Temperatur Akhir");

        javax.swing.GroupLayout PanelAlgenLayout = new javax.swing.GroupLayout(PanelAlgen);
        PanelAlgen.setLayout(PanelAlgenLayout);
        PanelAlgenLayout.setHorizontalGroup(
            PanelAlgenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAlgenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAlgenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAlgenLayout.createSequentialGroup()
                        .addGroup(PanelAlgenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelIterasi)
                            .addComponent(LabelCr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelAlgenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextFieldCr, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldIterasi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelAlgenLayout.createSequentialGroup()
                        .addComponent(LabelCr1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextFieldCr1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        PanelAlgenLayout.setVerticalGroup(
            PanelAlgenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAlgenLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PanelAlgenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelIterasi)
                    .addComponent(TextFieldIterasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelAlgenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextFieldCr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelAlgenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCr1)
                    .addComponent(TextFieldCr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel7.setText("Parameter k-means");

        jLabel8.setText("Parameter Simulated Annealing");

        LabelCentroid.setText("Centroid");

        LabelHasilCluster.setText("Hasil Clustering");

        jLabel1.setText("Iterasi");

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
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(LabelJlhDokumen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JlhDokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LabelJlhTerm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JlhTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(LabelDBI)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextFieldDBI, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(LabelMetodeCluster)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(38, 38, 38)
                                            .addComponent(ButtonMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(PanelKmeans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(PanelMetodeCluster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(PanelAlgen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(iterasi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(waktuKomputasi, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2)
                                            .addComponent(ScrollPanelCentroid)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(LabelCentroid)
                                                    .addComponent(LabelHasilCluster))
                                                .addGap(0, 0, Short.MAX_VALUE)))))))))
                .addContainerGap(53, Short.MAX_VALUE))
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
                    .addComponent(JlhDokumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelJlhDokumen)
                    .addComponent(LabelJlhTerm)
                    .addComponent(JlhTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelDBI)
                    .addComponent(TextFieldDBI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelMetodeCluster)
                    .addComponent(LabelCentroid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelMetodeCluster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelKmeans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelAlgen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonMulai))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScrollPanelCentroid, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(LabelHasilCluster)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(iterasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(waktuKomputasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
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
			if(bobot.getListDocument().isEmpty()){
				JOptionPane.showMessageDialog(null,"File di dalam folder terpilih tidak dapat diproses",
				"Gagal Muat", JOptionPane.ERROR_MESSAGE);
			}else{
				JlhDokumen.setText(String.valueOf(bobot.getGlobalTermList().getTotalTerm()));
				JlhTerm.setText(String.valueOf(bobot.getListDocument().size()));
				RadioButtonSVDKmeans.setEnabled(true);
				RadioButtonKMeans.setEnabled(true);
				RadioButtonSAKMeans.setEnabled(true);
                                RadioButtonSVDSAKMeans.setEnabled(true);
                                ButtonMulai.setEnabled(true);
                        }
		} catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null,"File tidak dapat diproses","Gagal Muat", JOptionPane.ERROR_MESSAGE);
		}
	} else {
	System.out.println("Gagal Muat");
	}
    }//GEN-LAST:event_ButtonMuatActionPerformed

    private void JlhTermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JlhTermActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JlhTermActionPerformed

    private void ButtonMulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMulaiActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ButtonMulaiActionPerformed

    private void JlhDokumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JlhDokumenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JlhDokumenActionPerformed

    private void RadioButtonKMeansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonKMeansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonKMeansActionPerformed

    private void RadioButtonSAKMeansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonSAKMeansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonSAKMeansActionPerformed

    private void RadioButtonSVDSAKMeansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonSVDSAKMeansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonSVDSAKMeansActionPerformed

    private void TextFieldCrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldCrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldCrActionPerformed

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
    private javax.swing.JTextField JlhDokumen;
    private javax.swing.JTextField JlhTerm;
    private javax.swing.JLabel LabelCentroid;
    private javax.swing.JLabel LabelCr;
    private javax.swing.JLabel LabelCr1;
    private javax.swing.JLabel LabelDBI;
    private javax.swing.JLabel LabelHasilCluster;
    private javax.swing.JLabel LabelIterasi;
    private javax.swing.JLabel LabelJlhDokumen;
    private javax.swing.JLabel LabelJlhTerm;
    private javax.swing.JLabel LabelMetodeCluster;
    private javax.swing.JPanel PanelAlgen;
    private javax.swing.JPanel PanelKmeans;
    private javax.swing.JPanel PanelMetodeCluster;
    private javax.swing.JRadioButton RadioButtonKMeans;
    private javax.swing.JRadioButton RadioButtonSAKMeans;
    private javax.swing.JRadioButton RadioButtonSVDKmeans;
    private javax.swing.JRadioButton RadioButtonSVDSAKMeans;
    private javax.swing.JScrollPane ScrollPanelCentroid;
    private javax.swing.JTextField TextFieldCr;
    private javax.swing.JTextField TextFieldCr1;
    private javax.swing.JTextField TextFieldDBI;
    private javax.swing.JTextField TextFieldIterasi;
    private javax.swing.JTextField TextFieldJlhK;
    private javax.swing.JTextField folderPath;
    private javax.swing.JTextField iterasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jumlahK;
    private javax.swing.JTextField waktuKomputasi;
    // End of variables declaration//GEN-END:variables
}
