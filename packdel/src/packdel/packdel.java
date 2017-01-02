package packdel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class packdel {
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
		Scanner sc = new Scanner(new FileReader("ab.input"));
		PriorityQueue<point> pq = new PriorityQueue<point>();
		int V = sc.nextInt();
		int E = sc.nextInt();
		int S = 1;
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
		pq.add(new point(0,1));
		int[] key = new int[V];
		for (int i = 0; i <V; i++) {
            key[i] = Integer.MAX_VALUE;
		}
		key[S-1] = 0;
		while(!pq.isEmpty()){
			int n = pq.poll().end - 1;
			if(visited[n])continue;
			visited[n] = true;
			for(int i = 0; i < paths[n].size(); i++){
				int r = ((point)paths[n].get(i)).end - 1;
				int w = ((point)paths[n].get(i)).weight;
				if(!visited[r] && w + key[n] < key[r]){
					key[r] = w + key[n];
					pq.add(new point(w + key[n], r+1));
				}
						
			}
			
		}
		System.out.println(key[V-1]);
		sc.close();
	}
}