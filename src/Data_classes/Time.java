package Data_classes;

public class Time {
	/**
	 * @author Bar Janach, Amit Nuni.
	 * This class represents the time which the Wifi signal has been recorded.
	 */
	
	String time;
	public Time(String s){
		time = s;
	}
	
	public String toString() {
		return time;
	}
	
	public String getTimestamp() {
		System.out.println(time);
		String[] s = time.split(" ");
		String str = s[0]+"T"+s[1]+"Z";
		return str;
	}
}
