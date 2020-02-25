
public class Manager extends Employee {
	protected String department_;
	
	
	public Manager(String name, double salary, String department) {
		super(name, salary);
		department_ = department;
	}
	
	public String toString() {
		return name_ + " is a manager who is in the " + department_ + " department and makes $" + salary_;
	}
}