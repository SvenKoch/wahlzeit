/*
 * CoordinateTest
 */
package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the Coordinate class
 */
public class CoordinateTest {
	
	private final int EARTHRADIUS = 6371;

	/**
	 * 
	 */
	@Test
	public void testConstructorAndAccessMethods(){
		Coordinate random = new Coordinate(67.0, 130.0);
		assertEquals(67.0, random.getLatitude(), 0.0);
		assertEquals(130.0, random.getLongitude(), 0.0);
	}
	
	/**
	 *
	 */
	@Test
	public void testGetDistance() {
		Coordinate zerozero = new Coordinate(0.0, 0.0);
		Coordinate first = new Coordinate(0.0, 90.0);
		Coordinate second = new Coordinate(0.0, -90.0);
		Coordinate random1 = new Coordinate(67.0, 130.0);
		Coordinate random2 = new Coordinate(-23.0, -5.0);
		
		assertEquals(0.0, zerozero.getDistance(zerozero), 0.0);
		assertEquals(0.0, first.getDistance(first), 0.0);
		assertEquals(0.0, random1.getDistance(random1), 0.0);
		assertEquals(0.0, random2.getDistance(random2), 0.0);
		
		assertEquals(2*EARTHRADIUS*Math.PI / 2.0, first.getDistance(second), 1.0);
		assertEquals(2*EARTHRADIUS*Math.PI / 4.0, zerozero.getDistance(first), 1.0);
		assertEquals(2*EARTHRADIUS*Math.PI / 4.0, zerozero.getDistance(second), 1.0);
		assertEquals(14220.0, random1.getDistance(random2), 10.0);
	}
}
