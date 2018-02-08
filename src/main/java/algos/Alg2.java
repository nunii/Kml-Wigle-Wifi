package main.java.algos;

import java.util.ArrayList;


import main.java.data_classes.*;

public class Alg2 {

	/**
	 * @author Amit Nuni, Bar Janach
	 * This class implements the 2nd algorithm.
	 */
	
	
	/**
	 * @param minSig The minimum signal value possible.
	 * @param noSig	Default	signal value if there is no record.
	 * @param noSigDiff	Default diff value if there is no record.
	 */
	private static final int normal=10000,minSig=3,noSig=-120,noSigDiff=100;
	private static final double sigDiff=0.4;

	/**
	 * 
	 * @param empty The sample with the missing position. 
	 * @param full The sample with the correct positions.
	 * @return returns our calculated locations.
	 */
	
	
	/**
	 * The main funciton of alg2
	 * @param empty
	 * @param full
	 * @return
	 */
	public static Position calcPos(Sample empty, Samples full){

		
	
		ArrayList<Double> Pis = new ArrayList<Double>();
		int cnt = 0;
		for (int i = 0; i < full.length(); i++) {
			int k=0;
			boolean contain = false;
			while(k < empty.getMount()&&!contain){
				if(full.getSample(i).Contains(empty.getWifi(k).getMac())){
					contain = true;
					cnt++;
				}
				k++;
			}
			if(contain)
				Pis.add(calcPI(empty,full.getSample(i)));
			else
				Pis.add(0.0);
		}
		if(cnt<1)
			return new Position("0","0","0");
		double[] arr = new double[3];
		int[] ind = new int[3];
		for (int i = 0; i < 3; i++) {
			ind[i] = FindMax(Pis);
			arr[i] = Pis.get(ind[i]);
			Pis.set(ind[i], -1.0);
		}
		Position p1,p2,p3;
		p1 = full.getSample(ind[0]).getPosition();
		p2 = full.getSample(ind[1]).getPosition();
		p3 = full.getSample(ind[2]).getPosition();
		Position pos = new Position(WeightedSum.calcNewPos(arr[0],arr[1],arr[2],p1,p2,p3));
		return pos;

	}


	/**
	 * calculates the pi
	 * @param empty
	 * @param full
	 * @return
	 */
	public static double calcPI(Sample empty, Sample full){
		
		double pi=1;
	
		for(int i=0;i<empty.getMount();i++){
			if(full.Contains(empty.getWifi(i).getMac()))
				pi *= wCalc(empty.getWifi(i).getSig(),full.FindMac(empty.getWifi(i).getMac()).getSig());
			else
				pi *= wCalc(empty.getWifi(i).getSig(),-120);
		}
		return pi;
	}
/**
 * weight calculating
 * @param sig1
 * @param sig2
 * @return
 */
	private static double wCalc(int sig1,int sig2 ) {

		int diff = ((sig2==noSig)? noSigDiff : Math.max(Math.abs((sig1-sig2)), minSig));
		double w = normal/((Math.pow(diff, sigDiff))*sig1*sig1);
		return w;
	}
 /**
  * Finds the max pi
  * @param pis
  * @return
  */
	private static int FindMax(ArrayList<Double> pis){
		int maxind = 0;
		for(int i = 1;i < pis.size();i++)
			if(pis.get(i)>pis.get(maxind))
				maxind=i;
		return maxind;
	}

}
