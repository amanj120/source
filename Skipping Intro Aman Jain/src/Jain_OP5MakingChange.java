import java.util.*;
import java.io.*;
public class Jain_OP5MakingChange {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter purchase price:		");
		double a = sc.nextDouble();
		System.out.print("Enter amount received:		");
		double b = sc.nextDouble();
		System.out.println("Change Due:			" + format(b-a));
		System.out.println("\nBreakdown:");
		System.out.println();
		int x = (int) (100 * (b-a));
		int dollars = x / 100;
		x %= 100;
		int quarters = x/25;
		x %= 25;
		int dimes = x/10;
		x %=10;
		int nickels = x/5;
		x %= 5;
		int pennies = x;
		System.out.println("Dollars:		" + dollars);
		System.out.println("Quarters:		" + quarters);
		System.out.println("Dimes:			" + dimes);
		System.out.println("Nickels:		" + nickels);
		System.out.println("Pennies:		" + pennies);
		
		
		sc.close();
	}
	public static String format(double j){
		return String.format("%.2f ", j);
	}
}
