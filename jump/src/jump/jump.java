package jump;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class jump {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("jump.input"));
		int end = sc.nextInt();
		int rockno = sc.nextInt() + 2;
		int remove = sc.nextInt();
		int[] rocks = new int[rockno];
		int[][] p = new int[rockno-1][3];
		rocks[0] = 0;
		rocks[rockno - 1] = end;
		for(int i = 1; i < rockno - 1; i++){
			rocks[i] = sc.nextInt();
		}
		Arrays.sort(rocks);
		for(int i = 0; i < p.length; i++){
			p[i][0] = rocks[i+1] - rocks[i];
			p[i][1] = rocks[i+1];
			p[i][2] = rocks[i];
		}
		java.util.Arrays.sort(p, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		for(int i = 0; i < remove; i++){
			for(int j = 0; j < rocks.length; j++){
				int[] tempo = new int[rocks.length - 1];
				if(p[i][1]!= 0)
			}
		}
		sc.close();
	}

}
