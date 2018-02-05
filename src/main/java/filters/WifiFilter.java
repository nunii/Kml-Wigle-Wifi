package main.java.filters;

import main.java.data_classes.Sample;
import main.java.data_classes.Wifi;

public class WifiFilter implements Filter {
	/**
	 * @author Bar Janach, Amit Nuni
	 * This class is used to to filter the file by wifi.
	 */

	private String wf;
	
	public WifiFilter(String wf){
		this.wf = wf;
	}

	public boolean criterion(Sample samp) {
		return samp.Contains(wf);
	}
	
}
