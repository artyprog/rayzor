package de.rayzor.tracer;

import de.rayzor.vecmath.Vector3d;

public class Camera 
{
	private Vector3d location;
	private double alpha;
	
	public Camera(Vector3d location, double alpha)
	{
		this.location 	= location;
		this.alpha 		= alpha;
	}

	public Vector3d getLocation() {
		return location;
	}

	public void setLocation(Vector3d location) {
		this.location = location;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}
		
}
