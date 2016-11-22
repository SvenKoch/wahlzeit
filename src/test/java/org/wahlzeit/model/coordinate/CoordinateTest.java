package org.wahlzeit.model.coordinate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordinateTest {

	@Test
	public void testIsEqual(){
		SphericCoordinate sc = new SphericCoordinate(67, 130);
		assertTrue(sc.isEqual(sc));
		assertTrue(sc.isEqual(sc.asCartesianCoordinate()));
		assertTrue(sc.asCartesianCoordinate().isEqual(sc));
		assertTrue(sc.asCartesianCoordinate().isEqual(sc.asCartesianCoordinate()));
	}
	
	@Test
	public void testNotEqual(){
		SphericCoordinate sc1 = new SphericCoordinate(67, 130);
		SphericCoordinate sc2= new SphericCoordinate(60, 130);
		assertFalse(sc1.isEqual(sc2));
		assertFalse(sc1.isEqual(sc2.asCartesianCoordinate()));
		assertFalse(sc1.asCartesianCoordinate().isEqual(sc2));
		assertFalse(sc1.asCartesianCoordinate().isEqual(sc2.asCartesianCoordinate()));
	}
}
