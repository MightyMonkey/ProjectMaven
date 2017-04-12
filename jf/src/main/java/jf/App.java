package jf;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
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
	int i,j,nb=0;

	CSVReader reader;
	try {
		reader = new CSVReader(new FileReader("data.csv"),',');
	

	 	List<String[]> myEntries= reader.readAll();

		for(i=0;i<myEntries.size();i++){
			for(j=0;j<myEntries.get(i).length;j++){
				nb=Integer.parseInt(myEntries.get(i)[j]);
				System.out.println("Nombre lu: "+nb);
				monmax=instance.max(monmax,nb);
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
