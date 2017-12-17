package EX01;

import java.util.ArrayList;

import Algos.Alg2;
import Data_classes.Samples;

public class MyPos {


	private ArrayList<Double> Pis = new ArrayList<Double>();


	public void calcPos(Samples empty, Samples full) {
		
		for(int i =0;i<empty.length();i++) {
			for(int j=0;j<full.length();j++) {
				
				int k=0;
				boolean contain = false;
				while(k < empty.getSample(i).getMount()&&!contain){
					if(full.getSample(j).ContainsMac(empty.getSample(i).getWifi(k).getMac()))
						contain = true;
					k++;
				}
				if(contain)
					Pis.add(Alg2.calcPI(empty.getSample(i),full.getSample(j)));
			}

		}

	}
	
}
