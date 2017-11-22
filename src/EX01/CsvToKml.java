package EX01;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;




public class CsvToKml {
	private File csv;
	private Samples sample;
	
	public CsvToKml(String s){
		csv = new File(s);
		sample = new Samples(csv.getPath());
	}

	public void CreateByBest(){
		int ind = 1;
		ArrayList<String> str = new ArrayList<>();
		try{
			FileReader fr = new FileReader("C:\\Users\\Bar&Almog\\Desktop\\matala00\\KMLexam.kml");
			BufferedReader br = new BufferedReader(fr);
			
			for(int i=0;i<2;i++)
				str.add(br.readLine());

			while(ind<sample.length()){
				fr = new FileReader("C:\\Users\\Bar&Almog\\Desktop\\matala00\\KMLexam.kml");
				br = new BufferedReader(fr);
				for(int i=0;i<2;i++)
					br.readLine();
				str.add(br.readLine());
				str.add(br.readLine().replaceAll("NAME", sample.getName(ind)));
				str.add("<description><![CDATA[BSSID: <b>"+sample.getMac(ind)+"</b><br/>Capabilities: <b>SECURITY</b><br/>Frequency: <b>"+sample.getFreq(ind)+"</b><br/>Timestamp: <b>1509528977000</b><br/>Date: <b>"+sample.getDate(ind)+"</b>]]></description><styleUrl>#green</styleUrl>");
				br.readLine();				
				str.add(br.readLine());
				str.add(br.readLine().replaceAll("LAT,LON",sample.getPoint(ind)));
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

	public void CreateByNetName(String name){
		
		int ind=1;
		if(!sample.contains(name)){
			System.out.println("Net name not found");
			return;
		}
		ArrayList<String> str = new ArrayList<>();
		try{
			FileReader fr = new FileReader("C:\\Users\\Bar&Almog\\Desktop\\matala00\\KMLexam.kml");
			BufferedReader br = new BufferedReader(fr);
			for(int i=0;i<2;i++)
				str.add(br.readLine());
			while(ind<sample.length()){
				try{
				if(sample.getSample(ind).Contains(name)){
					fr = new FileReader("C:\\Users\\Bar&Almog\\Desktop\\matala00\\KMLexam.kml");
					br = new BufferedReader(fr);
					for(int i=0;i<2;i++)
						br.readLine();
					str.add(br.readLine());
					str.add(br.readLine().replaceAll("NAME", name));
					str.add("<description><![CDATA[BSSID: <b>"+sample.getMac(ind, name)+"</b><br/>Capabilities: <b>SECURITY</b><br/>Frequency: <b>"+sample.getFreq(ind, name)+"</b><br/>Timestamp: <b>1509528977000</b><br/>Date: <b>"+sample.getDate(ind)+"</b>]]></description><styleUrl>#green</styleUrl>");
					br.readLine();				
					str.add(br.readLine());
					str.add(br.readLine().replaceAll("LAT,LON",sample.getPoint(ind)));
					str.add(br.readLine());
				}
				}
				catch(ArrayIndexOutOfBoundsException ex) {
				}
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
		WTK(str,name);
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
		c.CreateByNetName("GOLAN T");
		reader.close();
	}

}
