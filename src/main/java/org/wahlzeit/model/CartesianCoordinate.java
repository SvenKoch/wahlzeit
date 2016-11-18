package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate {
	
	// Cartesian coordinates in km
	private final double x;
	private final double y;
	private final double z;

	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public double getDistance(Coordinate other) {
		CartesianCoordinate o = other.asCartesianCoordinate();
		return doGetDistance(o);
	}
	
	private double doGetDistance(CartesianCoordinate other){
		double dx = other.getX()-this.x;
		double dy = other.getY()-this.y;
		double dz = other.getZ()-this.z;
		
		return Math.sqrt(dx*dx + dy*dy + dz*dz);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		double lat = Math.asin(z / EARTHRADIUS);
		double lon = Math.atan2(y, z);
		return new SphericCoordinate(lat,lon);
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	/**
	 * @methodtype get
	 */
	public double getX() {
		return x;
	}

	/**
	 * @methodtype get
	 */
	public double getY() {
		return y;
	}

	/**
	 * @methodtype get
	 */
	public double getZ() {
		return z;
	}

}
