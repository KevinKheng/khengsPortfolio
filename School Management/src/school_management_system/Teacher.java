package school_management_system;

/**
 * 
 * @author Kevin Kheng
 * This class is responsible for keeping the track of teacher's name, id, salary
 */

public class Teacher {
	
	private int id;
	private String name;
	private int salary;
	private int salaryEarned;
	
	/**
	 * Creates a new Teacher object
	 * @param id
	 * @param name
	 * @param salary
	 */
	
	public Teacher(int id, String name, int salary) {
		this.id=id;
		this.name=name;
		this.salary=salary;
		this.salaryEarned = 0;
	}
	
	/**
	 * 
	 * @return the id.
	 */
	
	public int getId() {
		return id ;
	}
	
	/**
	 * 
	 * @return the name of the teacher
	 */
	
	public String getName(){
		return this.name;
		
	}
	
	/**
	 * 
	 * @return the salary of the teacher.
	 */
	
	public int getSalary() {
		return salary;
	}
	
	/**
	 * set the salary
	 * @param salary
	 */
	
	public void setSalary(int salary) {
		this.salary=salary;
		
	}
	
	/**
	 * Add to salary salaryEarned.
	 * Removes from the the total money earned to Morton
	 * @param salary
	 */
	public void recieveSalary(int salary) {
		salaryEarned += salary;
		School.updateTotalMoneyEarned(salary);
	}
	
	
}
