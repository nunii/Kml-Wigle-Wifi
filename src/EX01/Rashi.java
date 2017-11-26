package EX01;

import java.io.File;

import Data_classes.Position;
import Data_classes.Samples;
import Data_classes.Time;
import Filter.*;

public class Rashi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewCSV.start();
		File file = new File("newCSV.csv");
		Samples samps = new Samples(file.getPath());
		WriteToKml.write(samps, "NoFilt.kml");
		Position pos = new Position("32.00828529","34.81321819","48");
		Filter posfilt = new positionFilter(pos,1);
		WriteToKml.write(samps.Filter(posfilt),"PosFilt.kml");
		Time STtime = new Time("2017-11-05 14:00:02");
		Time ENdtime = new Time("2017-11-05 14:28:31");
		Filter timfilt = new timeFilter(STtime.toString(),ENdtime.toString());
		WriteToKml.write(samps.Filter(timfilt), "TimeFilt.kml");
	}

}
