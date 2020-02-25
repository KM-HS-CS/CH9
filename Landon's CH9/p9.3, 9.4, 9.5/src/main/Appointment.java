package main;


public class Appointment {
	protected String description_;
	protected int year_;
	protected int month_;
	protected int day_;
	
	public Appointment(String description, int year, int month, int day) {
		description_ = description;
		year_ = year;
		month_ = month;
		day_ = day;
	}
	
	public boolean occursOn(int year, int month, int day) {
		if (year==year_ && month==month_ && day==day_) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
