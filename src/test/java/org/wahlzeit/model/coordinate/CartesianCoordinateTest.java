package org.wahlzeit.model.coordinate;

import static org.junit.Assert.*;

import org.junit.Test;

public class CartesianCoordinateTest {
	
	private final int EARTHRADIUS = 6371;
	
	@Test
	public void testConstructorAndAccessMethodsCartesian(){
		double x = 1907;
		double y = 4492;
		double z = -4095;
		CartesianCoordinate coord = CartesianCoordinate.getInstance(x,y,z);
		assertEquals(x, coord.getX(), 0.0);
		assertEquals(y, coord.getY(), 0.0);
		assertEquals(z, coord.getZ(), 0.0);
	}
	
	@Test
	public void testGetDistanceCartesian(){
		CartesianCoordinate zerozero = CartesianCoordinate.getInstance(EARTHRADIUS, 0, 0);
		CartesianCoordinate halfeast = CartesianCoordinate.getInstance(0, EARTHRADIUS, 0);
		CartesianCoordinate halfwest = CartesianCoordinate.getInstance(0, -EARTHRADIUS, 0);
		CartesianCoordinate northeast = CartesianCoordinate.getInstance(-1600, 1907, 5865);
		CartesianCoordinate southwest = CartesianCoordinate.getInstance(5842, -511, -2489);
		
		assertEquals(0.0, zerozero.getDistance(zerozero), 0.0);
		assertEquals(0.0, halfeast.getDistance(halfeast), 0.0);
		assertEquals(0.0, halfwest.getDistance(halfwest), 0.0);
		assertEquals(0.0, northeast.getDistance(northeast), 0.0);
		assertEquals(0.0, southwest.getDistance(southwest), 0.0);
		
		assertEquals(2*EARTHRADIUS, halfeast.getDistance(halfwest), 1.0);
		assertEquals(Math.sqrt(2*EARTHRADIUS*EARTHRADIUS), zerozero.getDistance(halfeast), 1.0);
		assertEquals(Math.sqrt(2*EARTHRADIUS*EARTHRADIUS), zerozero.getDistance(halfwest), 1.0);
		assertEquals(11447, northeast.getDistance(southwest), 10.0);
	}
	
	@Test
	public void testShared(){
		CartesianCoordinate cc1 = CartesianCoordinate.getInstance(0, 8, 15);
		CartesianCoordinate cc2 = CartesianCoordinate.getInstance(0, 8, 15);
		
		assertTrue(cc1==cc2);
	}

}
