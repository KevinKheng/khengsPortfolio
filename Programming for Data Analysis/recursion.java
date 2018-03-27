/*Factorial of n numbers using recursive method
 * 
 */
import java.io.*;
import java.util.*;

public class recursion {

	public static void main(String[] args) {
		System.out.println("Enter number up to finding factorial: ");
        Scanner scr = new Scanner(System.in); 
        int userInput = scr.nextInt();
        System.out.println("Factorial of " + userInput+ " numbers: "+new recursion().factUpto(userInput));
	}
	public int factUpto(int nums) {
		if(nums==0)
			return 1;
		else
			return(nums*factUpto(nums-1));
	}

}
