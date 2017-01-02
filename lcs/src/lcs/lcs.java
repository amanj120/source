package lcs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class lcs {
	public static int[][] d;
	public static String A;
	public static String B;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("lcs.in"));
		A = sc.nextLine();
		B = sc.nextLine();
		d = new int[A.length() + 1][B.length() + 1];
		for(int i = 0; i < A.length() ; i++){
			for(int j = 0; j < B.length(); j++){
				if(A.charAt(i) == B.charAt(j)){
					d[i+1][j+1] = d[i][j] + 1;
				}
				else{
					d[i+1][j+1] = Math.max(d[i+1][j], d[i][j+1]);
				}
			}
		}
		System.out.println(d[A.length()][B.length()]);
		sc.close();
	}
}