package knapsack2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class knapsack2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner (new FileReader ("knapsack2"));
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[][] items = new int[N][2];
		int[][] d = new int[N+1][C+1];
		for(int i = 0; i < N; i++){
			items[i][0] = sc.nextInt();
			items[i][1] = sc.nextInt();
		}
		for(int i = 1; i < d.length ; i++){
			for(int j = 1; j < d[0].length ; j++){
				if(items[i-1][0] <= j){
					d[i][j] = Math.max(d[i-1][j], d[i-1][j-(items[i-1][0])] + items[i-1][1]);
				}
				else{
					d[i][j] = Math.max(d[i-1][j-1],d[i-1][j]) ;
				}
			}
		}
		System.out.println(d[N][C]);
		sc.close();
	}
}
