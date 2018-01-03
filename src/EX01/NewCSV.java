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

	static ArrayList<String> FinalFile;

	private static ArrayList<String> DirToCsv(File[] fileslist, String s){
		FinalFile = new ArrayList<>();
		for(File i:fileslist){
			FinalFile.addAll(Best10(ReadCSV.CSVtoMatrix(i.getPath())));
		}
		return FinalFile;
	}

	/**
	 * Takes only the relevant sample lines into a new Sample-matrix
	 * @param mtx
	 */
	public static ArrayList<String> Best10(String[][] mtx)	{
		ArrayList<String> tempFile = new ArrayList<String>();
		if(mtx == null)
			return tempFile;
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
			tempFile.add(st);
			f++;
			l++;
		}
		return tempFile;
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
	public static ArrayList<String> start(String s) {
		/*Scanner reader = new Scanner(System.in);
		System.out.println("Insert path to direcory: ");
		String s = (String)reader.nextLine();*/
		if(!s.endsWith("\\"))
			s+="\\";
		File[] listOfFiles = new File[1];
		listOfFiles = getDir(s);
/*
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
		*/
		return DirToCsv(listOfFiles, s);
		//reader.close();
		//WriteCSV.Write(FinalFile, s+"newCSV.csv");

	
	}
}

