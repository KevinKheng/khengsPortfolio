/*CS 245 Lewis University \
 * Kevin Kheng Face Draw Assignment 
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random; 

 class FaceClass {
	private int x ; 
	private int y;
	private int h;
	private int w;
	private int ss;
	
	public FaceClass() {  // Default Constructor
		x = 0;
		y = 0;
		h = 0;
		w = 0;
		ss = 0;
	}
	// Get Function
	public int getX() {
		return x;
	}
	public int getY(){
		return y ; 
	}
	public int getWidth () {
		return w ;
	}
	public int getHeight() {
		return h;
	}
	public int getSmileStatus() {
		return ss;
	}
//Set Functions
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y) { 
		this.y = y;
	}
	public void setWidth( int w){
		this.w = w ;
	}
	public void setHeight(int h){
		this.h = h;
	}
	public void setSmileStatus(int ss){
		this.ss = ss;
	}
	// non default constructor,takes in parameters 
	public FaceClass(int x,int y, int w , int h, int ss){
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setSmileStatus(ss);
	}
	
	
	//toString method
	public String toString() {
	 return String.format("x=%d y=%d w= %d h=%d  ss= %d ",getX(),getY(),getWidth(),getHeight(),getSmileStatus());
	}
	

}

// This Face Panel is compile with the Model View Controller
class FacePanel extends JPanel {
	
}
class FaceFrame extends JFrame {
	private DrawFacePanelController dfpc;
	public FaceFrame (ArrayList<FaceClass> faces) {
		setBounds(100,50,500,500); // Setting the dimension of interface frame
		setTitle("Faces");
		setDefaultCloseOperation(EXIT_ON_CLOSE); //a close operation for the interface
		Container c = getContentPane () ; 
		c.setLayout(new BorderLayout()); // The layout 
		FacePanel panCircles = new FacePanel (); //Uses the graphics g function
		c.add(panCircles,BorderLayout.CENTER);
	    dfpc = new DrawFacePanelController(faces,panCircles);
	}
	public void paint(Graphics g){
		super.paint(g); // rendering the internals of the frame
		dfpc.drawFaces();
	}
}
//Controller Class
class DrawFacePanelController {
	private FacePanel panFace;
	private ArrayList<FaceClass> faces;
	public DrawFacePanelController(ArrayList<FaceClass> faces, FacePanel pan){
		this.faces = faces;
		panFace =pan;
	}
	public void drawFaces() {
		Graphics g = panFace.getGraphics();
for (FaceClass f : faces){
			
			//Face Outline
			g.drawOval(f.getX(),f.getY(),f.getWidth(),f.getHeight());
//I have to manipulate the 2 eyes, mouth status in order to get my eyeballs and mouth
//in my face outline. I played with numbers alot in order to get my eyeballs and mouth in the correct position.
			//left eye
			g.drawOval(f.getX() + (int)(f.getWidth() / 3),f.getY() + (int)(f.getHeight()/3),
					(int)(.1 *f.getWidth()),(int)(.1 * f.getHeight()));
			//right eye 
			g.drawOval(f.getX() + (int)( 2 * f.getWidth() / 3),f.getY() + (int)(f.getHeight()/3),
					(int)(.1 *f.getWidth()),(int)(.1 * f.getHeight()));
			
			//To determine the mouth status 
			if (f.getSmileStatus() == 1){
				//mouth frowning status
				g.drawArc(f.getX() + (int)(f.getWidth() / 4),f.getY() + (int)(f.getHeight()/2),
						(int)(.5 *f.getWidth()),(int)(.5 * f.getHeight()), 0, 180);
			} // mouth smiling status
			else if (f.getSmileStatus() == 2)
				g.drawArc(f.getX() + (int)(f.getWidth() / 4),f.getY() + (int)(f.getHeight()/2),
						(int)(.5 *f.getWidth()),(int)(.4 * f.getHeight()), 0, -180);
			else 
				//mouth neutral status
				g.drawLine(f.getX() + (int)(f.getWidth() / 2),f.getY() + (int)(f.getHeight()/1.5),
						f.getX() + (int)(f.getWidth() / 3),f.getY() + (int)(f.getHeight()/1.5));

		
		}
		
	}
}
//Main Method
public class FaceDraw {
	public static void main(String[] args) {
		Random rnd = new Random ();
		int faceCount = 3 + rnd.nextInt(10);
		FaceClass f;
		ArrayList <FaceClass> faces = new ArrayList <FaceClass>();
		for (int i = 0 ; i < faceCount; i++) {
			f = new FaceClass(rnd.nextInt(500),rnd.nextInt(300), 100 + rnd.nextInt(200), 100 +rnd.nextInt(200), rnd.nextInt(3));
			faces.add(f); // This object takes in parameters from the Get function that I got from the Face Model class
			// The last parameter is random through 3 because it is my decision making for the 
			//mouth status
		}
		// My code that prints out the  the x ,y,width, and height and smiling status
		// on to the command line
		for (FaceClass s: faces ){
			System.out.println(s);
		}
		FaceFrame ff = new FaceFrame (faces);//pass faces to put on the interface. 
		ff.setVisible(true);//set true to show the interface and circles 
	}
}


