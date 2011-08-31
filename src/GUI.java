import javax.swing.*;
import java.io.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class GUI extends JFrame implements KeyListener{

	Can can;
	JMenuBar menu;
	JMenu file, options, help;
	JLabel turn, speedLbl, actualVectorLbl, roadVectorLbl, speed, actualVector, roadVector;
	Player[][] players;
	int actualTurn, status, cursorX, cursorY;
	JFileChooser loadMap, loadSave;
	RandomAccessFile reader;
	String mapname;
	
	public GUI()
	{
		super("Vector-Race");
		setSize(800,600);
		setLocation(0,0);
		setLayout(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addKeyListener(this);
		
		status=0;
		
		can=new Can(this);
		can.setBounds(265,15,500,500);
		add(can);
		
		loadMap=new JFileChooser();
		loadMap.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Maps (*.map)","*.*"));
		
		loadSave=new JFileChooser();
		loadSave.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Saves (*.sav)","*.*"));
		
		menu=new JMenuBar();
		file=new JMenu("File");
		options=new JMenu("Options");
		help=new JMenu("Help");
		menu.add(file);
		menu.add(options);
		menu.add(help);
		setJMenuBar(menu);
		
		turn=new JLabel("X´s Turn");
		turn.setBounds(0,30,265,20);
		add(turn);
		turn.setHorizontalAlignment(SwingConstants.CENTER);
		
		actualVectorLbl=new JLabel("Actual Vector:");
		actualVectorLbl.setBounds(00,80,265,20);
		add(actualVectorLbl);
		actualVectorLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		actualVector=new JLabel("(  0    0  )");
		actualVector.setBounds(0,130,265,20);
		add(actualVector);
		actualVector.setHorizontalAlignment(SwingConstants.CENTER);
		
		speedLbl=new JLabel("Actual Speed:");
		speedLbl.setBounds(0,180,265,20);
		add(speedLbl);
		speedLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		speed=new JLabel(calcSpeed(0,0));
		speed.setBounds(0,230,265,20);
		add(speed);
		speed.setHorizontalAlignment(SwingConstants.CENTER);
		
		roadVectorLbl=new JLabel("Road´s Vector:");
		roadVectorLbl.setBounds(0,280,265,20);
		add(roadVectorLbl);
		roadVectorLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		roadVector=new JLabel("(  0    0  )");
		roadVector.setBounds(0,330,265,20);
		add(roadVector);
		roadVector.setHorizontalAlignment(SwingConstants.CENTER);
		
		Action newGame = new AbstractAction( "New..." ) {
			  public void actionPerformed( ActionEvent e ) {
				  while(true)
				  {
					  try
					  {
						  String answer=JOptionPane.showInputDialog("Spielerzahl angeben:");
						  if(answer==null) break;
						  int playerNumber=Integer.parseInt(answer);
						  players=new Player[playerNumber][1];
						  for(int i=0;i< playerNumber;i++)
						  {
							  players[i][0]=new Player(i+1,10,10,0,1,0);
						  }
						  status=1;
						  actualTurn=1;
						  setLabels();
						  cursorX=players[actualTurn][0].getX();
						  cursorY=players[actualTurn][0].getY();
						  int returnVal=loadMap.showDialog(null, "Load...");
						  if(returnVal==JFileChooser.APPROVE_OPTION)
						  {
							  String map=loadMap.getSelectedFile().getAbsolutePath();
							  useMap(map);
						  }
						  break;
					  }
					  catch(NumberFormatException ex)
					  {
						  System.err.println("Das war keine Zahl!");
					  }
					  catch(Exception ex)
					  {
						  System.out.println( ex.getClass().getName() );
						  System.out.println( ex.getMessage() ); 
						  System.out.println( ex.toString() );
						  ex.printStackTrace();
					  }
				  }
			  }
			};
		file.add(newGame);
		Action load = new AbstractAction( "Load..." ) {
			  public void actionPerformed( ActionEvent e ) {
				  while(true)
				  {
					  try
					  {
						  int returnVal=loadSave.showDialog(null, "Load...");
						  if(returnVal==JFileChooser.APPROVE_OPTION)
						  {
							  String loadedGame=loadSave.getSelectedFile().getAbsolutePath();
							  loadSave(loadedGame);		
						  }
						  break;
					  }
					  catch(Exception ex)
					  {
						  System.out.println( ex.getClass().getName() );
						  System.out.println( ex.getMessage() ); 
						  System.out.println( ex.toString() );
						  ex.printStackTrace();
					  }
				  }
			  }
			};
		file.add(load);
		Action save = new AbstractAction( "Save..." ) {
			  public void actionPerformed( ActionEvent e ) {
				  while(true)
				  {
					  try
					  {
						  int returnVal=loadSave.showDialog(null, "Save as...");
						  if(returnVal==1)
						  {
							  break;
						  }
						  String savePath=loadSave.getSelectedFile().getAbsolutePath();
						  save(savePath);
						  break;
					  }
					  catch(Exception ex)
					  {
						  System.out.println( ex.getClass().getName() );
						  System.out.println( ex.getMessage() ); 
						  System.out.println( ex.toString() );
						  ex.printStackTrace();
					  }
				  }
			  }
			};
		file.add(save);
		Action resolution = new AbstractAction( "Change resolution..." ) {
			  public void actionPerformed( ActionEvent e ) {
			    
			  }
			};
		options.add(resolution);
		Action howTo = new AbstractAction( "How to play" ) {
			  public void actionPerformed( ActionEvent e ) {
			    
			  }
			};
		help.add(howTo);
		help.addSeparator();
		Action about = new AbstractAction( "About" ) {
			  public void actionPerformed( ActionEvent e ) {
			    
			  }
			};
		help.add(about);
		
		setVisible(true);
	}
	
	public String calcSpeed(int vx, int vy)
	{
		double v=Math.sqrt((vx*vx)+(vy*vy));
		return "" + v*10 + " m/s";
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		System.out.println(e.getKeyText(e.getKeyCode()));
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
	
	public void useMap(String mapPath) throws Exception
	{
		System.out.println(mapPath);
		reader=new RandomAccessFile("mapPath","r");
		String readin=reader.readLine();
		mapname=readin;
		String map="";
		while(readin!=null)
		{
			readin=reader.readLine();
			map+="|";
			map+=readin;
		}
		String[] loadedMap=map.split("|");
		can.setMap(loadedMap);
	}
	
	public void loadSave(String loadedGame) throws Exception
	{
		System.out.println(loadedGame);
		reader=new RandomAccessFile("loadedGame","r");
		String readin=reader.readLine();
		String save=readin;
		while(readin!=null)
		{
			readin=reader.readLine();
			save+="|";
			save+=readin;
		}
	}
	
	public void save(String savePath) throws Exception
	{
		System.out.println(savePath);
		reader=new RandomAccessFile("savePath","rw");
		
		
	}
	
	public void setLabels()
	{
		turn.setText("Player " + actualTurn + "´s turn");
		actualVector.setText("(  " + players[actualTurn-1][players[actualTurn-1].length-1].getVx() + "    " + players[actualTurn-1][players[actualTurn-1].length-1].getVy() + "  )");
		speed.setText(calcSpeed(players[actualTurn-1][players[actualTurn-1].length-1].getVx(),players[actualTurn-1][players[actualTurn-1].length-1].getVy()));
	}
}
