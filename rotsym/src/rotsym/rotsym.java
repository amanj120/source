package rotsym;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class rotsym {
	public static void main(String[] args) throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(new FileReader("rotsym.input"));
		int n = sc.nextInt();
		int ans = 0;
		int[][] points = new int[n][2];
		int[][] c = new int[n*(n-1)/2][2];
		for(int i = 0; i < n; i++){
			points[i][0] = sc.nextInt();
			points[i][1] = sc.nextInt();
		}
		int qww = 0;
		for(int k = 0; k < n; k++){
			for(int j = k+1; j < n; j++){
				c[qww][0] =points[k][0] + points[j][0];
				c[qww][1] =points[k][1] + points[j][1];
				qww++;
			}
		}
		java.util.Arrays.sort(c, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		int deltaxval = c[0][0];
		int deltaxindex = 0;
		for(int i = deltaxindex; i < c.length - 1; i++){
			for(int j = i+1; j < c.length; j++){
				if(c[j][0] == deltaxval){
					if(c[i][1] == c[j][1]){
						ans++;
					}
					continue;
				}
				break;
			}
			deltaxval = c[i+1][0];
			deltaxindex = i+1;
		}
		System.out.println(ans);
	}
}