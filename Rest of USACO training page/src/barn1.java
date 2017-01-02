/*
ID: amanj121
LANG: JAVA
TASK: barn1
 */
import java.io.*;
import java.util.*;



public class barn1 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		
		int numBoards = sc.nextInt();
		int cows = sc.nextInt();
		cows = sc.nextInt();
		int[] cowPos = new int[cows];
		for(int i = 0; i < cows; i++){
			cowPos[i] = sc.nextInt();
		}
		Arrays.sort(cowPos);
		int[] difs = new int[cows -1];
		for(int i = 0; i < cows - 1; i++){
			difs[i] = Math.abs(cowPos[i] - cowPos[i+1]);
		}
		Arrays.sort(difs);
		int sum = numBoards;
		for(int i = 0; i < cows - numBoards; i++){
			sum += difs[i];
		}
		
		if(numBoards >= cows){
			sum = cows;
		}
		out.println(sum);
		
		sc.close();
		out.close();
		System.exit(0);
	}
}
