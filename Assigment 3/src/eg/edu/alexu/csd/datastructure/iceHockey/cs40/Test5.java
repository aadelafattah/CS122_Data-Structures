package eg.edu.alexu.csd.datastructure.iceHockey.cs40;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class Test5 {

	@Test
	public void test() {
		String[] input={};
		int team=1, thresh=3;
		PlayersFinder test = new PlayersFinder();
		Point[] result = test.findPlayers(input, team, thresh);
		assertArrayEquals(null, result);
	}
}
