package org.wahlzeit.model.coordinate;

import static org.junit.Assert.*;

import org.junit.Test;

public class SphericCoordinateTest {
	
	private final int EARTHRADIUS = 6371;

	@Test(expected=IllegalArgumentException.class)
	public void testIllegalLatitude(){
		SphericCoordinate.getInstance(91, 60);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalLongitude(){
		SphericCoordinate.getInstance(60, -181);
	}
	
	@Test
	public void testConstructorAndAccessMethods(){
		double lat = 67;
		double lon = 130;
		SphericCoordinate coord = SphericCoordinate.getInstance(lat,lon);
		assertEquals(lat, coord.getLatitude(), 0.0);
		assertEquals(lon, coord.getLongitude(), 0.0);
	}
	
	@Test
	public void testGetDistance() {
		SphericCoordinate zerozero = SphericCoordinate.getInstance(0.0, 0.0);
		SphericCoordinate halfeast = SphericCoordinate.getInstance(0.0, 90.0);
		SphericCoordinate halfwest = SphericCoordinate.getInstance(0.0, -90.0);
		SphericCoordinate northeast = SphericCoordinate.getInstance(67.0, 130.0);
		SphericCoordinate southwest = SphericCoordinate.getInstance(-23.0, -5.0);
		
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
		SphericCoordinate sc1 = SphericCoordinate.getInstance(67, 130);
		SphericCoordinate sc2 = SphericCoordinate.getInstance(67, 130, EARTHRADIUS);
		
		assertTrue(sc1==sc2);
	}
}
