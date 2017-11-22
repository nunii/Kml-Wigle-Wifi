

public class Line {
	private String[] line;
	private Position pos;
	private Time time;
	private Wifi wifies; 
	public Line(String[] s){
		line = s;
		time = new Time(s[1]);
		pos = new Position(s[2],s[3],s[4]);
		wifies = new Wifi(s);

	}

	public boolean Contains(String s){
		int ind = 0;
		while(ind<line.length){
			if(line[ind].equals(s))
				return true;
			ind++;
		}
		return false;
	}

	public String getName(){
		return line[6];
	}

	public int getIndex(String s){
		int ind = 0;
		if(!this.Contains(s)){
			return -1;
		}
		while(!line[ind].equals(s)){
			ind++;
		}
		return ind;
	}

	public String getPoint(){
		return line[3]+","+line[2];
	}

	public String getMac(){
		return line[7];
	}

	public String getMac(String s){
		return line[this.getIndex(s)+1];
	}

	public String getFreq(){
		return line[8];
	}

	public String getFreq(String s){
		return line[this.getIndex(s)+1];
	}

	public String getDate(){
		return line[0];
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
