package EX01;

import java.io.File;

import Data_classes.Position;
import Data_classes.Samples;
import Filter.*;

public class Rashi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewCSV.start();
		File file = new File("newCSV.csv");
		Samples samp = new Samples(file.getPath());
		Position pos = new Position("32.00828529","34.81321819","48");
		Filter filt = new positionFilter(pos,1);
		WriteToKml wtk = new WriteToKml(samp.Filter(filt));
		wtk.write();
	}

}
