package Filter;

import Data_classes.Sample;
import Data_classes.Wifi;

public class WifiFilter implements Filter {

	private String wf;
	
	public WifiFilter(String wf){
		this.wf = wf;
	}

	public boolean criterion(Sample samp) {
		return samp.getWifi().Contains(wf);
	}
	
	
}
