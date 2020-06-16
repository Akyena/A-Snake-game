import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private ImageIcon titleImage;
	private int[] snakesXlength = new int [750];
	private int[] snakesYlength = new int [750];
	
	private boolean left;
	private boolean right ;
	private boolean up ;
	private boolean down = false;
	 
	private ImageIcon rightmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon leftmouth;
	private ImageIcon snakeimage;
	
	// Define default lenht of snake
	private int lengthofsnake = 3;
	
	
	//Define moves
	private int moves = 0;
	
	// speed of snake
	private Timer timer;
	private int delay = 100;
	
	//Enemy variables
	private int[] enemyxpos= {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	
	private int [] enemyypos= {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
	
private ImageIcon enemyimage;

private Random random = new Random();


// Score Variables
private int score = 0;




//#34 is for horiaontal in enemxpos
private int xpos = random.nextInt(34);
private int ypos = random.nextInt(23);

//BEgin Gameplay movements and design	
	public Gameplay()
	{
		addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
	//start timer
		timer = new Timer(delay, this);
		timer.start();
	}

	
	public void paint (Graphics g) {
		if(moves == 0)
		{
		// check if game has began	
			snakesXlength[2]=50;
			snakesXlength[1]=75;
			snakesXlength[0]=100;
			
			snakesYlength[2]=100;
			snakesYlength[1]=100;
			snakesYlength[0]=100;
			
			
		}
		
		
		
		// Draw titleimage border
		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 851,55);
		
		//Draw title image
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25,10 );
		
		 
		//Draw border for game playing area
		g.setColor(Color.WHITE);
		g.drawRect(24,74,851,577);
		
		
		//Draw Background for the gamplay
		g.setColor(Color.BLACK);
		g.fillRect(25, 75,850, 575);
		
		//Draw scores
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN,14));
		g.drawString("Scores: "+score, 780,30);
		
		//Draw Length of snakes
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN,14));
		g.drawString("Snake's Length: "+lengthofsnake, 760,50);
		
		
		
	rightmouth = new ImageIcon("rightmouth.png");
		// the array will store first posmof the snake in the frist index
	rightmouth.paintIcon(this, g, snakesXlength[0], snakesYlength[0]);
		
		
		for(int a =0;a<lengthofsnake;a++) {
		// Detect direction of snake
			//check
	if(a==0 && right) {
		
		rightmouth = new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snakesXlength[a], snakesYlength[a]);
		
	}
if(a==0 && left) {
		
		leftmouth = new ImageIcon("leftmouth.png");
		leftmouth.paintIcon(this, g, snakesXlength[a], snakesYlength[a]);
		
	}
	
if(a==0 && down) {
	
	downmouth = new ImageIcon("downmouth.png");
	downmouth.paintIcon(this, g, snakesXlength[a], snakesYlength[a]);
	
}
			
if(a==0 && up) {
	
	upmouth = new ImageIcon("upmouth.png");
	upmouth.paintIcon(this, g, snakesXlength[a], snakesYlength[a]);
	
}	

if(a!=0)
	// draw body of snake
{
	snakeimage = new ImageIcon("snakeimage.png");

	snakeimage.paintIcon(this, g, snakesXlength[a], snakesYlength[a]);
	
}
		}
	enemyimage = new ImageIcon("enemy.png");	
	
		if ((enemyxpos[xpos]== snakesXlength[0]) && enemyypos[ypos]== snakesYlength[0])
				{
			score++; 
			lengthofsnake++;//thats after the snake collides with the food
			
			xpos = random.nextInt(34);
			ypos= random.nextInt(23);
			
			
					}
		enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
		
		
		//Checking collision
		for (int b =1; b<lengthofsnake;b++)
		{
			if(snakesXlength[b] == snakesXlength[0] && snakesYlength[b] == snakesYlength[0])
			{
				right=false;
				left=false;
				up=false;
				down=false;
				g.setColor(Color.WHITE);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("Game OVer hahaha", 300, 300);
				
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("ESC to RESTART", 350, 340);
				
			}
			
			
		}
		
		
		
		g.dispose();
		
		
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// need to start the timer
				timer.start();
				if (right) 
				{
					
					for(int r = lengthofsnake-1; r>=0; r--)
					{
					//move head to nexxt index
						snakesYlength[r+1]=snakesYlength[r];
						
								}
			
					for(int r =lengthofsnake; r>=0; r--) {
						//shift pos of snake in x lenghts
						if (r==0)
						{
							snakesXlength[r] = snakesXlength[r]+25;
									}
						
						else
						{
							snakesXlength[r]=snakesXlength[r-1];
						}
			//if snake comes touches border ,
			//it must continue from the other side
					//check pos of head that if below
						if(snakesXlength[r]> 850)
						{
							//make pos to begin
							snakesXlength[r] = 25;
							
						}
					}
					// Call back paint
					repaint();
					
				}
