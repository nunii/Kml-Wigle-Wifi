package Data_classes;
import java.util.Arrays;

public class Wifi implements Comparable<Wifi> {
	/**
	 * @author Bar Janach, Amit Nuni.
	 * This class represents Wifi signals which has been recorded at the same time.
	 */
	String ssid,mac;
	int freq, sig, ind;
	Time time;
	Position pos;
	
	/**
	 * The constructor calculates exactly where are the Wifi signals name at the CSV file.
	 * @param s
	 */
	public Wifi(String[] s,int ind){
		//wifs = new String[Integer.parseInt(s[5])];
		this.ind = ind;
		ssid = s[(ind*4)+6];
		mac = s[(ind*4)+7];
		freq = Integer.parseInt(s[(ind*4)+8]);
		sig = Integer.parseInt(s[(ind*4)+9]);
		time = new Time(s[0]);
		pos = new Position(s[2],s[3],s[4]);
	}

	public String getSsid() {
		return ssid;
	}

	public String getMac() {
		return mac;
	}

	public int getFreq() {
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

	@Override
	public int compareTo(Wifi w) {
		return (this.sig-w.getSig());
	}

	

}
