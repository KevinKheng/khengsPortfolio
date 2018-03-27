import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.Random;

public class GuessMyNumberServerKheng {
	public static void main(String[] args) {
		//Introduction 
		System.out.println("Kevin Kheng Guess My Number Server");
		System.out.println("This server generates random integers that can connect.It is a mult-threaded, so multiple clients can connect");
        
		
		//Ask the server for the maximum number
		System.out.println("Enter a max number ");
		Scanner sc = new Scanner(System.in);
		int maxNumber =0;
		do{
			try{
				maxNumber = sc.nextInt();
			}
			catch (Exception e){
				System.out.println("Invalid input. Must be integer greater than 0");
				continue;
			}
		}
		while (maxNumber < 0);
		int count =0;
		try{ /* create a ServerSocket.
            The ServerSocket can manage multiple sockets simultaneously.
            To create a ServerSocket, you specify the port this application
            provides services on. */
            /* the listener implements one connection.
            the listener socket provides the conduit for data to flow
            between this server and one client.
            To create the listener, call the server socket's accept function.
            The accept blocks - in other words, the program sits there waiting
            for a connection to be formed. */
			ServerSocket server = new ServerSocket(9999);
			GuessMyNumberThreadKheng Thread;
			String thread;
			while(true){
				thread ="Thread-"+count;
				Thread = new GuessMyNumberThreadKheng(server.accept(),thread,count,maxNumber);
				System.out.println(thread + "is starting.");
				Thread.start();
				count++;
			}  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
//Thread class
class GuessMyNumberThreadKheng extends Thread {
	private Socket listener;
	private String threadName;
	private int correctCount = 0;
	private int maxNumber ;
	private int rndGenNumber; 
	private int threadCount;
	

	public GuessMyNumberThreadKheng(Socket listener, String threadName, int threadCount, int maxNumber) {
		super(threadName);
		this.listener = listener;
		this.threadName = threadName;
		this.threadCount = threadCount;
		this.maxNumber = maxNumber;
	}
	
	public void genNum(String threadName, int maxNum) {
		Random rnd = new Random();
		rndGenNumber = rnd.nextInt(maxNumber + 1);
		System.out.println("Number generated for " + threadName + ": " + rndGenNumber);
	}
	
	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(listener.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			PrintWriter pw = new PrintWriter(listener.getOutputStream(), true);
			
			if (correctCount == 0) {
				pw.println("You are Client-" + threadCount);
			}
			//Must past in these a parameters to display
			genNum(threadName, maxNumber);
			
			String userInput;
			int guessNumber;
			while (true) {
				pw.println("Enter a guess: ");//User enters in a guess
				userInput = br.readLine();		

				// To quit the client 
				if (userInput.equals("quit")) {
					System.out.println("Client on " + threadName + " wants to quit.");
					break;
				}
				else {
					try {
						guessNumber = Integer.parseInt(userInput);
						System.out.println("Client on " + threadName + " guessed " + userInput + ".");
						// Determine if the user got the guess right or if its greater than or low.
						if (guessNumber < rndGenNumber) {
							pw.println("Too low.");
						}
						else if (guessNumber > rndGenNumber) {
							pw.println("Too high.");
						}
						else {
							correctCount++;
							pw.println("You got it.");
							pw.println("YOWZER!!!!!");
							//options to play again
							while (true) {
								pw.println("Try again (y or n)? ");
								userInput = br.readLine();
								if (userInput.equals("y") || userInput.equals("n")) {
									break;
								}
								else {
									pw.println("Invalid input! Must respond with y or n.");
									continue;
								}
							}

							System.out.println(threadName + " responded with " + userInput + ".");
							if (userInput.equals("y")) {
								genNum(threadName, maxNumber);
								continue;
							}
							//To not continue the game
							else if (userInput.equals("n")) {
								if (correctCount == 1) {
									pw.println("You guessed 1 number correctly.");
								}
								else {
									pw.println("You guessed " + correctCount + " numbers correctly.");
								}
								break;
							}
						}
					}
					catch (Exception e) {
						pw.println("Invalid input! Must be integer of at least zero.");
						continue;
					}
				}				
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("A communications problem occured.");
		}

		finally {
			try {
				listener.close();
				System.out.println(threadName + " is quitting.");
			}
			catch (Exception e) {
				System.out.println("Could not close the connection.");
			}
		}
	}
}

