import java.util.*;

public class Arrays_Assignment {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int next = 0;
		do{
			System.out.println();
			System.out.println("-Menu-\n1. max-min-avg\n2. high-values\n0. Exit");
			next = sc.nextInt();
			switch (next){
			case 1:
				maxMinAvg();
				break;
			case 2:
				highVals();
				break;
			default:
				System.out.println("try again");
			case 0:
				break;
			}
			
		}while(next!=0);
		sc.close();
	}
	public static void maxMinAvg(){
		Scanner sc = new Scanner(System.in);
		int[] vals = new int[10];
		double sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < 10; i++){
			System.out.print("Enter Value " + (i+1) + ": ");
			vals[i] = sc.nextInt();
			sum += vals[i];
			min = Math.min(min, vals[i]);
			max = Math.max(max, vals[i]);
		}
		sum /= 10;
		System.out.println("\nAverage: " + sum + "\nMax: " + max + "\nMin: " + min);
		for(int i = 0; i < 10; i++){
			System.out.println("The value of the " + (i+1) + " number is " + vals[i]);
		}
		
	}
	public static void highVals(){
		Scanner sc = new Scanner(System.in);
		System.out.println("How many numbers would you like to enter?(Must be greater than 2)");
		int n = sc.nextInt();
		int[] vals = new int[n];
		for(int i = 0; i < n; i++){
			System.out.print("Enter a value: ");
			vals[i] = sc.nextInt();
		}
		System.out.println();
		System.out.print("List of Values: ");
		for(int i = 0; i < n - 1; i++){
			System.out.print(vals[i] + ", ");
		}
		System.out.println(vals[n-1]);
		System.out.println();
		System.out.println("There were a total of " + n + " numbers entered. ");
		int max1 = Integer.MIN_VALUE;
		int max1index = -1;
		for(int i = 0; i < n; i++){
			if(vals[i] > max1){
				max1index = i + 1;
				max1 = vals[i];
			}
		}
		System.out.println();
		System.out.println("The highest number was in sequence # " + max1index);
		vals[max1index - 1] = Integer.MIN_VALUE;
		
		int max2 = Integer.MIN_VALUE;
		int max2index = -1;
		for(int i = 0; i < n; i++){
			if(vals[i] > max2){
				max2index = i + 1;
				max2 = vals[i];
			}
		}
		System.out.println("The second highest number was in sequence # " + max2index);
		vals[max2index - 1] = Integer.MIN_VALUE;

		int max3 = Integer.MIN_VALUE;
		int max3index = -1;
		for(int i = 0; i < n; i++){
			if(vals[i] > max3){
				max3index = i + 1;
				max3 = vals[i];
			}
		}
		System.out.println("The second highest number was in sequence # " + max3index);
		vals[max3index - 1] = Integer.MIN_VALUE;
	}
}
