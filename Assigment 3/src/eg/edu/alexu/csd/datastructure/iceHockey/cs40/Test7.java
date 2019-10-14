package eg.edu.alexu.csd.datastructure.iceHockey.cs40;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class Test7 {

	@Test
	public void test() {
		String[] input={
				"33AA33",
				"33AA33",
				"AA33AA",
				"AA33AA",
				"33AA33",
				"33AA33"
				};
		int team=3, thresh=16;
		Point[] output = {new Point (2,2), new Point(2,10), new Point(6,6), new Point (10,2), new Point (10,10) };
		PlayersFinder test = new PlayersFinder();
		Point[] result = test.findPlayers(input, team, thresh);
		assertArrayEquals(output, result);
	}

}
