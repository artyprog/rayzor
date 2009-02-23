package de.rayzor.tracer;

import de.rayzor.vecmath.Vector3d;

public class Camera 
{
	private Vector3d location;
	private Vector3d direction;
	private double angle;
	
	/**
	 * Creates a default camera at the point
	 * of origin and an angle of 45 degrees
	 */
	public Camera()
	{
		this(new Vector3d(0, 0, 0), new Vector3d(0, 0, -1), Math.PI/4);
	}
	
	public Camera(Vector3d location, Vector3d direction, double angle) 
	{
		this.location = location;
		this.direction = direction;
		this.angle = angle;
	}

	public Vector3d getLocation() {
		return location;
	}

	public void setLocation(Vector3d location) {
		this.location = location;
	}

	public Vector3d getDirection() {
		return direction;
	}

	public void setDirection(Vector3d direction) {
		this.direction = direction;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
		
}
