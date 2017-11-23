package Data_classes;
import java.util.Arrays;

public class Wifi {
	/**
	 * @author Bar Janach, Amit Nuni.
	 * This class represents Wifi signals which has been recorded at the same time.
	 */
	String[] wifs;
	
	/**
	 * The constructor calculates exactly where are the Wifi signals name at the CSV file.
	 * @param s
	 */
	public Wifi(String[] s){
		wifs = new String[Integer.parseInt(s[5])];
		for (int i = 0; i < wifs.length; i++) {
			wifs[i] = s[(i*4)+6];
		}
	}
	
	
	public String toString(){
		return Arrays.toString(wifs);
	}
	
	public boolean Contains(String other){
		int i=0;
		while(i<wifs.length){
			if(wifs[i].equals(other))
				return true;
			i++;
		}
		return false;
	}
}
