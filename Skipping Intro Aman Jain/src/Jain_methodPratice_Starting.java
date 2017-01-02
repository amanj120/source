import java.util.*;
import java.io.*;
public class Jain_methodPratice_Starting {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length and width of a rectangle you'd like to find the perimeter of");
		int l = sc.nextInt();
		int r = sc.nextInt();
		System.out.println(rectPerimeter(l,r));
		System.out.println("Enter the base and power you'd like to raise the base to");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(toThePower(a,b));
		System.out.println("Enter a number to check whether it is prime or not");
		int c = sc.nextInt();
		System.out.println(isPrime(c));
		sc.close();
	}
	public static int rectPerimeter(int length, int width){
		return (length + length + width + width);
	}
	public static int toThePower(int base, int power){
		int ans = 1;
		for(int i = 0; i < power; i++){
			ans *= base;
		}
		return ans;
	}
	public static boolean isPrime(int num){
		boolean ans = true;
		for(int i = 2; i < num; i++){
			if(num % i == 0){
				ans = false;
			}
		}
		return ans;
	}
}
