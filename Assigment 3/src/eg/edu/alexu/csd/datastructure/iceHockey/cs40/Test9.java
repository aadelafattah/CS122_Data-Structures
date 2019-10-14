package eg.edu.alexu.csd.datastructure.iceHockey.cs40;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class Test9 {

	@Test
	public void test() {
		String[] input={
				"1"
				};
		int team=1, thresh=2;
		Point[] output = {new Point (1,1)};
		PlayersFinder test = new PlayersFinder();
		Point[] result = test.findPlayers(input, team, thresh);
		assertArrayEquals(output, result);
	}

}
