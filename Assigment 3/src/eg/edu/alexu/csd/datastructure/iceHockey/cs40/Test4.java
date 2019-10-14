package eg.edu.alexu.csd.datastructure.iceHockey.cs40;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class Test4 {

	@Test
	public void test() {
		String[] input={
				"11111",
				"1AAA1",
				"1A1A1",
				"1AAA1",
				"11111"
				};
		int team=1, thresh=3;
		Point[] output = {new Point (5,5), new Point (5,5) };
		PlayersFinder test = new PlayersFinder();
		Point[] result = test.findPlayers(input, team, thresh);
		assertArrayEquals(output, result);
	}

}
