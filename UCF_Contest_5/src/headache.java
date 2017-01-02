import java.util.*;
import java.io.*;
public class headache {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("a.in"));
		HashSet<Integer> nodes = new HashSet<Integer>();
		HashMap<Integer, ArrayList<Integer>> sets = new HashMap<Integer, ArrayList<Integer>>();
		int n = sc.nextInt();
		int m = sc.nextInt();
		PriorityQueue pq = new PriorityQueue<point>();
		for(int i = 0; i < m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			nodes.add(a);
			nodes.add(b);
			point d = new point(a,b,c);
			pq.add(d);
		}
		point d = (point) pq.poll();
		int a = d.a;
		int b = d.b;
		int ans = d.weight;
		sets.put(a, null);
		sets.put(b, null);
		while(!pq.isEmpty()){
			point s = (point)pq.poll();
			if(s.a == a){
				
			}
			if(s.b == a){
				
			}
			if(s.a == b){
				
			}
			if(s.b == b){
				
			}
		}
		sc.close();
	}
	public static class point implements Comparable{
		int a;
		int b;
		int weight;
		public point(int x, int y, int z){
			a = x;
			b = y;
			weight = z;
		}
		@Override
		public int compareTo(Object a) {
			point b = (point) a;
			return b.weight - this.weight;
		}
	}
}
