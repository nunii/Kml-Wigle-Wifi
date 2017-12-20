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
		String path = NewCSV.start();
		File file = new File(path+"Ex1\\newCSV.csv");
		Samples samps = new Samples(file.getPath());
		WriteToKml.write(samps, path+"Ex1\\NoFilt.kml");
		Position pos = new Position(samps.getPos(830));
		Filter posfilt = new positionFilter(pos,0.5);
		WriteToKml.write(samps.Filter(posfilt),path+"Ex1\\PosFilt.kml");
		Time STtime = new Time("2017-11-05  14:00:02");
		Time ENdtime = new Time("2017-11-05  14:34:10");
		Filter timfilt = new timeFilter(STtime.toString(),ENdtime.toString());
		WriteToKml.write(samps.Filter(timfilt), path+"Ex1\\TimeFilt.kml");
	}

}
