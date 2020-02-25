
public class Executive extends Manager {
	
	
	public Executive(String name, double salary, String department) {
		super(name, salary, department);
	}
	
	public String toString() {
		return name_ + " is an executive who is in the " + department_ + " department and makes $" + salary_;
	}
	
	public static void main(String[] args) {
		Employee testEmployee = new Employee("Landon", 5);
		Manager testManager = new Manager("My mum", 15000, "The department for people who are bad at math");
		Executive testExecutive = new Executive("My dad", 150, "Health sciences");
		System.out.println(testEmployee.toString());
		System.out.println(testManager.toString());
		System.out.println(testExecutive.toString());
	}
}
