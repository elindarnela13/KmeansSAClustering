/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class Kamus {
    private static Map<Character, String[]> KamusKDid;
    
    public static Map<Character, String[]> getKamusKDid() {
        return KamusKDid;
    }
    
    private static List<Character> indexAlphabet;

    public static List<Character> getIndexAlphabet() {
        return indexAlphabet;
    }
    
    public static void initKamusKDid() {
        // init Kamus
        String pathKamusKDid = "folderkamus\\kamusKDid\\";
        File FileFolder = new File(pathKamusKDid);
        List<String> Files = new ArrayList<String>(listFiles(FileFolder));
        Map<Character, String[]> tmpKamusKDid = new LinkedHashMap<Character, String[]>();
        try {
            char ix = 'a';
            for (String File : Files) {
                ArrayList<String> tmp = new ArrayList<String>();
                String line;
                BufferedReader reader = new BufferedReader(new FileReader(pathKamusKDid+File));
                while ((line = reader.readLine()) != null) {
                    tmp.add(line);
                }
                tmpKamusKDid.put(ix, tmp.toArray(new String[tmp.size()]));
                ix++;
            }
            String[] s = {"`"};
            tmpKamusKDid.put('`', s);
            KamusKDid = tmpKamusKDid;
        }
        catch(IOException e){
        }
        // init Index
        List<Character> tmpIndexAlphabet = new ArrayList<Character>();
        for(char c='a'; c<='z'; c++) {
            tmpIndexAlphabet.add(c);
        }
        tmpIndexAlphabet.add('`');
        indexAlphabet = tmpIndexAlphabet;
    }
    
    // list all Files found in folder
    private static ArrayList<String> listFiles(final File pathFolder) {
        // * Retrieve all files inside a Folder
        ArrayList<String> results = new ArrayList<String>();
        for (final File fileEntry : pathFolder.listFiles()) {
            if (fileEntry.isDirectory()) {
                 listFiles(fileEntry);
            } 
            else {
                results.add(fileEntry.getName());
            }
        }
        return results;
    } 
    
    public List<String> loadStopWord()
	{
            List<String>lststopword = new ArrayList<String>();
            
            try
		{

                    BufferedReader in = new BufferedReader(new FileReader("folderkamus\\stopwordlist.txt"));
                    StringBuffer sb = new StringBuffer();
                    String s = null;
                    while((s = in.readLine()) != null){
                        sb.append(s);
                    }
                    
                    lststopword.addAll(Arrays.asList(sb.toString().split(";")));

		}catch(FileNotFoundException ex)
		{
                    System.out.println("File not found");
		}catch(IOException ex)
		{
                    System.out.println("IOexception");
		}
            return lststopword;
	}

}
