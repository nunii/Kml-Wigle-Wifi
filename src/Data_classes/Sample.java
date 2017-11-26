package Data_classes;

public class Sample {
	/**
	 *  @author Bar Janah, Amit nuni.
	 * This class takes one line from the CSV file, which is actually taking a one cell from the Samples ArrayList.
	 */
	
	private String[] samp;
	private Position pos;
	private Time time;
	private Wifi wifies; 
	
	/**
	 * The constructor. Takes a Line from the CSV file which presented as "Sample", and divides the line into parameters.
	 * @param s
	 */
	public Sample(String[] s){
		samp = s;
		time = new Time(s[0]);
		pos = new Position(s[2],s[3],s[4]);
		wifies = new Wifi(s);
	}
	
	public boolean Contains(String s){
		return wifies.Contains(s);
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

	public String getPoint(){
		return pos.toString();
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
		System.out.println(time.toString());
		return time.toString();
	}

	public Position getPosition() {
		return pos;
	}
	
	public Time getTime() {
		return time;
	}
	public Wifi getWifi() {
		return wifies;
	}
}
