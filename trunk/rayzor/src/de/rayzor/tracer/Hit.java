package de.rayzor.tracer;

import de.rayzor.scene.ObjectBase;

public class Hit implements Comparable<Hit>
{
	private ObjectBase objectHit;
	private Ray ray;
	private double param;
	
	public Hit(ObjectBase objectHit, Ray ray, double param)
	{
		if(objectHit==null)
			throw new IllegalArgumentException("objectHit must not be null");
		
		if(ray==null)
			throw new IllegalArgumentException("ray must not be null");
		
		this.objectHit = objectHit;
		this.ray = ray;
		this.param = param;
	}

	public ObjectBase getObjectHit() {
		return objectHit;
	}

	public void setObjectHit(ObjectBase objectHit) {
		this.objectHit = objectHit;
	}

	public Ray getRay() {
		return ray;
	}

	public void setRay(Ray ray) {
		this.ray = ray;
	}

	public double getParam() {
		return param;
	}

	public void setParam(double distance) {
		this.param = distance;
	}

	@Override
	public int compareTo(Hit o) 
	{
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;
		
		if(o==null)
			return BEFORE;
		
		if(this.ray!=o.getRay())
			throw new IllegalArgumentException("Only Hits based on the same ray can be compared.");
						
		if(this==o)
			return EQUAL;
				
		double compared = this.ray.evaluate(this.param).abs() - o.getRay().evaluate(o.param).abs();
		if(compared < 0)
			return BEFORE;
		else if(compared==0)
			return EQUAL;
		else
			return AFTER;
	}
		
}