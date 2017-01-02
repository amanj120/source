package subset;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class subset {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("subset.in"));
		int[][]d;
		int n = sc.nextInt();
		int sum = (n*(n+1));
		if(sum%4 !=0)System.out.println(0);
		else{
			sum = sum/4;
			d = new int[n+1][sum+1];
			d[0][0] = 1;
			for(int i = 1; i <= n ; i++){
				for(int j = 1; j <= sum ; j++){
					if(j - i >= 0){
						d[i][j] = d[i-1][j] + d[i-1][j-i];
					}
					else{
						d[i][j] = d[i-1][j];
					}
				}
			}
			System.out.println(d[n][sum]);
		}
		sc.close();
	}
}