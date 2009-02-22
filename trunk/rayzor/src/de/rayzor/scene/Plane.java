package de.rayzor.scene;

import de.rayzor.tracer.Hit;
import de.rayzor.tracer.Ray;
import de.rayzor.vecmath.Vector3d;

public class Plane extends ObjectBase 
{
	private Vector3d normal;
	
	public Plane(Vector3d location, Vector3d normal)
	{
		if(location==null || normal==null)
			throw new IllegalArgumentException("Location and or normal must not be null.");
		
		this.location = location;
		this.normal = normal;
	}
	
	@Override
	public Hit intersect(Ray ray) 
	{
		double a = location.dot(normal);
		double b = ray.getLocation().dot(normal);
		double c = ray.getDirection().dot(normal);
				
		if(c==0) // no intersection
			return null;
		
		double param = (a - b) / c;
		if(param<0)
			return null;
		
		return new Hit(this, ray, param);
	}

	public Vector3d getNormal() {
		return normal;
	}

	public void setNormal(Vector3d normal) {
		this.normal = normal;
	}
	
}