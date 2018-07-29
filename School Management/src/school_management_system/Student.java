package school_management_system;

/*
 * Created by Kevin Kheng
 */

/*This class is responsible for keeping track of student fees, name, 
grade & fees paids
*/
public class Student {

	private int id;
	private String name;
	private int grade;
	private int feesPaid;
	private int feesTotal;
	
	/**
	 * To create a new student by initializing 
	 * Fees for every student is $30,000.
	 * Fees paid initially is 0.
	 * @param id 
	 * @param name 
	 * @param grade 
	 */
	public Student(int id, String name, int grade) {
		this.feesPaid = 0;
		this.feesTotal=30000;
		this.id =id;
		this.name = name;
		this.grade = grade; 
	}
	
	//Not going to alter student's name,student's id
	
	/**
	 * Used to update the student's grade.
	 * @param grade new grade of the student.
	 */
	
	public void setGrade(int grade) {
		this.grade=grade;
		
	}
	
	/**
	 * Keep adding the fees to feesPaid Field.
	 * Add the fees to the fees paid.
	 * The school is going to receive the funds.
	 * @param fees the fees that the student pays.
	 */
	public void payFees(int fees) {
		feesPaid = feesPaid + fees;
		School.updateTotalMoneyEarned(feesPaid);
	}
	
	/**
	 * 
	 * @return id of the student.
	 */

	public int getId() {
		return id;
	}
	/**
	 * 
	 * @return name of the student.
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return grade of the student.
	 */

	public int getGrade() {
		return grade;
	}
	
	/**
	 * 
	 * @return fees paid  by the student.
	 */

	public int getFeesPaid() {
		return feesPaid;
	}
	
	/**
	 * 
	 * @return fees of the student.
	 */

	public int getFeesTotal() {
		return feesTotal -feesPaid;
	}
	
	/**
	 * 
	 * @return the remaining fees
	 */
	
	public int getRemaingFees() {
		return feesTotal - feesPaid;
	}

	@Override
    public String toString() {
        return "Student's name :"+name+
                " Total fees paid so far $"+ feesPaid;
    }
	
	
	
	
}
