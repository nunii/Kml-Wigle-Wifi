package ex03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import Data_classes.MacList;
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
import ex02.MacPos;

public class Data {
	static Samples samples = new Samples(),currentData = new Samples(samples);
	public static int csvCounter,kmlCounter;
	static boolean filterFlag = false;
	static Filter[] filters = new Filter[2];
	static String operator;
	static MacList ml = new MacList(samples);
	static Vector<String> myVector = new Vector<String>();
	
	private static void setVector(){
		for (int i = 0; i < ml.size(); i++) {
			myVector.add(ml.get(i).getMac());
		}
	}
	
	public static void addDir(String path){
		ArrayList<String> al = NewCSV.start(path);
		samples.add(al);
		if(!filterFlag)
			currentData = new Samples(samples);
		else{
			Samples temp = new Samples(samples);
			temp = temp.Filter(filters[0]);
			if(filters[1]!=null){
				if(operator.equals("OR")){
					Samples tempo = new Samples(samples);
					tempo = tempo.Filter(filters[1]);
					temp.add(tempo);
				}
				else if(operator.equals("AND")){
					temp = temp.Filter(filters[1]);
				}
			}
			currentData = new Samples(temp);
		}
		ml = new MacList(samples);
		setVector();
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
		if(!filterFlag)
			currentData = new Samples(samples);
		else{
			Samples temp = new Samples(samples);
			temp = temp.Filter(filters[0]);
			if(filters[1]!=null){
				if(operator.equals("OR")){
					Samples tempo = new Samples(samples);
					tempo = tempo.Filter(filters[1]);
					temp.add(tempo);
				}
				else if(operator.equals("AND")){
					temp = temp.Filter(filters[1]);
				}
			}
			currentData = new Samples(temp);
		}
		ml = new MacList(samples);
		setVector();
	}
	
	public static void addWglFile(String filepath){
		ArrayList<String> al = NewCSV.Best10(ReadCSV.CSVtoMatrix(filepath));
		samples.add(al);
		if(!filterFlag)
			currentData = new Samples(samples);
		else{
			Samples temp = new Samples(samples);
			temp = temp.Filter(filters[0]);
			if(filters[1]!=null){
				if(operator.equals("OR")){
					Samples tempo = new Samples(samples);
					tempo = tempo.Filter(filters[1]);
					temp.add(tempo);
				}
				else if(operator.equals("AND")){
					temp = temp.Filter(filters[1]);
				}
			}
			currentData = new Samples(temp);
		}
		ml = new MacList(samples);
		setVector();
	}
	
	public static void toCSV(String path){
		samples.toCSV(path+"\\newCsvFile-"+csvCounter+".csv");
		csvCounter++;
	}
	
	public static void FilterstoCSV(String path){
		currentData.toCSV(path+"\\newFilterdCsvFile-"+csvCounter+".csv");
		csvCounter++;
	}
	
	public static void toKML(String path){
		WriteToKml.write(currentData, path+"\\newKMLfile-"+kmlCounter+".kml");
	}
	
	public static Samples CurrentData(){
		return currentData;
	}
	
	public static void Timefilter(String start, String end, String oper){
		
		Filter tf = new timeFilter(start,end);
		
		if(!filterFlag||oper==null){
			currentData = currentData.Filter(tf);
			filters[0] = tf;
			filterFlag = true;
		}
		else{
			operator = oper;
			filters[1] = tf;
			if(operator.equals("OR")){
				Samples temp = new Samples(currentData);
				currentData = samples.Filter(tf);
				currentData.add(temp);
			}
			else if(operator.equals("AND")){
				currentData = currentData.Filter(tf);
			}
		}
	}
	
	public static void positionfilter(String lat, String lon, String alt, String radius, String oper){
		Filter pf = new positionFilter(new Position(lat,lon,alt),Double.parseDouble(radius));
		
		if(!filterFlag||oper==null){
			currentData = currentData.Filter(pf);
			filters[0] = pf;
			filterFlag = true;
		}
		else{
			operator = oper;
			filters[1] = pf;
			if(operator.equals("OR")){
				Samples temp = new Samples(currentData);
				currentData = samples.Filter(pf);
				currentData.add(temp);
			}
			else if(operator.equals("AND")){
				currentData = currentData.Filter(pf);
			}
		}
	}
	
	public static void macFilter(String mac, String oper){
		Filter wf = new WifiFilter(mac);
		
		if(!filterFlag||oper==null){
			currentData = currentData.Filter(wf);
			filters[0] = wf;
			filterFlag = true;
		}
		else{
			operator = oper;
			filters[1] = wf;
			if(operator.equals("OR")){
				Samples temp = new Samples(currentData);
				currentData = samples.Filter(wf);
				currentData.add(temp);
			}
			else if(operator.equals("AND")){
				currentData = currentData.Filter(wf);
			}
		}
	}

	public static String currentFilter(){
		String f1="",f2="";
		if(filters[0]!=null)
			f1=filters[0].toString();
		if(filters[1]!=null)
			f2=filters[1].toString();
		return f1 + operator + f2;
	}
	
	public static void ClearData(){
		samples = new Samples();
		currentData = new Samples(samples);
		filters[0] = null;
		filters[1] = null;
		operator = null;
	}
	
	public static void ClearFilters(){
		currentData = new Samples(samples);
		filters[0] = null;
		filters[1] = null;
		operator = null;
	}
	
	public static String MacMount(){
		if(ml.size()<1)
			return "0";
		return String.valueOf(ml.size());
	}
	
	public static String SamplesMount(){
		if(samples.length()<1)
			return "0";
		return String.valueOf(samples.length());
	}
	
	public static String getPositionAlg1(String mac){
		return MacPos.makePos(samples,mac).toString();
	}
	
}
