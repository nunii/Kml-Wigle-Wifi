package Algos;

import org.junit.Test;

import Data_classes.Position;
import Data_classes.Wifi;

public class Alg1 {

	/**
	 * @author Amit Nuni, Bar Janach
	 * This class implements the first algorithm 
	 * It takes 3 wifi records and calculates the recorder position. 
	 */
	
	 

	private static Wifi m1,m2,m3;
	private static double wt1,wt2,wt3;


/**
 * This function returns the position of the recorder
 * @param w1
 * @param w2
 * @param w3
 * @return
 */
	public static Position MacNewPos(Wifi w1,Wifi w2,Wifi w3){

		m1 = new Wifi(w1);
		m2 = new Wifi(w2);
		m3 = new Wifi(w3);

		calcWeight();
		Position pos = new Position(WeightedSum.calcNewPos(wt1,wt2,wt3,m1.getPos(),m2.getPos(),m3.getPos()));
		return pos;
	}
/**
 * This function calculates the weight of each signal.
 */
	private static void calcWeight(){
		wt1=1.0/((m1.getSig()*m1.getSig()));
		wt2=1.0/((m2.getSig()*m2.getSig()));
		wt3=1.0/((m3.getSig()*m3.getSig()));
	}
	
	/*@Test
	public void Test() {
		
		double t1,t2,t3;
		
				
	}*/

}
