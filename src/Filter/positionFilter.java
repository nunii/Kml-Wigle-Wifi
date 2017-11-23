package Filter;

import Data_classes.Position;
import Data_classes.Sample;

public class positionFilter implements Filter {
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
