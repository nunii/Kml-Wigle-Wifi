package EX01;


public class WifiFilter implements Filter {

	private Wifi wf;
	
	public WifiFilter(Wifi wf){
		this.wf = wf;
	}

	public boolean criterion(Sample samp) {
		return samp.getWifi().equals(wf);
	}
	
	
}
