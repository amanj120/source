/*
ID: amanj120
LANG: JAVA
TASK: cowsignal
*/
import java.util.*;
import java.io.*;
public class cowsignal {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("cowsignal.in"));
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		char[][] in = new char[m][n];
		for(int i = 0; i < m; i++){
			String line = sc.next();
			for(int j = 0; j < n; j++){
				in[i][j] = line.charAt(j);
			}
		}
		sc.close();
		char[][] output = new char[k*m][k*n];
		for(int i = 0; i < k*m; i+=k)
			for(int j = 0; j < k*n; j+=k)
				for(int ik = 0; ik < k; ik++)
					for(int jk = 0; jk < k; jk++)
						output[i+ik][j+jk] = in[i/k][j/k];
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
		for(int i = 0; i < k*m; i++){
			String x = "";
			for(int j = 0; j < k*n; j++)
				x += output[i][j];
			out.println(x);
		}
		out.close();
		System.exit(0);
	}
}
