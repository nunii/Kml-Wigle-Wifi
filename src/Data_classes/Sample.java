package Data_classes;

import java.util.Arrays;

public class Sample {
	/**
	 *  @author Bar Janah, Amit nuni.
	 * This class takes one line from the CSV file, which is actually taking a one cell from the Samples ArrayList.
	 */

	//private String[] samp;
	//private MacAddress addr;
	private Position pos;
	private Time time;
	private Wifi[] wifies;
	private String ID;

	/**
	 * The constructor. Takes a Line from the CSV file which presented as "Sample", and divides the line into parameters.
	 * @param s
	 */
	public Sample(String[] s){
		//samp = s;
		//	addr = new MacAddress(s);
		time = new Time(s[0]);
		ID = s[1];
		pos = new Position(s[2],s[3],s[4]);
		wifies = new Wifi[Integer.parseInt(s[5])];
		for (int i = 0; i < wifies.length; i++) {
			wifies[i] = new Wifi(s,i);
		}
	}

	public Sample(Sample s){
		//samp = s;
		//	addr = new MacAddress(s);
		time = new Time(s.getDate());
		ID = s.getID();
		pos = new Position(s.getPosition());
		wifies = new Wifi[(s.getMount())];
		for (int i = 0; i < wifies.length; i++) {
			wifies[i] = new Wifi(s.getWifi(i));
		}
	}

	public boolean Contains(String s){
		boolean b = false;
		int i=0;
		while(i<wifies.length) {
			if(wifies[i].getMac().equals(s))
				return !b;
			i++;
		}
		return b;
	}

	public Wifi FindMac(String s){
		int i=0;
		while(i<wifies.length) {
			if(wifies[i].getMac().equals(s))
				return wifies[i];
			i++;
		}
		return null;
	}

	public int getMount(){
		return wifies.length;
	}

	public String getMacSig(int ind){
		return "wifies[ind].getSig()";
	}

	public String getName(int ind){
		return wifies[ind].getSsid();
	}

	public int getIndex(String s){
		int ind = 0;
		if(!this.Contains(s)){
			return -1;
		}
		while(wifies[ind].getMac().equals(s)){
			ind++;
		}
		return ind;
	}

	public String getMac(int ind){
		return wifies[ind].getMac();
	}

	public String getFreq(int ind){
		return "wifies[ind].getFreq()";
	}

	public String getDate(){
		return time.toString();
	}

	public Position getPosition() {
		return pos;
	}

	public void setPosition(Position p){
		pos = new Position(p);
	}

	public String getTimestamp() {
		return time.getTimestamp();
	}
	
	public Wifi getWifi(int ind) {
		return wifies[ind];
	}
	
	public String getID(){
		return ID;
	}
	
	public String toString(){
		String s = time+","+ID+","+pos+",";
		for(int i=0;i<wifies.length;i++){
			s+=","+wifies[i].toString();
		}
		return s;
	}
}
