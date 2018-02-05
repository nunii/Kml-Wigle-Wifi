package main.java.algos_practic;

import java.util.ArrayList;

import main.java.algos.Alg2;
import main.java.data_classes.Position;
import main.java.data_classes.Samples;

public class MyPos {

	/**
	 * @author Amit Nuni, Bar Janach
	 * this class is used for calculating my position by the 2nd algorithm.
	 */

	

	public static void fillPoses(Samples empty, Samples full,String path) {
		Position pos;
		for(int i = 0;i<empty.length();i++) {
			pos = (Alg2.calcPos(empty.getSample(i),full));
			empty.getSample(i).setPosition(pos);
		}
		empty.toCSV(path);

	}

}
