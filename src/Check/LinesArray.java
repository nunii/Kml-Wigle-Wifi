

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinesArray {
	private ArrayList<Line> file = new ArrayList<>();

	public LinesArray(String s){
		try {
			FileReader fr = new FileReader(s);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			if(str==null||!str.startsWith("Time,ID,Lat,Lon,Alt,#WiFi networks,SSID1,MAC1,Frequncy1,Signal1,SSID2,MAC2,Frequncy2,Signal2,SSID3,MAC3,Frequncy3,Signal3,SSID4,MAC4,Frequncy4,Signal4,SSID5,MAC5,Frequncy5,Signal5,SSID6,MAC6,Frequncy6,Signal6,SSID7,MAC7,Frequncy7,Signal7,SSID8,MAC8,Frequncy8,Signal8,SSID9,MAC9,Frequncy9,Signal9,SSID10,MAC10,Frequncy10,Signal10"))
				throw new IOException(s);
			while(str!=null){
				file.add(new Line(str.split(",")));
				str = br.readLine();
			}
			br.close();
			fr.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}	}

	public boolean contains(String name){
		
		for (int i = 0; i < file.size(); i++)
			if(file.get(i).Contains(name))
				return true;
		return false;
	}

	public Line getLine(int d){
		return file.get(d);
	}
	
	public String getName(int d){
		return file.get(d).getName();
	}

	public int getInd(String name, int line){
		return file.get(line).getIndex(name);
	}
	
	public String getPoint(int d){
		return file.get(d).getPoint();
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

	public int length(){
		return file.size();
	}
}
