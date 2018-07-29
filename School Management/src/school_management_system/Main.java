package school_management_system;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Kevin Kheng
 *
 */
public class Main {

	public static void main(String[] args) {
		Teacher lizzy = new Teacher(1,"Lizzy",500);
		Teacher tom = new Teacher(2,"Tom",600);
		Teacher jessica = new Teacher(3,"Jessica",700);
		
		List<Teacher> teacherList = new ArrayList<>();
		teacherList.add(lizzy);
		teacherList.add(tom);
		teacherList.add(jessica);
		
		
		
		Student ryan = new Student(1,"Ryan",4);
		Student mayra = new Student(2,"Mayra",12);
		Student ben = new Student(3,"Ben",14);
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(ryan);
		studentList.add(mayra);
		studentList.add(ben);
		
		//Note the method or function must be done before the object can be updated.
		School morton = new School(teacherList,studentList);
		
		ben.payFees(1000);
		mayra.payFees(5000);
		System.out.println("Morton has earned $" + morton.getTotalMoneyEarned());
		ryan.payFees(2000);
		System.out.println("Morton has earned $" + morton.getTotalMoneyEarned());
		
		System.out.println("=======Making Morton PAY SALARY=====");
		lizzy.recieveSalary(lizzy.getSalary());
		System.out.println("Morton has spent for salary to " + lizzy.getName()+" and now has $" + morton.getTotalMoneyEarned());
		
		jessica.recieveSalary(jessica.getSalary());
		System.out.println("Morton has spent for salary to " + jessica.getName()+" and now has $" + morton.getTotalMoneyEarned());
		
		System.out.println(ben);
		
		
	
		
		
	}

}
