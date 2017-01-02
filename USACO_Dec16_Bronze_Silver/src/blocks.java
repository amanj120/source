/*
ID: amanj120
LANG: JAVA
TASK: blocks
*/
import java.util.*;
import java.io.*;
public class blocks {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("blocks.in"));
		int n = sc.nextInt();
		String[][] words = new String[n][2];
		for(int i = 0; i < n; i++){
			words[i][0] = sc.next();
			words[i][1] = sc.next();
		}
		int[] ans = new int[26];
		for(int i = 0; i < n; i++){
			for(int j = 97; j < 123; j++){
				char cur = (char)(j);
				int wordAOccurances = 0;
				int wordBOccurances = 0;
				String wordA = words[i][0];
				String wordB = words[i][1];
				for(int a = 0; a < wordA.length(); a++)
					if(wordA.charAt(a) == cur)
						wordAOccurances++;
				for(int b = 0; b < wordB.length(); b++)
					if(wordB.charAt(b) == cur)
						wordBOccurances++;
				ans[cur-97] += Math.max(wordAOccurances, wordBOccurances);
			}
		}
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
		for(int i = 0; i < 26; i++) out.println(ans[i]);
		out.close();
		sc.close();
		System.exit(0);
	}
}