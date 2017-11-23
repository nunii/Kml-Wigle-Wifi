package EX01;

import java.io.File;

import Data_classes.Position;
import Data_classes.Sample;
import Data_classes.Samples;
import Filter.*;
import de.micromata.opengis.kml.v_2_2_0.Kml;

public class Rashi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("newCSV.csv");
		Samples samp = new Samples(file.getPath());
		Position pos = new Position("32.00828529","34.81321819","48");
//		Filter filt = new positionFilter(pos,1);
//		WriteToKml wtk = new WriteToKml(samp.Filter(filt));
		WriteToKml wtk = new WriteToKml(samp);
		wtk.write();
	}

}
