import java.util.*;
import java.io.*;
public class PetTesting {
	public static Pet alpha;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("-Menu-\n1. Customized Pet\n2. Default Pet");
		int n = sc.nextInt();
		if(n == 1){
			System.out.println("Enter your pet's weight (integer)");
			int a = sc.nextInt();
			System.out.println("Enter your pet's age (integer)");
			int b = sc.nextInt();
			System.out.println("Enter your pet's intelligence (integer)");
			int c = sc.nextInt();
			System.out.println("Enter your pet's speed (integer)");
			int d = sc.nextInt();
			System.out.println("Enter your pet's favorite hobby (string)");
			String e = sc.next();
			alpha = new Pet(a,b,c,d,e);
		}
		if(n == 2){
			alpha = new Pet();
		}
		int next = 0;
		do{
			System.out.println("-What would you like to your pet?-\n1. Feed your pet \n2. Give your pet a book \n3. Throw your pet a birthday party \n4. Take your pet out for a run \n5. Have your pet try a new activity  \n6. Give your pet a drink \n7. Display all of your pet's Information \n8. Exit");
			next = sc.nextInt();
			switch (next){
			case 1:
				System.out.println("How many pounds of food will your pet eat?");
				int j = sc.nextInt();
				alpha.eat(j);
				System.out.println();
				break;
			case 2:
				System.out.println("How many hours will your pet read?");
				int k = sc.nextInt();
				alpha.read(k);
				System.out.println();
				break;
			case 3:
				alpha.birthdays();
				System.out.println();
				break;
			case 4:
				System.out.println("How many miles will your pet run?");
				int l = sc.nextInt();
				alpha.run(l);
				System.out.println();
				break;
			case 5:
				System.out.println("What new activity will your pet try");
				String d = sc.next();
				System.out.println("On a scale from 1-10 how much did your pet enjoy " + d);
				int hhhhhhhh = sc.nextInt();
				alpha.tryActivity(d, hhhhhhhh);
				System.out.println();
				break;
			case 6:
				System.out.println("How much water will your pet drink");
				int m = sc.nextInt();
				int newWeight = alpha.drinkWater(m);
				System.out.println("Your pet drank " + m + " fluid ounces of water. It is hydrated and weighs "+ newWeight + " pounds.");
				System.out.println();
				break;
			case 7:
				alpha.displayInfo();
				System.out.println();
				break;
			default:
				System.out.println("try again");
				System.out.println();
			case 8:
				break;
			}
			
		}while(next!=8);
		sc.close();
	}
}
