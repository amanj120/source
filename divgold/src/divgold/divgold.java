package divgold;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class divgold {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("divgold.in"));
		int nocoin = sc.nextInt();
		int[] coins = new int[nocoin];
		for(int i = 0; i < nocoin; i++){
			coins[i] = sc.nextInt();
		}
		int sum = 0;
		for(int i = 0; i < nocoin; i++){
			sum += coins[i];
		}
		long[][] d = new long[2][sum+1];
		d[0][0] = 1;
		int u = 1;
		for(int i = 1; i <=nocoin; i++){
			for(int j = 0; j <=sum; j++){
				if(j - coins[i-1] >= 0){
					d[u][j] = d[u^1][j] + d[u^1][j-coins[i-1]];
				}
				else{
					d[u][j] = d[u^1][j];
				}
			}
			u = u^1;
		}
		int sDif = 1000000;
		for(int i = sum; i >= 0; i--){
			if(d[0][i] > 0){
				sDif = Math.min(sDif,Math.abs((i - (sum-i))));
			}
		}
		System.out.println(sDif);
		System.out.println(((d[1][(sDif + sum)/2])%1000000) + " " + d[0][(sDif + sum)/2]%1000000);
		sc.close();	
	}
}
