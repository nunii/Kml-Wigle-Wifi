/*package test.java.EX01;

import main.java.filters.Filter;
import main.java.filters.positionFilter;
import main.java.filters.timeFilter;
import main.java.io_pack.*;

import java.io.File;

import main.java.data_classes.Position;
import main.java.data_classes.Samples;
import main.java.data_classes.Time;
import main.java.filters.*;

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
*/