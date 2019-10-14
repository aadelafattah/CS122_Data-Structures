package eg.edu.alexu.csd.datastructure.iceHockey.cs40;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class Test8 {

	@Test
	public void test() {
		String[] input={
				"3A33AA333AAA3333AAAA33333"
				};
		int team=3, thresh=16;
		Point[] output = {new Point (28,1), new Point (45,1)};
		PlayersFinder test = new PlayersFinder();
		Point[] result = test.findPlayers(input, team, thresh);
		assertArrayEquals(output, result);
	}

}
