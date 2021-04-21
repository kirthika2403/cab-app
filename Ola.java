package com.kirthika;

import java.util.*;
import java.time.*;

public class Ola {
	public static void display() {
		System.out.println("Enter the car type:");
		System.out.println("1.micro 2.mini 3.prime");
	}

	public static void extra_charge(int amnt, int peak) {
		double val;
		Scanner sc = new Scanner(System.in);
		System.out.println("GST: 7%");
		double pay = (double) (amnt + (0.07 * amnt));
		System.out.println("Amount after GST: " + pay);
		if (peak >= 17 && peak <= 19) {
			System.out.println("It is a peak hour");
			val = pay + (0.0125 * pay);
			System.out.println("The total amount for peak hour: " + val);
		} else {
			val = pay;
			System.out.println("The total amount for non peak hour is " + val);
		}
		System.out.println("Enter your date of birth:");
		String dob = sc.next();
		LocalDate currentDob = LocalDate.parse(dob);
		int age = currentDob.getYear();
		LocalDate current = LocalDate.now();
		int cur = current.getYear();
		int diff = cur - age;
		if (diff >= 60) {
			System.out.println("Senior citizen,you are getting 50% discount on the amount");
			double fare = (val - (0.5 * val));
			System.out.println("-----------------------------");
			System.out.println("The final fare is " + fare);
			System.out.println("-----------------------------");

		} else {
			double fare = val;
			System.out.println("----------------------------");
			System.out.println("The final fare is " + fare);
			System.out.println("----------------------------");

		}
	}

	public static int time() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the journey date:");
		String date = sc.next();
		LocalDate currentdate = LocalDate.parse(date);
		if (currentdate.isAfter(LocalDate.now())) {
			System.out.println("The entered date is valid");

		} else {
			System.out.println("The entered date is not valid");
		}
		System.out.println("Enter your pickup time:");
		String time = sc.next();
		LocalTime currentTime = LocalTime.parse(time);
		int hour = currentTime.getHour();
		if (currentTime.isBefore(LocalTime.now())) {
			System.out.println("The entered time is not valid");
		} else {
			System.out.println(
					"Your cab is booked for the scheduled date " + currentdate + " and time is " + currentTime);
		}
		return hour;
	}
	public static void login()
	{   Scanner sc = new Scanner(System.in);
		System.out.println("Enter your 10 digit mobile number:");
		long mobile = sc.nextLong();
		String mobilenum = String.valueOf(mobile);// valueOf()function is used to convert data type(int,long) to string
													// type
		if (mobilenum.length() != 10) 
		{
			System.out.println("Invalid mobile number");
			login();
		}
		else {
			System.out.println("Valid mobile number");
		}
		String password = "pass1234";
		System.out.println("Enter the password:");
		String pass = sc.next();
		if (pass.equals(password)) {
			System.out.println("Have a Happy Journey!!!!");
		} 
		else 
		{
			System.out.println("Wrong Password");
			login();
			
		}
		display();
		int type = sc.nextInt();
		if (type == 1) 
		{
			System.out.println("Car name:Micro");
			System.out.println("Price per km: 10rs");
			int peak = time();
			System.out.println("Enter the km travelled:");
			int km = sc.nextInt();
			int total = km * 10;
			System.out.println("The total amount is: " + total);
			extra_charge(total, peak);
		} 
		else if (type == 2) 
		{
			System.out.println("Car name:Mini");
			System.out.println("Price per km: 15rs");
			int peak = time();
			System.out.println("Enter the km travelled:");
			int km = sc.nextInt();
			int total = km * 15;
			System.out.println("The total amount is: " + total);
			extra_charge(total, peak);

		} 
		else if (type == 3) 
		{
			System.out.println("Car name:Prime");
			System.out.println("Price per km: 20rs");
			int peak = time();
			System.out.println("Enter the km travelled:");
			int km = sc.nextInt();
			int total = km * 20;
			System.out.println("The total amount is: " + total);
			extra_charge(total, peak);
		} 
		else
		{
			System.out.println("The entered car type is invalid");
		}
	}
	


	public static void main(String args[])
	{
		
		login();
		
    }
}
