package org.wahlzeit.model.coordinate;

import org.wahlzeit.model.Coordinate;

public abstract class AbstractCoordinate implements Coordinate {

	public abstract CartesianCoordinate asCartesianCoordinate();
	
	/*
	 * getDistance should use Cartesian interpretation (shortest distance)
	 */
	@Override
	public double getDistance(Coordinate other) {
		return this.asCartesianCoordinate().doGetDistance(other.asCartesianCoordinate());
	}

}
