
public class Person {
	protected int birthYear;
	protected String name;
	
	public Person(int birthYear_, String name_) {
		this.birthYear = birthYear_;
		this.name = name_;
	}
	
	public String toString() {
		return this.name + " was born in " + this.birthYear;
	}
	
	public static void main(String[] args) {
		Person testPerson = new Person(1889, "Dummy");
		Student testStudent = new Student(1969, "my dad", "Biology");
		Instructor testInstructor = new Instructor(1967, "my mom", 15);
		System.out.println(testPerson.toString());
		System.out.println(testStudent.toString());
		System.out.println(testInstructor.toString());
	}
}
