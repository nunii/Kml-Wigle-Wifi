package EX01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteCSV {
	public static ArrayList<String> ListToWrite;
	//method that write the summarize csv file of the directory
		public WriteCSV(ArrayList<String> list){
			ListToWrite = list;
		}
		
		public void write(){
			int q=0;
			try {
				String str;
				FileWriter fw = new FileWriter("newCSV.csv");
				PrintWriter outs = new PrintWriter(fw);
				while(q<ListToWrite.size()){
					str = ListToWrite.get(q);
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
}
