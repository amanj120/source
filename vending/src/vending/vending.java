package vending;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class vending {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("vending.in"));
		int n = sc.nextInt();
		int[][] vend = new int[n+1][4];
		for(int i = 1; i <= n; i++){
			vend[i][0] = sc.nextInt();
			vend[i][1] = sc.nextInt();
			vend[i][2] = sc.nextInt();
			vend[i][3] = sc.nextInt();
		}
		int ans = 0;
		for(int i = 1; i <= n; i++){
			int send = vend[i][0];
			int pay = vend[i][1];
			int sell = vend[send][2];
			int quantity = vend[send][3];
			if(sell - pay >= 0){
				ans+= (sell - pay)*(quantity);
			}
		}
		System.out.println(ans);
		sc.close();
		
	}

}
