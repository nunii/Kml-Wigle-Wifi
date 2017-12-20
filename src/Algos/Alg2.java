package Algos;

import java.util.ArrayList;
import java.util.Collections;

import Data_classes.*;
import ex02.WeightedSum;

public class Alg2 {

	private static final int power=2,norm=10000,minSig=3,noSig=-120,noSigDiff=100;
	private static final double sigDiff=0.4;
	private static double pi;

	public static Position calcPos(Sample empty, Samples full){

		ArrayList<Double> Pis = new ArrayList<Double>();
		int cnt = 0;
		for (int i = 0; i < full.length(); i++) {
			int k=0;
			boolean contain = false;
			while(k < empty.getMount()&&!contain){
				if(full.getSample(i).ContainsMac(empty.getWifi(k).getMac())){
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
		//System.out.println(pos);
		return pos;//WeightedSum.calcNewPos(arr[0],arr[1],arr[2],p1,p2,p3);

	}

	private static double calcPI(Sample empty, Sample full){

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

	private static int FindMax(ArrayList<Double> pis){
		int maxind = 0;
		for(int i = 1;i < pis.size();i++)
			if(pis.get(i)>pis.get(maxind))
				maxind=i;
		return maxind;
	}

}
