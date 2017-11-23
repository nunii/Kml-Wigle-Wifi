package EX01;

import java.io.File;
import java.io.FileNotFoundException;

import Data_classes.Samples;
import de.micromata.opengis.kml.v_2_2_0.*;

public class WriteToKml {
	private Samples samples;
	private Kml kml; 
	
	public WriteToKml(Samples samp){
		samples = samp;
	}
	
	public void write(){
		kml = new Kml();
		kml.createAndSetPlacemark()
		   .withName(samples.getName(0)).withOpen(Boolean.TRUE).withDescription("<![CDATA[BSSID: <b>"+samples.getMac(0)+"</b><br/>Capabilities: <b>SECURITY</b><br/>Frequency: <b>"+samples.getFreq(0)+"</b><br/>Timestamp: <b>1509528977000</b><br/>Date: <b>"+samples.getDate(0)+"</b>]]>")
		   .createAndSetPoint().addToCoordinates(samples.getPoint(0));
		Document document = kml.createAndSetDocument();
		for (int i = 1; i < samples.length(); i++) {
			document.createAndAddPlacemark()
			   .withName(samples.getName(i)).withOpen(Boolean.TRUE).withDescription("<![CDATA[BSSID: <b>"+samples.getMac(i)+"</b><br/>Capabilities: <b>SECURITY</b><br/>Frequency: <b>"+samples.getFreq(i)+"</b><br/>Timestamp: <b>1509528977000</b><br/>Date: <b>"+samples.getDate(i)+"</b>]]>")
			   .createAndSetPoint().addToCoordinates(samples.getPoint(i));
		}
		kml.setFeature(document);
		try {
			kml.marshal(new File("HelloKml.kml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
