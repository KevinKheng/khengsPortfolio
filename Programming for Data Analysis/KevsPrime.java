import java.util.Scanner;

//Main Class
class KevsPrime

{

   public static void main(String args[])

   {

       Scanner in=new Scanner(System.in);

       int num;

       System.out.println("Enter a number for calculate prime number : ");

       num=in.nextInt();

       Primecalculation obj=new Primecalculation(num);

       System.out.println("\n Thread initiated");

       System.out.println("\nprime numbers list upto the given "+num +"\n");

       obj.start();

   }

}


//Thread class 
class Primecalculation extends Thread

{

   int val;

   Primecalculation(int val)

   {

       this.val=val;

   }     

   public void run()

   {

       int temp=0;

       try

       {

       for(int i=1;i<=val;i++)

           {

               for(int j=1;j<=i;j++)

               if(i%j==0) temp++;

             

               if(temp<=2) System.out.println(i);

               temp=0;

               sleep(250);

           }

       }catch(InterruptedException ex)

       {System.out.println(ex);}

   }

}