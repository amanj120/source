/*
ID: amanj121
LANG: JAVA
TASK: hamming
*/
import java.io.*;
import java.util.*;

public class hamming {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("hamming.in"));
		int n = sc.nextInt();
		int b = sc.nextInt();
		int d = sc.nextInt();
		sc.close();
		ArrayList<Integer>ans = new ArrayList<Integer>();
		//
		
		for(int i = 0; i < Math.pow(2, b); i++){
			ans.add(i);
			int curIdx = 1;
			for(int j = i; j < Math.pow(2, b); j++){
				boolean toAdd = true;
				for(int k = 0; k < ans.size(); k++){
					if(!hammed(j, ans.get(k), d)){
						toAdd = false;
						break;
					}
				}
				if(toAdd){
					ans.add(j);
					//System.out.println(j);
				}
			}
			if(ans.size() >= n){
				break;
			}
			else{
				ans.clear();
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
		for(int i = 0; i <= n/10; i++){
			String k = "";
			for(int j = 0; j < Math.min(10, n - i*10); j++){
				k += (ans.get(i*10 + j) + " ");
			}
			k = k.substring(0,Math.max(0,k.length() - 1));
			if(k.length() == 0){
				break;
			}
			out.println(k);
		}
			
		out.close();
		System.exit(0);
	}
	public static boolean hammed(int a, int b, int h){
		String sa= toBinary(a);
		String sb= toBinary(b);
		int numDif = 0;
		for(int i = 0; i < 11; i++){
			if(sa.charAt(i) != sb.charAt(i))numDif++;
		}
		if(numDif < h){
			return false;
		}
		return true;
	}
	public static String toBinary(int a){
		String ret = "";
		for(int i = 10; i >= 0; i--){
			int l = (int) (a/(Math.pow(2, i)));
			if(l == 1){
				ret += "1";
				a -= Math.pow(2, i);
			}
			else{
				ret += "0";
			}
		}
		return ret;
	}
}

