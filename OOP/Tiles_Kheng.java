/*CS 245 Lewis University 
 * Kevin Kheng Tiles
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random; 
import java.awt.event.*;

class Tile {
	private int row; 
	private int col;
	private int shape;
	private char letter;
	private Color color;
	//Default constructor
	public Tile(){
		row = 0 ; 
	    col = 0;
		shape = 0;
		letter =(char)65;
		color = Color.BLACK;
		
	}
	
	// Get Function

	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public char getLetter() {
		return letter;
	}
	public int getShape(){
		return shape;
	}
	public Color getColor(){
		return color;
	}
	
//Set Functions
	
	public void setRow(int row) {
		this.row = row;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public void setLetter(char str){
		letter = str;
	}
	public void setShape (int s ){
		if ((shape <= 0) || (shape > 1)){
			shape = 0;
		}else 
		
		  { shape = s;
		 }
		}
	public void setColor(Color col){
		color = col;
	}
	public void setColor(int r, int g, int b){
		color = new Color(r,g,b);
	}
	
	
	// non default constructor,takes in parameters 
	public Tile (int row ,int col,int shape,char letter,int r, int g, int b){
		setRow(row);
		setCol(col);
		setShape(shape);
		setLetter(letter);
		setColor(r,g,b);
	}
	//To String function
    public String getColorString() {
    	return String.format("%d %d %d",color.getRed(),color.getGreen(),color.getBlue());
    }
	public String toString() {
		return String.format("%d %d %d %s %s",row,col,shape,letter,getColorString());
	}	
}
//Tile printer class
class TilePrinter {
	public void printTiles(ArrayList<Tile> tiles){
		for (Tile t: tiles){
			System.out.println(t);
		}	
	}
	
}


// MVC 
class TilePanel extends JPanel {
	
}
class TileFrame extends JFrame  {
	private TilePanelController tpc;
	public TileFrame (ArrayList<Tile> tiles) {
		setBounds(100,50,500,500); // Setting the dimension of interface frame
		setTitle("Tiles");
		setDefaultCloseOperation(EXIT_ON_CLOSE); //a close operation for the interface
		Container c = getContentPane () ; 
		c.setLayout(new BorderLayout()); // The layout 
		TilePanel panTiles = new TilePanel (); //Uses the graphics g function
		c.add(panTiles,BorderLayout.CENTER);
	    tpc = new TilePanelController (tiles,panTiles);
	    JButton btnRandomize = new JButton("Randomize");
	    btnRandomize.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		repaint();
	    	}
	    });
	    JPanel panButton = new JPanel();
	    panButton.add(btnRandomize);
	    c.add(panButton,BorderLayout.SOUTH);
	    
	    
	 
	}
	public void paint(Graphics g){
		super.paint(g); // rendering the internals of the frame
		tpc.drawTiles();
	}
}
//Controller Class
class TilePanelController {
	private TilePanel panTile;
	private ArrayList<Tile> tiles;
	private Random rnd;
	public TilePanelController(ArrayList<Tile> tiles, TilePanel pan){
		this.tiles = tiles;
		panTile = pan;
		rnd = new Random();
	}
	public void drawTiles() {
		Graphics g = panTile.getGraphics();
			for (Tile t: tiles){
				g.setColor(t.getColor());
				g.fillOval (t.getRow(), t.getCol(), 50 , 50);
				//Determine what shape will be drawn
				
				//Circle
				if(t.getShape() == 1){
					g.fillOval(t.getRow(), t.getCol(), 50 , 50);
				} 
				else { 
					g.fillRect(t.getRow(), t.getCol(), 50 , 50);
				}
				// Font of the color will be change 
				g.setColor (new Color(255 - t.getColor().getRed(),255 - t.getColor().getGreen(), 255 - t.getColor().getBlue()));
				// Draw the letter and center it onto the shape
				g.drawString(Character.toString(t.getLetter()), t.getRow()+19, t.getCol() + 30);
			
		}
	}

	}
class TileRandomizer {
	public ArrayList<Tile> buildTiles(){
		ArrayList<Tile> tiles = new ArrayList <> ();
		Random rnd = new Random();
		for(int i = 0; i < 10; i ++){
			for(int j = 0; j <10; j ++){
				tiles.add(new Tile(i * 50,j * 50, rnd.nextInt(2), (char) (65 + rnd.nextInt(26)),rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256)));
			}
			
		}
		return tiles;
	       
		}
	 public void changeTile(Tile tile){
		 Random rnd = new Random();
		 int r, g, b, shape;
		 char letter = (char) (65 + rnd.nextInt(26));
		 r = rnd.nextInt(255);
		 g = rnd.nextInt(255);
		 b = rnd.nextInt(255);
		 shape = rnd.nextInt(2);
         tile.setColor(new Color(r,g,b));
		 tile.setLetter(letter);
		 tile.setShape(shape);
	 }
	 public void changeTiles(ArrayList<Tile>tiles){
		 for(Tile t: tiles) {
			 changeTile(t);
		 }
	 }
	}

//Main Method
public class Tiles_Kheng {
	public static void main(String[] args) {
		// Call Tile randomizer 
		TileRandomizer T = new TileRandomizer();
		ArrayList<Tile> tiles = T.buildTiles();
		TileFrame tF = new TileFrame(tiles);
		tF.setVisible(true);
	

	}

}


