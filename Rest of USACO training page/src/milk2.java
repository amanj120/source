/*
ID: amanj121
LANG: JAVA
TASK: milk2
*/

import java.util.*;
import java.io.*;

public class milk2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		int n = sc.nextInt();
		int[][] times = new int[n][2];
		for(int i = 0; i < n; i++){
			times[i][0] = sc.nextInt();
			times[i][1] = sc.nextInt();
		}
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(times[i][1] >= times[j][0] && times[j][0] >= times[i][0]){
					times[i][1] = times[j][1] = Math.max(times[i][1] , times[j][1]);
					times[j][0] = times[i][0];
				}
			}
		}
		int max = 0;
		for(int i = 0; i < n; i++){
			max = Math.max(max, times[i][1] - times[i][0]);
		}
		java.util.Arrays.sort(times, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return a[0] - b[0];
		    }
		});
		int min = 0;
		for(int i = 0; i < n - 1; i++){
				if(times[i][0] != times[i + 1][0] && times[i][1] != times[i + 1][1]){
					min = Math.max(min, times[i + 1][0] - times[i][1]);
				}
		}
		out.println(max + " " + min);
		sc.close();
		out.close();
	}
}