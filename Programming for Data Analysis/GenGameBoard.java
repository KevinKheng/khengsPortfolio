
public class GenGameBoard{
	
	//Declaration of variables
	char[][] gameBoard;
	int gameSize,countVertical,countHorizontal,countDiagonal,countDiagonalDown,finish;
	String board = "";
	
	public void makeBoard(int x){//Initializes 2d array for gameboard
		gameBoard = new char[x][x];
		gameSize = x;//Used in the class as the max size for the array
			for(int z=0;z<gameSize;z++){
				for(int y=0;y<gameSize;y++){
					gameBoard[z][y] = ' ';//Initializes empty spaces
				}
			}
	}
	
	public void printBoard(){//For loops to print out the gameboard
		System.out.print("\n  ");
		for (int n = 1; n <= gameSize; n++)
		{
			System.out.print(n + " ");//Numbered columns
		}
		System.out.println();
		for(int z=0;z<gameSize;z++){
			for(int y=0;y<gameSize;y++){
				if(y==0){
					System.out.print(" ");
					for(int l=0;l<gameSize*2+1;l++){
						System.out.print("-");//Seperating dashes
					}
					System.out.print("\n"+(z+1)+"|"+gameBoard[z][y]+"|");//Gameboard individual tiles
				}
				else
					System.out.print(gameBoard[z][y]+"|");
					
				if(y==gameSize-1){
					System.out.println("");
				}
				if(z==gameSize-1&&y==gameSize-1){
					System.out.print(" ");
					for(int l=0;l<gameSize*2+1;l++){
						System.out.print("-");
					}
				}
			}
		}
	}
	public boolean checkSpot(int x, int y,char mark){//Makes sure the input(Player or CPU) can be placed
		if(gameBoard[x-1][y-1]==' '){
			gameBoard[x-1][y-1]=mark;//Marks the empty spot with the desires X or O
			if(this.checkWin(mark)==true){
				return true;}
			if(this.checkWin(mark)==true){
				return true;}
			return true;
		}
		if(gameBoard[x-1][y-1]!=' '){
			return false;}//checks to see if the spot is already taken
		return true;
	}
	public boolean checkWin(char mark){//Repeated for loops to check for wins
		countVertical=0;
		countHorizontal=0;
		countDiagonal=0;
		countDiagonalDown=0;
		
		//Left and Right
		for(int i=0;i<gameSize;i++){
			countHorizontal=0;
			for(int j=0;j<gameSize;j++){
				if(gameBoard[i][j]==mark){
					countHorizontal++;
						if(countHorizontal==gameSize){
							return true;
						}
				}
			}
		}
		
		//Up and Down
		for(int i=0;i<gameSize;i++){
			countVertical=0;
			for(int j=0;j<gameSize;j++){
				if(gameBoard[j][i]==mark){
					countVertical++;
						if(countVertical==gameSize){
							return true;
						}
				}
			}
		}
		
		//Top left to Bottom right
		for(int i=0;i<gameSize;i++){
				if(gameBoard[i][i]==mark){
					countDiagonal++;
						if(countDiagonal==gameSize){
							return true;
						}
				}
				else{
					countDiagonal=0;
				}
		}
		
		//Bottom left to Top right
		for(int i=0;i<gameSize;i++){
				if(gameBoard[i][gameSize-1-i]==mark){
					countDiagonalDown++;
						if(countDiagonalDown==gameSize){
							return true;
						}	
				}
				else{
					countDiagonalDown=0;
				}
		}
		
		return false;
	
	}
	
	public boolean noMoreMoves(){//Checks if there are more possible moves
		finish=0;
		for(int x=0;x<gameSize;x++){
			for(int y=0;y<gameSize;y++){
				if(gameBoard[x][y]!=' '){
					finish++;
				}
			}
		}
		if(finish == gameSize*gameSize){//If gamesize is the total number of spaces, end the program
			return true;
		}
		return false;
	}
}
