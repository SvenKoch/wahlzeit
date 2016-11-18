package org.wahlzeit.model;

public interface Coordinate {

	public static final int EARTHRADIUS = 6371;
	/**
	 * 
	 */
	public double getDistance(Coordinate other);
	public SphericCoordinate asSphericCoordinate();
	public CartesianCoordinate asCartesianCoordinate();

}