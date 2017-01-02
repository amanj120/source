/*
ID: amanj121
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;

public class combo {
	public static ArrayList<String> possibleVals = new ArrayList<String>();
	public static int[] firstLock = new int[3];
	public static int[] secLock = new int[3];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		int n = sc.nextInt();
		
		for(int i = 0; i < 3; i++){
			firstLock[i] = sc.nextInt();
		}
		for(int i = 0; i < 3; i++){
			secLock[i] = sc.nextInt();
		}
		int[] comb = new int[3];
		findCombo(0,n, comb);
		int ans = 0;
		for(int i = 0; i < possibleVals.size(); i++){
			StringTokenizer st = new StringTokenizer(possibleVals.get(i));
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(((Math.abs(firstLock[0] - a) <= 2||Math.abs(firstLock[0] - a)>= (n-2))&&
					(Math.abs(firstLock[1] - b) <= 2||Math.abs(firstLock[1] - b)>= (n-2))&&
					(Math.abs(firstLock[2] - c) <= 2||Math.abs(firstLock[2] - c)>= (n-2)))|| 
				((Math.abs(secLock[0] - a) <= 2||Math.abs(secLock[0] - a)>= (n-2))&&
					(Math.abs(secLock[1] - b) <= 2||Math.abs(secLock[1] - b)>= (n-2))&&
					(Math.abs(secLock[2] - c) <= 2||Math.abs(secLock[2] - c)>= (n-2)))){
				ans++;
			}
			if(ans == 250){
				break;
			}
		}
		out.println(ans);
		sc.close();
		out.close();
		System.exit(0);
	}
	public static void findCombo(int curPos, int n, int[] ret){
		if(curPos == 3){
			possibleVals.add(ret[0] + " " + ret[1] + " " + ret[2]);
			return;
		}
		for(int i = 1; i <= n; i++){
			ret[curPos] = i;
			if((Math.abs(firstLock[curPos] - i) <= 2|| (Math.abs(firstLock[curPos] - i)>= (n-2))) || (Math.abs(secLock[curPos] - i) <= 2|| (Math.abs(secLock[curPos] - i)>= (n-2)))){
				findCombo(curPos + 1, n, ret);
			}
			ret[curPos] = -1;
		}
	}
}
