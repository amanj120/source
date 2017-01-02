import java.util.*;
import java.io.*;
public class Jain_Taxes {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the hours worked in a week:");
		int hours = sc.nextInt();
		System.out.println("Enter the hourly rate:");
		final double rate = sc.nextDouble();
		final double fTax =  0.18;
		final double ssTax = 0.08;
		final double sTax =  0.032;
		final double lTax =  0.02;
		System.out.println("Hours worked:   	 " + hours);
		System.out.println("Hourly rate:    	$ " + rate);
		System.out.println();
		System.out.println("Gross pay :     	$ " + format(hours*rate));
		System.out.println("Federal tax (18%)	$ " + format(fTax*hours*rate));
		System.out.println("FICA (8%)           	$ " + format(ssTax*hours*rate));
		System.out.println("State tax (3.2%)    	$ " + format(sTax*hours*rate));
		System.out.println("Local tax (2%)      	$ " + format(lTax*hours*rate));
		System.out.println();
		System.out.println("Net pay 		$ " + format(0.688*hours*rate));
		sc.close();
	}
	public static String format(double j){
		return String.format("%.2f ", j);
	}
}
