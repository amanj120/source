import java.util.*;
public class nuts {
	public static int[] nodes;
	public static class point implements Comparable<point>{
		int start;
		int end;
		double weight;
		public point(int a, int b, double c) {
			start = a;
			end = b;
			weight = c;
		}
		public int compareTo(point o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	public static class dj{
		public static int find(int j){
			if(nodes[j] == j){
				return j;
			}
			else{
				int root = find(nodes[j]);
				nodes[j] = root;
				return root;
			}
		}
		public static boolean union(int a, int b){
			int pA = find(a);
			int pB = find(b);
			if(pA != pB){
				nodes[pB] = pA;
				return false;
			}
			else{
				return true;
			}
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		nodes = new int[n+1];
		for(int i = 0; i < n+1; i++){
			nodes[i] = i;
		}
		PriorityQueue<point> pq = new PriorityQueue<point>();
		for(int i = 0; i < m; i++){
			pq.add(new point(sc.nextInt(),sc.nextInt(),sc.nextDouble()));
		}
		double ans = 1;
		while(!pq.isEmpty()){
			point a = pq.poll();
			if(!dj.union(a.start,a.end)){
				double q = 1 - a.weight;
				ans = ans * (q);
			}
		}
		System.out.printf("%.4f%n", 1 - ans);
		sc.close();
	}
}