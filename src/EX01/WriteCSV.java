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


	public static void Write(ArrayList<String> list, String s){
		ListToWrite.add("Time,ID,Lat,Lon,Alt,#WiFi networks,SSID1,MAC1,Frequncy1,Signal1,SSID2,MAC2,Frequncy2,Signal2,SSID3,MAC3,Frequncy3,Signal3,SSID4,MAC4,Frequncy4,Signal4,SSID5,MAC5,Frequncy5,Signal5,SSID6,MAC6,Frequncy6,Signal6,SSID7,MAC7,Frequncy7,Signal7,SSID8,MAC8,Frequncy8,Signal8,SSID9,MAC9,Frequncy9,Signal9,SSID10,MAC10,Frequncy10,Signal10");
		ListToWrite.addAll(list);
		int q=0;
		try {
			String str;
			FileWriter fw = new FileWriter(s);
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
