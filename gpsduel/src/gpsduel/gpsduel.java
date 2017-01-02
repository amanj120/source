package gpsduel;

import java.util.*;
import java.io.*;

public class gpsduel {
static class pii implements Comparable{
	int we;
	int end;
	public pii(int w, int e){
		we = w;
		end = e;
	}
	@Override
	public int compareTo(Object a) {
		pii b = (pii) a;
		return this.we - b.we;
	}	
}
public static void main(String[] args) throws FileNotFoundException {
	Scanner sc = new Scanner(new FileReader("gpsduel.input"));
	PriorityQueue<pii> pq = new PriorityQueue<pii>();
	int V = sc.nextInt();
	int E = sc.nextInt();
	ArrayList[] pA = new ArrayList[V];
	ArrayList[] pB = new ArrayList[V];
	ArrayList[] pC = new ArrayList[V];
	int[][] num = new int[E][4];
	boolean[] visited = new boolean[V];
	int[][] key = new int[V][3];
	for(int i = 0; i < V; i++){pA[i] = new ArrayList<pii>();pB[i] = new ArrayList<pii>();pC[i] = new ArrayList<pii>();}
	for(int i = 0; i < E; i++){
		int B = num[i][0] = sc.nextInt();int A = num[i][1] = sc.nextInt();
		int C = num[i][2] = sc.nextInt();int D = num[i][3] = sc.nextInt();
		pA[A-1].add(new pii(C, B));pB[A-1].add(new pii(D, B));
	}
	pq.add(new pii(0,V));
	for (int i = 0; i <V-1; i++)key[i][0] = Integer.MAX_VALUE;
	while(!pq.isEmpty()){
		int n = pq.poll().end - 1;
		if(visited[n])continue;
		visited[n] = true;
		for(int i = 0; i < pB[n].size(); i++){
			if(!visited[((pii)pB[n].get(i)).end - 1] && ((pii)pB[n].get(i)).we + key[n][0] < key[((pii)pB[n].get(i)).end - 1][0]){
				key[((pii)pB[n].get(i)).end - 1][0] = ((pii)pB[n].get(i)).we + key[n][0];
				key[((pii)pB[n].get(i)).end - 1][1] = n; 
				pq.add(new pii(((pii)pB[n].get(i)).we + key[n][0], ((pii)pB[n].get(i)).end));
			}			
		}
	}
	for(int i = 0; i < visited.length; i++){
		visited[i] = false;
		key[i][0] = Integer.MAX_VALUE;
	}
	key[V-1][0] = 0;
	pq.add(new pii(0,V));
	while(!pq.isEmpty()){
		int n = pq.poll().end - 1;
		if(visited[n])continue;
		visited[n] = true;
		for(int i = 0; i < pA[n].size(); i++){
			if(!visited[((pii)pA[n].get(i)).end - 1] && ((pii)pA[n].get(i)).we + key[n][0] < key[((pii)pA[n].get(i)).end - 1][0]){
				key[((pii)pA[n].get(i)).end - 1][0] = ((pii)pA[n].get(i)).we + key[n][0];
				key[((pii)pA[n].get(i)).end - 1][2] = n; 
				pq.add(new pii(((pii)pA[n].get(i)).we + key[n][0], ((pii)pA[n].get(i)).end));
			}			
		}
	}
	for(int i = 0; i < E; i++){
		int A = num[i][0] - 1;
		int B = num[i][1] - 1; 
		if(key[A][1]==B&&key[A][2]!=B||key[A][1]!=B&&key[A][2]==B)pC[A].add(new pii(1,B));
		if(key[A][1]==B&&key[A][2]==B)pC[A].add(new pii(0, B));
		if(key[A][1]!=B&&key[A][2]!=B)pC[A].add(new pii(2, B));
	}
	int[] ansKey = new int[V];
	for(int i = 0; i < visited.length; i++){
		visited[i] = false;
		ansKey[i] = Integer.MAX_VALUE/2;
	}
	pq.add(new pii(0,0));
	ansKey[0]= 0;
	while(!pq.isEmpty()){
		int n = pq.poll().end;
		if(visited[n])continue;
		visited[n] = true;
		for(int i = 0; i < pC[n].size(); i++){
			if(!visited[((pii)pC[n].get(i)).end] && ((pii)pC[n].get(i)).we + ansKey[n] < ansKey[((pii)pC[n].get(i)).end]){
				ansKey[((pii)pC[n].get(i)).end] = ((pii)pC[n].get(i)).we + ansKey[n]; 
				pq.add(new pii( ((pii)pC[n].get(i)).we + ansKey[n], ((pii)pC[n].get(i)).end));
			}			
		}
	}
	System.out.println(ansKey[V-1]);
	}
}