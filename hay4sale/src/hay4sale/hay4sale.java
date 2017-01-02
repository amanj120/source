package hay4sale;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class hay4sale {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new FileReader("hay4sale.in"));
		int c = s.nextInt();
		int n = s.nextInt();
		int [] b = new int[n];
		for(int i = 0; i < n; i++){
			b[i] = s.nextInt();
		}
		int[][] d = new int[2][c + 1];
		int u=0;
		for(int i = 1; i < n + 1; i++){
			for(int j = 1; j < c+1 ; j++){
				if(b[i-1] <= j){  
					d[u][j] =Math.max(b[i-1] + d[u^1][j-b[i-1]], Math.max(d[u^1][j], d[u][j-1]));
					continue;
				}
				d[u][j] = Math.max(d[u^1][j], d[u][j-1]);
			}
			u=u^1;
		}
		System.out.println(d[0][c]);
		s.close();
	}
}
