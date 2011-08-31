import java.awt.Point;
public class Tile {
private int index, xCorner, yCorner, xLength, yLength, pointZ, pointM, pointVx, pointVy;
private String picName;
private Point[] points;
	public Tile(int pIndex, int pXCorner, int pYCorner, int pXLength, int pYLength, int pPointZ, int pPointM, int pPointVx, int pPointVy, String pPicName, Point[] pPoints)
	{
		index=pIndex;
		xCorner=pXCorner;
		yCorner=pYCorner;
		xLength=pXLength;
		yLength=pYLength;
		pointZ=pPointZ;
		pointM=pPointM;
		pointVx=pPointVx;
		pointVy=pPointVy;
		picName=pPicName;
		points=pPoints;
	}
	
	public void setIndex(int pIndex)
	{
		index=pIndex;
	}
	public int getIndex()
	{
		return index;
	}
	
	public void setXCorner(int pXCorner)
	{
		xCorner=pXCorner;
	}
	public int getXCorner()
	{
		return xCorner;
	}
	
	public void setYCorner(int pYCorner)
	{
		yCorner=pYCorner;
	}
	public int getYCorner()
	{
		return yCorner;
	}
	
	public void setXLength(int pXLength)
	{
		xLength=pXLength;
	}
	public int getXLength()
	{
		return xLength;
	}
	
	public void setYLength(int pYLength)
	{
		yLength=pYLength;
	}
	public int getYLength()
	{
		return yLength;
	}
	
	public void setPointZ(int pPointZ)
	{
		pointZ=pPointZ;
	}
	public int getPointZ()
	{
		return pointZ;
	}
	
	public void setPointM(int pPointM)
	{
		pointM=pPointM;
	}
	public int getPointM()
	{
		return pointM;
	}
	
	public void setPointVx(int pPointVx)
	{
		pointVx=pPointVx;
	}
	public int getPointVx()
	{
		return pointVx;
	}
	
	public void setPointVy(int pPointVy)
	{
		pointVy=pPointVy;
	}
	public int getPointVy()
	{
		return pointVy;
	}
	
	public void setPicName(String pPicName)
	{
		picName=pPicName;
	}
	public String getPicName()
	{
		return picName;
	}
	
	public void setPoints(Point[] pPoints)
	{
		points=pPoints;
	}
	public Point[] getPoints()
	{
		return points;
	}
}
