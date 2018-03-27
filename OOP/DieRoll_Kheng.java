//Kevin Khen;
// This program simulates rolling two 6 -sided dice
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.ArrayList;
import java.io.*;

//Die class
class Die{
	private int value;
	private int x;
	private int y;
	public int getValue() {
		return value;
	}
	public void setValue(int v){
		if (v < 1) {
			value = 1;
		} else if (v > 6) {
			value = 6;
		} else { 
			value =v;
		}
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		if (x <0) {
			this.x = 0;
		} else {
			this.x = x;
		}
	}
	public int getY() {
		return y;
	}
	public void setY(int y){
		if (y <0) {
			this.y = 0;
		} else {
			this.y = y;
		}
	}

	
	
	
	public Die() {
		value = 1; 
		x = 0;
		y = 0;
	
	}
	public Die(int v,int x, int y){
		setValue(v);
		setX(x);
		setY(y);
		
	}
	public String toString() {
		return String.format("%d,%d, %d ,",value,x,y);
	}
}
/* 
 * The DiceManager class is a controller class.It stores two Die objects 
 * and helps us roll them.To roll them, we need to adjust the value and 
 * the position coordinate of the two Die.
 * The DiceManager makes sure the die are rolled on a playing board of 
 * set dimension - rollWidth and rollHeight
 */
class DiceManager {
	private Die firstDie;
	private Die secondDie;
	private int rollWidth;
	private int rollHeight;
	private Random rnd;
	private Timer tim;
	private static int dieSize;
// made it static so I can hard code the the dices from overlapping.

	//Default constructor
	public DiceManager() {
		rnd = new Random();
		firstDie = new Die();
		secondDie = new Die();
		
	}
	//non default constructor
	public DiceManager( int rw, int rh){
		this(); // call the default constructor
		setRollWidth(rw);
		setRollHeight(rh);
	}
	public int getRollWidth() {
		return rollWidth;
	}
	public void setRollWidth(int rw){
		if (rw < 100) {
			rollWidth = 100;
		} else {
			rollWidth = rw;
		}
	}
	public int getRollHeight() {
		return rollHeight;
	}
	public void setRollHeight( int rh){
		if (rh < 100) {
			rollHeight = 100;
		} else {
			rollHeight = rh;
		}
	}
	// the following several functions help us learn what was actually rolled	
	public Die getFirstDie() {
		return firstDie;
	}
	public Die getSecondDie() {
		return secondDie;
	}
	//created local variable of array of Die with 2 slot
	public Die[] getDice(){
		Die[] result = new Die[2];
		result[0] = firstDie;
		result[1] = secondDie;
		return result;
	}
	public int getTotalRoll () {
		return firstDie.getValue() + secondDie.getValue();
	}
	public void rollDice() {
		rollDie(firstDie);
		rollDie(secondDie);
		
		int dieOneLeft = firstDie.getX();
		int dieOneRight = firstDie.getX() + DiceDrawer.getDieSize();
		int dieOneTop = firstDie.getX();
		int dieOneBottom = firstDie.getY() + DiceDrawer.getDieSize();
		
		int dieTwoLeft = secondDie.getX();
		int dieTwoRight = secondDie.getX() + DiceDrawer.getDieSize();
		int dieTwoTop = secondDie.getY();
		int dieTwoBottom = secondDie.getY() + DiceDrawer.getDieSize();
		
		if((dieOneLeft < dieTwoRight) && (dieOneTop < dieTwoBottom) && (dieOneBottom > dieTwoTop)) {
			rollDice();
		} //This part helps the dice to not overlap
		
	}
	// Randomizing the dices
	public void rollDie(Die theDie) {
		theDie.setValue(1 + rnd.nextInt(6));
		theDie.setX(rnd.nextInt(rollWidth));
		theDie.setY(rnd.nextInt(rollHeight));
	}  
	
	public String toString() {
		return String.format("Die 1: %s Die 2: %s",firstDie.toString(),secondDie.toString());
	}
} 



 


class DiceDrawer {
	private Font font;
	private static int dieSize; // length of each side of the die
	public DiceDrawer(Font f,int ds){
		font = f;
		setDieSize(ds);
	}
	public void setDieSize(int ds){
		if(ds < 20) {
			dieSize = 20;
		} else {
			dieSize = ds;
		}
	}
	//These function are use to determine the size from clicking the button.
	public void smallDie(){
		dieSize = 50 ;
	}
	public void mediumDie() {
		dieSize = 75;
	}
	public void largeDie() {
		dieSize = 100;
	}
	public static int getDieSize() {
		return dieSize;
	}
	
	// pass the parameters so that the dices can be drawn and color outline can be change
	public void drawDice(Die [] dice, JPanel pan,Color outline){
		Graphics g = pan.getGraphics();
		g.setFont(font);
		g.setColor(outline);
		FontMetrics fm = g.getFontMetrics();
		int textX, textY;
		for (Die d : dice) {
			g.drawRect(d.getX(), d.getY(),dieSize, dieSize);
			//todo:draw.d.getValue() in proper place
			textX = d.getX() + dieSize/2 - fm.stringWidth(String.valueOf(d.getValue()))/2 ;
			textY = d.getY() + dieSize/2 + fm.getAscent() /2 ;
			g.drawString(String.valueOf(d.getValue()),textX, textY);
		 }
		
		}   
	
} 
 // This class does my action listener and key events for my class
