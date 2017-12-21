package Algos;

import static org.junit.Assert.*;

import org.junit.Test;

import Data_classes.Position;
import Data_classes.Wifi;

public class Alg1Test {

	@Test
	public void testMacNewPos() {
		Wifi w1,w2,w3;
		//String[] s1,s2,s3;
		w1 = new Wifi("12,bar,32.103,35.208,650,1,bar,1:1,1,-30".split(","),0);
		w2 = new Wifi("12,bar,32.105,35.205,660,1,bar,1:1,1,-80".split(","),0);
		w3 = new Wifi("12,bar,32.103,35.307,680,1,bar,1:1,1,-90".split(","),0);
		Position p1 = new Position("32.10322469","35.21645076","653.7864078");
		Position pos = new Position(Alg1.MacNewPos(w1, w2, w3));
		double dif = 0.00000001;
		double def = 0.0000001;
		if(Math.abs(p1.getLAT()-pos.getLAT())>dif||Math.abs(p1.getLON()-pos.getLON())>dif||Math.abs(p1.getALT()-pos.getALT())>def)
			fail("Alg1 or WeightedSum not good");
	}


}
