import java.io.*;
 class A6 {
 public static void main(String args[]) throws IOException {
 DataInputStream in = new DataInputStream(System.in);
 int listlen,
 counter, 
 sum = 0;
 int average; 
 int result;
 result = 0;
 
 int intlist [] ;
 intlist = new int[4];
 listlen = Integer.parseInt(in.readLine());
 if ((listlen > 0) && (listlen < 100)) { 
 /* Read input into an array and sumputer the sum */
 for ( counter = 0; counter < listlen; counter++ ) {
 intlist[counter] = Integer.valueOf(in.readLine()).intValue();
 sum += intlist[counter];
 }
 /* Computer the average */
 average = sum / listlen;
 /* Count the input values that are > average */
 for ( counter = 0; counter < listlen; counter++ )
 if (intlist[counter] > average)
 result++;
 /* Print result */
 System.out.println( "\nNumber of values > average is: " + result );
 }
 else
 System.out.println("Error-input list length is not legal \n");
 }
 } 