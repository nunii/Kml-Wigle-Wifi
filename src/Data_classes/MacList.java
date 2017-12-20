package Data_classes;

import java.util.ArrayList;
import java.util.Collections;

import EX01.WriteCSV;

public class MacList extends ArrayList<Wifi> {

	public MacList(Samples s){
		addList(s);
	}
	
	private void addList(Samples s){
		int ind;
		Sample samp;
		for (int i = 0; i < s.length(); i++) {
			samp = s.getSample(i);
			ind = samp.getMount();
			for (int j = 0; j < ind; j++)
				this.add(samp.getWifi(j));
		}
		Collections.sort(this);
		removeDuplic();
	}
	
	private void removeDuplic(){
		int ind = 0;
		while(ind<this.size()-1) {
			if(this.get(ind)==this.get(ind+1))
				this.remove(ind+1);
			else
				ind++;
		}
	}
	
	public void toCSVfile(String s){
		ArrayList<String> csv = new ArrayList<String>();
		for (int i = 0; i < this.size(); i++) {
			csv.add(this.get(i).toString());
		}
		WriteCSV.Write(csv, s);
	}
	
}
