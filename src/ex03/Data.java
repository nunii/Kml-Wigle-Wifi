package ex03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import dataBase.MySQL;
import ex02.MacPos;

public class Data {
	private Samples samples;
	public Samples currentData;
	public int csvCounter,kmlCounter;
	private boolean filterFlag;
	private Filter[] filters;
	private String operator;
	private MacList ml;
	public Vector<String> myVector;
	public ArrayList<String> modified;
	static Date time = new Date();

	public Data(){
		samples = new Samples();
		currentData = new Samples(samples);
		filters = new Filter[2];
		ml = new MacList(samples);
		myVector = new Vector<String>();
		modified = new ArrayList<>();
		csvCounter = 1;
		kmlCounter = 1;
		filterFlag = false;
	}
	
	private static void setVector(){
		for (int i = 0; i < ml.size(); i++) {
			myVector.add(ml.get(i).getMac());
		}
	}
	
	public void addDir(String path){
		ArrayList<String> al = NewCSV.start(path);
		String[] mod = al.get(0).split(";");
		for (int i = 0; i < mod.length; i++) {
			modified.add(mod[i]);
		}
		al.remove(0);
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
	
	public void addCSV(String FilePath){
		try {
			FileReader fr = new FileReader(FilePath);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			if(str==null||!str.startsWith("Time,ID,Lat,Lon,Alt,#WiFi networks,SSID1,MAC1,Frequncy1,Signal1,SSID2,MAC2,Frequncy2,Signal2,SSID3,MAC3,Frequncy3,Signal3,SSID4,MAC4,Frequncy4,Signal4,SSID5,MAC5,Frequncy5,Signal5,SSID6,MAC6,Frequncy6,Signal6,SSID7,MAC7,Frequncy7,Signal7,SSID8,MAC8,Frequncy8,Signal8,SSID9,MAC9,Frequncy9,Signal9,SSID10,MAC10,Frequncy10,Signal10")){
				br.close();
				//here should pop up msg of wrong file type
				throw new IOException(FilePath);
			}
			File file = new File(FilePath);
			modified.add(FilePath+","+file.lastModified());
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
	
	public void addWglFile(String filepath){
		ArrayList<String> al = NewCSV.Best10(ReadCSV.CSVtoMatrix(filepath));
		File file = new File(filepath);
		modified.add(filepath+","+file.lastModified());
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
	
	public static void addSQLtable(String ip, String url, String user, String password) {
		MySQL table = new MySQL(ip,"jdbc:mysql://"+ip+url,user,password);
		samples.add(table.readTable());
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
	
	
	public void toCSV(String path){
		DateFormat f = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		samples.toCSV(path+"\\newCsvFile-"+f.format(time.getTime()).toString()+".csv");
		csvCounter++;
	}
	
	public void FilterstoCSV(String path){
		currentData.toCSV(path+"\\newFilterdCsvFile-"+csvCounter+".csv");
		csvCounter++;
	}
	
	public void toKML(String path){
		WriteToKml.write(currentData, path+"\\newKMLfile-"+kmlCounter+".kml");
	}
	
	public  Samples CurrentData(){
		return currentData;
	}
	
	public  void Timefilter(String start, String end, String oper){
		
		Filter tf = new timeFilter(start,end);
		
		if(!filterFlag||oper==null){
			currentData = samples.Filter(tf);
			filters[0] = tf;
			filters[1] = null;
			filterFlag = true;
		}
		else{
			if(filters[1]!=null)
				return ;
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
	
	public  void positionfilter(String lat, String lon, String alt, String radius, String oper){
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
	
	public  void macFilter(String mac, String oper){
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

	public  String currentFilter(){
		String f1="",f2="";
		if(filters[0]!=null)
			f1=filters[0].toString();
		if(filters[1]!=null)
			f2=filters[1].toString();
		return f1 + operator + f2;
	}
	
	public  void ClearData(){
		samples = new Samples();
		currentData = new Samples(samples);
		filters = new Filter[2];
		ml = new MacList(samples);
		myVector = new Vector<String>();
		modified = new ArrayList<>();
		csvCounter = 1;
		kmlCounter = 1;
		filterFlag = false;
	}
	
	public  void ClearFilters(){
		currentData = new Samples(samples);
		filters[0] = null;
		filters[1] = null;
		operator = null;
	}
	
	public  String MacMount(){
		if(ml.size()<1)
			return "0";
		return String.valueOf(ml.size());
	}
	
	public  String SamplesMount(){
		if(samples.length()<1)
			return "0";
		return String.valueOf(samples.length());
	}
	
	public  String getPositionAlg1(String mac){
		return MacPos.makePos(samples,mac).toString();
	}
	
}
