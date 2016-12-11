package org.wahlzeit.model.coordinate;

public class CartesianCoordinate extends AbstractCoordinate {
	
	// Cartesian coordinates in km
	private final double x;
	private final double y;
	private final double z;
	
	private static final double DELTA = 1e-6;

	/**
	 * @methodtype constructor
	 * @param x cartesian coordinate x in km
	 * @param y cartesian coordinate y in km
	 * @param z cartesian coordinate z in km
	 */
	public CartesianCoordinate(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	protected double doGetDistance(CartesianCoordinate other){
		assertNotNull(other);
		double dx = other.getX()-this.x;
		double dy = other.getY()-this.y;
		double dz = other.getZ()-this.z;
		
		return Math.sqrt(dx*dx + dy*dy + dz*dz);
	}
	
	public boolean isEqual(CartesianCoordinate other) {
		assertNotNull(other);
		return this.doGetDistance(other) < DELTA;
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
