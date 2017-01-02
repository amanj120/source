package allow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class allow {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("allow.input"));
		int n = sc.nextInt();
		int a = sc.nextInt();
		int ans = 0;
		int[][] coins = new int[n][2];
		for(int i = 0; i < n; i++){
			coins[i][1] = sc.nextInt();
			coins[i][0] = sc.nextInt();
		}
		java.util.Arrays.sort(coins, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(b[1], a[1]);
		    }
		});
		for(int i = 0; i < n; i++){
			if(coins[i][1] >= a){
				ans += coins[i][0];
			}
			else{
				break;
			}
		}
		double num1 = 0;
		double num2 = 0;
		for(int i = 0; i < n; i++){
			if(coins[i][1] >= a){
				continue;
			}
			num1 += coins[i][0];
			num2 += coins[i][0] * coins[i][1];
		}
		double num3 = num2/num1;
		double num4 = a/num3;
		double num5 = Math.floor(num1/num4);
		System.out.println((int)num5 + ans);
		sc.close();
	}
}
