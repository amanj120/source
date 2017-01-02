import java.util.Arrays;
import java.util.Scanner;
public class candy {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] candies = new int[n];
		int k = sc.nextInt();
		for(int i = 0; i < n; i++){
			candies[i] = sc.nextInt();
		}
		Arrays.sort(candies);
		int ans = 0;
		for(int i = 0; i < k; i++){
			ans+= candies[candies.length - 1] / 2;
			candies[candies.length - 1] = candies[candies.length - 1] -  candies[candies.length - 1]/2;
			Arrays.sort(candies);
		}
		System.out.println(ans);
		sc.close();
	}
}