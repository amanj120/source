/*
ID: amanj121
LANG: JAVA
TASK: wormhole
*/
import java.io.*;
import java.util.*;

public class wormhole {
	public static int n;
	public static int[]links;
	public static HashSet<int[]> dups = new HashSet<int[]>();
	public static ArrayList<int[]> tests = new ArrayList<int []>();
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("wormhole.in"));
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		n = sc.nextInt();
		int[]xvals = new int[n];
		int[]yvals = new int[n];
		int[]pairs = new int[n];
		links = new int[n];
		for(int i = 0; i < n; i++){
			xvals[i] = sc.nextInt();
			yvals[i] = sc.nextInt();
			links[i] = -1;
			pairs[i] = -1;
		}
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(i != j)
					if(yvals[i] == yvals[j])
						if(xvals[i] < xvals[j])
							links[i] = j;
		for(int i = 0; i < n; i++){
			int y = yvals[i];
			int x = xvals[i];
			int closestx = links[i];
			if(closestx == -1){
				continue;
			}
			else{
				closestx = Integer.MAX_VALUE; 
			}
			for(int j = 0; j < n; j++){
				if(y == yvals[j])
					if(xvals[j] < closestx && xvals[j] > x){
						links[i] = j;
						closestx = xvals[links[i]];
					}
			}
		}
		int ret = 0;
		makePairs(pairs);
		for(int i = 0; i < tests.size(); i++){
			if(cyclic(tests.get(i))) ret++;
		}
		out.println(ret);
		out.close();                                  // close the output file
		sc.close();
		System.exit(0);
	}
	public static void makePairs(int[]wormholes){
		int i = 0;
		for(i = 0; i < n; i++)
			if(wormholes[i] == -1)
				break;
		if(i == n){
			int[] enter = new int[n];
			int x = dups.size();
			for(int j = 0; j < n; j++){
				enter[j] = wormholes[j];
			}
			dups.add(enter);
			if(x < dups.size()){
				tests.add(enter);
			}
		}
		for(int j = i+1; j < n; j++){
			if(wormholes[j] == -1){
				wormholes[i] = j;
				wormholes[j] = i;
				makePairs(wormholes);
				wormholes[i] = wormholes[j] = -1;
			}
		}
	}
	public static boolean cyclic(int[] w){
		for(int i = 0; i < n; i++){
			int cur = i;
			int next = w[i];
			for(int j = 0; j < n+3; j++){
				cur = next;
				next = links[next];
				if(next == -1)break;
				cur = next;
				next = w[cur];
				if(j > n+1)
					return true;
			}
		}
		return false;
	}
}