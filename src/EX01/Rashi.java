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
		String path = NewCSV.start(args[1]).get(1);
		File file = new File(path+"newCSV.csv");
		Samples samps = new Samples(file.getPath());
		WriteToKml.write(samps, path+"NoFilt.kml");
		Position pos = new Position(samps.getPosition(830));
		Filter posfilt = new positionFilter(pos,0.5);
		WriteToKml.write(samps.Filter(posfilt),path+"PosFilt.kml");
		Time STtime = new Time("2017-11-05  14:00:02");
		Time ENdtime = new Time("2017-11-05  14:34:10");
		Filter timfilt = new timeFilter(STtime.toString(),ENdtime.toString());
		WriteToKml.write(samps.Filter(timfilt), path+"TimeFilt.kml");
	}

}
