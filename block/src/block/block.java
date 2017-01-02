package block;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class block {
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
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("block.input"));
		PriorityQueue<point> pq = new PriorityQueue<point>();
		int V = sc.nextInt();
		int E = sc.nextInt();
		ArrayList[] paths = new ArrayList[V+1];
		for(int i = 0; i < paths.length; i++){
			paths[i] = new ArrayList<point>();
		}
		for(int i = 0; i < E; i++){
			int start = sc.nextInt();
			int fin = sc.nextInt();
			int weight = sc.nextInt();
			if(fin != V){
				paths[start].add(new point(weight, fin));
				paths[start].add(new point(3*weight, fin));
				paths[fin].add(new point(weight, start));
				paths[fin].add(new point(3*weight, start));
			}
			else{
				paths[start].add(new point(weight, fin));
				paths[fin].add(new point(weight, start));
			}
		}
		boolean[] visited = new boolean[V];
		pq.add(new point(0,1));
		int[] key = new int[V];
		for (int i = 0; i <V; i++) {
            key[i] = 10000;
		}
		key[0]= 0;
		while(!pq.isEmpty()){
			int n = pq.poll().end - 1;
			if(visited[n])continue;
			visited[n] = true;
			for(int i = 0; i < paths[n + 1].size(); i++){
				int r = ((point)paths[n + 1].get(i)).end;
				int w = ((point)paths[n + 1].get(i)).weight;
				if(!visited[r - 1] && w + key[n] < key[r - 1]){
					key[r - 1] = w + key[n];
					pq.add(new point(w + key[n], r));
				}
						
			}
		}
		int ans = Integer.MAX_VALUE;
		int shortestPath = key[key.length - 1];
		for(int q = 1; q < V; q++){
			Collections.sort(paths[q]);
			int end = -1;
			point removed = new point(-1,-1);
			for(int i = 0; i < paths[q].size(); i++){
			removed = (point) paths[q].get(i);
			end = removed.end;
			if(end > q){
				paths[q].remove(0);
			}
			}
			boolean[] vis = new boolean[V];
			pq.add(new point(0,1));
			int[] keye = new int[V];
			for (int i = 0; i <V; i++) {
	            keye[i] = Integer.MAX_VALUE;
			}
			keye[0]= 0;
			while(!pq.isEmpty()){
				int n = pq.poll().end - 1;
				if(vis[n])continue;
				vis[n] = true;
				for(int i = 0; i < paths[n + 1].size(); i++){
					int r = ((point)paths[n + 1].get(i)).end;
					int w = ((point)paths[n + 1].get(i)).weight;
					if(!(n+1 == end && q == r)){
						if(!vis[r - 1] && w + keye[n] < keye[r - 1]){
							keye[r - 1] = w + keye[n];
							pq.add(new point(w + keye[n], r));
						}	
					}
				}
			}
			paths[q].add(removed);
			ans = Math.min(ans, keye[keye.length - 1]);
		}
		System.out.println(ans);
		sc.close();
	}
}