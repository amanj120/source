import java.util.*;
public class change {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] bills = {500, 100, 50, 20, 10, 5, 1};
		ArrayList<Integer> vals = new ArrayList<Integer>();
		int[][] people = new int[2][7];
		for(int i = 0; i < 14; i++){
			people[i/7][i%7] = sc.nextInt();
		}
		int target = sc.nextInt();
		if(target > 0){
			for(int i = 0; i < 7; i++){
				int l = people[0][i];
				for(int j = 0; j < l; j++){
					vals.add(bills[i]);
				}
			}
			for(int i = 0; i < 7; i++){
				int l = people[1][i];
				for(int j = 0; j < l; j++){
					vals.add(-1 * bills[i]);
				}
			}
		}
		else{
			for(int i = 0; i < 7; i++){
				int l = people[1][i];
				for(int j = 0; j < l; j++){
					vals.add(bills[i]);
				}
			}
			for(int i = 0; i < 7; i++){
				int l = people[0][i];
				for(int j = 0; j < l; j++){
					vals.add(-1 * bills[i]);
				}
			}
		}
		target = Math.abs(target);
		boolean[] dp = new boolean[20581];
		dp[0] = true;
		for(int i = 0; i < vals.size(); i++){
			if(vals.get(i) > 0){
				for(int j = 20580; j >= vals.get(i); j--){
					if(dp[j - vals.get(i)]){
						dp[j] = true;
					}
				}
			}
		}
		for(int i = 0; i < vals.size(); i++){
			if(vals.get(i)<0){
				for(int j = Math.abs(vals.get(i)); j <= 20580; j++){
					if(dp[j]){
						dp[j + vals.get(i)] = true;
					}
				}
			}
		}
		if(dp[target]){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
		sc.close();
	}

}
