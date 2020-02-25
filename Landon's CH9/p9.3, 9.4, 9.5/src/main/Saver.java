package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;

public class Saver {
	
	
	public static ArrayList<Appointment> loadFile(String file) {
		FileReader ine =  null; 
		BufferedReader in = null;
		ArrayList<Appointment> result = new ArrayList<Appointment>();
		String line; //format is index 0 is m, d, or o. index at 1-4 is year (0000-9999), index at 5-6 is month (01-12), index at 7-8 is day of month (01-99)
		try {
			ine = new FileReader(file);
			in = new BufferedReader(ine);
			line = in.readLine();
			while (line != null) {
				if (line.charAt(0) == 'm') {
					result.add(new Monthly(line.substring(9), Integer.parseInt(line.substring(1, 5)), Integer.parseInt(line.substring(5,7)), Integer.parseInt(line.substring(7,9))));
				} else if (line.charAt(0) == 'd') {
					result.add(new Daily(line.substring(9), Integer.parseInt(line.substring(1, 5)), Integer.parseInt(line.substring(5,7)), Integer.parseInt(line.substring(7,9))));
				} else if (line.charAt(0) == 'o') {
					result.add(new OneTime(line.substring(9), Integer.parseInt(line.substring(1, 5)), Integer.parseInt(line.substring(5,7)), Integer.parseInt(line.substring(7,9))));
				}
				line = in.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String saveFile(ArrayList<Appointment> list, String file) {
		String month;
		String day;
		String year;
		FileWriter ine = null;
		BufferedWriter in = null;
		try {
			ine = new FileWriter(file);
			in = new BufferedWriter(ine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Appointment item: list) {
			//gets here
			month = Integer.toString(item.month_);
			day = Integer.toString(item.day_);
			year = Integer.toString(item.year_);
			if (item.month_ < 10) {
				month = "0" + month;
			}
			if (item.day_ < 10) {
				day = "0" + day;
			}
			if (item.year_ < 1000) {
				if (item.year_ < 100) {
					if (item.year_ < 10) {
						year = "000" + year;
					} else {
						year = "00" + year;
					}
				} else {
					year = "0" + year;
				}
			}
			try {
				if (item.occursOn(item.year_, item.month_, item.day_ + 1)) { //could've added something in the classes to simplify the logic for all three
					//daily
					String stuff = "o" + year + month + day + item.description_;
					in.write(stuff);
					in.newLine();
				} else if (item.occursOn(item.year_, item.month_ + 1, item.day_) && !(item.occursOn(item.year_, item.month_, item.day_ + 1))) {
					//monthly
					String stuff = "m" + year + month + day + item.description_;
					in.write(stuff);
					in.newLine();
				} else if (!item.occursOn(item.year_ + 1, item.month_, item.day_)) {
					//oneTime
					String stuff = "o" + year + month + day + item.description_;
					in.write(stuff);
					in.newLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Saved Properly";
	}
}
