package EX01;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import Data_classes.Samples;
import de.micromata.opengis.kml.v_2_2_0.*;



public class CsvToKml {
	
	/**
	 * @author Bar Janach, Amit Nuni.
	 * This class is used for taking an existing CSV file and making a new KML file out of it.
	 */
	
	private File csv;
	private Samples samples;
	private final Kml kml = new Kml();

	public CsvToKml(String s){
		csv = new File(s);
		samples = new Samples(csv.getPath());
	}

	/**
	 * This function filters the 10 highest wifi signals at the same time.
	 * As we most likely get more than 10 wifi signals at the same time, we were asked to take the 10 with the highest signal.
	 * 
	 */
	public void CreateByBest(){
		int ind = 1;
		ArrayList<String> str = new ArrayList<>();
		try{
			FileReader fr = new FileReader("C:\\Users\\Bar&Almog\\Desktop\\matala00\\KMLexam.kml");
			BufferedReader br = new BufferedReader(fr);

			for(int i=0;i<2;i++)
				str.add(br.readLine());

			while(ind<samples.length()){
				fr = new FileReader("C:\\Users\\Bar&Almog\\Desktop\\matala00\\KMLexam.kml");
				br = new BufferedReader(fr);
				for(int i=0;i<2;i++)
					br.readLine();
				str.add(br.readLine());
				str.add(br.readLine().replaceAll("NAME", samples.getName(ind)));
				str.add("<description><![CDATA[BSSID: <b>"+samples.getMac(ind)+"</b><br/>Capabilities: <b>SECURITY</b><br/>Frequency: <b>"+samples.getFreq(ind)+"</b><br/>Timestamp: <b>1509528977000</b><br/>Date: <b>"+samples.getDate(ind)+"</b>]]></description><styleUrl>#green</styleUrl>");
				br.readLine();				
				str.add(br.readLine());
				str.add(br.readLine().replaceAll("LAT,LON",samples.getPoint(ind)));
				str.add(br.readLine());
				ind++;	
			}
			for(int i=0;i<2;i++)
				str.add(br.readLine());	

			br.close();
			fr.close();
		}

		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
		WTK(str);
	}

	

	public static void WTK(ArrayList<String> s,String name){
		int q=0;
		try {
			String str;
			FileWriter fw = new FileWriter("C:\\Users\\Bar&Almog\\Desktop\\matala00\\"+name+1+".kml");
			PrintWriter outs = new PrintWriter(fw);
			while(q<s.size()){
				str = s.get(q);
				outs.println(str);
				q++;
			}
			outs.close();
			fw.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}

	public static void WTK(ArrayList<String> s){
		int q=0;
		try {
			String str;
			FileWriter fw = new FileWriter("C:\\Users\\Bar&Almog\\Desktop\\matala00\\newKML1.kml");
			PrintWriter outs = new PrintWriter(fw);
			while(q<s.size()){
				str = s.get(q);
				outs.println(str);
				q++;
			}
			outs.close();
			fw.close();
		}

		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		System.out.println("Insert path to direcory: ");
		String s = (String)reader.nextLine();
		CsvToKml c = new CsvToKml(s);
		c.CreateByBest();
		//c.CreateByNetName("GOLAN T");
		reader.close();
	}

}
