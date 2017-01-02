import java.util.*;
import java.io.*;

public class DFS_Test {
	public static int[][] adj;
	public static int ans;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("d.in"));
		int n = sc.nextInt();
		int m = sc.nextInt();
		adj = new int[n][n];
		for(int i = 0; i < n; i++){
			Arrays.fill(adj[i], -1);
		}
		for(int i = 0; i < m; i++){
			int a = sc.nextInt() - 1;
			int b = sc.nextInt()- 1;
			int c = sc.nextInt();
			adj[a][b] = adj[b][a] = c;
			adj[a][a] = 0;
		}
		int start = 0;
		int end = 4;
		ans = Integer.MAX_VALUE;
		boolean[] visited = new boolean[n];
		visited[start] = true;
		dfs(start, end, visited, 0);
		System.out.println(ans);
		sc.close();
	}
	public static void dfs(int start, int end, boolean[] visited, int min){
		if(start == end){
			ans = Math.min(ans, min);
			return;
		}
		for(int i = 0; i < adj.length; i++){
			if(!visited[i] && adj[start][i] != -1){
				visited[i] = true;
				dfs(i, end, visited, min + adj[start][i]);
				visited[i] = false;
			}
		}
	}

}