////////////////////////////////////////left movement
		if (left) { 
			for(int r = lengthofsnake-1; r>=0; r--)
			{
			//move head to nexxt index
				snakesYlength[r+1]=snakesYlength[r];
				
						}
	
			for(int r =lengthofsnake; r>=0; r--) {
				//shift pos of snake in x lenghts
				if (r==0)
				{
					snakesXlength[r] = snakesXlength[r]-25;
							}
				
				else
				{
					snakesXlength[r]=snakesXlength[r-1];
				}
	//if snake comes touches border ,
	//it must continue from the other side
			//check pos of head that if below
				if(snakesXlength[r]< 25)
				{
					//make pos to begin
					snakesXlength[r] = 850;
					
				}
			}
			// Call back paint
			repaint();
			
			
			
			
				}
		
		

		////////////////////// up movement
				
		if (up) {
					
			for(int r = lengthofsnake-1; r>=0; r--)
			{
			//move head to nexxt index
				snakesXlength[r+1]=snakesXlength[r];
				
						}
	
			for(int r =lengthofsnake; r>=0; r--) {
				//shift pos of snake in Y lenghts since going up
				if (r==0)
				{
					snakesYlength[r] = snakesYlength[r]-25;
							}
				
				else
				{
					snakesYlength[r]=snakesYlength[r-1];
				}
	//if snake comes touches border ,
	//it must continue from the other side
			//check pos of head that if below
				if(snakesYlength[r]< 75)
				{
					//make pos to begin
					snakesYlength[r] = 625;
					
				}
			}
			// Call back paint
			repaint();
			
			
			
				}
				
		

////////////////////////////////////////// down snake movement
		if (down) {
			
			for(int r = lengthofsnake-1; r>=0; r--)
			{
			//move head to nexxt index
				snakesXlength[r+1]=snakesXlength[r];
				
						}
			 
	
			for(int r =lengthofsnake; r>=0; r--) {
				//shift pos of snake in x lenghts
				if (r==0)
				{
					snakesYlength[r] = snakesYlength[r]+25;
							}
				
				else
				{
					snakesYlength[r]=snakesYlength[r-1];
				}
	//if snake comes touches border ,
	//it must continue from the other side
			//check pos of head that if below
				if(snakesYlength[r] >625 )
				{
					//make pos to begin
					snakesYlength[r] = 75;
					
				}
			}
			// Call back paint
			repaint();
			
			
			
			
		}
		
		
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
	

		}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
{
	moves=0;
	score=0;
	lengthofsnake=3;
	repaint();
	
	
	
	
}
		
		
		
	// when right key is pressed
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			moves++;
		right = true;
		// if not left then right 
		if(!left) {
			
			right = true;
		}
		else
		{
		right = false;
		left = true;
		}
			
		
		up = false;
		down= false;
			
		}
		////////////////////////////////////////
		
		// when LEFT key is pressed
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			moves++;
		left = true;
		// if not right then left
		if(!right) {
			
			left = true;
		}
		else
		{
		left = false;
		right = true;
		}
			
		
		up = false;
		down= false;
			
		}
		
////////////////////////////////////////
		
// when UP key is pressed
if(e.getKeyCode()==KeyEvent.VK_UP) {
moves++;
up = true;
// if not up then left
if(!down) {

up = true;
}
else
{
up = false;
down = true;
}

  
left = false;
right= false;

}
		
///////////////////////////////////////////////////////

// when LEFT key is pressed
if(e.getKeyCode()==KeyEvent.VK_DOWN) {
moves++;
down = true;
// if not up then down
if(!up) {

 down= true;
}
else
{
down = false;
up = true;
}


left = false;
right= false;

}
////////////////////////////////////////////////////////
	}




	
	
}
