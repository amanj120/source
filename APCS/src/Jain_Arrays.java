import java.util.*;

public class Jain_Arrays {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int next = 0;
		do{
			System.out.println();
			System.out.println("-Menu-\n1. max-min-avg\n2. high-values\n3. Bonus\n0. Exit");
			next = sc.nextInt();
			switch (next){
			case 1:
				maxMinAvg();
				break;
			case 2:
				highVals();
				break;
			case 3:
				grades();
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
		// Finds the higest number and stores the index of the highest number
		System.out.println(vals[n-1]);
		System.out.println();
		System.out.println("There were a total of " + n + " numbers entered.");
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
		//The next line sets the highest value to a low value
		vals[max1index - 1] = Integer.MIN_VALUE;
		
		//This does the exact same thing as above, but now it will find the second highest value
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
		
		//Same as above, but with third value
		int max3 = Integer.MIN_VALUE;
		int max3index = -1;
		for(int i = 0; i < n; i++){
			if(vals[i] > max3){
				max3index = i + 1;
				max3 = vals[i];
			}
		}
		System.out.println("The third highest number was in sequence # " + max3index);
		vals[max3index - 1] = Integer.MIN_VALUE;
	}
// The bonus doesnt print out the names and grades for some reason...
	public static void grades(){
		Scanner sc = new Scanner(System.in);
		int[] grades = new int[40];
		String[] names = new String[40];
		for(int i = 0; i < 40; i++){
			names[i] = "";
		}
		String name = "";
		int i = 1;
		int sum = 0;
		int gr = -1;
		System.out.println("Enter Name and Grade as -1 to exit");
		do{
			System.out.print("Enter name " + i + ": ");
			name = sc.next();
			System.out.println("Enter grade " + i + ": ");
			gr = sc.nextInt();
			if(gr!= -1){
				sum += gr;
				i++;
				names[i - 1] = name;
				grades[i-1] = gr;
			}
		}while(gr != -1);
		double avg = ((double)sum)/(i-1);
		System.out.println("The average(mean) grade was " + avg);
		int highIndex = -1;
		int max =Integer.MIN_VALUE;
		for(int j = 0; j < 40; j++){
			if(grades[j] > max){
				highIndex = j;
				max = grades[j];
			}
		}
		int j = 0;
		while(grades[j] != 0 && names[j] != ""){
			if(j == highIndex){
				System.out.println("**" + names[j] + "* had the highest grade in the class: " + "*" + grades[j] + "*");
			}
			else{
				System.out.println(names[j] + "had a grade of: " + grades[j]);
			}
			j++;
			
		}
		System.out.println("The difference between the highest grade and the mean grade was: " + (grades[highIndex] - avg) + " points");
		
	}
}
