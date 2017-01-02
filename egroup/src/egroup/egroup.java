package egroup;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class egroup {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("egroup.in"));
		int N = sc.nextInt();
		int [][] ups = new int[N+1][3];
		int [][] downs = new int[N+1][3];
		
		for(int i = 1; i < ups.length; i++){
			for(int j = 0; j < 3 ; j++){
				ups[i][j] = downs[i][j] = 1;
			}
		}
		
		for(int i = 1; i < N+1; i++){
			int l = sc.nextInt()- 1;
			ups[i][l] = downs[i][l] = 0;	
		}
		
		for(int i = N; i > 1; i--){
			ups[i-1][0] += ups[i][0];
			ups[i-1][1] += Math.min(ups[i][0], ups[i][1]);
			ups[i-1][2] += Math.min(Math.min(ups[i][0], ups[i][1]), ups[i][2]);
		}
		
		for(int i = N; i > 1; i--){
			downs[i-1][0] += Math.min(Math.min(downs[i][0], downs[i][1]), downs[i][2]);
			downs[i-1][1] += Math.min(downs[i][1], downs[i][2]);
			downs[i-1][2] += downs[i][2];
		}
		
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < 3; i++){
			ans = Math.min(Math.min(ups[1][i], downs[1][i]), ans);
		}
		System.out.println(ans);
		sc.close();
	}
}
