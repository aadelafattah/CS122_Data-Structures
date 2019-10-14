package eg.edu.alexu.csd.datastructure.iceHockey.cs40;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class Test2 {

	@Test
	public void test() {
		String[] input={
				"44444H44S4",
				"K444K4L444",
				"4LJ44T44XH",
				"444O4VIF44",
				"44C4D4U444",
				"4V4Y4KB4M4",
				"G4W4HP4O4W",
				"4444ZDQ4S4",
				"4BR4Y4A444",
				"4G4V4T4444"
				};
		int team=4, thresh=16;
		Point[] output ={ new Point(3,8), new Point(4,16),
				new Point(5,4),new Point (16,3), new Point(16,17), new Point(17,9) };
		PlayersFinder test = new PlayersFinder();
		Point[] result = test.findPlayers(input, team, thresh);
		assertArrayEquals(output, result);
	}

}