class DiceFrame extends JFrame implements KeyListener,ActionListener {
	private ArrayList<DiceManager> diceManagers;
	private DiceManager dman;
	private DiceDrawer drawer;
	private JPanel panDice;
	private Font dieFont;
	private int Size;
	private Timer tim;
	private Color color;
	
	
	public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_R){
			color = Color.RED;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_G){
			color=Color.GREEN;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_B){
			color = Color.BLUE;
			repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE){
			dman.rollDice();
			repaint();
		}
	}
    public void keyReleased(KeyEvent e) {
    	
    }
    public void keyTyped(KeyEvent e) {
    	
    }
    
    public void actionPerformed(ActionEvent e){
    	dman.rollDice();
    	repaint();
    }
    // The menu for my interface 
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miReset = new JMenuItem("Reset");
		JMenuItem miSave = new JMenuItem("Save");
		JMenuItem miExit = new JMenuItem("Exit");
		JMenuItem miRoll = new JMenuItem("Roll");
		JMenu mnuAutoRoll =  new JMenu("AutoRoll");
		JMenuItem miStart = new JMenuItem("Start");
		JMenuItem miStop = new JMenuItem("Stop");
		JMenu mnuColor = new JMenu("Color");
		JMenuItem miRed = new JMenuItem("Red");
		JMenuItem miBlue = new JMenuItem("Blue");
		JMenuItem miGreen = new JMenuItem("Green");
		JMenu mnuSize = new JMenu("Size");
		JMenuItem miLarge = new JMenuItem("Large");
		JMenuItem miMedium = new JMenuItem("Medium");
		JMenuItem miSmall = new JMenuItem("Small");
		miExit.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				}
				);
		miReset.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){
						
					}
				}
				
				);
		miRoll.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){
						dman.rollDice();
						repaint();
					}
				}
				
				);
		miStart.addActionListener(
				new ActionListener () {
					public void actionPerformed(ActionEvent e){
						dman.rollDice();
						tim.start();
						repaint();
					
					   
					}
				}
				);
		miStop.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){
				       tim.stop();
				       repaint();
					}
				}
				);
		
		miRed.addActionListener (
				new ActionListener() {
					public void actionPerformed(ActionEvent e){
						color = Color.RED;
						repaint();
					}
				}
				
				);
		miGreen.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){
						color=Color.GREEN;
						repaint();
					}
				}
				);
		miBlue.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){
						color = Color.BLUE;
						repaint();
					}
				}
				);
	 miSmall.addActionListener(
			 new ActionListener() {
				 public void actionPerformed(ActionEvent e){
					 drawer.smallDie();
					 repaint();
				 }
			 }
			 
			 );
	 miMedium.addActionListener(
			 new ActionListener() {
				 public void actionPerformed(ActionEvent e){
					 drawer.mediumDie();
					 repaint();
				 }
			 }
			 
			 );
	 miLarge.addActionListener(
			 new ActionListener() {
				 public void actionPerformed(ActionEvent e){
					 drawer.largeDie();
					 repaint();
				 }
			 }
			 
			 );
	
		
		// add menu items and menu to the the frame
		mnuFile.add(miExit);
		mnuFile.add(miRoll);
		mnuFile.add(miReset);
		mnuFile.add(miSave);
		mnuAutoRoll.add(miStart);
		mnuAutoRoll.add(miStop);
		mnuColor.add(miRed);
		mnuColor.add(miGreen);
		mnuColor.add(miBlue);
		mnuSize.add(miLarge);
		mnuSize.add(miMedium);
		mnuSize.add(miSmall);
		mbar.add(mnuFile);
		mbar.add(mnuAutoRoll);
		mbar.add(mnuColor);
		mbar.add(mnuSize);
		setJMenuBar(mbar);
		
	}
	public DiceFrame(ArrayList<DiceManager> diceManagers) {
		dman = new DiceManager(400,600); // composition
		dieFont = new Font("Arial",Font.BOLD,18);
		drawer = new DiceDrawer(dieFont,50);
		drawer = new DiceDrawer(dieFont,50);
		tim = new Timer(3000,this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,500,500);
		setTitle("Kevin's Kheng Dice Application");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		panDice = new JPanel();
		c.add(panDice,BorderLayout.CENTER);
		JPanel panButton = new JPanel();
		JButton btnRoll = new JButton("Roll Dice");
		btnRoll.addActionListener(
                new ActionListener() {
				   public void actionPerformed(ActionEvent e){
				       // tell a DiceManager to roll the dice
					   // force a repaint
					   dman.rollDice();
					   repaint();
					    }
				   }
				);
		
		panButton.add(btnRoll);
		c.add(panButton,BorderLayout.SOUTH);
		setupMenu();
		addKeyListener(this);
		setFocusable(true);

	}
	public void paint(Graphics g){
		super.paint(g);
		//draw the dice 
		drawer.drawDice(dman.getDice(), panDice,color);
		     
	}
}

/*class PointIO {
	public boolean saveDiceRolltoFile()
}*/
public class DieRoll_Kheng{
	public static void main(String[] args) {
	DiceManager dman = new DiceManager(500,500);
		/*for (int i = 0; i <10; i ++) {
			dman.rollDice();
			System.out.println(dman);
		
		}*/
		ArrayList<DiceManager> diceManagers = new ArrayList<DiceManager>();
		for(DiceManager d : diceManagers ){
			System.out.println(d);
		}
		
		DiceFrame df = new DiceFrame(diceManagers);
		df.setVisible(true);
	}

}