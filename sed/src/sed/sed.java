package sed;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class sed {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("sed.in"));
		String A = sc.nextLine();
		String B = sc.nextLine();
		int[][] d = new int[B.length()+1][A.length()+1];
		for(int i = 1; i <=B.length(); i++){
			d[i][0] = i;
		}
		for(int i = 1; i <=A.length(); i++){
			d[0][i] = i;
		}
		for(int i = 1; i<=B.length(); i++){
			for(int j = 1; j <=A.length(); j++){
				if(B.charAt(i-1) == A.charAt(j-1)){
					d[i][j] = d[i-1][j-1]; 
				}
				else{
					d[i][j] = Math.min(d[i][j-1] + 1,Math.min(d[i-1][j] + 1, d[i-1][j-1] + 1));
				}
			}
		}
		System.out.println(d[B.length()][A.length()]);
		sc.close();
	}
}
