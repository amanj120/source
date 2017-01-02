import java.util.*;
import java.io.*;
public class dots {
	public static int[] nodes;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		nodes = new int[n];
		Arrays.fill(nodes, -1);
		for(int i = 0; i < m; i++)
			dj.union(sc.nextInt() - 1, sc.nextInt() - 1);
		int ans = 0;
		for(int i = 0; i < nodes.length; i++)
			if(nodes[i] < -1) ans++;
		System.out.println(ans);
		sc.close();
	}
	static class dj{
		public static int find(int j){
			if(nodes[j] < 0) return j;
			else return nodes[j] = find(nodes[j]);
		}
		public static boolean union(int a, int b){
			int pA = find(a);
			int pB = find(b);
			if(pA == pB) return false;
			else{
				if(nodes[pA] <= nodes[pB]){
					nodes[pA] += nodes[pB];
					nodes[pB] = pA;
				}
				if(nodes[pB] < nodes[pA]){
					nodes[pB] += nodes[pA];
					nodes[pA] = pB;
				}
				return true;
			}
		}
	}
}