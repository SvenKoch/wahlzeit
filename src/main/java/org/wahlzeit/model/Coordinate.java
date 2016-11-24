package org.wahlzeit.model;

import org.wahlzeit.model.coordinate.CartesianCoordinate;

import com.googlecode.objectify.annotation.Serialize;

@Serialize
public interface Coordinate {

	// Earth's radius in km
	public static final int EARTHRADIUS = 6371;
	
	public CartesianCoordinate asCartesianCoordinate();
	public double getDistance(Coordinate other);
	public boolean isEqual(Coordinate other);
	

}