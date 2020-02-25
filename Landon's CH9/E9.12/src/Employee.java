


public class Employee {
	protected String name_;
	protected double salary_;
	public Employee(String name, double salary) {
		name_ = name;
		salary_ = salary;
	}
	
	public String toString() {
		return name_ + " is an employee who makes $" + salary_;
	}
}
