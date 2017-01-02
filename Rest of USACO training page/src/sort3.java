/*
ID: amanj121
LANG: JAVA
TASK: sort3
*/
import java.io.*;
import java.util.*;

public class sort3 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("input.in"));
		int n = sc.nextInt();
		int[]nums = new int[n];
		for(int i = 0; i < n; i++)
			nums[i] = sc.nextInt();
		sc.close();
		int ans = 0;
		int s = 0;
		while(true){
			int j = s;
			for(j = s; j < n; j++){
				if(nums[s] > nums[j]){
					ans++;
					int t = nums[s];
					nums[s] = nums[j];
					nums[j] = t;
					break;
				}
			}
			if(j < n){
				s= 0;
			}
			else{
				s++;
			}
			if(s == n){
				break;
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.out")));
		out.println(ans);
		
		out.close();
		System.exit(0);
	}
}
