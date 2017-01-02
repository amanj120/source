package picnic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class picnic {
	public static int M;
	public static int[] h;
	public static int[][] paths;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("picnic.input"));
		int K = sc.nextInt();
		int N = sc.nextInt();
		M = sc.nextInt();
		int ans = 0;
		int[] cows = new int[K];
		h = new int[N];
		paths = new int[M][2];
		for(int i = 0; i<K; i++){
			cows[i] = sc.nextInt();
		}
		for(int i = 0; i < M; i++){
			paths[i][0] = sc.nextInt();
			paths[i][1] = sc.nextInt();
		}
		for(int i = 0; i <K; i++){
			h[cows[i]-1] += 1;
			boolean [] visited = new boolean[N];
			visited[cows[i]-1] = true;
			moves(cows[i], visited);
		}
		for(int i = 0; i< h.length; i++){
			if(h[i] == K)ans++;
		}
		System.out.println(ans);
		sc.close();
	}
	public static void moves(int n, boolean[] visited){
		for(int i = 0; i<M; i++){
			if(paths[i][0] == n && !visited[paths[i][1]-1]){
				h[paths[i][1] - 1] += 1;
				visited[paths[i][1]-1] = true;
				moves(paths[i][1], visited);
			}
		}
	}
}