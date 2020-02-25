package main;

public class OneTime extends Appointment {
	
	
	public OneTime(String description, int year, int month, int day) {
		super(description, year, month, day);
	}
	
	@Override
	public boolean occursOn(int year, int month, int day) {
		if (year==year_ && month==month_ && day==day_) {
			return true;
		} else {
			return false;
		}
	}
}
