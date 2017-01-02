package mtime;

import java.util.*;
import java.io.*;

public class mtime {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("mtime.input"));
		int[][] jobs = new int[sc.nextInt()][2];
		for(int i = 0; i < jobs.length; i++){
			jobs[i][1] = sc.nextInt();jobs[i][0] = sc.nextInt();
		}
		
		java.util.Arrays.sort(jobs, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b){
		    	return Integer.compare(b[0], a[0]);
		    }
		});
		
		int x = jobs[0][0] - jobs[0][1];
		for(int i = 1; i < jobs.length; i++){
			if(x <= jobs[i][0]){
				x -= jobs[i][1];
			}
			else{
				x = jobs[i][0]  - jobs[i][1];
			}
		}
		if(x >= 0){
			System.out.println(x);
		}
		else{
			System.out.println(-1);
		}
		sc.close();	
	}
}