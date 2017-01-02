import java.util.*;
import java.io.*;
public class palindrome {
	public static String n;
	public static String ans = "";
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.next();
		int[] longest = new int[26];
		for(int i = 0; i < n.length() - 1; i++){
			int ss = n.charAt(i) - 65;
			longest[ss] = Math.max(longest[ss], findPalin(i,1));
		}
		int max = 0;
		for(int i = 0; i < 26; i++)
			max = Math.max(Integer.highestOneBit(longest[i]), max);
		if(max < 2){
			System.out.println(-1);
			return;
		}
		for(int i = 0; i < 26; i++){
			if(Integer.highestOneBit(longest[i]) == max){
				int f = Integer.highestOneBit(max);
				String res = "";
				for(int j = 0; j < f; j++){
					res += (char)(65 + i);
				}
				System.out.println(res);
				break;
			}
		}
		sc.close();
	}
	public static int findPalin(int index, int ans){
		if(index + 1 >= n.length()) return ans;
		if(n.charAt(index+1) != n.charAt(index)) return ans;
		if(n.charAt(index + 1) == n.charAt(index)) return findPalin(index + 1, ans+1);
		return 0;
	}
}
