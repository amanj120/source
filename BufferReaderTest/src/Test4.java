import java.util.*;
import java.io.*;

public class Test4 {

	public static void main(String[] args) throws Exception{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine().trim());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < n; i++){
			StringTokenizer tk = new StringTokenizer(sc.readLine());
			//String[] tokens = sc.readLine().Split();
			String s = tk.nextToken();
			int h = Integer.parseInt(tk.nextToken());
			map.put(s,h);
		}
		sc.close();
	}

}
