package ex02;

import java.util.ArrayList;

import Algos.Alg2;
import Data_classes.Position;
import Data_classes.Samples;

public class MyPos {


	private ArrayList<Double> Pis = new ArrayList<Double>();

	public static void fillPoses(Samples empty, Samples full,String path) {
		Position pos;
		for(int i =0;i<empty.length();i++) {
			//for(int j=0;j<full.length();j++) {
			pos = (Alg2.calcPos(empty.getSample(i),full));
			//System.out.println(pos.toString());
			empty.getSample(i).setPosition(pos);
			//System.out.println(empty.getSample(i).getPosition().toString());
			//}
		}
		empty.toCSV(path);
		/*
				int k=0;
				boolean contain = false;
				while(k < empty.getSample(i).getMount()&&!contain){
					if(full.getSample(j).ContainsMac(empty.getSample(i).getWifi(k).getMac()))
						contain = true;
					k++;
				}
				if(contain)
					Pis.add(Alg2.calcPI(empty.getSample(i),full.getSample(j)));
				else
					Pis.add(0.0);
			}
		 */


	}

}
