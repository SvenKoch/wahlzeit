/*
 * Location
 */
package org.wahlzeit.model;

/**
 *
 */
public class Location {
	
	private final Coordinate coordinate;
	
	/**
	 * @methodtype constructor
	 */
	public Location(Coordinate coordinate){
		if(coordinate == null){
			throw new IllegalArgumentException("Coordinate may not be null!");
		}
		this.coordinate = coordinate;
	}

	/**
	 * @methodtype get
	 * @return the coordinate
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}
}
