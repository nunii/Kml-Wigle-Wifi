package main.java.data_classes;

import java.util.ArrayList;
import java.util.Collections;

import main.java.io_pack.WriteCSV;

public class MacList extends ArrayList<Wifi> {

	
	/**
	 * @author Bar Janach, Amit Nuni
	 * Class used for making a filtered wifiList which removes duplicates.
	 * It also writes the list to a csv file.
	 * @param s
	 */
	private static Samples samps;
	public MacList(Samples s){
		samps = new Samples(s);
		addList();
	}
	
	@Override
	public boolean add(Wifi f){
		if(checkDuplic(f.getMac()))
			super.add(f);
		return true;
	}
	
	@Override
	public void add(int index, Wifi f){
		if(checkDuplic(f.getMac()))
			super.add(index,f);
	}
	
	private void addList(){
		int ind;
		Sample samp;
		for (int i = 0; i < samps.length(); i++) {
			samp = samps.getSample(i);
			ind = samp.getMount();
			for (int j = 0; j < ind; j++){
				if(checkDuplic(samp.getWifi(j).getMac())){
					this.add(samp.getWifi(j));
				}
			}
		}
	}
	
	private boolean checkDuplic(String newMac){
		int ind = 0;
		while(ind<this.size()) {
			if(this.get(ind).getMac().equals(newMac)){
				return false;
			}
			ind++;
		}
		return true;
	}
	
	public void syso(){
		for(int i = 0;i<this.size();i++)
			System.out.println(this.get(i).getMac());
	}
	
	public void toCSVfile(String s){
		ArrayList<String> csv = new ArrayList<String>();
		for (int i = 0; i < this.size(); i++) {
			csv.add(this.get(i).FulltoString());
		}
		WriteCSV.Write(csv, s);
	}
	
}
