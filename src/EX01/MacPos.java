package EX01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Data_classes.Samples;
import Data_classes.Wifi;
import Filter.*;

public class MacPos {

	public static void main(String[] args) {
		String mac;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter mac address to find it's position:");
		mac = sc.nextLine();
		List<Wifi> wifiAr = new ArrayList<Wifi>();
		Samples samps = new Samples("newCSV.csv");
		Filter wf = new WifiFilter(mac);
		Samples samps1 = samps.Filter(wf);
		
		for (int i = 0; i < samps1.length(); i++) 
			if(samps1.getSample(i).Contains(mac))
				wifiAr.add(samps.getSample(i).FindMac(mac));
		
		Collections.sort(wifiAr);
		
		//Position macPos = new Position(alg1(wifiAr.g))
		
		
	}
	
}
