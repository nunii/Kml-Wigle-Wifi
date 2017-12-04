package EX01;

import java.io.File;

import Data_classes.Position;
import Data_classes.Samples;
import Data_classes.Time;
import Filter.*;

public class Rashi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//32.17245298	34.80157306
		NewCSV.start();
		File file = new File("C:\\EX01\\newCSV.csv");
		Samples samps = new Samples(file.getPath());
		WriteToKml.write(samps, "C:\\EX01\\NoFilt.kml");
		Position pos = new Position("32.17245298","34.80157306","37");
		Filter posfilt = new positionFilter(pos,0.5);
		WriteToKml.write(samps.Filter(posfilt),"C:\\EX01\\PosFilt.kml");
		Time STtime = new Time("2017-10-27  16:22:02");
		Time ENdtime = new Time("2017-10-27  16:30:00");
		Filter timfilt = new timeFilter(STtime.toString(),ENdtime.toString());
		WriteToKml.write(samps.Filter(timfilt), "C:\\EX01\\TimeFilt.kml");
	}

}
