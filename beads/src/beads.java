/*
ID: amanj121
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;

public class beads {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		int ans = 0;
		int length = sc.nextInt();
		String beads = sc.next();
		String temp = "";
		temp = beads;
		for(int i = 0; i < beads.length(); i++){
			temp = beads.substring(i) + beads.substring(0, i) + beads.substring(i) + beads.substring(0, i);
			if(temp.charAt(length - 1) != temp.charAt(length)){
				ans = Math.max(longestleft(temp.substring(0, length )) + longestright(temp.substring(length)), ans);
			}
		}
		System.out.println(ans);
		sc.close();
		out.close();
	}
	public static int longestleft(String a){
		if(a.length() < 2){
			if(a.charAt(0) == a.charAt(1)){
				return 2;
			}
			if(a.charAt(0) != a.charAt(1)){
				return 1;
			}
		}
		char l = a.charAt(a.length() - 1);
		if(l == a.charAt(a.length() - 2)){
			a = a.substring(0, a.length() - 1);
			return 1 + longestleft(a);
		}
		if(l != a.charAt(a.length() - 2)){
			return 1;
		}
		return 0;
	}
	public static int longestright(String a){
		if(a.length() < 2){
			if(a.charAt(0) == a.charAt(1)){
				return 2;
			}
			if(a.charAt(0) != a.charAt(1)){
				return 1;
			}
		}
		char l = a.charAt(0);
		if(l == a.charAt(1)){
			a = a.substring(1);
			return 1 + longestright(a);
		}
		if(l != a.charAt(1)){
			return 1;
		}
		return 0;
	}
}