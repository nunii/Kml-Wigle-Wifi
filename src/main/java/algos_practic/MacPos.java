package main.java.algos_practic;

import main.java.filters.Filter;
import main.java.filters.WifiFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.java.algos.Alg1;
import main.java.data_classes.MacList;
import main.java.data_classes.Position;
import main.java.data_classes.Samples;
import main.java.data_classes.Wifi;


public class MacPos {

	
	/**
	 * @author Amit Nuni, Bar Janach
	 * this class is used for calculating macs positions.
	 */
	
	private static Samples samps;

	/**
	 * makes a MACList from the given sample and makes a new file in its path.
	 * @param s
	 * @param path
	 */
	public static void fillPos(Samples s, String path){
		samps = new Samples(s);
		MacList ml = new MacList(samps);
		//ml.syso();
		for (int i = 0; i < ml.size(); i++) {
			ml.get(i).setPos(makePos(ml.get(i).getMac()));
		}
		
		ml.toCSVfile(path);
	}
/**
 * for each wifi from the MACList, changes the position by the 2nd algorithm.
 * @param mac
 * @return
 */
	private static Position makePos(String mac) {

		Position macPos;
		List<Wifi> wifiAr = new ArrayList<Wifi>();
		Filter wf = new WifiFilter(mac);
		Samples samps1 = samps.Filter(wf);

		for(int i = 0; i < samps1.length(); i++) 
			wifiAr.add(samps1.getSample(i).FindMac(mac));
		
		Collections.sort(wifiAr);

		if(wifiAr.size()>2)
			macPos = new Position(Alg1.MacNewPos(wifiAr.get(0),wifiAr.get(1),wifiAr.get(2)));
		else 
			macPos = new Position(wifiAr.get(0).getPos());

		return macPos;

	}
	
	public static Position makePos(Samples s, String mac) {

		Position macPos;
		List<Wifi> wifiAr = new ArrayList<Wifi>();
		Filter wf = new WifiFilter(mac);
		Samples samps1 = s.Filter(wf);

		for(int i = 0; i < samps1.length(); i++) 
			wifiAr.add(samps1.getSample(i).FindMac(mac));
		
		Collections.sort(wifiAr);

		if(wifiAr.size()>2)
			macPos = new Position(Alg1.MacNewPos(wifiAr.get(0),wifiAr.get(1),wifiAr.get(2)));
		else 
			macPos = new Position(wifiAr.get(0).getPos());

		return macPos;

	}
}
