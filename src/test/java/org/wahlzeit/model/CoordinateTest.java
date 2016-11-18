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

	@Test
	public void testConstructorAndAccessMethodsSpheric(){
		SphericCoordinate coord = new SphericCoordinate(67.0, 130.0);
		assertEquals(67.0, coord.getLatitude(), 0.0);
		assertEquals(130.0, coord.getLongitude(), 0.0);
	}
	
	@Test
	public void testConstructorAndAccessMethodsCartesian(){
		double x = 42;
		double y = 43;
		double z = 53;
		CartesianCoordinate coord = new CartesianCoordinate(x,y,z);
		assertEquals(x, coord.getX(), 0.0);
		assertEquals(y, coord.getY(), 0.0);
		assertEquals(z, coord.getZ(), 0.0);
	}
	
	@Test
	public void testGetDistanceSpheric() {
		SphericCoordinate zerozero = new SphericCoordinate(0.0, 0.0);
		SphericCoordinate halfeast = new SphericCoordinate(0.0, 90.0);
		SphericCoordinate halfwest = new SphericCoordinate(0.0, -90.0);
		SphericCoordinate coord1 = new SphericCoordinate(67.0, 130.0);
		SphericCoordinate coord2 = new SphericCoordinate(-23.0, -5.0);
		
		assertEquals(0.0, zerozero.getDistance(zerozero), 0.0);
		assertEquals(0.0, halfeast.getDistance(halfeast), 0.0);
		assertEquals(0.0, coord1.getDistance(coord1), 0.0);
		assertEquals(0.0, coord2.getDistance(coord2), 0.0);
		
		assertEquals(2*EARTHRADIUS*Math.PI / 2.0, halfeast.getDistance(halfwest), 1.0);
		assertEquals(2*EARTHRADIUS*Math.PI / 4.0, zerozero.getDistance(halfeast), 1.0);
		assertEquals(2*EARTHRADIUS*Math.PI / 4.0, zerozero.getDistance(halfwest), 1.0);
		assertEquals(14220.0, coord1.getDistance(coord2), 10.0);
	}
	
	@Test
	public void testGetDistanceCartesian(){
		CartesianCoordinate zero = new CartesianCoordinate(0, 0, 0);
		CartesianCoordinate halfeast = new CartesianCoordinate(0, EARTHRADIUS, 0);
		CartesianCoordinate halfwest = new CartesianCoordinate(0, -EARTHRADIUS, 0);
		
		assertEquals(0.0, zero.getDistance(zero), 0.0);
		assertEquals(0.0, halfeast.getDistance(halfeast), 0.0);
		
		assertEquals(2*EARTHRADIUS, halfeast.getDistance(halfwest), 1.0);
	}
}
