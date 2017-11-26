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
}
