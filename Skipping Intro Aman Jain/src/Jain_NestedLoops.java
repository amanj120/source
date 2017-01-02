import java.util.*;
import java.io.*;
public class Jain_NestedLoops {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int next = 0;
		do{
			System.out.println("-Menu-\n1.	Multiply\n2.	Pattern A\n3.	Pattern B\n4.	Pattern C\n5.	Pattern D\n6.	Diamond\n0.	Exit");
			next = sc.nextInt();
			switch (next){
			case 1:
				multiply();
				break;
			case 2:
				PatternA();
				break;
			case 3:
				PatternB();
				break;
			case 4:
				PatternC();
				break;
			case 5:
				PatternD();
				break;
			case 6:
				Diamond();
				break;
			default:
				System.out.println("try again");
			case 0:
				break;
			}
			
		}while(next!=0);
		sc.close();
	}
	public static void multiply(){
		final int rows = 8;
		String header = "	";
		for(int i = 1; i <= rows ; i++){
			header += i + "	";
		}
		System.out.println(header);
		for(int i = 1; i <= rows; i++){
			String ans = (i) + "	";
			for(int j = 1; j <= rows; j++){
				ans += i*j + "	";
			}
			System.out.println(ans);
		}
	}
	public static void PatternA(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter height");
		int h = sc.nextInt();
		System.out.println("Enter intital");
		String k = sc.next();
		for(int i = 0; i < h; i++){
			String jjjjjjjjjj = "";
			for(int j = 0; j < h; j++){
				jjjjjjjjjj += k;
			}
			System.out.println(jjjjjjjjjj);
		}
	}
	public static void PatternB(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter height");
		int h = sc.nextInt();
		System.out.println("Enter intital");
		String k = sc.next();
		for(int i = 0; i < h; i++){
			String r = "";
			for(int j = h; j >i; j--){
				r+= k ;
			}
			System.out.println(r);
		}
	}
	public static void PatternC(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter height");
		int h = sc.nextInt();
		System.out.println("Enter intital");
		String k = sc.next();
		for(int i = 0; i < h; i++){
			String r = "";
			for(int j = 0; j < i; j++){
				r+= " ";
			}
			for(int j = h; j >i; j--){
				r+= k ;
			}
			System.out.println(r);
		}
		
	}
	public static void PatternD(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter height");
		int h = sc.nextInt();
		System.out.println("Enter intital");
		String k = sc.next();
		for(int i = 0; i < h; i++){
			String r = "";
			for(int j = 0; j < (h-i)- 1; j++){
				r+= " ";
			}
			for(int j = 0; j <(2*i + 1); j++){
				r+= k ;
			}
			System.out.println(r);
		}
	}
	public static void Diamond(){
		Scanner sc = new Scanner(System.in);
		boolean brake = false;
		while(brake == false){
			System.out.println("Enter an Odd Diamond Size:	");
			int n = sc.nextInt();
			if(n%2 == 0){
				System.out.println("Invalid Entry");
				System.out.println("Enter an Odd Diamond Size:	");
				n = sc.nextInt();
			}
			if(n%2 == 1){
				brake = true;
				for(int jj = 0; jj < n; jj++){
					String r = "";
					int half = n/2;
					int index = half - (Math.abs(jj - half));
					for(int i = 0; i < (half - index); i++){
						r += " ";
					}
					for(int i = 0; i < (index * 2) + 1; i++){
						r += "*";
					}
					System.out.println(r);
				}	
			}
		}
	}
}