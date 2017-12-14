package EX01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Algos.Alg1;
import Data_classes.Position;
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
				wifiAr.add(samps1.getSample(i).FindMac(mac));
		
		Collections.sort(wifiAr);
		
		System.out.println(wifiAr.get(0).toString()+"\n"+wifiAr.get(1).toString()+"\n"+wifiAr.get(2).toString());
		
		Position macPos = new Position(Alg1.MacNewPos(wifiAr.get(0),wifiAr.get(1),wifiAr.get(2)));
		System.out.println(macPos.toString());
		//Alg1 a = new Alg1(wifiAr.get(0),wifiAr.get(1),wifiAr.get(2));
	}
	
}
