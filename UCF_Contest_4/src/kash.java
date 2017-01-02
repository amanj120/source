import java.util.*;
public class kash {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] o = new int[n][2];
		for(int i = 0; i < n; i++){
			o[i][0] = sc.nextInt();
			o[i][1] = sc.nextInt();
		}
		int[][] dp = new int[n+1][n+1];
		for(int i = 1; i < n+1; i++){
			for(int j = i; j < n+1; j++){
				if(o[j-1][0] <= i){
					dp[j][i] = Math.max(Math.max(dp[j-1][i],dp[j][i-1]), o[j-1][1] + dp[j-1][i-o[j-1][0]]);
				}
				else{
					dp[j][i] = Math.max(dp[j-1][i],dp[j][i-1]);
				}
			}
		}
		System.out.println(dp[n][n]);
		sc.close();
	}
}