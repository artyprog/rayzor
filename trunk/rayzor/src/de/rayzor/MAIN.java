package de.rayzor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.rayzor.scene.Plane;
import de.rayzor.scene.Scene;
import de.rayzor.scene.Sphere;
import de.rayzor.tracer.Camera;
import de.rayzor.tracer.Raytracer;
import de.rayzor.vecmath.Vector3d;

public class MAIN 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Plane plane 	= new Plane(new Vector3d(0,0,0), new Vector3d(0, 1, 0));
		Sphere sphere 	= new Sphere(new Vector3d(300, 300, -1000), 200);
		
		Scene scene 	= new Scene(5000);
		scene.addObject(plane);
		scene.addObject(sphere);
		
		Camera camera	= new Camera(new Vector3d(30, 120, 0), Math.PI / 4);
		
		BufferedImage image = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
		
		Raytracer tracer = new Raytracer();
		tracer.raytrace(scene, camera, image);
		
		File file = new File("d:/tracer.png");
		try {
			ImageIO.write(image, "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
