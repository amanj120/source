
package dijkstra2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
public class dijkstra2 {
	static class point implements Comparable{
		int weight;
		int end;
		public point(int w, int e){
			weight = w;
			end = e;
		}
		@Override
		public int compareTo(Object a) {
			point b = (point) a;
			return this.weight - b.weight;
		}	
	}
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileReader("a.input"));
		PriorityQueue<point> pq = new PriorityQueue<point>();
		int V = sc.nextInt();
		int E = sc.nextInt();
		int S = sc.nextInt();
		ArrayList[] paths = new ArrayList[V];
		for(int i = 0; i < paths.length; i++){
			paths[i] = new ArrayList<point>();
		}
		for(int i = 0; i < E; i++){
			int A = sc.nextInt();
			int B = sc.nextInt(); 
			int C = sc.nextInt();
			paths[A-1].add(new point(C, B));
			paths[B-1].add(new point(C, A));
		}
		boolean[] visited = new boolean[V];
		pq.add(new point(0,S));
		int[][] key = new int[V][2];
		for (int i = 0; i <V; i++) {
            key[i][0] = Integer.MAX_VALUE;
		}
		key[S-1][0] = 0;
		while(!pq.isEmpty()){
			int n = pq.poll().end - 1;
			if(visited[n])continue;
			visited[n] = true;
			for(int i = 0; i < paths[n].size(); i++){
				int r = ((point)paths[n].get(i)).end - 1;
				int w = ((point)paths[n].get(i)).weight;
				if(!visited[r] && w + key[n][0] < key[r][0]){
					key[r][0] = w + key[n][0];
					key[r][1] = n; 
					pq.add(new point(w + key[n][0], r+1));
				}	
			}
		}
		for(int i = 0; i < key.length; i++){
			System.out.println(key[i][0]);
		}
		sc.close();
	}
}