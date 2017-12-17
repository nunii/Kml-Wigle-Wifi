package Algos;

import java.util.ArrayList;

import Data_classes.*;

public class Alg2 {
	private final int power=2,norm=10000,minSig=3,noSig=-120,noSigDiff=100;
	private final double sigDiff=0.4;
	private double pi;
	private ArrayList<Double> Pis;


	public void calcPos(Samples empty, Samples full) {
		// כרגע הקוד יוצא מנקודת הנחה שהוא בודק רק כתובת מאק אחת מתוך המלא.
		// נדרש תיקון שיעבור על "עד 3 מאקים" במידה ויש.
		// אפשרות אחת להעביר את הקובץ "הריק" סינון שייתן עד 3כתובות מאק.
		//אפשרות שניה פשוט להכניס תנאי בתוך הלולאת פור השניה תנאי שייבדוק את כל המאקים בריק לעומת כל המקאים במלא.

		for(int i =0;i<empty.length();i++) {
			for(int j=0;j<full.length();j++) {
				// כאן אמור לקרות החישוב של המשקל של כל כתובת מאק
				//ולאחר מכן שיכלול כל המשקלים לכדי דמיון שייכנס לרשימת דמיונות שלנו, שמהם ניקח את השלושה המקסימלים.
				// כרגע ישנו חישוב של כתובת מק אחת

				if(empty.getSample(i).getMac().contains((CharSequence) full.getSample(j))) {
					Pis.add(wCalc(Integer.parseInt(empty.getSample(i).getMacSig()), Integer.parseInt(full.getSample(j).getMacSig())));
				}
			}

		}


	}

	private double wCalc(int sig1,int sig2 ) {

		int diff=((sig2==noSig)? noSigDiff : Math.max((sig1-sig2), minSig));
		double w = norm/((Math.pow(diff, sigDiff))*(Math.pow(sig2, 2)));
		return w;
	}


}
