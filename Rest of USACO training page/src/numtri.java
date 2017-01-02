/*
ID: amanj121
LANG: JAVA
TASK: numtri
*/
import java.util.*;
import java.io.*;
public class numtri {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("numtri.in"));
		int n = sc.nextInt();
		int[][] nums = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j <=i; j++){
				nums[i][j] = sc.nextInt();
			}
		}
		sc.close();
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		if(n == 0)
			out.println(0);
		else if(n == 1)
			out.println(nums[0][0]);
		else if(n == 2)
			out.println(nums[0][0] + Math.max(nums[1][0],nums[1][1]));
		else{
			for(int i = n - 2; i >= 0; i--){
				for(int j = 0; j <=i; j++){
					nums[i][j] += Math.max(nums[i+1][j], nums[i+1][j+1]);
				}
			}
			out.println(nums[0][0]);
		}
		
		
		
		//children of nums[row][col] = nums[row + 1][col] and nums[row + 1][col+1];
		
		
		out.close();                                  
		System.exit(0);
	}

}
