/*
ID: amanj121
LANG: JAVA
TASK: crypt1
 */
import java.io.*;
import java.util.*;

public class crypt1 {
	public static ArrayList<Integer> possibleVals = new ArrayList<Integer>(); 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		int n = sc.nextInt();
		int[] nums = new int[n];
		HashSet<Integer> containsNums = new HashSet<Integer>();
		for(int i = 0; i < n; i++){
			nums[i] = sc.nextInt();
			containsNums.add(nums[i]);
		}
		retTrial(nums, 0, "");
		
		int ans = 0;
		for(int i = 0; i < possibleVals.size(); i++){
			int curTry = possibleVals.get(i);
			int first = curTry/100;
			int sec = curTry%100;
			int product = first * sec;
			int lineA = first * (sec%10);
			int lineB = first * (sec/10);
			if(product < 10000 && lineA < 1000 && lineB < 1000){
				String sProd = "" + product + "" + lineA + ""  + lineB;
				boolean ansAdd = true;
				for(int j = 0; j < 10; j++){
					if(!(containsNums.contains(Integer.parseInt("" + sProd.charAt(j))))){
						ansAdd = false;
						break;
					}
				}
				if(ansAdd){
					System.out.println(first + "*" + sec + "=" + lineA + " " + lineB + " " + product );
					ans++;
				}
			}
		}
		out.println(ans);
		sc.close();
		out.close();
		System.exit(0);
	}
	
	public static void retTrial(int[]nums, int curPos, String ret){
		if(curPos == 5){
			possibleVals.add(Integer.parseInt(ret));
		}
		else{
			for(int i = 0; i < nums.length; i++){
				ret += "" + nums[i];
				retTrial(nums, curPos + 1, ret);
				ret = ret.substring(0,ret.length() - 1);
			}
		}
	}
}
