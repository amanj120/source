package treasure;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class treasure {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("treasure.input"));
		int n = sc.nextInt();
		int[] S = new int[n+1];
		int[][]d = new int[n][n];
		for(int i = 0; i < n; i++){
			d[i][i] = sc.nextInt();
			S[i+1] = d[i][i] + S[i];
		}
		for(int j = 1 ; j <n; j++){
			for(int i = 0; i <n-j; i++){
				d[i][i+j]= (S[i+j+1]-S[i])-Math.min(d[i+1][i+j],d[i][i+j-1]);
			}
		}
		System.out.println(d[0][n-1]);
		sc.close();
	}
}