/*
 * Coordinate
 */
package org.wahlzeit.model;

/**
 * 
 */
public class Coordinate {
	
	private final int EARTHRADIUS = 6371000;
	
	private double latitude;
	private double longitude;
	
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
		double deltaLongitude = Math.abs(this.longitude-other.getLongitude());
		double centralAngle = Math.arccos(Math.sin(this.latitude)*Math.sin(other.latitude)+Math.cos(this.longitude)*Math.cos(other.longitude)*Math.cos(deltaLongitude));
		return centralAngle * EARTHRADIUS;
		//TODO: precise algorithm
	}
}
