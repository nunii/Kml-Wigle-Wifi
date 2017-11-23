package Filter;

import Data_classes.Position;
import Data_classes.Sample;

public class positionFilter implements Filter {
	/**
	 * @author Bar Janach, Amit Nuni
	 * This class is used to to filter the file by position.
	 */
	private Position pos;
	private double _radius;
	public positionFilter(Position pos,double rad){
		this.pos = pos;
		_radius = rad;
	}

	public boolean criterion(Sample samp) {
		return this.test(samp.getPosition());
	}
	public boolean test(Position other) {
		return other.dist2D(pos)<=_radius;
	}	
	

}
