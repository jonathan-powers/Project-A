package main;
import java.util.Scanner;

public class Converter {
	public static double conversion[] = new double[] {101325,1.01325,14.6959,760,1};
	//contains unit conversion from atmosphere to different units
	public static int initu = -1;
	public static int finu = -1;
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		// create scanner object to collect user inputs
		
		System.out.println("Welcome to Pressure Unit Converter");
		
		System.out.println("What is the initial value?");
		
		String initvalue = input.nextLine();
		//gathers user input as string
		
		double val = Double.parseDouble(initvalue);
		// converts value from string to double
		
		//System.out.println(val);
		
		System.out.println("Select an Initial unit");
		
		String userinput1 = input.nextLine();
		//gets input from user
		
		initu = Converter.evalunitinput(userinput1);
		//returns appropriate index for conversion array
		
		/*int initu =-1;
		
		switch (userinput1) {
		case "Pascal":
			initu = 0; 
			break;
		case "Barr":
			initu = 1; 
			break;
		case "PSI":
			initu = 2;
			break;
		case "Torr":
			initu = 3;
			break;
		case "Atmosphere":
			initu = 4;
			break;
		default:
			System.out.println("Not a valid unit, Please try again\n ");
			Converter.main(args);
			break;
		}*/
		
		System.out.println("Unit to convert to");
		
		String userinput2 = input.nextLine();
		
		finu = Converter.evalunitinput(userinput2);
		//returns appropriate index for conversion array
		
		/*int finu = -1;
		
		switch (userinput2) {
		case "Pascal":
			finu = 0;
			break;
		case "Barr":
			finu = 1;
			break;
		case "PSI":
			finu = 2;
			break;
		case "Torr":
			finu = 3;
			break;
		case "Atmosphere":
			finu = 4;
			break;
		default:
			System.out.println("Not a valid unit, Please try again\n ");
			Converter.main(args);
			break;
		}*/
		
		double finvalue = Converter.convert(val,initu,finu);
		
		System.out.println(val + " " + userinput1 + " is equal to " + finvalue + " " + userinput2);
	}
	
	/*public static double convert(double value,String initunit, String finunit) {
		//method to call if using a map to hold values to convert units
		double v = value;
		return v;
	}*/
	
	public static double convert(double value,int initunit, int finunit) {
		//method to call if using a array to hold values to convert units
		
		double v = value;
		
		v = v / Converter.conversion[initunit];
		//Converts unit to atmosphere
		
		v = v * Converter.conversion[finunit];
		//Converts from atmosphere to desired unit 
		
		return v;
	}
	

	public static int evalunitinput(String userinput) {
		
		switch (userinput) {
		case "Pascal":
			return 0; 
		case "Barr":
			return 1; 
		case "PSI":
			return 2;
		case "Torr":
			return 3;
		case "Atmosphere":
			return 4;
		default:
			return -1;
		}
		
	}

}
