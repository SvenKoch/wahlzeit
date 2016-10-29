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
		double phi1 = this.latitude;
		double phi2 = other.getLatitude();
		
		// simple algorithm
		// double centralAngle = Math.acos(Math.sin(this.latitude)*Math.sin(other.latitude)+Math.cos(this.longitude)*Math.cos(other.longitude)*Math.cos(deltaLongitude));
		
		// precise algorithm
		double temp1 = Math.cos(phi2)*Math.sin(deltaLongitude);
		temp1 = temp1*temp1;
		double temp2 = Math.cos(phi1)*Math.sin(phi2) - Math.sin(phi1)*Math.cos(phi2)*Math.cos(deltaLongitude);
		temp2 = temp2*temp2;
		
		double centralAngle = Math.atan(Math.sqrt(temp1 + temp2) / (Math.sin(phi1) * Math.sin(phi2)+Math.cos(phi1)*Math.cos(phi2)*Math.cos(deltaLongitude)));
		
		return Math.abs(centralAngle * EARTHRADIUS);
	}
}
