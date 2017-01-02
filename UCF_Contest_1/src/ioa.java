import java.util.Scanner;
public class ioa {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() - 1;
		int ans = 0;
		int[][] adj = new int[n][2];
		adj[0][0] = sc.nextInt();
		ans+= sc.nextInt();
		for(int i = 1; i < n; i++){
			adj[i][0] = adj[i-1][0] + sc.nextInt(); 
			ans+= sc.nextInt();
		}
		int k = adj[n - 1][0] + sc.nextInt();
		ans+= sc.nextInt();
		for(int i = 0; i < n; i++ ){
			adj[i][1] = k - adj[i][0];
		}
		int paths = Math.min(adj[n-1][0],  adj[0][1]);
		for(int i = 0; i < n - 1; i++){
			paths = Math.min(Math.min(paths,2 * adj[i][0] + adj[i+1][1]),2 * adj[i + 1][1] + adj[i][0]);
		}
		System.out.println(paths + ans);
		sc.close();
	}

}
