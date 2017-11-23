package EX01;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import de.micromata.opengis.kml.v_2_2_0.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class NewCSV {

	static ArrayList<String> FinalFile = new ArrayList<>();
	
	public static void DirToCsv(File[] fileslist){
		FinalFile.add("Time,ID,Lat,Lon,Alt,#WiFi networks,SSID1,MAC1,Frequncy1,Signal1,SSID2,MAC2,Frequncy2,Signal2,SSID3,MAC3,Frequncy3,Signal3,SSID4,MAC4,Frequncy4,Signal4,SSID5,MAC5,Frequncy5,Signal5,SSID6,MAC6,Frequncy6,Signal6,SSID7,MAC7,Frequncy7,Signal7,SSID8,MAC8,Frequncy8,Signal8,SSID9,MAC9,Frequncy9,Signal9,SSID10,MAC10,Frequncy10,Signal10");
		for(File i:fileslist){
			CSVtoMX(i.getPath());
		}
		WriteCSV(FinalFile);
	}


	public static void CSVtoMX(String fileName){
		int raws, lines;
		raws = 11;
		lines = LCtr(fileName);
		String[][] mtx = new String[lines][raws];
		
		//enter the file to matrix
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			System.out.println(str);
			if(str==null||!str.startsWith("WigleWifi"))
				return;
			for(int j=0;j<lines;j++){
				mtx[j] = str.split(",");
				str = br.readLine();
			}
			br.close();
			fr.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
		
		//take only the relevant sample lines into a new List-matrix
		
		ArrayList<String[]> gdsamp = new ArrayList<>();
		List<Integer> sum = new ArrayList<>();
		List<String> time = new ArrayList<>();
		int[] db = new int[lines-2];
		int[] ar;
		int f=0,l=0,c;

		for(int k=2;k<lines;k++)
			time.add(mtx[k][3]);
		
		for(int j=0;j<db.length;j++){
			db[j] = Integer.parseInt(mtx[j+2][5]);
		}
		
		//save only relevant samples:
		while(f<time.size()){
			while(f<(time.size()-1)&&(time.get(f).equals(time.get(f+1)))){
				f++;
			}


			//count and save index of top 10 wifi:
			ar = new int[10];
			int index,k=0;
			while(k<10&&k<((f-l)+1)){
				index = FindMax(db,l,f);
				ar[k] = index;
				db[index] = 1;
				k++;
			}
			sum.add(k);
			
			c=0;
			while(c<10&&c<((f-l)+1)){
				gdsamp.add(mtx[ar[c]+2]);
				c++;
			}

			f++;
			l=f;
		}
		
		//enter the new lines into the final matrix 
		String st;
		l=1;
		f=0;
		while(l<=sum.size()){
			st = gdsamp.get(f)[3]+","+mtx[0][2].substring(6)+","+gdsamp.get(f)[6]+","+gdsamp.get(f)[7]+","+gdsamp.get(f)[8]+","+sum.get(l-1)+","+gdsamp.get(f)[1]+","+gdsamp.get(f)[0]+","+gdsamp.get(f)[4]+","+gdsamp.get(f)[5];
			c=0;
			while(c<sum.get(l-1)-1){
				st+=","+gdsamp.get(f+1)[1]+","+gdsamp.get(f+1)[0]+","+gdsamp.get(f+1)[4]+","+gdsamp.get(f+1)[5];
				f++;
				c++;
			}
			FinalFile.add(st);
			f++;
			l++;
		}

	}
//method that write the summarize csv file of the directory
	public static void WriteCSV(ArrayList<String> list){
		int q=0;
		try {
			String str;
			FileWriter fw = new FileWriter("C:\\Users\\Bar&Almog\\Desktop\\matala00\\newCSV.csv");
			PrintWriter outs = new PrintWriter(fw);
			while(q<list.size()){
				str = list.get(q);
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
	
// returns the index of max negative int
	private static int FindMax(int[] arr, int l, int r){
		int maxind;
		while(arr[l]==1)
			l++;
		maxind=l;
		for(int i=l;i<arr.length&&i<r;i++)
			if(arr[i]>arr[maxind]&&arr[i]!=1)
				maxind=i;
		return maxind;
	}
	
//returns sum of raws in the file
	private static int RCtr(String fileName){
		int raws = 1;	
		try {
			FileReader nfr = new FileReader(fileName);
			BufferedReader nbr = new BufferedReader(nfr);
			nbr.readLine();
			String str = nbr.readLine();
			int index=0;
			index = str.indexOf(',');			
			while(index!=(-1)){
				str = str.substring(index+1);
				index = str.indexOf(',');
				raws++;
			}
			nbr.close();
			nfr.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
		return raws;
	}
//returns sum of lines in the file
	private static int LCtr(String fileName){
		int lines = 0;
		try {
			FileReader nfr = new FileReader(fileName);
			BufferedReader nbr = new BufferedReader(nfr);
			while(nbr.ready()){
				lines++;
				nbr.readLine();
			}
			nbr.close();
			nfr.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
		return lines;
	}

	// returns array of relevant csv files to work with
	public static File[] getDir(String s){
		File folder = new File(s);
		File[] listOfFiles = folder.listFiles();
		int index = 0;
		for (File file : listOfFiles) {
			if (file.getName().endsWith(".csv")&&file.isFile()) {
				index++;
			}
		}
		File[] ListOfGoods = new File[index];
		index = 0;
		for (File file : listOfFiles) {
			if (file.getName().endsWith(".csv")&&file.isFile()) {
				ListOfGoods[index] = file;
				System.out.println(file);
				index++;
			}
		}	
		return ListOfGoods;
	}

	public static void main(String[] args) {


//\\Users\\Bar&Almog\\Desktop\\matala00\\
		Scanner reader = new Scanner(System.in);
		System.out.println("Insert path to direcory: ");
		String s = (String)reader.nextLine();
		File[] listOfFiles = new File[1];
		boolean bool = true;
		while(bool){
			try{
				listOfFiles = getDir(s);
				bool = false;
			}
			catch(Exception e){
				System.out.print("Error reading file\n"+e+"\n");
				System.out.println("Insert path to direcory: ");
				s = (String)reader.nextLine();
				bool = true;
			}
		}
			DirToCsv(listOfFiles);

	}
}

























