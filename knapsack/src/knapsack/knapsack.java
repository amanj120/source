package knapsack;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class knapsack {
	public static int money;
	public static int[][] d;
	public static int q;
	public static int[][]items;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("knapsack.in"));
		q = sc.nextInt();
		money = sc.nextInt();
		items = new int[q + 1][2];
		items[0][0] = 0;
		items[0][1] = 0;
		d = new int[money + 1][items.length + 1];
		for(int i = 1; i < items.length; i++){
			items[i][0] = sc.nextInt();
			items[i][1] = sc.nextInt();
		}
		for(int i = 0; i < money + 1; i++){
			for(int j = 1; j <= q ; j++){
				if(i - items[j][0] < 0){
					continue;
				}
				d[i][j] = Math.max(d[i - items[j][0]][j-1] + items[j][1], d[i][j-1]);
			}
		}
		int ans = 0;
		for(int i = 0; i < d.length; i++){
			for(int j = 0; j < d[0].length; j++){
				ans = Math.max(ans, d[i][j]);
			}
		}
		System.out.println(ans);
		sc.close();
	}
}