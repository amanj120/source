package irrigation;

import java.io.*;
import java.util.*;
public class irrigation {
	static class point implements Comparable<Object>{
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
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(new FileReader("a.input"));
		PriorityQueue<point> pq = new PriorityQueue<point>();
		int N = sc.nextInt();
		int m = sc.nextInt();
		int[][] p = new int[N][2];
		int[][] a = new int[N][N];
		int[] key = new int[N];
		for(int i = 0; i < N; i++){
			p[i][0] = sc.nextInt();
			p[i][1] = sc.nextInt();
		}
		for(int i = 0; i< N; i++){
			for(int j = i+1; j < N; j++){
				a[i][j]=a[j][i]=(int)(Math.pow((p[i][0]-p[j][0]),2)+Math.pow((p[i][1]-p[j][1]),2));
			}
			key[i] = Integer.MAX_VALUE;
		}
		boolean[]visited = new boolean[N];
		key[0] = 0;
		pq.add(new point(0,0));
		while(!pq.isEmpty()){
			int n = pq.poll().end;
			if(visited[n])continue;
			visited[n] = true;
			for(int i = 0; i < N; i++){
				int w = a[n][i];
				if(!visited[i] && w>=m && w < key[i]){
					key[i] = w;
					pq.add(new point(key[i], i));
				}		
			}
		}
		long ans = 0;
		for(int i = 0; i < visited.length; i++){
			if(visited[i] == false){
				System.out.println(-1);
				return;
			}
			ans += key[i];
		}
		System.out.println(ans);
	}
}