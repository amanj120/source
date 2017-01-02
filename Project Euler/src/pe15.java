

import java.util.Arrays;

public class pe15 {
	public static int [][] board = new int [3][3];
	public static void main(String[] args) {
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board.length; j++){
				board[i][j] = 0;
			}
		}
	}
	public int traverse(int x , int y){
		if(x == 1 && y == 1){
			return 77;
		}
		if(x!= 0){
			return left(x,y);
		}
		if(x!= 2){
			return right(x,y);
		}
		if(y!= 2){
			return down(x,y);
		}
		return - 1;
	}
	public int left(int x , int y){
		return 0;
	}
	public int right(int x, int y){
		return 0;
	}
	public int down(int x, int y){
		return 0;
	}

}
