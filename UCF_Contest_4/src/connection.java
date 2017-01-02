import java.util.*;

public class connection {

public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	int max = 0;
	ArrayDeque<Integer> next = new ArrayDeque<Integer>();
	boolean[][] board = new boolean[m][n];
	for(int i = 0; i < n * m; i++){
		int x = sc.nextInt();
		int y = sc.nextInt();
		board[y][x] = true;
		next.add(x);
		next.add(y);
		int ans = 0;
		boolean[][] vis = new boolean[m][n];
		vis[y][x] = true;
		while(!next.isEmpty()){
			int xx = next.poll();
			int yy = next.poll();
			ans++;
			if(xx < n - 1){
				if(board[yy][xx+1] && !vis[yy][xx+1]){
					next.add(xx +1);
					next.add(yy);
					vis[yy][xx+1] = true;
					}
				}
				if(xx > 0){
					if(board[yy][xx-1] && !vis[yy][xx-1]){
					next.add(xx - 1);
					next.add(yy);
					vis[yy][xx-1] = true;
					}
				}
				if(yy < m - 1){
					if(board[yy+1][xx] && !vis[yy+1][xx]){
					next.add(xx);
					next.add(yy + 1);
					vis[yy+1][xx] = true;
					}
				}
				if(yy > 0){
					if(board[yy-1][xx] && !vis[yy-1][xx]){
					next.add(xx);
					next.add(yy - 1);
					vis[yy-1][xx] = true;
					}
				}
			}
			max = Math.max(max,ans);
			System.out.println(max);
			ans = 0;
		}
	sc.close();
	}
}
