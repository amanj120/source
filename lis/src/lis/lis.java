package lis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class lis {
	public static int n;
	public static int[] seq;
	public static int[][][] d;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("lis.in"));
		n = sc.nextInt();
		seq = new int[n];
		d = new int[n][n][2];
		for(int i = 0; i < n; i++){
			seq[i] = sc.nextInt();
		}
		for(int i = 0; i< n; i++){
			d[i][i][0] = 1;
			d[i][i][1] = seq[i];
		}
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				f(i,j);
			}
		}
		int ans = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				ans = Math.max(ans, d[i][j][0]);
			}
		}
		System.out.println(ans);
		sc.close();
	}
	public static void f(int i, int j){
		if( seq[j]> d[i][j-1][1]){
			d[i][j][0] = d[i][j-1][0] + 1;
			d[i][j][1] = seq[j];
		}
		else{
			d[i][j][0] = d[i][j-1][0];
			d[i][j][1] = d[i][j-1][1];
		}
	}
}
