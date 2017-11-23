package Data_classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class WifiTest {

	@Test
	public void testContains() {
		String[] s = {"a","b","c","d","e","3","g","h","i","j","k","l","m","n","o","p","q","r"};
		Wifi w = new Wifi(s);
		if(w.Contains("a")||w.Contains("b")||w.Contains("c")||w.Contains("d")||w.Contains("e")||w.Contains("3")||w.Contains("h")||w.Contains("i")||w.Contains("j")||w.Contains("l"))
			fail("Method contains of Wifi is wrong");
		if(!(w.Contains("g")||w.Contains("k")||w.Contains("o")))
				fail("Method contains of Wifi is wrong");
	}

}
