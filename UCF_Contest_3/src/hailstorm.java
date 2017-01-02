import java.util.Scanner;
public class hailstorm {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = 2 * sc.nextInt();
		int[] players = new int[n];
		int sum = 0;
		for(int i = 0; i < n; i++){
			sum += players[i] = sc.nextInt();
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 1<<n; i++){
			int newSum = 0;
			if(Integer.bitCount(i) == n/2){
				for(int j = 0; j < n; j++){
					if((i & 1<<j) != 0){
						newSum += players[j];
					}
				}
				min = Math.min(min, Math.abs((sum - newSum) - newSum));
			}
		}
		System.out.println(min);
	}

}
