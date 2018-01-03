package ex03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Data_classes.Position;
import Data_classes.Sample;
import Data_classes.Samples;
import EX01.NewCSV;
import EX01.ReadCSV;
import EX01.WriteToKml;
import Filter.Filter;
import Filter.WifiFilter;
import Filter.positionFilter;
import Filter.timeFilter;

public class Data {
	static Samples samples = new Samples(),currentData = new Samples(samples);
	static int csvCounter=1,kmlCounter=1;
	static boolean filterFlag = false;
	
	public static void addDir(String path){
		ArrayList<String> al = NewCSV.start(path);
		samples.add(al);
		currentData = new Samples(samples);
	}
	
	public static void addCSV(String FilePath){
		try {
			FileReader fr = new FileReader(FilePath);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			if(str==null||!str.startsWith("Time,ID,Lat,Lon,Alt,#WiFi networks,SSID1,MAC1,Frequncy1,Signal1,SSID2,MAC2,Frequncy2,Signal2,SSID3,MAC3,Frequncy3,Signal3,SSID4,MAC4,Frequncy4,Signal4,SSID5,MAC5,Frequncy5,Signal5,SSID6,MAC6,Frequncy6,Signal6,SSID7,MAC7,Frequncy7,Signal7,SSID8,MAC8,Frequncy8,Signal8,SSID9,MAC9,Frequncy9,Signal9,SSID10,MAC10,Frequncy10,Signal10")){
				br.close();
				//here should pop up msg of wrong file type
				throw new IOException(FilePath);
			}
			str = br.readLine();
			while(str!=null){
				samples.add(new Sample(str.split(",")));
				str = br.readLine();
			}
			br.close();
			fr.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
		currentData = new Samples(samples);
	}
	
	public static void addWglFile(String filepath){
		ArrayList<String> al = NewCSV.Best10(ReadCSV.CSVtoMatrix(filepath));
		samples.add(al);
		currentData = new Samples(samples);
	}
	
	public static void toCSV(String path){
		samples.toCSV(path+"newCsvFile-"+csvCounter+".csv");
		currentData = new Samples(samples);
	}
	
	public static void toKML(String path){
		WriteToKml.write(samples, path+"newKMLfile-"+kmlCounter+".kml");
		currentData = new Samples(samples);
	}
	
	public static Samples CurrentData(){
		return currentData;
	}
	
	public static void Timefilter(String start, String end){
		Filter tf = new timeFilter(start,end);
		if(!filterFlag){
			currentData = currentData.Filter(tf);
			filterFlag = true;
		}
		else{
			Samples temp = new Samples(currentData);
			currentData = samples.Filter(tf);
			currentData.add(temp);
		}
	}
	
	public static void Timefilter(String lat, String lon, String alt, String radius){
		Filter pf = new positionFilter(new Position(lat,lon,alt),Double.parseDouble(radius));
		if(!filterFlag){
			currentData = currentData.Filter(pf);
			filterFlag = true;
		}
		else{
			Samples temp = new Samples(currentData);
			currentData = samples.Filter(pf);
			currentData.add(temp);
		}
	}
	
	public static void macFilter(String mac){
		Filter wf = new WifiFilter(mac);
		if(!filterFlag){
			currentData = currentData.Filter(wf);
			filterFlag = true;
		}
		else{
			Samples temp = new Samples(currentData);
			currentData = samples.Filter(wf);
			currentData.add(temp);
		}
	}
}
