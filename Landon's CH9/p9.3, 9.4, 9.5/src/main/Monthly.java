package main;

public class Monthly extends Appointment {

	public Monthly(String description, int year, int month, int day) {
		super(description, year, month, day);
	}
	
	@Override
	public boolean occursOn(int year, int month, int day) {
		if ((year>=year_ || (month>=month_ && year==year_)) && day==day_) {
			return true;
		} else {
			return false;
		}
	}
}
