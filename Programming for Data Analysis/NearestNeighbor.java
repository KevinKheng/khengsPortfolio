/*CS 210 Lewis University 
 * Kevin Kheng Programming Assignment 1
 */
 
import java.io.*;
import java.util.*;

public class NearestNeighbor {
	/*I declare my arrays
	 * 
	 */
	static double[][] trainValues = new double[75][4];
	static double [][] testValues = new double [75][4]; 
	static String [] trainlabel = new String [75]; 
	static String [] testlabel = new String [75];
	static String [] prediction = new String [75]; 

	public static void main(String[] args) throws Exception{
		//use for a counter 
			double p = 0;
		//header 
		System.out.println("CS 210, Fall 2016");
		System.out.println("Name: Kevin Kheng" );
		System.out.println("Programming Assignment 4");
		System.out.println(" ");
		
		System.out.println("EX# TRUE LABEL, PREDICTED LABEL");
		File trainexamples = new File ("iris-training-data.csv");
		
		/*I threw an exception in order and use the try catch in order
		 * to read the file. I parse my data as well.
		 * 
		 */
	    try
	    {
		
		Scanner fileScan = new Scanner(trainexamples) ;   
		int count = 0;
		String line = " ";
		String data[];
		while (fileScan.hasNext()) {
			line = fileScan.nextLine();
			data = line.split(",");
				trainValues [count][0] = Double.parseDouble(data[0]);
				trainValues [count][1] = Double.parseDouble(data[1]);
				trainValues [count][2] = Double.parseDouble(data[2]);
				trainValues [count][3] = Double.parseDouble(data[3]);
				trainlabel [count] = data [4];
				count ++; 
			}
		
		fileScan.close();
	
	    }
	    

	     catch(Exception e){
	    	 System.out.print("FileNotFound");
	     }
	    	 //Testing data
	    		File testexamples = new File ("iris-testing-data.csv");
	    	    try
	    	    {
	    		
	    		Scanner fileScan = new Scanner(testexamples) ;   
	    		int count = 0;
	    		String line = " ";
	    		String data2[];
	    		while (fileScan.hasNext()) {
	    			line = fileScan.nextLine();
	    			data2 = line.split(",");
	  
	    				testValues [count][0] = Double.parseDouble(data2[0]);
	    				testValues [count][1] = Double.parseDouble(data2[1]);
	    				testValues [count][2] = Double.parseDouble(data2[2]);
	    				testValues [count][3] = Double.parseDouble(data2[3]);
	    				testlabel [count] = data2 [4];
	    				count ++; 
	     }
	    		
	    		fileScan.close();
	    	    
	     }
	 
	    	  
	    			catch(Exception d){
	    		    	 System.out.print("FileNotFound");
	    		 
	    			} 
	    	    //prediction
	    	    double min; 
	    	    double [][]dist = new double [75][75];
	    	    for (int i = 0;i < 75; i++){
	    	    	String name = " " ;
	    	    	min = Double.MAX_VALUE;
	    	    	for( int f = 0;f < 75; f++){
	    	    		dist [i][f] = distance(testValues,trainValues, i,f);
	    	    		if(dist [i][f] < min ){
	    	    			min = dist[i][f];
	    	    			name = trainlabel[f];
	    	    		}
	    	     
	    	    	}
	    	    
	    	    	if(name.equals(testlabel[i])){
	    	    		p ++;
	    	    		
	    	    	}
	    	    	System.out.println(i+1+": "+ testlabel[i] + " "+ name);
	    	    
	    	    }
	    	   System.out.println("Accuracy: " +p /75);
	     
	     }
	     
	//Distance method
	public static double distance (double [][] testdata,double [][] traindata,int i,int f){
		return Math.sqrt(Math.pow(testdata[i][0]-traindata[f][0], 2) + Math.pow(testdata[i][1]-traindata[f][1], 2)+Math.pow(testdata[i][2]-traindata[f][2], 2)+Math.pow(testdata[i][3]-traindata[f][3], 2));
		
	}
}
	    

			
		
	
		
	
		


	
