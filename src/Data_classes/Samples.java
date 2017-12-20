package Data_classes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import EX01.WriteCSV;
import Filter.Filter;



public class Samples {
	/**
	 * @author Bar Janach, Amit Nuni.
	 * This class is taking a given CSV file and
	 * enters each line f the file into a Sample object which is another cell at an ArrayList<Sample>.
	 * the constructor receives String which is the path to csv file
	 * this means the Samples obj is a matrix of the csv file
	 */

	private String FileName;
	private ArrayList<Sample> file;

	/**
	 * the constructor.
	 * @param FileName
	 */
	public Samples(String FileName){
		file = new ArrayList<Sample>();
		try {
			FileReader fr = new FileReader(FileName);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			if(str==null||!str.startsWith("Time,ID,Lat,Lon,Alt,#WiFi networks,SSID1,MAC1,Frequncy1,Signal1,SSID2,MAC2,Frequncy2,Signal2,SSID3,MAC3,Frequncy3,Signal3,SSID4,MAC4,Frequncy4,Signal4,SSID5,MAC5,Frequncy5,Signal5,SSID6,MAC6,Frequncy6,Signal6,SSID7,MAC7,Frequncy7,Signal7,SSID8,MAC8,Frequncy8,Signal8,SSID9,MAC9,Frequncy9,Signal9,SSID10,MAC10,Frequncy10,Signal10"))
				throw new IOException(FileName);
			str = br.readLine();
			while(str!=null){
				file.add(new Sample(str.split(",")));
				str = br.readLine();
			}
			br.close();
			fr.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}	}

	public Samples(ArrayList<Sample> samp){
		file = samp;
	}
	
	public Samples(){
		file = new ArrayList<Sample>();
	}
	
	public void add(Sample s){
		file.add(s);
	}
	
	/**
	 * This function makes a filtered Samples.
	 * @param f 
	 * @return a filtered Samples
	 */
	
	public Samples Filter(Filter f){
		Samples s = new Samples();
		for (int i = 0; i < file.size(); i++) {
			if(f.criterion(file.get(i)))
				s.add(file.get(i));
		}
		return s;
	}
	
	public boolean contains(String name){
		for (int i = 0; i < file.size(); i++)
			if(file.get(i).Contains(name))
				return true;
		return false;
	}
	public Sample getSample(int d){
		return file.get(d);
	}
	
	public String getName(int d){
		return file.get(d).getName();
	}

	public int getInd(String name, int sample){
		return file.get(sample).getIndex(name);
	}
	
	public Position getPos(int d){
		return file.get(d).getPos();
	}
	
	public String getMac(int d){
		return file.get(d).getMac();
	}
	
	public String getMac(int d, String s){
		return file.get(d).getMac(s);
	}
	
	public String getFreq(int d){
		return file.get(d).getFreq();
	}
	public String getFreq(int d,String s){
		return file.get(d).getFreq(s);
	}

	public String getDate(int d){
		return file.get(d).getDate();
	}
	
	public String getTimestamp(int d) {
		return file.get(d).getTimestamp();
	}
	
	public int length(){
		return file.size();
	}
	
	public void toCSV(String path){
		ArrayList<String> towrite = new ArrayList<String>();
		towrite.add("Time,ID,Lat,Lon,Alt,#WiFi networks,SSID1,MAC1,Frequncy1,Signal1,SSID2,MAC2,Frequncy2,Signal2,SSID3,MAC3,Frequncy3,Signal3,SSID4,MAC4,Frequncy4,Signal4,SSID5,MAC5,Frequncy5,Signal5,SSID6,MAC6,Frequncy6,Signal6,SSID7,MAC7,Frequncy7,Signal7,SSID8,MAC8,Frequncy8,Signal8,SSID9,MAC9,Frequncy9,Signal9,SSID10,MAC10,Frequncy10,Signal10");
		for (int i = 0; i < file.size(); i++) {
			towrite.add(file.get(i).toString());//.substring(1, file.get(i).toString().length()-1));
		}
		WriteCSV.Write(towrite, path);
	}
	
	
	
	
}
