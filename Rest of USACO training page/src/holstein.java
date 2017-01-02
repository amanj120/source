/*
ID: amanj121
LANG: JAVA
TASK: holstein
*/
import java.io.*;
import java.util.*;

public class holstein {
	public static int V;
	public static int[]vRequired;
	public static int g;
	public static int[][]vPerG;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("holstein.in"));
		V = sc.nextInt();
		vRequired = new int[V];
		for(int i = 0; i < V; i++)
			vRequired[i] = sc.nextInt();
		g = sc.nextInt();
		vPerG = new int[g][V];
		for(int i = 0; i < g; i++)
			for(int j = 0; j < V; j++)
				vPerG[i][j] = sc.nextInt();
		sc.close();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = 0; i < Math.pow(2, g); i++){
			int[] pass = new int[g];
			Integer curSeq = i;
			for(int j = 0; j < g; j++){
				pass[j] = ((((curSeq & (1<<j)) != 0) ? 1:0));
			}
			int[] thisCombo = new int[V];
			for(int s = 0; s < g; s++){
				if(pass[s] == 1){
					for(int j = 0; j < V; j++){
						thisCombo[j] += vPerG[s][j];
					}
				}
			}
			boolean good = true;
			for(int j = 0; j < V; j++){
				if(thisCombo[j] < vRequired[j]){
					good = false;
					break;
				}
			}
			if(good){
				//System.out.println(pass[0]+""+pass[1]+""+pass[2]);
				ans.add(curSeq);
			}
		}
		int minBitCount = g;
		for(Integer i : ans){
			minBitCount = Math.min(minBitCount, Integer.bitCount(i));
		}
		int min = Integer.MAX_VALUE;
		for(Integer i : ans){
			if(Integer.bitCount(i) == minBitCount){
				min = Math.min(min, i);
			}
		}
		String ansa = "";
		ansa += minBitCount + " ";
		for(int j = 0; j < g; j++){
			if((min & (1<<j)) != 0) ansa+=(j+1 + " ");
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
		out.println(ansa.trim());
		out.close();
		System.exit(0);
	}
}