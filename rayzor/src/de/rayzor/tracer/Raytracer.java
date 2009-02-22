package de.rayzor.tracer;

import java.awt.Color;
import java.awt.image.BufferedImage;

import de.rayzor.scene.ObjectBase;
import de.rayzor.scene.Scene;
import de.rayzor.scene.Sphere;
import de.rayzor.vecmath.Vector3d;

public class Raytracer 
{
	
	public BufferedImage raytrace(Scene scene, Camera cam, BufferedImage image)
	{
		for(int y=0; y<image.getHeight(); y++)
		{
			for(int x=0; x<image.getWidth(); x++)
			{
				Ray ray = makeRay(x, y, cam, image);
				Hit hit = null;
				for(ObjectBase obj: scene.getObjects())
				{
					Hit tempHit = obj.intersect(ray);
					if(tempHit!=null && tempHit.compareTo(hit)<0)
					{
						hit = tempHit;	
					}						
				}
				image.setRGB(x, y, makeColor(hit, scene));	
			}
		}
		return image;
	}
	
	private Ray makeRay(int x, int y, Camera cam, BufferedImage image)
	{
		double xPart = x - image.getWidth() / 2;
		double yPart = y - image.getHeight() / 2;
		double zPart = -( image.getWidth()/2 / Math.tan( cam.getAlpha()/2 ) );
		
		return new Ray(cam.getLocation(), new Vector3d(xPart, yPart, zPart));
	}
	
	private int makeColor(Hit hit, Scene scene)
	{		
		if(hit==null)
			return Color.BLUE.getRGB();
		
		if(hit.getObjectHit() instanceof Sphere)
			return new Color(0, 255, 0).getRGB();
		
		double distance = hit.getRay().evaluate(hit.getParam()).abs();
		if(distance>=scene.getMaxRayLength())
			return Color.BLUE.getRGB();
		
		int gray = (int)(distance * 255 / scene.getMaxRayLength());
		return new Color(gray, gray, gray).getRGB();
	}
}
