package Data_classes;

public class Wifi implements Comparable<Wifi> {
	/**
	 * @author Bar Janach, Amit Nuni.
	 * This class represents Wifi signals which has been recorded at the same time.
	 */
	String freq,ssid,mac;
	int  sig, ind;
	Time time;
	Position pos;
	
	/**
	 * The constructor calculates exactly where are the Wifi signals name at the CSV file.
	 * @param s
	 */
	public Wifi(String[] s,int ind){
		this.ind = ind;
		ssid = s[(ind*4)+6];
		mac = s[(ind*4)+7];
		freq = (s[(ind*4)+8]);
		sig = (int)(Double.parseDouble(s[(ind*4)+9]));
		time = new Time(s[0]);
		pos = new Position(s[2],s[3],s[4]);
	}

	public Wifi(Wifi w){
		this.ind = w.getInd();
		ssid = w.getSsid();
		mac = w.getMac();
		freq = w.getFreq();
		sig = w.getSig();
		time = w.getTime();
		pos = w.getPos();
	}
	
	public String getSsid() {
		return ssid;
	}

	public String getMac() {
		return mac;
	}

	public String getFreq() {
		return freq;
	}

	public int getSig() {
		return sig;
	}

	public int getInd() {
		return ind;
	}

	public Time getTime() {
		return time;
	}

	public Position getPos() {
		return pos;
	}
	
	public void setPos(Position p){
		pos = new Position(p);
	}
	
	public String FulltoString(){
		return time.toString()+ ","+ pos.toString()+ ","+
				ssid+ ","+ mac+ ","+ freq+ ","+ sig;
	}

	public String toString(){
		return ssid+ ","+ mac+ ","+ freq+ ","+ sig;
	}
	
	@Override
	public int compareTo(Wifi w) {
		return ((-1)*(this.sig-w.getSig()));
	}

	

}
