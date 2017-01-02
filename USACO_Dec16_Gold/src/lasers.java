/*
ID: amanj121
LANG: JAVA
TASK: lasers
*/
import java.io.*;
import java.util.*;




public class lasers {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("lasers.in"));
		int n = sc.nextInt() + 2;
		int max = 100000;
		int[][] adj = new int[n][n];
		int[][] points = new int[n][2];
		int[]key = new int[n];
		//HashSet[] adj = new HashSet[n];
		points[0][0]= sc.nextInt();points[0][1] = sc.nextInt();points[n-1][0] = sc.nextInt();points[n-1][1] = sc.nextInt();Arrays.fill(adj[0], max);Arrays.fill(adj[n-1], max);
		//for(int i = 0; i < n; i++)adj[i] = new HashSet<Integer>();
		for(int i = 1; i < n-1; i++){
			points[i][0] = sc.nextInt();
			points[i][1] = sc.nextInt();
			Arrays.fill(adj[i], max);
		}
		sc.close();
		for(int i = 0; i < n; i++){
			key[i] = max+1;
			for(int j = i+1; j < n; j++)
				if(points[i][0] == points[j][0] || points[i][1] == points[j][1]){
					adj[i][j] = adj[j][i] = 1;
				}
		}
		
		/*int ans = 0;	
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[]visited = new boolean[n];
		visited[0] = true;
		q.add(0);
		while(!q.isEmpty()){
			int s1 = q.size();
			ans++;
			for(int j = 0; j < s1; j++){
				int curNode = q.poll();
				if(curNode == n-1) break;
				for(int i = 0; i < n; i++){
					if(!visited[i] && adj[curNode].contains(i)){
						q.add(i);
						visited[i] = true;
					}
				}
			}
		}*/
		boolean[] visited = new boolean[n];
		int currentNode = 0;
		key[0] = 0;
		visited[0] = true;
		
		for(int reps = 0; reps < n; reps++){
			int min = max+1;
			int minIndex = 0;
			for(int i=0; i< n; i++){
				if(!visited[i]){
					if(adj[currentNode][i] +  key[currentNode]   < key[i]){
						key[i] = 1 + key[currentNode];
					}
					if(key[i] < min){
						min = key[i];
						minIndex = i;
					}
				}
			}
			currentNode = minIndex;
			visited[currentNode] = true;
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lasers.out")));
		out.println(key[n-1]);
		//out.println(ans - 2);
		out.close();
		System.exit(0);
	}
}