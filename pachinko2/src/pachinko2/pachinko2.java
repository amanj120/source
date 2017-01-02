package pachinko2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class pachinko2 {
	public static int R;
	public static int[][]mat; 
	public static boolean[][] found;
	public static int[][] val;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("pachinko2.in"));
		R = sc.nextInt();
		mat = new int[R][R];
		found = new boolean[R][R];
		val = new int[R][R];
		for(int i = 0; i < R; i++){
			for(int j = 0; j< R; j++){
				mat[i][j] = -1;
			}
		}
		for(int i = 0; i < R; i++){
			for(int j = 0; j <=i; j++){
				mat[i][j] = sc.nextInt();
			}
		}
		System.out.println(f(0,0));
		sc.close();
	}
	public static int f(int y, int x){
		if(y == R){
			return 0;
		}
		if(!found[y][x]){
			val[y][x] = mat[y][x] + Math.max(f(y+1, x),f(y+1, x+1));
			found[y][x] = true;
		}
		return val[y][x];
	}
}
