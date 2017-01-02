/*
ID: amanj121
LANG: JAVA
TASK: pprime
*/
import java.util.*;
import java.io.*;
public class pprime {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("pprime.in"));
		int s = sc.nextInt();
		int e = sc.nextInt();
		sc.close();
		/*int max = e + 10;
		boolean[] isPrime = new boolean[max + 1];
		isPrime[0] = isPrime[1] = false;
		for(int i = 2; i*i< max+1; i++){
			for(int j = i*i; j < max+1; j+= i){
				isPrime[j] = true;
			}
		}*/
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int d1 = 1; d1<10; d1+=2){//1s and 10s
			int a = d1;
			int b = d1 * 10 + d1;
			if(a <= e && !isPrime(a))ans.add(a);
			if(b <= e && !isPrime(b))ans.add(b);
		}
		Collections.sort(ans);
		for(Integer i : ans){
			if(i >= s){
				if(i <= e){
					out.println(i);
				}
				else{
					break;
				}
			}
			continue;
		}
		ans.clear();
		for(int d1 = 1; d1<10; d1+=2){//100s and 1000s
			for(int d2 = 0; d2 < 10; d2++){
				int a = d1* 100 + d2 * 10 + d1 ;
				int b = d1* 1000 + d2*100 + d2*10 + d1;
				if(a <= e && !isPrime(a))ans.add(a);
				if(b <= e && !isPrime(b))ans.add(b);
			}
		}
		Collections.sort(ans);
		for(Integer i : ans){
			if(i >= s){
				if(i <= e){
					out.println(i);
				}
				else{
					break;
				}
			}
			continue;
		}
		ans.clear();
		for(int d1 = 1; d1<10; d1+=2){//10000s and 100000s
			for(int d2 = 0; d2 < 10; d2++){
				for(int d3 = 0; d3 < 10; d3++){
					int a = d1* 10000 + d2 * 1000 + d3 * 100 + d2*10 + d1 ;
					int b = d1* 100000 + d2 * 10000 + d3 * 1000 + d3*100 + d2*10 + d1;
					if(a <= e &&!isPrime(a))ans.add(a);
					if(b <= e &&!isPrime(b))ans.add(b);
				}
			}
		}
		Collections.sort(ans);
		for(Integer i : ans){
			if(i >= s){
				if(i <= e){
					out.println(i);
				}
				else{
					break;
				}
			}
			continue;
		}
		ans.clear();
		for(int d1 = 1; d1<10; d1+=2){//1000000s and 10000000s
			for(int d2 = 0; d2 < 10; d2++){
				for(int d3 = 0; d3 < 10; d3++){
					for(int d4 = 0; d4 < 10; d4++){
						int a = d1* 1000000 + d2 * 100000 + d3 * 10000 + d4 * 1000 + d3 * 100 + d2*10 + d1 ;
						int b = d1* 10000000 + d2 * 1000000 + d3 * 100000 + d4 *10000 + d4 * 1000 + d3 * 100 + d2*10 + d1;
						if(a <= e && !isPrime(a))ans.add(a);
						if(b <= e && !isPrime(b))ans.add(b);
					}	
				}
			}
		}
		Collections.sort(ans);
		for(Integer i : ans){
			if(i >= s){
				if(i <= e){
					out.println(i);
				}
				else{
					break;
				}
			}
			continue;
		}
		ans.clear();
		out.close();
		System.exit(0);
	}
	public static boolean isPrime(int x){
		for(int i = 2; (i-1)*(i-1) <x; i++){
			if(x%i == 0)return true;
		}
		return false;
	}
}