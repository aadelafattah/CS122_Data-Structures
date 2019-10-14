package eg.edu.alexu.csd.datastructure.iceHockey.cs40;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class Test10 {

	@Test
	public void test() {
		String[] input={
				"012346789A",
				"012346789A",
				"012346789A",
				"012346789A",
				"012346789A",
				"012346789A",
				"012346789A",
				"012346789A",
				"012346789A",
				"0123467895"
				};
		int team=5, thresh=2;
		Point[] output = {new Point(19,19)};
		PlayersFinder test = new PlayersFinder();
		Point[] result = test.findPlayers(input, team, thresh);
		assertArrayEquals(output, result);
	}

}
