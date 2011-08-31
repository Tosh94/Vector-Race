import java.awt.*;
public class Player {
private int number, x, y, z
, speed, vx, vy;
Point[] pathTrack;
	public Player(int pNumber, int pX, int pY, int pZ, int pVx, int pVy)
	{
		number=pNumber;
		x=pX;
		y=pY;
		z=pZ;
		vx=pVx;
		vy=pVy;
		speed=calcSpeed(vx,vy);
		pathTrack=new Point[1];
		pathTrack[0]=new Point(x,y);
	}
	
	public void setNumber(int pNumber)
	{
		number=pNumber;
	}
	public int getNumber()
	{
		return number;
	}
	
	public void setX(int pX)
	{
		x=pX;
	}
	public int getX()
	{
		return x;
	}
	
	public void setY(int pY)
	{
		y=pY;
	}
	public int getY()
	{
		return y;
	}
	
	public void setZ(int pZ)
	{
		z=pZ;
	}
	public int getZ()
	{
		return z;
	}
	
	public void setVector(int pVx, int pVy)
	{
		vx=pVx;
		vy=pVy;
		speed=calcSpeed(vx,vy);
	}
	public int getVx()
	{
		return vx;
	}
	public int getVy()
	{
		return vy;
	}
	public int getSpeed()
	{
		return speed;
	}
	
	public Point[] getPathTrack()
	{
		return pathTrack;
	}
	public void setPathTrack(Point[] newTrack)
	{
		pathTrack=newTrack;
	}
	public void nextPoint(Point next)
	{
		x=next.x;
		y=next.y;
		Point[] newTrack;
		newTrack=new Point[pathTrack.length];
		for(int i=0;i<pathTrack.length;i++)
		{
			newTrack[i]=pathTrack[i];
		}
		newTrack[newTrack.length-1]=new Point(x,y);
		pathTrack=newTrack;
	}
	
	
	public int calcSpeed(int pVx, int pVy)
	{
		return (int)(Math.sqrt(vx*vx+vy*vy));
	}
}
