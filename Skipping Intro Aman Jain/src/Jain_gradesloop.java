import java.util.*;
import java.io.*;
public class Jain_gradesloop {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int next = 0;
		do{
			System.out.println("-Menu-\n1. Grades\n2. GCDA\n3. GCDB\n4. Binary Search\n0. Exit");
			next = sc.nextInt();
			switch (next){
			case 1:
				grades();
				break;
			case 2:
				GCDA();
				break;
			case 3:
				GCDB();
				break;
			case 4:
				binary();
				break;
			default:
				System.out.println("try again");
			case 0:
				break;
			}
			
		}while(next!=0);
		sc.close();
	}
	public static void grades(){
		Scanner sc = new Scanner(System.in);
		char grade = 'Z';
		int i = 1;
		int passing = 0;
		int failing = 0;
		do{
			System.out.print("Enter grade #" + i + ": ");
			grade = sc.next().charAt(0);
			switch (grade){
			case 'A':
				passing++;
				i++;
				break;
			case 'B':
				passing++;
				i++;
				break;
			case 'C':
				passing++;
				i++;
				break;
			case 'D':
				passing++;
				i++;
				break;
			case 'F':
				failing++;
				i++;
				break;
			default:
				System.out.println("<" + grade + " is NOT an acceptable grade>");
			case 'Z':
				break;
			}
		}while(grade != 'Z');
		System.out.println();
		double passed = 100 * ((double)passing/(double)(i-1));
		double failed = 100 * ((double)failing/(double)(i-1));
		String p = String.format("%.2f", passed);
		String f = String.format("%.2f", failed);
		System.out.println((i-1) + " students total.");
		System.out.println(passing + " students passed:	%" + p);
		System.out.println(failing + " students failed:	%" + f);
	}
	public static void GCDA(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int A = sc.nextInt();
		System.out.print("Enter an integer: ");
		int B = sc.nextInt();
		for(int j = Math.min(A, B); j > 0; j--){
			if(A%j == 0 && B%j == 0){
				System.out.println("The GCD is " + j );
				break;
			}
		}
	}
	public static void GCDB(){
		int C = (int) Math.ceil((Math.random() * 100));
		int D = (int) Math.ceil((Math.random() * 100));
		for(int j = Math.min(C, D); j > 0; j--){
			if(C%j == 0 && D%j == 0){
				System.out.println("The first number is " + C);
				System.out.println("The second number is " + D);
				System.out.println("The GCD is " + j );
				break;
			}
		}
	}
	public static void binary(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number that the program will guess: ");
		int n = sc.nextInt();
		int guess = 50;
		int lower = 0;
		int higher = 100;
		int num = 1;
		while(true){
			System.out.println("Is the number " + guess + "?" + " (H)igher, (L)ower, or (C)orrect:");
			char lllllllll = sc.next().charAt(0);
			if(lllllllll == 'H'){
				num++;
				lower = guess;
				guess += ((higher - lower)/2);
			}
			if(lllllllll == 'L'){
				num++;
				higher = guess;
				guess -= ((higher - lower)/2 + 1);
			}
			if(lllllllll == 'C'){
				System.out.println("It took " + num  + " guesses to reach the number");
				break;
			}
		}
		
	}
}
