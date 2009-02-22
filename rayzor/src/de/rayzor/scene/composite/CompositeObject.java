package de.rayzor.scene.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.rayzor.scene.ObjectBase;

public abstract class CompositeObject extends ObjectBase 
{

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
