/*
 * CoordinateTest
 */
package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the Coordinate class.
 */
public class CoordinateTest {
	
	private final int EARTHRADIUS = 6371000;

	/**
	 *
	 */
	@Test
	public void testGetDistance() {
		//TODO: tests
		Coordinate zerozero = new Coordinate(0,0);
		assertEquals(0.0, zerozero.getDistance(zerozero), 0.0);
		
		Coordinate first = new Coordinate(0, 90);
		assertEquals(0.0, first.getDistance(first), 0.0);
		
		assertEquals(2*EARTHRADIUS*Math.PI / 4.0, first.getDistance(zerozero), 0.0);
		
		System.out.println(first.getDistance(zerozero));
	}
}
