/**
 * 
 */
package tourguide;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author pbj
 */
public class DisplacementTest {
	/**
	 * EPS = Epsilon, the difference to allow in floating point numbers when
	 * comparing them for equality.
	 */
	private static final double EPS = 0.01;

	@Test
	public void testNorthBearing() {
		double bearing = new Displacement(0.0, 1.0).bearing();
		double distance = new Displacement(0.0, 1.0).distance();
		assertEquals(0.0, bearing, EPS);
		assertEquals(1.0, distance, EPS);
	}

	@Test
	public void test45Bearing() {
		double bearing = new Displacement(5.0, 5.0).bearing();
		double distance = new Displacement(5.0, 5.0).distance();
		assertEquals(45.00, bearing, EPS);
		assertEquals(7.07, distance, EPS);
	}

	public void test90Bearing() {
		double bearing = new Displacement(1, 0).bearing();
		double distance = new Displacement(1, 0).distance();
		assertEquals(90.00, bearing, EPS);
		assertEquals(1.0, distance, EPS);
	}

	@Test
	public void test120Bearing() {
		double bearing = new Displacement(50, -28.87).bearing();
		double distance = new Displacement(50, -28.87).distance();
		assertEquals(120.00, bearing, EPS);
		assertEquals(57.74, distance, EPS);
	}

	@Test
	public void test150Bearing() {
		double bearing = new Displacement(50, -86.6).bearing();
		double distance = new Displacement(50, -86.6).distance();
		assertEquals(150.00, bearing, EPS);
		assertEquals(100.00, distance, EPS);
	}

	@Test
	public void test180Bearing() {
		double bearing = new Displacement(0.0001, -50000).bearing();
		double distance = new Displacement(0.0001, -50000).distance();
		assertEquals(180.00, bearing, EPS);
		assertEquals(50000, distance, EPS);
	}

	@Test
	public void test210Bearing() {
		double bearing = new Displacement(-1, -1.732).bearing();
		double distance = new Displacement(-1, -1.732).distance();
		assertEquals(210.00, bearing, EPS);
		assertEquals(2.00, distance, EPS);
	}

	@Test
	public void test240Bearing() {
		double bearing = new Displacement(-1, -0.5773).bearing();
		double distance = new Displacement(-1, -0.5773).distance();
		assertEquals(240.00, bearing, EPS);
		assertEquals(1.15, distance, EPS);
	}

	@Test
	public void test270Bearing() {
		double bearing = new Displacement(-1, 0).bearing();
		double distance = new Displacement(-1, 0).distance();
		assertEquals(270.00, bearing, EPS);
		assertEquals(1.00, distance, EPS);
	}

	@Test
	public void test315Bearing() {
		double bearing = new Displacement(-75.0, 75.0).bearing();
		double distance = new Displacement(-75.0, 75.0).distance();
		assertEquals(315.00, bearing, EPS);
		assertEquals(106.06, distance, EPS);
	}

	@Test
	public void test30Bearing() {
		double bearing = new Displacement(Math.sqrt(3.0), 3).bearing();
		double distance = new Displacement(Math.sqrt(3.0), 3).distance();
		assertEquals(30.00, bearing, EPS);
		assertEquals(3.46, distance, EPS);
	}

	@Test
	public void test330Bearing() {
		double bearing = new Displacement(-Math.sqrt(3.0), 3).bearing();
		double distance = new Displacement(-Math.sqrt(3.0), 3).distance();
		assertEquals(330.00, bearing, EPS);
		assertEquals(3.46, distance, EPS);
	}

	@Test
	public void test60Bearing() {
		double bearing = new Displacement(Math.sqrt(3.0), 1).bearing();
		double distance = new Displacement(Math.sqrt(3.0), 1).distance();
		assertEquals(60.00, bearing, EPS);
		assertEquals(2.0, distance, EPS);
	}

	@Test
	public void test300Bearing() {
		double bearing = new Displacement(-Math.sqrt(3.0), 1).bearing();
		double distance = new Displacement(-Math.sqrt(3.0), 1).distance();
		assertEquals(300.00, bearing, EPS);
		assertEquals(2.0, distance, EPS);
	}
}
