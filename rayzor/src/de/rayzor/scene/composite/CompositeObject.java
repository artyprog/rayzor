package de.rayzor.scene.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.rayzor.scene.ObjectBase;
import de.rayzor.vecmath.Vector3d;

public abstract class CompositeObject extends ObjectBase 
{

	public CompositeObject(Vector3d location) 
	{
		super(location);
	}

	private List<ObjectBase> components = new ArrayList<ObjectBase>();

	@Override
	public void add(ObjectBase object) 
	{
		components.add(object);
	}

	@Override
	public Iterator<ObjectBase> iterator() 
	{
		return components.iterator();
	}

	@Override
	public void remove(ObjectBase object) 
	{
		components.remove(object);
	}	

	
}
