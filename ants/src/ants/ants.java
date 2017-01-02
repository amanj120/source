package ants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ants {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("ants.input"));
		int fams = sc.nextInt();
		int ants = sc.nextInt();
		int S = sc.nextInt();
		int B = sc.nextInt();
		int[][] nums = new int[fams][B];
		for(int i = 0; i < ants; i++){
			int l = sc.nextInt();
			nums[l-1][0] +=1;
		}
		for(int i = 1; i < B; i++){
			for(int j = 0; j < fams; j++){
				nums[j][i] = (i+1) * nums[j][0];
			}
		}
		sc.close();
	}
}

