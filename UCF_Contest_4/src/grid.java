import java.util.*;
public class grid {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] board = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		for(int i = 0; i < n; i++){
			String line = sc.next();
			for(int j = 0; j < m; j++){
				board[i][j] = Integer.parseInt("" + line.charAt(j));
			}
		}
		visited[0][0] = true;
		ArrayDeque<Integer> next = new ArrayDeque<Integer>();
		next.add(0);
		next.add(0);
		visited[0][0] = true;
		int ans = 0;
		
		while(!next.isEmpty()){
			int hh = next.size()/2;
			for(int i = 0; i < hh; i++){
				int x = next.poll();
				int y = next.poll();
				visited[y][x] = true;
				if(x == m-1 && y == n-1){
					System.out.println(ans);
					next.clear();
					break;
				}
				int val = board[y][x];
				if(x + val < m){
					if(!visited[y][x+val]){
						next.add(x + val);
						next.add(y);
						visited[y][x+val] = true;
					}
				}
				if(y + val < n){
					if(!visited[y+val][x]){
						next.add(x);
						next.add(y + val);
						visited[y+val][x] = true;
					}
				}
				if(x - val >= 0){
					if(!visited[y][x-val]){
						next.add(x - val);
						next.add(y);
						visited[y][x-val] = true;
					}
				}
				if(y - val >= 0){
					if(!visited[y-val][x]){
						next.add(x);
						next.add(y - val);
						visited[y-val][x] = true;
					}
				}
			}
			ans++;
		}
		if(!visited[n-1][m-1]){
			System.out.println(-1);
		}
		sc.close();
	}

}
