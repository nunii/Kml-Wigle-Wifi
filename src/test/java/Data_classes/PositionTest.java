package test.java.Data_classes;

import static org.junit.Assert.*;
import org.junit.Test;

import main.java.data_classes.Position;

public class PositionTest {


	@Test
	public void testEqualsPosition() {
		Position p1 = new Position("32.00828529","34.81321819","48");
		Position p2 = new Position(p1);
		Position p3 = new Position("32.00828529","34.81321819","0");
		Position p4 = new Position("32.00828529","34.81321819");
		
		if(!p1.equals(p2))
			fail("method equals of Position wrong");
		if(!p3.equals(p4))
			fail("method equals of Position wrong");
		if(p2.equals(p3))
			fail("method equals of Position wrong");
	}

	@Test
	public void testDist2D() {
		Position pos = new Position("51.5","0","48");
		Position pos2 = new Position("38.8","-77.1","48");
		double d = 5918.185064088764;
		if(pos.dist2D(pos2)!=d)
			fail("Method dist2D of Position is wrong");
	}

}
