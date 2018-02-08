package test.java.Algos;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import main.java.algos.*;
import main.java.algos_practic.MyPos;
import main.java.data_classes.Position;
import main.java.data_classes.Sample;
import main.java.data_classes.Samples;

public class Alg2Test {

	@Test
	public void testCalcPos() {
		String e =  "Ex2\\testing\\_comb_no_gps_ts1.csv";
		Samples empt = new Samples(e);
		String s = "Ex2\\testing\\_comb_all_BM2_.csv";
		Samples full = new Samples(s);
		try{
		MyPos.fillPoses(empt, full, "Ex2\\testing\\output\\Alg1_Bar-n-Amit_BM2-ts1.csv");
		}
		catch(Exception ex) {
			System.out.print("Error reading files\n" + ex);
		}
		if(empt.getSample(0).getPosition()!=null)
			System.out.println("CalcPos went good");
		else
			fail("Algo 2 Position calc, not good");
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
