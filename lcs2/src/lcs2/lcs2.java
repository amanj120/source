package lcs2;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.util.Scanner;

	public class lcs2 {
		public static int[][] d;
		public static String A;
		public static String B;
		public static void main(String[] args) throws FileNotFoundException {
			Scanner sc = new Scanner(new FileReader("lcs2.in"));
			A = sc.nextLine();
			B = sc.nextLine();
			d = new int[2][B.length() + 1];
			int u = 0;
			for(int i = 0; i < A.length() ; i++){
				for(int j = 0; j < B.length(); j++){
					if(A.charAt(i) == B.charAt(j)){
						d[u^1][j+1] = d[u][j] + 1;
					}
					else{
						d[u^1][j+1] = Math.max(d[u^1][j], d[u][j+1]);
					}
				}
				u = u^1;
			}
			System.out.println(Math.max(d[0][B.length()],d[1][B.length()]));
			sc.close();
		}
	}
