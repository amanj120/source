/*
ID: amanj121
LANG: JAVA
TASK: milk3
*/

/*
 java.util.Arrays.sort(array, new java.util.Comparator<double[]>() {
    public int compare(double[] a, double[] b) {
        return Double.compare(a[0], b[0]);
    }
});

 */
import java.io.*;
import java.util.*;

public class milk3 {
	public static int A,B,C;
	public static HashSet<String> dups = new HashSet<String>();
	public static boolean[] ans;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("milk3.in"));
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		sc.close();
		ans = new boolean[C + 1];
		solve(0,0,C);
		
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
		int end = -1;
		for(int i = C; i >= 0;){
			if(ans[i]) end = i;
			break;
		}
		for(int i = 0; i <=C; i++){
			if(ans[i] && i != end)out.print(i + " ");
			else if(ans[i] && i == end)out.print(i + "\n");
		}
		out.close();                                  
		System.exit(0);
	}
	
	public static void solve(int a, int b, int c){
		String seentest = a + " " + b + " " + c;
		if(!dups.add(seentest))
			return;
		if(a == 0)
			ans[c] = true;
		//c to a        min of whats left in c and whats left to fill a
		solve(a + (Math.min(c,A-a)),b,c - (Math.min(c,A-a)));
		//a to c
		solve(a - (Math.min(a,C-c)),b,c + (Math.min(a,C-c)));
		//c to b
		solve(a,b + (Math.min(c,B-b)),c - (Math.min(c,B-b)));
		//b to c
		solve(a, b - (Math.min(b,C-c)),c + (Math.min(b,C-c)));
		//a to b
		solve(a - (Math.min(a,B-b)),b + (Math.min(a,B-b)), c);
		//b to a
		solve(a + (Math.min(b,A-a)),b - (Math.min(b,A-a)), c);
	}
}
