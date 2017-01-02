import java.util.*;
import java.io.*;
public class Jain_Quadratic {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type in the coefficient of the second degree polynomial (a) here:");
		double a = sc.nextDouble();
		System.out.println("Type in the coefficient of the first degree polynomial (b) here:");
		double b = sc.nextDouble();
		System.out.println("Type in the constant term (c) here:");
		double c = sc.nextDouble();
		if(4*a*c > b*b){
			System.out.println();
			System.out.println("This quadratic has imaginary roots.");
		}
		else{
			System.out.println("the roots are:");
			System.out.println();
			System.out.println((-b + (Math.sqrt((b*b) - (4*a*c))))/(2*a));
			System.out.println((-b - (Math.sqrt((b*b) - (4*a*c))))/(2*a));
		}
		sc.close();
	}
}
