/*
ID: amanj121
LANG: JAVA
TASK: sprime
*/
import java.io.*;
import java.util.*;

public class sprime {
	public static int n;
	public static PrintWriter out;
	public static ArrayList<Integer> ans = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("sprime.in"));
		n = sc.nextInt();
		sc.close();
		out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
		solve(2);
		solve(3);
		solve(5);
		solve(7);
		for(int i = 0; i < ans.size(); i++){
			out.println(ans.get(i));
		}
		out.close();
		System.exit(0);
	}
	public static void solve(int num){
		if((""+num).length() == n){
			ans.add(num);
			return;
		}
		for(int i = 0; i <= 9; i++){
			int newnum = num*10;
			newnum+=i;
			if(isPrime(newnum)){
				solve(newnum);
			}
		}
	}
	public static boolean isPrime(int x){
		if(x == 2) return true;
		if(x == 1 || x == 0)return false;
		for(int i = 2; (i-1)*(i-1) <x; i++)	
			if(x%i == 0)	
				return false;
		return true;
	}
}
