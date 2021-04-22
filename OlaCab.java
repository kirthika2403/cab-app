package com.kirthika;
import java.util.*;
import java.time.*;

public class OlaCab {
	public static void loginVerification()
	{ Scanner sc=new Scanner(System.in);
	  System.out.println("Enter the 10 digit mobile number: ");
	  String mobileNumber=sc.next();
	  if(mobileNumber.length()==10)
	  {
		  System.out.println("It is a valid Mobile number");
	  }
	  else
	  {
		  System.out.println("It is an invalid Mobile number");
		  loginVerification();
	  }
	  System.out.println("Enter the five digit login password: ");
	  String password=sc.next();
	  if(password.length()==5)
	  {
		  System.out.println("It is a valid password");
	  }
	  else
	  {
		  System.out.println("It is an invalid password");
		  loginVerification();
	  }
	  
		
	}
	public static int priceEstimator()
	{   Scanner sc=new Scanner(System.in);
	    int totalAmount=0;
	    int km;
		System.out.println("Enter the Car type from(1-3): ");
		System.out.println("1.Micro----->10Rs/Km");
		System.out.println("2.Mini----->15Rs/Km");
		System.out.println("3.Prime----->20Rs/Km");
		int carType=sc.nextInt();
		switch(carType)
		{
		case 1:
		{
			System.out.println("Entered the km travelled: ");
			km=sc.nextInt();
		    totalAmount=(10*km);
		    break;
		}
		case 2:
		{
			System.out.println("Entered the km travelled: ");
			km=sc.nextInt();
		    totalAmount=(15*km);
		    break;
		}
		case 3:
		{
			System.out.println("Entered the km travelled: ");
			km=sc.nextInt();
		    totalAmount=(20*km);
		    break;
		}
		}
		
		return totalAmount;
}
	public static double gstCalculation(int totalAmount)
	{  System.out.println("The Gst is 7% on the bill");
	   double gstPrice=0.07*totalAmount;
	   System.out.println("The Gst amount is: "+gstPrice);
	   double gstTotalAmount=totalAmount+gstPrice;
	   return gstTotalAmount;
	   
	}
	public static int bookingDetails()
	{   
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the journey date(YYYY-MM-DD): ");
		String date = sc.next();
		LocalDate currentDate = LocalDate.parse(date);
		System.out.println("Enter your pickup time(HH-MM): ");
		String time = sc.next();
		LocalTime currentTime = LocalTime.parse(time);
		if (currentDate.isAfter(LocalDate.now())) 
		{
			System.out.println("The entered date and time is valid");
		} 
		else 
		{
			System.out.println("The entered date and time is not valid");
			bookingDetails();
		}
		int hour = currentTime.getHour();
		return hour;
	}
	public static double peakHourCalculation(double gstTotalAmount,int hour)
	{   double peakHourTotalAmount=0;
		if(hour>=17&&hour<=19)
		{
			System.out.println("It is peak hour,so you get additional 1.25% extra on your bill");
			double peakHourCharge=0.0125*gstTotalAmount;
			System.out.println("The peak hour fare is: "+peakHourCharge);
		    peakHourTotalAmount=peakHourCharge+gstTotalAmount;
		}
		else
		{
			System.out.println("It is non peak hour");
		    peakHourTotalAmount=gstTotalAmount;
		}
		return peakHourTotalAmount;
	}
	public static void seniorCitizenValidation(double peakHourTotalAmount)
	{   Scanner sc=new Scanner(System.in);
		System.out.println("Enter your date of birth:");
		String dob = sc.next();
		LocalDate birthDob = LocalDate.parse(dob);
		int birthYear = birthDob.getYear();
		LocalDate currentYear = LocalDate.now();
		int currentAge = currentYear.getYear();
		int ageDifference = currentAge - birthYear;
		if (ageDifference >= 60) {
			System.out.println("Senior citizen,you are getting 50% discount on the amount");
			double totalFare = (peakHourTotalAmount - (0.5 * peakHourTotalAmount));
			System.out.println("-----------------------------");
			System.out.println("The final fare is " + totalFare);
			System.out.println("-----------------------------");

		} else {
			double totalFare = peakHourTotalAmount;
			System.out.println("----------------------------");
			System.out.println("The final fare is " + totalFare);
			System.out.println("----------------------------");

		}
	}

	public static void main(String args[])
	{
		loginVerification();//User defined function to verify login credentials
		int totalAmount=priceEstimator();//User defined function to calculate total amount for Km travelled
		System.out.println("The Total price for the Km travelled is: "+totalAmount);
		double gstTotalAmount=gstCalculation(totalAmount);//User defined function to calculation Gst amount
		System.out.println("The total amount after adding Gst is: "+gstTotalAmount);
		int hour=bookingDetails();//User defined function to get journey date and time
		double peakHourTotalAmount=peakHourCalculation(gstTotalAmount,hour);//User defined function to calculate peak hour charge
		System.out.println("The amount after adding peak hour charge is: "+peakHourTotalAmount);
		seniorCitizenValidation(peakHourTotalAmount);//User defined function to find senior citizen
		
		
	}
}
