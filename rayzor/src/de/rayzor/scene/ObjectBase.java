package de.rayzor.scene;

import java.util.Iterator;

import de.rayzor.tracer.Hit;
import de.rayzor.tracer.Ray;
import de.rayzor.vecmath.Vector3d;

public abstract class ObjectBase 
{
	protected Vector3d location;
	
	public abstract Hit intersect(Ray ray);

	public void add(ObjectBase object)
	{
		throw new UnsupportedOperationException();
	}
	
	public void remove(ObjectBase object)
	{
		throw new UnsupportedOperationException();
	}
	
	public Iterator<ObjectBase> iterator()
	{
		throw new UnsupportedOperationException();
	}
	
	public Vector3d getLocation() {
		return location;
	}

	public void setLocation(Vector3d location) {
		this.location = location;
	}
		
}