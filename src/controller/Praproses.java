/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import entity.Document;
import entity.Term;
import entity.TermList;

public class Praproses {
        TermList lsttoken;//term uniqe (hsl stopword removing)
	TermList lsttokencurrent;// list per doc (hsl stopword removing)
	Kamus stpwlist; //kamus stopword
	List<Document>lstDoc; // list daftar doc
        
        //Stemming stemming = new Stemming();
        
	public Praproses()
	{
		lsttoken = new TermList();   
	}

	public void setTokenList(TermList lstTokenList)
	{
		lsttoken = lstTokenList;
	}

	public void doPraproses(Document doc)
	{
                //tokenize remove punctuation
                String[] t= removePunctuation(doc.getIsi().toLowerCase()).split("\\s+");
                //stemming
                String[] s = Stemming(t);
		lsttokencurrent = new TermList();
                //stopword removal
                for(int i=0; i<s.length; i++){
//                    System.out.println("Stem: "+s[i]);
			if(s[i].length()>1)
			{
				if(!findStopWord(s[i]))
				{
					s[i] = s[i].toLowerCase();
					//s[i] = removePunctuation(s[i]);
					lsttokencurrent.addTerm(new Term(s[i]));
					Term tkn = lsttoken.checkTerm(s[i]);
					if(tkn==null)
					{
						lsttoken.addTerm(new Term(s[i]));
					}
				}
			}
                }
	}
        

        private static String removePunctuation(String isiDokumen){
            // Filter Punctuation (Per kalimat)
            String rslt = isiDokumen;
            String P = "[!\"$%&'()*\\+,./:;<=>? \\[\\]^~_\\-`{|}…0987654321]";
            return rslt.replaceAll(P, " ");
        }
  
        public boolean findStopWord(String str)
	{
            List<String>lststopword = new ArrayList<String>();
            Kamus stpwlist = new Kamus();
            
            lststopword = stpwlist.loadStopWord();
   
            boolean ada=false;
		for(int i=0; i<lststopword.size(); i++)
		{
			if(lststopword.get(i).equals(str))
			{
				ada=true;
				break;
			}
		}
		return ada;
	}
        
        public String[] Stemming (String[] token){         
            Stemming stem = new Stemming();
                        
            String[] Filter = token;
            String HasilStem="";
            String[] Result;
            for(int i=0; i<Filter.length; i++){
                HasilStem += stem.Stem(Filter[i])+ "\n";
            }
                Result = HasilStem.split("\n");
            return Result;
    }

	public TermList getCurrentTokenList()
	{
		return lsttokencurrent;
	}

	public TermList getTokenList()
	{
		return lsttoken;
	}

}
