
import java.util.*; 



public class KevTest {
    
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        int n = 0;
        int h = 0;
        int io = 0;
        int i = 0;
       
       int seekTimeTotal =0 ;
       
       float t =0; 
       
       System.out.print("How many tracks are in disk? : ");
       n = scan.nextInt() ;
       
       System.out.print("Enter intial head position of the disk ? : ");
       h = scan.nextInt() ;
       
       System.out.print(" Enter how many I/O request in disk? : ");
       io= scan.nextInt() ;
       
       int a[] , st[];
       
       System.out.print("Enter I/O request? : ");
       
       for(i=0;i< io; i ++) {
           a[i] =scan.nextInt () ;
       }
       
       for(i = 0; i < io; i ++) {
           st[i]=h-a[i];
           if(st[i] < 0){
        	   st[i]=abs(st[i]);
               h = a[i];
           }
        for(i = 0; i < io; i ++){
            System.out.print(st[i]);
            seekTimeTotal+= st[i];
        }
        
        System.out.print(seekTimeTotal);
        
        t = ((float)seekTimeTotal/io);
        System.out.print("The seek time of given I/O request using FCFS algorithm are: %f" , t );
       }
    }
}