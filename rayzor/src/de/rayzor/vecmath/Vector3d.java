package de.rayzor.vecmath;

/**
 * A simple class representing a 3d vector with
 * double typed components
 * 
 * @author Gregor Raschke
 *
 */
public class Vector3d 
{
	private double x;
	private double y;
	private double z;
	
	public Vector3d()
	{
		this(0d, 0d, 0d);
	}
	
	public Vector3d(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3d add(Vector3d v)
	{
		if(v==null)
			throw new IllegalArgumentException("Can't add 'null'");
		
		return new Vector3d(x+v.getX(), y+v.getY(), z+v.getZ());
	}
	
	public Vector3d sub(Vector3d v)
	{
		if(v==null)
			throw new IllegalArgumentException("Can't subtract 'null'");
		
		return new Vector3d(x-v.getX(), y-v.getY(), z-v.getZ());
	}
	
	public Vector3d mult(double scalar)
	{
		return new Vector3d(scalar*x, scalar*y, scalar*z);	
	}
	
	public double dot(Vector3d v)
	{
		if(v==null)
			throw new IllegalArgumentException("Can't calculate dot-product with 'null'");
		
		return x*v.getX() + y*v.getY() + z*v.getZ();
	}
	
	public double abs()
	{
		return Math.sqrt(this.dot(this));
	}
	
	public Vector3d cross(Vector3d v)
	{
		if(v==null)
			throw new IllegalArgumentException("Can't calculate cross-product with 'null'");
		
		double xPart = y*v.getZ() - z*v.getY();
		double yPart = z*v.getX() - x*v.getZ();
		double zpart = x*v.getY() - y*v.getX();
		
		return new Vector3d(xPart, yPart, zpart);
	}
	
	public double angle(Vector3d v)
	{
		return Math.acos( this.dot(v) / (this.abs() * v.abs()) );
	}
	
	public void norm()
	{
		double var = this.abs();
		if(var==0)
			return;
		
		x /= var;
		y /= var;
		z /= var;
	}
	
	/**
	 * Getter and Setter
	 */
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
		
}