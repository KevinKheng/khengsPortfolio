import java.util.Random ;
import java.util.Scanner ;
public class Cipher {

	public static void main(String[] args) {
	// Header
    System.out.println("CS 210, Fall 2016");
    System.out.println("Name: Kevin Kheng" );
    System.out.println("Programming Assignment 1");
    System.out.println(" ");
    // I intialize my variable 
	Scanner scan = new Scanner(System.in);
    int num1;
    int num2;
    int num3;
    int num4;
    int num5;
    int Total;
    
  
    Random gen = new Random();

    System.out.println("Welcome to the Cipher program. ") ;

    System.out.println("Enter 5 numbers between 0 and 19");
 
    // I use the if and else statement if the user types a number less than 0 and more than 19
    System.out.print( "Enter the 1st number:  ");
    num1 = scan.nextInt();
	if (num1 < 0 ||num1 > 19) { 
	System.out.print("Please read directions and try again");
    System.exit(0) ; }

	System.out.print("Enter the 2nd number: ");
    num2 = scan.nextInt();
	if (num2 < 0 || num2 > 19) {
	System.out.print("Please read directions and try again");
    System.exit(0) ; }
	
	System.out.print("Enter the 3rd number: ");
    num3 = scan.nextInt();
	if (num3 < 0 ||num3 > 19) {
	System.out.print("Please read directions and try again");
    System.exit(0) ; }

	System.out.print("Enter the 4th number: ");
    num4 = scan.nextInt();
	if (num4 < 0 ||num4 > 19) {
	System.out.print("Please read directions and try again");
    System.exit(0) ; }

	System.out.print("Enter the 5th number: ");
    num5 = scan.nextInt();
	if (num5 < 0 ||num5 > 19) {
	System.out.print("Please read directions and try again");
    System.exit(0) ; }
	
	System.out.println(" ");
	Total = num1 + num2 + num3 + num4 + num5 ; 
	System.out.println ("Total = "  + Total);

	int randum = gen.nextInt(10); 
	System.out.println("Your random key is " + randum);
	
	// This here is the cipher part 
	int digit1 = Total / 10 ;
	int digit2 = Total % 10 ; 
	int encode1 = (digit1 + randum) % 10 ;
	int encode2 = (digit2 + randum) % 10 ;
	
	System.out.print("Your encoded number is " + encode1+encode2);
	
	
	
	



	}

}
