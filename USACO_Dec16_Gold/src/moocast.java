/*
ID: amanj121
LANG: JAVA
TASK: moocast
*/
import java.io.*;
import java.util.*;

public class moocast {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("moocast.in"));
		int n = sc.nextInt();
		int[][] points = new int[n][2];
		long[] key = new long[n];
		long[][] adj= new long[n][n];
		for(int i = 0; i < n; i++){
			points[i][0] = sc.nextInt();
			points[i][1] = sc.nextInt();
			key[i] = Long.MAX_VALUE;
		}
		sc.close();
		
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				int x = points[i][0] - points[j][0];
				int y = points[i][1] - points[j][1];
				long dist = (x*x+y*y);
				adj[i][j] = adj[j][i] = dist;
			}
		}
		boolean[] visited = new boolean[n];
		boolean brake = true;
		int currentNode = 0;
		//The distance between the starting node and itself is 0;
		key[currentNode] = 0;
		visited[currentNode] = true;
		for(int reps = 0; reps < n; reps++){
			for(int i=0; i< key.length; i++)
				if(!visited[i] && adj[currentNode][i] < key[i])
					key[i] = adj[currentNode][i];
			
			long min = Long.MAX_VALUE;//the length of the shortest path that can be chosen
			int minIndex = 0; // the index of the shortest path that can be taken
			for(int i = 0; i < key.length; i++){
				if(!visited[i] && key[i] < min){
					min = key[i];
					minIndex = i;
				}
			}
			//After finding the smallest path, the index of the smallest path is marked visited
			visited[minIndex] = true;
			currentNode = minIndex;
		}
		long ans = 0;
		for(int i = 0; i < n; i++)
			ans = Math.max(ans, key[i]);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		out.println(ans);
		out.close();
		System.exit(0);
	}
}
