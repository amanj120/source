package disjoint;

import java.util.Arrays;

public class disjointSet {
	public static int[] nodes = new int[6];
	public static class dj{
		public static int find(int j){
			if(nodes[j] < 0){
				return j;
			}
			else{
				return nodes[j] = find(nodes[j]);
			}
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
	public static void main(String[] args) {
		Arrays.fill(nodes, -1);
		dj.union(1, 3);
		System.out.println(Arrays.toString(nodes));
	}
}
