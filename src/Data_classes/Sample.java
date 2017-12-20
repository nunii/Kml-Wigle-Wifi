package Data_classes;

import java.util.Arrays;

public class Sample {
	/**
	 *  @author Bar Janah, Amit nuni.
	 * This class takes one line from the CSV file, which is actually taking a one cell from the Samples ArrayList.
	 */

	private String[] samp;
	//private MacAddress addr;
	private Position pos;
	private Time time;
	private Wifi[] wifies; 

	/**
	 * The constructor. Takes a Line from the CSV file which presented as "Sample", and divides the line into parameters.
	 * @param s
	 */
	public Sample(String[] s){
		samp = s;
		//	addr = new MacAddress(s);
		time = new Time(s[0]);
		pos = new Position(s[2],s[3],s[4]);
		wifies = new Wifi[Integer.parseInt(s[5])];
		for (int i = 0; i < wifies.length; i++) {
			wifies[i] = new Wifi(s,i);
		}
	}

	public boolean Contains(String s){
		boolean b = false;
		int i=0;
		while(i<wifies.length) {
			if(wifies[i].getSsid().equals(s))
				return !b;
			i++;
		}
		return b;
	}

	public boolean ContainsMac(String s){
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

	public String getMacSig(){
		return samp[6];
	}

	public String getName(){
		return samp[6];
	}

	public int getIndex(String s){
		int ind = 0;
		if(!this.Contains(s)){
			return -1;
		}
		while(!samp[ind].equals(s)){
			ind++;
		}
		return ind;
	}

	public Position getPos(){
		return pos;
	}

	public String getMac(){
		return samp[7];
	}

	public String getMac(String s){
		return samp[this.getIndex(s)+1];
	}

	public String getFreq(){
		return samp[8];
	}

	public String getFreq(String s){
		return samp[this.getIndex(s)+1];
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
	
	public String toString(){
		return Arrays.toString(samp);
	}
}
