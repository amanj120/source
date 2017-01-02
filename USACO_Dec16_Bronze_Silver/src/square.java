/*
ID: amanj120
LANG: JAVA
TASK: square
*/
import java.util.*;
import java.io.*;
public class square {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("square.in"));
		int[] vals = new int[8];
		for(int i = 0; i < 8; i++)
			vals[i] = sc.nextInt();
		sc.close();
		int maxx = -1;
		int maxy = -1;
		int minx = Integer.MAX_VALUE;
		int miny = Integer.MAX_VALUE;
		for(int i = 0; i < 8; i+= 2){
			maxx = Math.max(maxx, vals[i]);
			minx = Math.min(minx, vals[i]);
			maxy = Math.max(maxy, vals[i+1]);
			miny = Math.min(miny, vals[i+1]);
		}
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
		out.println(Math.max((maxy-miny), (maxx - minx))*Math.max((maxy-miny), (maxx - minx)));
		out.close();
		System.exit(0);
	}
}