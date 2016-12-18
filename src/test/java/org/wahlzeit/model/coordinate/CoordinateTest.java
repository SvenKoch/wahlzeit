package org.wahlzeit.model.coordinate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {
	
	private SphericCoordinate sc;
	
	@Before
	public void setUp(){
		sc = SphericCoordinate.getInstance(67, 130);
	}

	@Test
	public void testIsEqual(){
		assertTrue(sc.isEqual(sc));
		assertTrue(sc.isEqual(sc.asCartesianCoordinate()));
		assertTrue(sc.asCartesianCoordinate().isEqual(sc));
		assertTrue(sc.asCartesianCoordinate().isEqual(sc.asCartesianCoordinate()));
	}
	
	@Test
	public void testNotEqual(){
		SphericCoordinate sc2 = SphericCoordinate.getInstance(60, 130);
		assertFalse(sc.isEqual(sc2));
		assertFalse(sc.isEqual(sc2.asCartesianCoordinate()));
		assertFalse(sc.asCartesianCoordinate().isEqual(sc2));
		assertFalse(sc.asCartesianCoordinate().isEqual(sc2.asCartesianCoordinate()));
	}
	
	@Test
	public void testGetDistance(){
		assertEquals(0, sc.getDistance(sc),0);
		assertEquals(0, sc.getDistance(sc.asCartesianCoordinate()),0);
		assertEquals(0, sc.asCartesianCoordinate().getDistance(sc),0);
		assertEquals(0, sc.asCartesianCoordinate().getDistance(sc.asCartesianCoordinate()),0);
	}
}
