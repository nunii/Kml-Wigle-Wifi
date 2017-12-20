package ex02;

import javax.swing.plaf.synth.SynthSpinnerUI;

import Data_classes.Position;
import Data_classes.Wifi;

public class WeightedSum {

	private static Position p1,p2,p3;
	private static double w1,w2,w3;
	private static int c =0;

	public static Position calcNewPos(double a,double b,double c,Position pos1,Position pos2,Position pos3){
		p1 = new Position(pos1);
		p2 = new Position(pos2);
		p3 = new Position(pos3);
		
		w1 = a;
		w2 = b;
		w3 = c;

//		System.out.println("Weights: "+w1+","+w2+","+w3);
//		System.out.println("Poses: "+p1+"\n"+p2+"\n"+p3);
//		
		
		String Lat = Double.toString(p1.getLAT()*w1);
		String Lon = Double.toString(p1.getLON()*w1);
		String Alt = Double.toString(p1.getALT()*w1);
		p1 = new Position(Lat,Lon,Alt);

		Lat = Double.toString(p2.getLAT()*w2);
		Lon = Double.toString(p2.getLON()*w2);
		Alt = Double.toString(p2.getALT()*w2);
		p2 = new Position(Lat,Lon,Alt);

		Lat = Double.toString(p3.getLAT()*w3);
		Lon = Double.toString(p3.getLON()*w3);
		Alt = Double.toString(p3.getALT()*w3);
		p3 = new Position(Lat,Lon,Alt);

		//System.out.println(p1+"\n"+p2+"\n"+p3);
		
		return calcPos();
	}


	private static Position calcPos(){
		double sumlat, sumlon, sumalt, sumw;

		sumlat = p1.getLAT()+p2.getLAT()+p3.getLAT();
		sumlon = p1.getLON()+p2.getLON()+p3.getLON();
		sumalt = p1.getALT()+p2.getALT()+p3.getALT();
		sumw = w1+w2+w3;
		String Lat = Double.toString(sumlat/sumw);
		String Lon = Double.toString(sumlon/sumw);
		String Alt = Double.toString(sumalt/sumw);
		
		Position pos = new Position(Lat,Lon,Alt); 
		c++;
		//System.out.println(pos.toString()+" count: "+c);
		return pos;

	}

}
