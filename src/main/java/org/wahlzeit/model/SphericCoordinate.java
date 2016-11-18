/*
 * Coordinate
 */
package org.wahlzeit.model;

/**
 * 
 */
public class SphericCoordinate implements Coordinate {
	
	// latitude and longitude in degrees
	private final double latitude;
	private final double longitude;
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * @methodtype get
	 */
	public double getLatitude(){
		return latitude;
	}
	
	/**
	 * @methodtype get
	 */
	public double getLongitude(){
		return longitude;
	}
	
	/**
	 * 
	 */
	@Override
	public double getDistance(Coordinate other){
		SphericCoordinate o = other.asSphericCoordinate();
		return doGetDistance(o);
	}
	
	private double doGetDistance(SphericCoordinate other){
		double deltaLongitude = Math.abs(Math.toRadians(this.longitude-other.getLongitude()));
		double phi1 = Math.toRadians(this.latitude);
		double phi2 = Math.toRadians(other.getLatitude());
		
		// https://en.wikipedia.org/wiki/Great-circle_distance
		double centralAngle = Math.acos(Math.sin(phi1)*Math.sin(phi2)+Math.cos(phi1)*Math.cos(phi2)*Math.cos(deltaLongitude));
		return centralAngle * EARTHRADIUS;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double lat = Math.toRadians(this.latitude);
		double lon = Math.toRadians(this.longitude);
		double x = EARTHRADIUS * Math.cos(lat) * Math.cos(lon);
		double y = EARTHRADIUS * Math.cos(lat) * Math.sin(lon);
		double z = EARTHRADIUS * Math.sin(lat);
		return new CartesianCoordinate(x,y,z);
	}
}
