package jf;

import java.io.*;
import java.util.*;
import org.apache.commons.collections.*;
import com.opencsv.*;

import org.apache.commons.collections.CollectionUtils;
/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
	App instance = new App();
        System.out.println( "Hello World!" );
	int a= instance.max(4,5);
	System.out.println("max: "+a);

	int monmax=0;
	int nb=0;

	CSVReader reader;
    CSVWriter writer; 

	try {
		reader = new CSVReader(new FileReader("data.csv"),',');
		writer = new CSVWriter(new FileWriter("data-filtered.csv"), ';', (char)0);

	 	List<String[]> myEntries= reader.readAll();

		for(int i=0;i<myEntries.size();i++){
			for(int j=0;j<myEntries.get(i).length;j++){
				nb=Integer.parseInt(myEntries.get(i)[j]);
				System.out.println("Nombre lu: "+nb);
				monmax=instance.max(monmax,nb);
			}
			List<String> list=Arrays.asList(myEntries.get(i));
			Vector<String>out= new Vector<String>();
			Predicate Monpredicat = new Predicate(){
                public boolean evaluate(Object x)
                {
                    try
                    {
                        return Integer.parseInt((String) x) < 50;
                    }
                    catch (java.lang.NumberFormatException n)
                    {
                        return false;
                    }
                }
            };
			CollectionUtils.select(list,Monpredicat, out);
			System.out.println("contenu filtré de la ligne "+i+" : "+out);
			
			//bloc writer
			for (int k=0; k < out.size(); k++) {
                String[] tmp=out.toArray(new String[0]);
                System.out.println("TMP:"+tmp[k]);
                if(k==out.size()-1)
                {
                    writer.writeNext(tmp);
                }
            }
			
		}
		System.out.println("Nombre max lu: "+monmax);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    }
    public int max(int a,int b)
	{
		return a>b ? a:b;
	}
}
