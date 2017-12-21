package ex02;

import Algos.Alg2;
import Data_classes.Sample;
import Data_classes.Samples;

public class Rashi2 {
	
	
	/**
	 * @author Amit Nuni, Bar Janach
	 * This is the executing class of Ex2
	 */

	public static void main(String[] args) {
		String s = "Ex2\\testing\\_comb_all_BM2_.csv";
		Samples full = new Samples(s);
		MacPos.fillPos(full,"Ex2\\testing\\output\\Alg1_Bar-n-Amit_BM2.csv");
		
		String e =  "Ex2\\testing\\_comb_no_gps_ts1.csv";
		Samples empt = new Samples(e);
		MyPos.fillPoses(empt, full, "Ex2\\testing\\output\\Alg1_Bar-n-Amit_BM2-ts1.csv");
		
		Sample sis = new Sample("1,1,1,1,1,3,1,1,1,-50,1,1,1,-70,1,1,1,-90".split(","));
		Sample sos = new Sample("1,1,1,1,1,3,1,1,1,-62,1,1,1,-79,1,1,1,-71".split(","));
		
	}

}
