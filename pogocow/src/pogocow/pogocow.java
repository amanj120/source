package pogocow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class pogocow {
	public static int[][]mat;
	public static int[][] points;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("pogocow.in"));
		int n = sc.nextInt();
		mat = new int[n][n];
		points = new int[n][2];
		for(int i = 0; i < n; i++){
			points[i][0] = sc.nextInt();
			points[i][1] = sc.nextInt();
		}
		for(int i = 0; i < n; i++){
			mat[i][i] = points[i][0];
		}
		sc.close();
	}	
}