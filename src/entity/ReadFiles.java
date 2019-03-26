/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author User
 */
public class ReadFiles {

    public double[][] Read() throws FileNotFoundException {
        BufferedReader in = new BufferedReader(new FileReader("D:\\dataset.txt"));
        
        Object tableLine[] = in.lines().toArray();
        int baris = tableLine.length;
        int kolom = tableLine[0].toString().trim().split(" ").length;
        
        String[][] dataset = new String[baris][kolom];
        double[][] data = new double[baris][kolom];
        for (int i = 0; i < baris; i++) {
            String line = tableLine[i].toString().trim();
            String dataRow[] = line.split(" ");
            for (int j = 0; j < kolom; j++) {
                dataset[i][j] = dataRow[j];
//                System.out.println(dataset[i][j]);
                data[i][j] = Double.parseDouble(dataset[i][j]);
//                System.out.println(data[i][j]);
            }
        }
        return data;
    }
}
