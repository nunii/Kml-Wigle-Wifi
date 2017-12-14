package Algos;

import Data_classes.Position;
import Data_classes.Wifi;

public class Alg1 {
	
	private static Wifi m1,m2,m3;
	private static double w1,w2,w3;
	private static Position p1,p2,p3;
	
	/*public Alg1(Wifi w1,Wifi w2,Wifi w3){
		m1 = new Wifi(w1);
		m2 = new Wifi(w2);
		m3 = new Wifi(w3);
	}*/
	
	public static Position MacNewPos(Wifi w1,Wifi w2,Wifi w3){
		
		m1 = new Wifi(w1);
		m2 = new Wifi(w2);
		m3 = new Wifi(w3);
		
		calcWeight();
		calcNewPoses();
		return calcMacPos();
	}
	
	private static void calcWeight(){
		//w1 = 1/(Math.pow(m1.getSig(), 2));
		w1=1.0/((m1.getSig()*m1.getSig()));
		w2=1.0/((m2.getSig()*m2.getSig()));
		w3=1.0/((m3.getSig()*m3.getSig()));
	//	w2 = 1/(Math.pow(m2.getSig(), 2));
		//w3 = 1/(Math.pow(m3.getSig(), 2));
	}
	
	private static void calcNewPoses(){
		String Lat = Double.toString(m1.getPos().getLAT()*w1);
		String Lon = Double.toString(m1.getPos().getLON()*w1);
		String Alt = Double.toString(m1.getPos().getALT()*w1);
		p1 = new Position(Lat,Lon,Alt);

		Lat = Double.toString(m2.getPos().getLAT()*w2);
		Lon = Double.toString(m2.getPos().getLON()*w2);
		Alt = Double.toString(m2.getPos().getALT()*w2);
		p2 = new Position(Lat,Lon,Alt);

		Lat = Double.toString(m3.getPos().getLAT()*w3);
		Lon = Double.toString(m3.getPos().getLON()*w3);
		Alt = Double.toString(m3.getPos().getALT()*w3);
		p3 = new Position(Lat,Lon,Alt);
	}
	
	
	private static Position calcMacPos(){
		double sumlat, sumlon, sumalt, sumw;
	
			sumlat = p1.getLAT()+p2.getLAT()+p3.getLAT();
			sumlon = p1.getLON()+p2.getLON()+p3.getLON();
			sumalt = p1.getALT()+p2.getALT()+p3.getALT();
			sumw = w1+w2+w3;
			String Lat = Double.toString(sumlat/sumw);
			String Lon = Double.toString(sumlon/sumw);
			String Alt = Double.toString(sumalt/sumw);
			
			return new Position(Lat,Lon,Alt);
			
	}
	
}
