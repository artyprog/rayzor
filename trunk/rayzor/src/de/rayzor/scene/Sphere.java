package de.rayzor.scene;

import de.rayzor.tracer.Hit;
import de.rayzor.tracer.Ray;
import de.rayzor.vecmath.Vector3d;

public class Sphere extends ObjectBase 
{
	private double radius;
	
	public Sphere(Vector3d location, double radius)
	{
		if(location==null)
			throw new IllegalArgumentException("Location must not be null");
		if(radius<=0)
			throw new IllegalArgumentException("The radius of a sphere must be greater than 0");
		
		this.location = location;
		this.radius = radius;
	}
	
	@Override
	public Hit intersect(Ray ray) 
	{
		double a 		 = ray.getDirection().dot(ray.getDirection());
		double b 		 = 2 * ray.getDirection().dot(ray.getLocation().sub(location));
		Vector3d cVector = ray.getLocation().sub(location);
		double c		 = cVector.dot(cVector) - radius * radius;
		
		double det		 = b * b - 4 * a * c;
		if(a==0 || det<0) // no intersection
			return null;
		
		double root = Math.sqrt(det);
		double hit1 = (-b + root) / 2 * a;
		double hit2 = (-b - root) / 2 * a;
		
		if(hit1 >= 0 && hit2 >= 0)
			return new Hit(this, ray, Math.min(hit1, hit2));
		
		if(hit1<0 && hit2<0)
			return null;				
		
		return new Hit(this, ray, (hit1 >= 0) ? hit1 : hit2);
	}

}
