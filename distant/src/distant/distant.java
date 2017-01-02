package distant;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class distant {
	static class point implements Comparable{
		int end;
		int weight;
		public point(int e, int w){
			end = e;
			weight = w;
		}
		@Override
		public int compareTo(Object a) {
			point b = (point) a;
			return this.weight - b.weight;
		}	
	}
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileReader("b.inp"));
		PriorityQueue<point> pq = new PriorityQueue<point>();
		int N = sc.nextInt();
		char[] g = new char[N*N];
		int same = sc.nextInt();
		int dif = sc.nextInt();
		int[] key = new int[N*N];
		ArrayList[] paths = new ArrayList[N*N];
		for(int i = 0; i < paths.length; i++){
			paths[i] = new ArrayList<point>();
		}
		for(int i = 0; i < N; i++){
			String k = sc.next();
			for(int j = 0; j < N; j++){
				g[(i*N)+j] = k.charAt(j);
			}
		}
		for(int i = 0; i < N*N; i++){
			if(i%N > 0){
				if(g[i] == g[i-1]){paths[i].add(new point(i-1, same));paths[i-1].add(new point(i, same));}
				else{paths[i].add(new point(i-1, dif));paths[i-1].add(new point(i, dif));}
			}
			if(i%N < N-1){
				if(g[i] == g[i+1]){paths[i].add(new point(i+1, same));paths[i+1].add(new point(i, same));}
				else{paths[i].add(new point(i+1, dif));paths[i+1].add(new point(i, dif));}
			}
			if(i< N*(N - 1)){
				if(g[i] == g[i+N]){paths[i].add(new point(i+N, same));paths[i+N].add(new point(i, same));}
				else{paths[i].add(new point(i+N, dif));paths[i+N].add(new point(i, dif));}
			}
			if(i> (N - 1)){
				if(g[i] == g[i-N]){paths[i].add(new point(i-N, same));paths[i-N].add(new point(i, same));}
				else{paths[i].add(new point(i-N, dif));paths[i-N].add(new point(i, dif));}
			}
		}
		int qns = 0;
		for(int S = 0; S < N*N; S++){
			boolean[] visited = new boolean[N*N];
			pq.add(new point(S,0));
			for (int i = 0; i <N*N; i++) {
		        key[i] = Integer.MAX_VALUE/2;
			}
			key[S] = 0;
			while(!pq.isEmpty()){
				int n = pq.poll().end;
				if(visited[n])continue;
				visited[n] = true;
				for(int i = 0; i < paths[n].size(); i++){
					int r = ((point)paths[n].get(i)).end;
					int w = ((point)paths[n].get(i)).weight;
					if(!visited[r] && w + key[n] < key[r]){
						key[r] = w + key[n];
						pq.add(new point(r, w + key[n] ));
					}		
				}
			}
			for(int i = 0; i < key.length; i++)qns = Math.max(qns, key[i]);
		}
		System.out.println(qns);
	}
}