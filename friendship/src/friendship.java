import java.util.Scanner;

public class friendship {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] adj = new int[n][n];
		int k = sc.nextInt();
		int frs = sc.nextInt();
		for(int i = 0; i < k; i++){
			int h = sc.nextInt() - 1;
			int g = sc.nextInt() - 1;
			adj[h][g] = adj[g][h] = 1;
		}
		int ans = 0;
		for(int i = 0; i < 1<<n; i++){
			boolean[] ponies = new boolean[n];
			for(int j = 0; j < n; j++){
				if((i & 1<<j) != 0){
					ponies[j] = true;
				}
			}
			if(Integer.bitCount(i) > 1){
				int frmakes = 0;
				for(int j = 0; j < n; j++){
					if(ponies[j]){
						for(int l = j + 1; l < n; l++){
							if(ponies[l] && adj[j][l] == 0){
								frmakes++;
							}
						}
					}
				}
				if(frmakes <= frs){
					ans = Math.max(ans, Integer.bitCount(i));
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
