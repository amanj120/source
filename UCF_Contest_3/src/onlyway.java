import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
public class onlyway {
	public static int[] board = new int[9];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 3; i++){
			String row = sc.next();
			for(int j = 0; j < 3; j++){
				if(row.charAt(j) == 'X'){
					board[i * 3 + j] = 1;
				}
				if(row.charAt(j) == 'O'){
					board[i * 3 + j] = 0;
				}
				if(row.charAt(j) == '.'){
					board[i * 3 + j] = 2;
				}
			}
		}
		int noX = 0;
		for(int i = 0; i < 9; i++){
			if(board[i] == 1){
				noX++;
			}
			if(board[i] == 0){
				noX--;
			}
		}
		int ans = 0;
		for(int i = 0; i < 512; i++){
			int[] cur = new int[9];
			for(int j = 0; j < 9; j++){
				if((i & 1<<j) > 0){
					cur[j] = 1;
				}
			}
			if(noX == 1 && Integer.bitCount(i) == 5 && validBoard(cur)){
				ans++;
			}
			if(noX == 0 && (Integer.bitCount(i) == 4 || Integer.bitCount(i) == 5) && validBoard(cur)){
				ans++;
			}
			if(noX == -1 && Integer.bitCount(i) == 4 && validBoard(cur)){
				ans++;
			}
		}
		System.out.println(ans);
		sc.close();
	}
	public static boolean validBoard(int[] b){
		boolean val = true;
		for(int i= 0; i < 9; i++){
			if(board[i] == 1 && b[i] != 1){
				val = false;
			}
			if(board[i] == 0 && b[i] != 0){
				val = false;
			}
			if(board[i] == 2){
				continue;
			}
		}
		if((b[0] == b[3] && b[3] == b[6] && b[0] == b[6])||(b[1] == b[4] && b[4] == b[7] && b[1] == b[7])||(b[2] == b[5] && b[5] == b[8] && b[2] == b[8])){
			val = false;
		}
		if((b[0] == b[1] && b[1] == b[2] && b[0] == b[2])||(b[3] == b[4] && b[4] == b[5] && b[3] == b[5])||(b[6] == b[7] && b[7] == b[8] && b[6] == b[8])){
			val = false;
		}
		if((b[0] == b[4] && b[4] == b[8] && b[0] == b[8])||(b[2] == b[4] && b[4] == b[6]&& b[2] == b[6])){
			val = false;
		}
		return val;
	}
}