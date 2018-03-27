/*Factorial of n numbers using iterative method
 * 
 */
import java.io.*;
import java.util.*;

public class iterative {

	public static void main(String[] args) {
		System.out.println("Enter number up to finding factorial: ");
        Scanner scr = new Scanner(System.in); 
        int userInput = scr.nextInt();
        System.out.println("Factorial " + userInput+ " numbers: "+new recursion().factUpto(userInput));
	}
	public int factUpto(int nums) {
		for (int i = 1;i <= 100; i ++) 
			nums *= i;
		return nums;
	}

}
