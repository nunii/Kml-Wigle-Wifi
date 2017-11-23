package Filter;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Data_classes.Sample;

public class timeFilter implements Filter{
	/**
	 * @author Bar Janach, Amit Nuni
	 * This class is used to to filter the file by time.
	 */
	private DateFormat df;
	private Date startTime;
	private Date endTime;
	
	public timeFilter(String start, String end) throws ParseException{
			df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			startTime =  (Date) df.parse(start.trim());
			endTime = (Date) df.parse(end.trim());
	}

		@Override
		public boolean criterion(Sample samp) {
			try {
				Date compare = (Date) df.parse(samp.getDate().trim());
				return(compare.before(startTime)||compare.after(endTime));
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

	}

