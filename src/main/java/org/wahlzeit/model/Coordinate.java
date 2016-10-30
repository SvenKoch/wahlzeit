/*
 * Coordinate
 */
package org.wahlzeit.model;

/**
 * 
 */
public class Coordinate {
	
	private final int EARTHRADIUS = 6371;
	
	// latitude and longitude in degrees
	private final double latitude;
	private final double longitude;
	
	/**
	 * @methodtype constructor
	 */
	public Coordinate(double latitude, double longitude){
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
	public double getDistance(Coordinate other){
		double deltaLongitude = Math.abs(Math.toRadians(this.longitude-other.getLongitude()));
		double phi1 = Math.toRadians(this.latitude);
		double phi2 = Math.toRadians(other.getLatitude());
		
		// https://en.wikipedia.org/wiki/Great-circle_distance
		double centralAngle = Math.acos(Math.sin(phi1)*Math.sin(phi2)+Math.cos(phi1)*Math.cos(phi2)*Math.cos(deltaLongitude));
		return centralAngle * EARTHRADIUS;
	}
}
