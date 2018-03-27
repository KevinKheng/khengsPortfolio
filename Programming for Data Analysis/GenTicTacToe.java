import java.io.*;
import java.awt.*;
import java.math.*;
import java.util.*;
public class GenTicTacToe {

	public static void main(String[] args)throws IndexOutOfBoundsException{
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		//Declaration of Variables
		boolean gameWin = false;
		int boardSize;
		int userRow;
		int userColumn;
		char Player = 'X';
		char CPU = 'O';
		int winner=0;
		int cpuX=rand.nextInt(3)+1;
		int cpuY=rand.nextInt(3)+1;//1 for player, 2 for cpu, 3 for Draw
		
		GenGameBoard game = new GenGameBoard();//Initializing a new GameBoard
		
		
		System.out.print("Please enter the size of the board n (e.g. n=3,4,5,...): ");
		boardSize = scan.nextInt();//Gets the user-declared size of the board
		
		while(boardSize < 3){//Checks to make sure the gameboard is greater than 2
			System.out.print("Please enter a number greater than or equal to 3: ");
			boardSize = scan.nextInt();
		}
		
		game.makeBoard(boardSize);//Makes the 2d array for the board
		game.printBoard();//Prints out the blank board
		
		while(gameWin!=true){//while look that ends when the game has a winner
			System.out.println("\n\nPlayer's Move");
			System.out.print("Choose your row: ");
				userRow = scan.nextInt();//Rows(Y)
			System.out.print("Choose your column: ");
				userColumn = scan.nextInt();//Columns(X)
				
				while(userRow>boardSize||userColumn>boardSize||userRow<0||userColumn<0){//While loop so the user enters something in the range of the board
					System.out.println("\nNot a valid row or column!");
						System.out.print("\nChoose your row: ");
							userRow = scan.nextInt();
						System.out.print("Choose your column: ");
							userColumn = scan.nextInt();
				}
				
				while(game.checkSpot(userRow,userColumn,Player)==false){//Makes sure the user declared spot is clear or empty
					System.out.println("\nThis Position is Already Taken!");
					System.out.println("\n\nPlayer's Move");
					System.out.print("Choose your row: ");
						userRow = scan.nextInt();
					System.out.print("Choose your column: ");
						userColumn = scan.nextInt();
				}
				
					game.printBoard();//Prints board with the user's inputed move
				
				while(game.checkSpot(cpuX, cpuY, CPU)==false && game.noMoreMoves()==false){//Makes a move for the computer
							cpuX=rand.nextInt(3)+1;
							cpuY=rand.nextInt(3)+1;
				}
					
				System.out.println("\nComputer chose: "+cpuX+","+cpuY);
				game.printBoard();//Prints out the board with the user and cpu moves
				
				if(game.checkWin(Player)==true && game.checkWin(CPU)==true){
					gameWin=true;//Checks for a draw of both teams getting 3 in a row, which is technically impossible
					winner = 3;
				}
				if(game.checkWin(Player)==true && game.checkWin(CPU)==false){
					gameWin=true;//Checks if the user won
					winner = 1;
				}
				if(game.checkWin(CPU)==true && game.checkWin(Player)==false){
					gameWin=true;//Check if the computer won
					winner = 2;
				}
				if(game.checkWin(Player)==false && game.checkWin(CPU)==false && game.noMoreMoves()==true){
					gameWin=true;//Checks if the game ends in a draw or tie
					winner = 3;
				}
				if(gameWin==true && winner==1){//Prints that the player won
					System.out.println("\n\nGAME OVER\nPlayer Has Won");
				}
				if(gameWin==true && winner==2){//Prints that the cpu won
					System.out.println("\n\nGAME OVER\nCPU Won");
				}
				if(gameWin==true && winner==3){//Printout for a draw
					System.out.println("\n\nGAME OVER\nIt Was a Draw!");
				}
		}
	}
}
