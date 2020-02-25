package main;

public class Daily extends Appointment {

	public Daily(String description, int year, int month, int day) {
		super(description, year, month, day);
	}
	
	@Override
	public boolean occursOn(int year, int month, int day) {
		if ((year>=year_ || (month>=month_ && year==year_) || (day>=day_ && month==month_ && year==year_))) {
			return true;
		} else {
			return false;
		}
	}
}
