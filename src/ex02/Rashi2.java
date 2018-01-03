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
		Samples full = new Samples(args[0]);
		MacPos.fillPos(full,"Ex2\\testing\\output\\Alg1_Bar-n-Amit_BM2.csv");
		
		String e =  "Ex2\\testing\\_comb_no_gps_ts1.csv";
		Samples empt = new Samples(e);
		MyPos.fillPoses(empt, full, "Ex2\\testing\\output\\Alg1_Bar-n-Amit_BM2-ts1.csv");
		
		
	}

}
