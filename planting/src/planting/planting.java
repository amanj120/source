package planting;

import java.util.Scanner;
import java.util.*;
import java.io.*;


public class planting {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("planting.input"));
		int n = sc.nextInt();
		ArrayList<String> ans = new ArrayList<String>();
		int[][] fields = new int[n][4];
		for(int i = 0; i < n; i++){
			fields[i][0] = sc.nextInt();
			fields[i][1] = sc.nextInt();
			fields[i][2] = sc.nextInt();
			fields[i][3] = sc.nextInt();
		}
		for(int i= 0; i < n; i++){
			for(int j = Math.min(fields[i][0], fields[i][2]); j < Math.max(fields[i][0], fields[i][2]); j++){
				for(int k = Math.min(fields[i][1], fields[i][3]); k < Math.max(fields[i][1], fields[i][3]); k++){
					String l = j + "~" + k;
					if(!ans.contains(l)){
						ans.add(l);
					}
				}
			}
		}
		System.out.println(ans.size());
		sc.close();
	}
}
