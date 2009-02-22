package de.rayzor.scene;

import java.util.ArrayList;
import java.util.List;

public class Scene 
{
	private List<ObjectBase> objects = new ArrayList<ObjectBase>();
	private double maxRayLength;

	public Scene(double maxRayLength)
	{
		this.maxRayLength = maxRayLength;
	}
	
	public void addObject(ObjectBase obj)
	{
		objects.add(obj);
	}
	
	public List<ObjectBase> getObjects() {
		return objects;
	}

	public double getMaxRayLength() {
		return maxRayLength;
	}

	public void setMaxRayLength(double maxRayLength) {
		this.maxRayLength = maxRayLength;
	}
		
}
