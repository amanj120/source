import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class campus {
	public static int[][] adj;
	public static boolean[] visited;
	public static int ans;
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileReader("campus.in"));
		int n = sc.nextInt();
		adj = new int[n][n];
		visited = new boolean[n];
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				adj[i][j] =  adj[j][i] = 1;
			}
		}
		int g = sc.nextInt();
		for(int i = 0; i < g; i++){
			int l = sc.nextInt() - 1;
			int m = sc.nextInt() - 1;
			adj[l][m] = adj[m][l] = 0;
		}
		ans = 1;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				visited[j] = false;
			}
			visited[i] = true;
			move(i, 1);
		}
		System.out.println(ans);
		sc.close();
	}
	public static void move(int n, int d){
		ans = Math.max(ans, d);
		for(int i = 0; i < adj.length; i++){
			if(adj[n][i] == 1 && !visited[i]){
				visited[i] = true;
				move(i, d + 1);
				visited[i] = false;
			}
		}
	}
}
