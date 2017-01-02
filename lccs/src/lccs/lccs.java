package lccs;
import java.util.Scanner;
public class lccs {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String B = sc.nextLine();
		int[][] d = new int[A.length() + 1][B.length() + 1];
		int max = 0;
		for(int i = 0; i < A.length() ; i++)
			for(int j = 0; j < B.length(); j++){
				if(A.charAt(i) == B.charAt(j)) d[i+1][j+1] = d[i][j] + 1;
				max = Math.max(max, d[i+1][j+1]);
			}
		System.out.println(max);
		sc.close();
	}
}