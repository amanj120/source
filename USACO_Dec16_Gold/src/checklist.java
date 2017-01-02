/*
ID: amanj121
LANG: JAVA
TASK:checklist
*/
import java.io.*;
import java.util.*;

public class checklist {
	public static int h;
	public static int g;
	public static int[][] hpos;
	public static int[][] gpos;
	public static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("checklist.in"));
		h = sc.nextInt();
		g = sc.nextInt();
		hpos = new int[h][2];
		gpos = new int[g][2];
		for(int i = 0; i < h; i++){
			hpos[i][0] = sc.nextInt();
			hpos[i][1] = sc.nextInt();
		}
		for(int i = 0; i < g; i++){
			gpos[i][0] = sc.nextInt();
			gpos[i][1] = sc.nextInt();
		}
		sc.close();
		int[] path = new int[h+g];
		path[0] = 1;
		move(1,0,path);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("checklist.out")));
		out.println(ans);
		out.close();
		System.exit(0);
	}
	public static void move(int hpointer, int gpointer, int[]path){//0 = h, 1 = g
		if(hpointer == h){
			ans = Math.min(ans, calculateDist(path));
		}
		if(gpointer < g){//if can move to next g
			path[hpointer+gpointer] = -(gpointer+1);
			move(hpointer, gpointer+1,path);
			path[hpointer+gpointer] = 0;
		}
		if(hpointer < h && (hpointer != h-1 || gpointer == g)){//if can move to next h
			path[hpointer+gpointer] = (hpointer+1);
			move(hpointer+1, gpointer,path);
			path[hpointer+gpointer] = 0;
		}
		return;
	}
	public static int calculateDist(int[]p){
		int ret = 0;
		for(int i = 1; i < g+h; i++){
			int px,py,cx,cy;
			int prev = p[i-1];
			int cur = p[i];
			if(prev < 0){
				px = gpos[-prev-1][0];
				py = gpos[-prev-1][1];
			}
			else{
				px = hpos[prev-1][0];
				py = hpos[prev-1][1];
			}
			if(cur < 0){
				cx = gpos[-cur-1][0];
				cy = gpos[-cur-1][1];
			}
			else{
				cx = hpos[cur-1][0];
				cy = hpos[cur-1][1];
			}
			ret+= (cx-px)*(cx-px)+(cy-py)*(cy-py);
		}
		return ret;
	}
}
