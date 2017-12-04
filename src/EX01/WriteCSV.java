package EX01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteCSV {
	public static ArrayList<String> ListToWrite;
	/**
	 * Method that writes the summarize csv file of the directory.
	 * Theres no Junit for this class, since the ArrayList is representing sorted data from a verified file.
	 * @param list
	 */
	
	
		public static void Write(ArrayList<String> list){
			ListToWrite = list;
			int q=0;
			try {
				String str;
				FileWriter fw = new FileWriter("C:\\EX01\\newCSV.csv");
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
