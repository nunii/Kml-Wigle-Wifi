package main.java.filters;

import java.util.Date;

import main.java.data_classes.Sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class timeFilter implements Filter{
	/**
	 * @author Bar Janach, Amit Nuni
	 * This class is used to to filter the file by time.
	 */
	private DateFormat df;
	private Date startTime;
	private Date endTime;

	public timeFilter(String start, String end){
		try {
			df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			startTime =  (Date) df.parse(start);
			endTime = (Date) df.parse(end);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean criterion(Sample samp) {
		try {
			Date compare = (Date) df.parse(samp.getDate());
			return(!compare.before(startTime)&&!compare.after(endTime));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}

