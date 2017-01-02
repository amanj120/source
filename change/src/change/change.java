package change;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class change {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("change.input"));
		int c = sc.nextInt();
		int n = sc.nextInt();
		int[] coins = new int[n];
		for(int i = 0; i <n ; i++){
			coins[i] = sc.nextInt();
		}
		Arrays.sort(coins);
		int[][] d = new int[n+1][c + 1];
		for(int i = 0; i < c+1; i++){
			d[0][i] = 12345678;
		}
		for(int i = 1; i < n + 1; i++){
			for(int j = 1; j < c+1;  j++){
				if(coins[i-1] <= j){
					d[i][j] = Math.min(d[i-1][j], d[i][j - coins[i - 1]] + 1);
				}
				else{
					d[i][j] = d[i-1][j];
				}
			}
		}
		System.out.println(d[n][c]);
		sc.close();
	}
}