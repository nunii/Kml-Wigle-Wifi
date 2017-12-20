package EX01;


import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class NewCSV {

	/**
	 * @author Bar Janach, Amit Nuni.
	 * This class functions lets u make a new CSV file from an exported csv file from the app "WiGLE WiFi"
	 * The class is doing it by filtering 10best wifi signals of each record.
	 */

	static ArrayList<String> FinalFile = new ArrayList<>();

	private static void DirToCsv(File[] fileslist, String s){
		FinalFile.add("Time,ID,Lat,Lon,Alt,#WiFi networks,SSID1,MAC1,Frequncy1,Signal1,SSID2,MAC2,Frequncy2,Signal2,SSID3,MAC3,Frequncy3,Signal3,SSID4,MAC4,Frequncy4,Signal4,SSID5,MAC5,Frequncy5,Signal5,SSID6,MAC6,Frequncy6,Signal6,SSID7,MAC7,Frequncy7,Signal7,SSID8,MAC8,Frequncy8,Signal8,SSID9,MAC9,Frequncy9,Signal9,SSID10,MAC10,Frequncy10,Signal10");
		for(File i:fileslist){
			Best10(ReadCSV.CSVtoMatrix(i.getPath()+"newCSV.csv"));
		}
		WriteCSV.Write(FinalFile, s);
	}

	/**
	 * Takes only the relevant sample lines into a new Sample-matrix
	 * @param mtx
	 */
	private static void Best10(String[][] mtx)	{
		if(mtx == null)
			return;
		ArrayList<String[]> samp = new ArrayList<>();
		List<Integer> sum = new ArrayList<>();
		List<String> time = new ArrayList<>();
		int[] db = new int[mtx.length-2];
		int[] ar;
		int f=0,l=0,c;

		for(int k=2;k<mtx.length;k++)
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
				samp.add(mtx[ar[c]+2]);
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
			st = samp.get(f)[3]+","+mtx[0][2].substring(6)+","+samp.get(f)[6]+","+samp.get(f)[7]+","+samp.get(f)[8]+","+sum.get(l-1)+","+samp.get(f)[1]+","+samp.get(f)[0]+","+samp.get(f)[4]+","+samp.get(f)[5];
			c=0;
			while(c<sum.get(l-1)-1){
				st+=","+samp.get(f+1)[1]+","+samp.get(f+1)[0]+","+samp.get(f+1)[4]+","+samp.get(f+1)[5];
				f++;
				c++;
			}
			FinalFile.add(st);
			f++;
			l++;
		}

	}


	/**
	 *  Returns the index of max negative int
	 * @param arr
	 * @param l
	 * @param r
	 * @return the index of max negative int
	 */
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




	/**
	 *  returns array of relevant csv files to work with
	 * @param s
	 * @return array of relevant csv files to work with
	 */
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
				index++;
			}
		}	
		return ListOfGoods;
	}
	/**
	 * Asks for a path to directory and starts activating the other functions of this class.
	 */
	public static String start() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Insert path to direcory: ");
		String s = (String)reader.nextLine();
		if(!s.endsWith("\\"))
			s+="\\";
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
		DirToCsv(listOfFiles, s);
		reader.close();

		return s;
	}
}

