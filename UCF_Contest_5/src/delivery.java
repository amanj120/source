import java.util.*;
import java.io.*;
public class delivery {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] adj = new int[n][n];
		for(int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				adj[i][j] = sc.nextInt();
				if(adj[i][j] < 0)adj[i][j] = 10000000;
			}
		}
		for(int i = 0; i < n; i++)
			for(int j = i+1; j < n; j++)
				for(int k = j+1; k < n; k++)
					if(adj[i][j] + adj[j][k] < adj[i][k])
						adj[i][k] = adj[i][j] + adj[j][k];
		System.out.println(adj[0][n-1]);
		sc.close();
	}
}