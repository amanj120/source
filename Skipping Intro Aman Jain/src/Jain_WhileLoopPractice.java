import java.util.*;
public class Jain_WhileLoopPractice {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int next = 0;
		do{
			System.out.println("-Menu-\n1.  Practice 1\n2.  Practice 2\n3. Practice 3\n0. Exit");
			next = sc.nextInt();
			switch (next){
			case 1:
				Practice1();
				break;
			case 2:
				Practice2();
				break;
			case 3:
				Practice3();
				break;
			default:
				System.out.println("try again");
			case 0:
				break;
			}
			
		}while(next!=0);
		sc.close();
	}
	public static void Practice3(){
		final int target = 100;
		int sum = 0;
		int n = 1;
		while(sum <= target){
			sum += n;
			n++;
		}
		System.out.println("It takes the sum of " +  n + " consecutive integers to exceed 100.");
		System.out.println("The sum of " +  n + " consecutive integers is "  + sum + ".");
	}
	public static void Practice2(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter start fahrenheit here:   ");
		int s = sc.nextInt();
		System.out.println("Enter end fahrenheit here:     ");
		int e = sc.nextInt();
		while(s <= e){
			double c = (((s-32) * 5)/9);
			System.out.println(s + "    " + c);
			s++;
		}
	}
	public static void Practice1(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name here:   ");
		String name = sc.next();
		System.out.println("enter 0 to stop, enter any other number to continue");
		while(true){
			if(sc.nextInt() != 0)
			System.out.println(name);
			else{
				break;
			}
		}
	}
}