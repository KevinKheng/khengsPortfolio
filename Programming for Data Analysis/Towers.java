import java.util.Random;
import java.util.Scanner; 
public class Towers {

	public static void main(String[] args) {
		// heading
		System.out.println("CS 210, Fall 2016");
		System.out.println("Name: Kevin Kheng" );
		System.out.println("Programming Assignment 2");
		System.out.println(" ");
// I intialize my varibales for my width of the tower and height
		Scanner scan = new Scanner(System.in); 
		int tower1;
		int tower2;
		int tower3;
		int height1;
		int height2;
		int height3; 
// I use the random generator  for my height
		Random gen = new Random(); 
//In order to  random and get odds and make the random inclusive I made the 0 to 4 then multiply by 2 and add 3 to get and odd number 
		height1 = gen.nextInt(5) * 2 + 3; 
		height2 = gen.nextInt(5) * 2 + 3;
		height3 = gen.nextInt(5) * 2 + 3; 

// I use the while loop to ask the user to make sure they pick the correct number and add number. I use the module in order for the remainder to equals to 0 so the integer can be odd
		//Width of tower1
		System.out.print("Enter the width of tower 1(an odd number): "); 
		tower1 = scan.nextInt(); 
		while (tower1 % 2 == 0)
		{ 
			System.out.println("Invalid Input!Width needs to be odd.");
			System.out.print("Reenter the width of tower 1(an odd number: ");
			tower1 = scan.nextInt(); 

		}
         //Width of Tower 2
		System.out.print("Enter the width of tower 2(an odd number): ");
		tower2 = scan.nextInt();
		while (tower2 % 2 == 0)
		{ 
			System.out.println("Invalid Input!Width needs to be odd.");
			System.out.print("Reenter the width of tower 2(an odd number: ");
			tower2 = scan.nextInt(); 

		}

        // Width of Tower 3
		System.out.print("Enter the width of tower 3(an odd number): ");
		tower3 = scan.nextInt();
		while (tower3 % 2 == 0)
		{ 
			System.out.println("Invalid Input!Width needs to be odd.");
			System.out.print("Reenter the width of tower 3(an odd number): ");
			tower3 = scan.nextInt();
		}
		// I compare the height from my height 1 to height 2 to see which one bigger and use a variable call maxheight. The height that is greater than the height is the 
		// max height.After that I compare it with the third height of the tower.
		int maxheight = Math.max(height1, height2);
		maxheight = Math.max(maxheight,height3);
//I use the for loop in order to to print my stars and spaces.I also use the if and else statement within the for loop also. I have to use the for loop to 
// within the if and else to compare to column and increment by 1 to print out the spaces and stars.
		for (int row = maxheight; row > 0 ; row--){
			//Tower 1
			if (height1 >= row){
				for (int column = 0; column < tower1; column ++) {
					System.out.print("*");
				}
			}
			else { 
				for (int column = 0; column < tower1; column ++) {
					System.out.print(" ");
				}
			}
           // This print statement is use for spaces of tower 2 and 3
			System.out.print(" ");
			//Tower2
			if (height2 >= row){
				for (int column = 0; column < tower2; column ++) {
					System.out.print("*");
				}
			}
			else { 
				for (int column = 0; column < tower2; column ++) {
					System.out.print(" ");
				}
			}
			// Spacing for tower 2 and 3
			System.out.print(" "); 
			//Tower3 
			if (height3 >= row){
				for (int column = 0; column < tower3; column ++){
					System.out.print("*");
				}
			} 
			else { 
				for (int column = 0; column < tower3; column ++){
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}
}

