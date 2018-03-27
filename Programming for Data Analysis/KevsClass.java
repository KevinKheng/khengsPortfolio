

	import java.util.ArrayList;
	import java.util.Random;

	public class KevsClass {
	    public static void main(String args[]) {
	        // Lets populate that array with info
	        ArrayList<Integer> intList = new ArrayList<Integer>();
	        Random rn = new Random();
	        int answer = rn.nextInt(100) + 1;
	        int Total = 0;
	        //System.out.println(answer);
	        for (int i=0; i < answer; i++) {
	            int looper = rn.nextInt(100) + 1;
	            intList.add(looper);
	        }
	        for(int i = 0; i < intList.size(); i++) {   
	            //System.out.println(intList.get(i));
	            Total = Total +intList.get(i);
	        } 
	        Total = Total / intList.size();
	        
	        System.out.println(Total+ " Average");
	        System.out.println(answer+" Length");
	        
	        //  Now lets compare the length to the average.
	        if (Total > intList.size()){
	            System.out.println("Average is greater then Length");
	        } else if (Total < intList.size()){
	            System.out.println("Length is greater then Average");
	        }else{
	            System.out.println("They are the same!");
	        }
	    }
	}
