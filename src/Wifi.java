import java.util.Arrays;

public class Wifi {
	String[] wifs;
	public Wifi(String[] s){
		wifs = new String[Integer.parseInt(s[5])];
		for (int i = 0; i < wifs.length; i++) {
			wifs[i] = s[(i*4)+6];
		}
	}
	
	public String toString(){
		return Arrays.toString(wifs);
	}
	
	public boolean equals(String other){
		int i=0;
		while(!wifs[i].equals(other)){
			i++;
			if(i==wifs.length)
				return false;
		}
		return true;
	}
}
