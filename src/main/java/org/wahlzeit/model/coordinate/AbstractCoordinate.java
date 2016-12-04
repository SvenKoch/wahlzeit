package org.wahlzeit.model.coordinate;

import org.wahlzeit.model.Coordinate;

public abstract class AbstractCoordinate implements Coordinate {

	public abstract CartesianCoordinate asCartesianCoordinate();
	
	/*
	 * getDistance uses Cartesian interpretation (shortest distance)
	 */
	@Override
	public double getDistance(Coordinate other) {
		assert(other!=null);
		return this.asCartesianCoordinate().doGetDistance(other.asCartesianCoordinate());
	}
	
	@Override
	public boolean isEqual(Coordinate other) {
		assert(other!=null);
		return this.asCartesianCoordinate().isEqual(other.asCartesianCoordinate());
	}

}
