package main;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import main.Saver;

//add year cap of 9999 for file structure, max month of 12, max day of 31

public class CheckBook {
	
	public static String newAppointment(Scanner in, ArrayList<Appointment> Appointments) {
		String temp1; //lots of copy and paste code, could've been much further simplified with more thought and effort
		String temp2;
		String temp3;
		String temp4;
		System.out.printf("\n Would you like a (M)onthly, (O)netime, or (D)aily appointment (answer with m, o , or d): ");
		temp1 = in.nextLine();
		if (temp1.toLowerCase().equals("m")) {
			System.out.printf("\n Enter a description or name for the appointment: ");
			temp1 = in.nextLine();
			System.out.printf("\n Enter a year: ");
			temp2 = in.nextLine();
			System.out.printf("\n Enter a month (1-12): ");
			temp3 = in.nextLine();
			System.out.printf("\n Enter a day of the month: ");
			temp4 = in.nextLine();
			try {
				Appointments.add(new Monthly(temp1, Integer.parseInt(temp2), Integer.parseInt(temp3), Integer.parseInt(temp4)));
				return "\n Your appointment was succesfully added \n";
			} catch (Exception err) {
				return "\n Input Error: Please Try Again \n \n";
			}
		} else if ((temp1.toLowerCase().equals("d"))) {
			System.out.printf("\n Enter a description or name for the appointment: ");
			temp1 = in.nextLine();
			System.out.printf("\n Enter a year: ");
			temp2 = in.nextLine();
			System.out.printf("\n Enter a month (1-12): ");
			temp3 = in.nextLine();
			System.out.printf("\n Enter a day of the month: ");
			temp4 = in.nextLine();
			try {
				Appointments.add(new Daily(temp1, Integer.parseInt(temp2), Integer.parseInt(temp3), Integer.parseInt(temp4)));
				return "\n Your appointment was succesfully added \n";
			} catch (Exception err) {
				return "\n Input Error: Please Try Again \n \n";
			}
		} else if (temp1.toLowerCase().equals("o")) {
			System.out.printf("\n Enter a description or name for the appointment: ");
			temp1 = in.nextLine();
			System.out.printf("\n Enter a year: ");
			temp2 = in.nextLine();
			System.out.printf("\n Enter a month (1-12): ");
			temp3 = in.nextLine();
			System.out.printf("\n Enter a day of the month: ");
			temp4 = in.nextLine();
			try {
				Appointments.add(new OneTime(temp1, Integer.parseInt(temp2), Integer.parseInt(temp3), Integer.parseInt(temp4)));
				return "\n Your appointment was succesfully added \n";
			} catch (Exception err) {
				return "\n Input Error: Please Try Again \n \n";
			}
		} else {
			return ("\n Input Error: Please Try Again \n \n");
		}
		
		
	}
	
	
	public static String checkDate(Scanner in, ArrayList<Appointment> Appointments) {
		String temp; //index of object
		String temp1; //year
		String temp2; //month
		String temp3; //day
		
		for (Appointment appointments: Appointments) {
			System.out.print((Appointments.indexOf(appointments)) + ". " + appointments.description_ + "      ");
		}
		System.out.printf("\n please choose a number from the above list: ");
		temp = in.nextLine();
		try {
			System.out.printf("\n Enter a year: ");
			temp1 = in.nextLine();
			System.out.printf("\n Enter a month (1-12): ");
			temp2 = in.nextLine();
			System.out.printf("\n Enter a day of the month: ");
			temp3 = in.nextLine();
			if (Appointments.get(Integer.parseInt(temp)).occursOn(Integer.parseInt(temp1), Integer.parseInt(temp2), Integer.parseInt(temp3))) {
				return ("\n this appointment is available on said date \n");
			} else {
				return ("\n this appointment is NOT available on said date \n");
			}
			
		} catch (Exception error) {
			return ("\n Input Error: Please Try Again \n \n");
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		ArrayList<Appointment> list = new ArrayList<Appointment>();
		list = Saver.loadFile("src\\Saves\\Appointments.txt");
		Scanner in = new Scanner(System.in);
		boolean done = false; //LOAD ABILITIES HERE
		String temp;
		
		while (done != true) {
			System.out.printf("\n Would you like to (respond with numbers): \n 1. create an appointment \n 2. check if an appointment is on a date \n 3. Exit \n");
			temp = in.nextLine();
				if (temp.equals("1")) { //I could've made this a lot simpler with a class or two but 
					System.out.printf(CheckBook.newAppointment(in, list));
					
				} else if (temp.equals("2")) {
					System.out.printf(CheckBook.checkDate(in, list));
					
				} else if (temp.equals("3")) {
					Saver.saveFile(list, "src\\Saves\\Appointments.txt");
					done = true;
					System.out.println("Have a wonderful rest of your day"); //NEED TO ADD SAVE ABILITY HERE
					
					
				} else {
					System.out.printf("\n Input Error: Please Try Again \n \n");
				}
		}
	}
}
