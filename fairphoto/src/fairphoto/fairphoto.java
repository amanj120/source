package fairphoto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class fairphoto {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("fairphoto.in"));
		int[][] cows;
		int n= sc.nextInt();
		cows = new int[n][2];
		for(int i = 0; i < n; i++){
			cows[i][0] = sc.nextInt();
			String b = sc.nextLine();
			if(b.equals(" S")){
				cows[i][1] = -1;
			}
			if(b.equals(" W")){
				cows[i][1] = 1;
			}
		}
		java.util.Arrays.sort(cows, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Double.compare(a[0], b[0]);
		}});
		for(int i = 1; i < cows.length; i++){
			cows[i][1] += cows[i-1][1];
		}
		int ans1 = 0;
		int ans2 = 0;
		
		for(int i = 0; i < cows.length; i++){
			for(int j = cows.length - 1; j > i; j--){
				if(cows[i][1] >= 0 && cows[j][1] >= 0 && (j-i)%2 == 1){
					ans1 = cows[j][0] - cows[i][0];
					break;
				}
			}
			break;
		}
		for(int j = cows.length - 1; j > 0; j--){
			for(int i = 0; i < j; i++){
				if(cows[j][1] >= 0 && cows[i][1] >= 0 && (j-i)%2 == 1){
					ans2 = cows[j][0] - cows[i][0];
					break;
				}
			}
		}
		System.out.println(Math.max(ans1, ans2));
		sc.close();
	}
}
