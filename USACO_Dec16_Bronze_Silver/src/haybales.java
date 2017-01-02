/*
ID: amanj120
LANG: JAVA
TASK: 
*/
import java.util.*;
import java.io.*;
public class haybales {
	public static int[]bales;
	public static void main(String[] args) throws IOException {
		TreeSet<Integer> closest = new TreeSet<Integer>();
		Scanner sc = new Scanner(new FileReader("haybales.in"));
		int n = sc.nextInt();
		int q = sc.nextInt();
		bales = new int[n];
		for(int i = 0; i < n; i++){
			bales[i] = sc.nextInt();
			closest.add(bales[i]);
		}
		Arrays.sort(bales);
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		for(int i = 0; i < q; i++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			if(end < bales[0] || start > bales[n-1])
				out.println(0);
			else if(end == bales[0] || start == bales[n-1])
				out.println(1);
			else{
				int locEnd = findEnd(closest.floor(end));
				int locStart = findStart(closest.ceiling(start));
				int numBales = locEnd-locStart;
				out.println(numBales);
			}
		}
		sc.close();
		out.close();
		System.exit(0);
	}
	public static int findStart(int x){
		int min = 0;
		int max = bales.length;
		int cur = (max+min)/2;
		while(true){
			if(bales[cur] == x){
				return cur - 1;
			}
			else{
				if(bales[cur] > x){
					max = cur;
					cur = (max + min)/2;
				}
				else if(bales[cur] < x){
					min = cur;
					cur = (max + min)/2;
				}
			}
		}
	}
	public static int findEnd(int x){
		int min = 0;
		int max = bales.length;
		int cur = (max+min)/2;
		while(true){
			if(bales[cur] == x){
				return cur;
			}
			else{
				if(bales[cur] > x){
					max = cur;
					cur = (max + min)/2;
				}
				else if(bales[cur] < x){
					min = cur;
					cur = (max + min)/2;
				}
			}
		}
	}
	
}
