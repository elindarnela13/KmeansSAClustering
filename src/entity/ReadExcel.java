/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author User
 */
public class ReadExcel {

    public String ReadExcel;
      public ArrayList<ArrayList<Double>> load_excel_format_xls(String filename) {

        ArrayList<ArrayList<Double>> data = new ArrayList<>();

        try {
            FileInputStream excelFile = new FileInputStream(new File(filename));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = (Sheet) workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            ArrayList<Double> data_from_excel = new ArrayList<>();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                ArrayList<Double> angka = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    data_from_excel.add(Double.valueOf(currentCell.getStringCellValue()));
//                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
//                        data_from_excel.add(currentCell.getStringCellValue().trim().toLowerCase());
////
//                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
//                        data_from_excel.add(String.valueOf((double) currentCell.getNumericCellValue()));
//                    }

                }

                data.add(data_from_excel);
                data_from_excel = new ArrayList<>();
            }
        } catch (IOException ex) {
          
        }
        return data;
    }
      
    public ArrayList<ArrayList> load_excel_format_csv(String filename,String cvsSplitBy) {
        String csvFile = filename;
        String line = "";
        ArrayList<ArrayList> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            ArrayList<String> angka = new ArrayList<>();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                for (int i = 0; i < country.length; i++) {
                     angka.add(country[i]);
                }
                data.add(angka);
                angka = new ArrayList<>();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
    
     public  void write_to_excel(JTable jTable1, String Location) throws FileNotFoundException, IOException {

        HSSFWorkbook fWorkbook = new HSSFWorkbook();
        HSSFSheet fSheet = fWorkbook.createSheet("new Sheet");
        HSSFFont sheetTitleFont = fWorkbook.createFont();
        HSSFCellStyle cellStyle = fWorkbook.createCellStyle();
        sheetTitleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //sheetTitleFont.setColor();
        TableModel model = jTable1.getModel();

        //Get Header
        TableColumnModel tcm = jTable1.getColumnModel();
        HSSFRow hRow = fSheet.createRow((short) 0);
        for (int j = 0; j < tcm.getColumnCount(); j++) {
            HSSFCell cell = hRow.createCell((short) j);
            cell.setCellValue(tcm.getColumn(j).getHeaderValue().toString());
            cell.setCellStyle(cellStyle);
        }

        //Get Other details
        for (int i = 0; i < model.getRowCount()-1; i++) {
            HSSFRow fRow = fSheet.createRow((short) i + 1);
            for (int j = 0; j < model.getColumnCount(); j++) {
                HSSFCell cell = fRow.createCell((short) j);
                cell.setCellValue(model.getValueAt(i, j).toString());
                cell.setCellStyle(cellStyle);
            }
        }
        FileOutputStream fileOutputStream;
        fileOutputStream = new FileOutputStream(Location);
        try (BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream)) {
            fWorkbook.write(bos);
        }
        fileOutputStream.close();
    }

}
