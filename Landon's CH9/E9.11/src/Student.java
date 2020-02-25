
public class Student extends Person {
		private String major;
		
		public Student(int birthYear_, String name_, String major_) {
			super(birthYear_, name_);
			this.major = major_;
		}
		
		public String toString() {
			return super.toString() + " and is majoring in " + major;
		}
}
