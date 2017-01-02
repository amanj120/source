import java.util.*;
import java.io.*;
public class C {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int n = sc.nextInt();
		int[]costs = new int[n]; 
		for(int i = 0; i < n; i++){
			costs[i] = sc.nextInt();
		}
		String[] str = new String[n];
		str[0] = sc.next();
		for(int i = 1; i < n; i++){
			str[i] = sc.next();
			int v = str[i-1].compareTo(str[i]);
			if(v > 0){
				int first = costs[i-1];
				int second = costs[i];
				if(first > second){
					if(str[i-1].compareTo(swap(str[i])) <= 0){
						ans += second;
					}
					else if(swap(str[i-1]).compareTo(str[i]) <= 0){
						ans += first;
					}
					else{
						System.out.println(-1);
						return;
					}
				}
				if(second > first){
					if(swap(str[i-1]).compareTo(str[i]) <= 0){
						ans += first;
					}
					else if(str[i-1].compareTo(swap(str[i])) <= 0){
						ans += second;
					}
					else{
						System.out.println(-1);
						return;
					}
				}
				if(first == second){
					if(str[i-1].compareTo(swap(str[i])) <= 0){
						ans += second;
					}
					else if(swap(str[i-1]).compareTo(str[i]) <= 0){
						ans += first;
					}
					else{
						System.out.println(-1);
						return;
					}
				}
			}
			
		}
		System.out.println(ans);
		sc.close();
	}
	public static String swap(String l){
		return new StringBuilder(l).reverse().toString();
	}
}
