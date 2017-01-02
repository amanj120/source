import java.util.*;
import java.io.*;
public class A {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int Mishka = 0;
		int Chris = 0;
		for(int i = 0; i < n; i++){
			int m = sc.nextInt();
			int c = sc.nextInt();
			if(m > c){
				Mishka++;
			}
			else if(c > m){
				Chris++;
			}
			else{
				Chris++;
				Mishka++;
			}
		}
		if(Mishka > Chris){
			System.out.println("Mishka");
		}
		else if(Chris > Mishka){
			System.out.println("Chris");
		}
		else{
			System.out.println("Friendship is magic!^^");
		}
		sc.close();
	}
}
