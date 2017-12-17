package Algos;

import java.util.ArrayList;

import Data_classes.*;

public class Alg2 {

	private static final int power=2,norm=10000,minSig=3,noSig=-120,noSigDiff=100;
	private static final double sigDiff=0.4;
	private static double pi;
	
	public static double calcPI(Sample empty, Sample full){
		
		for(int i=0;i<empty.getMount();i++){
			if(full.ContainsMac(empty.getWifi(i).getMac()))
				pi *= wCalc(empty.getWifi(i).getSig(),full.FindMac(empty.getWifi(i).getMac()).getSig());
			else
				pi *= wCalc(empty.getWifi(i).getSig(),-120);
		}
		return pi;
	}
	
	private static double wCalc(int sig1,int sig2 ) {

		int diff=((sig2==noSig)? noSigDiff : Math.max((sig1-sig2), minSig));
		double w = norm/((Math.pow(diff, sigDiff))*(Math.pow(sig2, 2)));
		return w;
	}


}
