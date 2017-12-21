package Algos;

import static org.junit.Assert.*;

import org.junit.Test;

import Data_classes.Sample;

public class Alg2Test {

	@Test
	public void testCalcPos() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcPI() {
		Sample sis = new Sample("1,1,1,1,1,3,1,aa,1,-50,1,bb,1,-70,1,cc,1,-90".split(","));
		Sample sos = new Sample("1,1,1,1,1,3,1,aa,1,-62,1,bb,1,-79,1,cc,1,-71".split(","));
		System.out.println(Alg2.calcPI(sis, sos));
		if(!(Math.abs(Alg2.calcPI(sis, sos)-0.476988545)<0.000000001))
			fail("Not yet implemented");
	}

}
