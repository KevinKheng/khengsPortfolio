import java.net.Socket;
import java.io.*;
import java.util.Scanner;

public class GuessMyNumberClientKheng {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Socket connection = null;
		String playerInput;
		String response; 
		String command;
		try {/* create the socket that will initiate the connection with the server.
        	 * You have to specify the ip address of the server and the port it's listening on 
        	 */
			connection = new Socket("localhost", 9999);
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			PrintWriter pw = new PrintWriter(connection.getOutputStream(), true);
			
			// Name of the Client
			String clientName = in.readLine();
			System.out.println(clientName);
			
			while (true) {
				command = in.readLine();//players enter in a guess
				System.out.print(command);
				playerInput = sc.nextLine();
				pw.println(playerInput);
				
	
				if (playerInput.equals("quit")) {
					break;
				}
				
				// Response is read
				response = in.readLine();
				System.out.println(response);
				
				
				if (response.equals("You got it.")) {
					do {
						//send the user input to the server 
						System.out.println(in.readLine());
						System.out.print(in.readLine());
						playerInput = sc.nextLine();
						pw.println(playerInput);
					}
					while (!playerInput.equals("y") && !playerInput.equals("n"));
					
					if (playerInput.equals("y")) {
						continue;
					}
					
					if (playerInput.equals("n")) {
						// Number of correct guesses
						System.out.println(in.readLine());
						break;
					}
				}
				
				if (playerInput.equals("n")) {
					break;
				}
			}
		}
		catch (Exception e) {
			System.out.println("Communication breakdown");
		}
		finally {
			try {
				connection.close();
			}
			catch (Exception e) {
				System.out.println("Could not close");
			}
		}
	}
}