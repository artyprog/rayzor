package de.rayzor.tracer;

import de.rayzor.vecmath.Vector3d;

public class Ray 
{
	private Vector3d location;
	private Vector3d direction;
	
	public Ray(Vector3d location, Vector3d direction)
	{
		if(location==null || direction==null)
			throw new IllegalArgumentException("Direction and or Location must not be null.");
		
		this.location = location;
		this.direction = direction; 
	}
	
	public Vector3d evaluate(double var)
	{
		return location.add(direction.mult(var));
	}

	/**
	 * Getter and Setter
	 */
	
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
		
}