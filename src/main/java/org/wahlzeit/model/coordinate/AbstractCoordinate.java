package org.wahlzeit.model.coordinate;

import org.wahlzeit.model.Coordinate;

public abstract class AbstractCoordinate implements Coordinate {

	public abstract CartesianCoordinate asCartesianCoordinate();
	
	/*
	 * getDistance uses Cartesian interpretation (shortest distance)
	 */
	@Override
	public double getDistance(Coordinate other) {
		assertNotNull(other);
		return this.asCartesianCoordinate().doGetDistance(other.asCartesianCoordinate());
	}
	
	@Override
	public boolean isEqual(Coordinate other) {
		assertNotNull(other);
		return this.asCartesianCoordinate().isEqual(other.asCartesianCoordinate());
	}
	
	protected void assertNotNull(Object o){
		if(o == null){
			throw new IllegalArgumentException("Argument may not be null!");
		}
	}

}
