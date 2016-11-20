package org.wahlzeit.model.coordinate;

public class CartesianCoordinate extends AbstractCoordinate {
	
	// Cartesian coordinates in km
	private final double x;
	private final double y;
	private final double z;

	/**
	 * @methodtype constructor
	 * @param x cartesian coordinate x in km
	 * @param y cartesian coordinate y in km
	 * @param z cartesian coordinate z in km
	 */
	public CartesianCoordinate(double x, double y, double z){
		double delta=10;
		if(x*x+y*y+z*z<(EARTHRADIUS-delta)*(EARTHRADIUS-delta) || x*x+y*y+z*z>(EARTHRADIUS+delta)*(EARTHRADIUS+delta)){
			throw new IllegalArgumentException("Coordinate has to be located earth's surface!");
		}
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	protected double doGetDistance(CartesianCoordinate other){
		double dx = other.getX()-this.x;
		double dy = other.getY()-this.y;
		double dz = other.getZ()-this.z;
		
		return Math.sqrt(dx*dx + dy*dy + dz*dz);
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
