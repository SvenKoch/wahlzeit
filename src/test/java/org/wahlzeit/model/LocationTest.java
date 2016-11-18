/*
 * LocationTest
 */
package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the Location class.
 */
public class LocationTest {

	/**
	 * 
	 */
	@Test
	public void testConstructor(){
		SphericCoordinate coord = new SphericCoordinate(23, 42);
		Location loc = new Location(coord);
		
		assertEquals(coord, loc.coordinate);
	}
}
