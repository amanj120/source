/*
ID: amanj121
LANG: JAVA
TASK: skidesign
*/
import java.io.*;
import java.util.*;

public class skidesign {
	public static int n;
	public static int[] hills;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("input.in"));
		n = sc.nextInt();
		hills = new int[n];
		for(int i = 0; i < n; i++)
			hills[i] = sc.nextInt();
		sc.close();
		
		int ans = Integer.MAX_VALUE;
		
		for(int smallest = 0; smallest <=83; smallest++){
			int largest = smallest + 17;
			int temp = 0;
			for(int i = 0; i < n; i++)
				temp += (hills[i]<smallest? ((smallest-hills[i])*(smallest-hills[i])) :  hills[i] > largest?((hills[i] - largest)*(hills[i] - largest)):0 );
			ans = Math.min(temp, ans);
		}
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		System.out.println(ans);
		out.close();                                  
		System.exit(0);
	}

}
