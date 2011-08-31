import java.awt.*;
@SuppressWarnings("serial")
public class Can extends Canvas{

	
	public Can(GUI g)
	{
		
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0,0,500,500);
		g.setColor(Color.black);
		for(int i=1;i<50;i++)
		{
			g.drawLine(0,i*10,500,i*10);
			g.drawLine(i*10,0,i*10,500);
		}
	}
	
	public void setMap(String[] newMap)
	{
		
	}
}
