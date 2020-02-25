
public class Instructor extends Person {
	private double salary;
	
	public Instructor(int birthYear_, String name_, double salary_) {
		super(birthYear_, name_);
		this.salary = salary_;
	}
	
	public String toString() {
		return super.toString() + " and is payed a salary of $" + salary;
	}
}
