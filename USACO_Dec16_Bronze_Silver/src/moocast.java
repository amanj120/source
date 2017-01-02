/*
ID: amanj120
LANG: JAVA
TASK: moocast
*/
import java.util.*;
import java.io.*;
public class moocast {
	public static int[][] adj;
	public static int n;
	public static boolean visited[];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("moocast.in"));
		n = sc.nextInt();
		adj = new int[n][n];
		visited = new boolean[n];
		int[][] stats = new int[n][3];
		for(int i = 0; i < n; i++){
			stats[i][0] = sc.nextInt();
			stats[i][1] = sc.nextInt();
			stats[i][2] = sc.nextInt();
		}
		sc.close();
		for(int i = 0; i < n; i++){
			Arrays.fill(adj[i], 100000);
		}
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				int x = Math.abs(stats[i][0] - stats[j][0]);
				int y = Math.abs(stats[i][1] - stats[j][1]);
				double dist = Math.sqrt((double)(x*x+y*y));
				if(dist < (double)stats[i][2] && i!= j){
					adj[i][j] =  1;
				}
			}
		}
		int finalAns = 1;
		for(int start = 0; start < n; start++){
			int ans = 0;	
			Queue<Integer> q = new LinkedList<Integer>();
			boolean[]visited = new boolean[n];
			visited[start] = true;
			q.add(start);
			while(!q.isEmpty()){
				int curNode = q.poll();
				ans++;
				for(int i = 0; i < n; i++){
					if(!visited[i] && adj[curNode][i] == 1){
						q.add(i);
						visited[i] = true;
					}
				}
			}
			finalAns = Math.max(ans, finalAns);
		}
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		out.println(finalAns);
		out.close();
		System.exit(0);
	}
}

