import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
public class CF_S_1 {
	public static int[][] paper;
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileReader("imput.in"));
		int n = sc.nextInt();
		for(int hhh = 0; hhh < n; hhh++){
			int rows = sc.nextInt();
			int columns = sc.nextInt();
			paper = new int[rows][columns];
			for(int i = 0; i < rows; i++){
				String row = sc.next();
				for(int j = 0; j < columns; j++){
					if(row.charAt(j) == '.'){
						paper[i][j] = 1;
					}
					else{
						paper[i][j] = 0;
					}
				}
			}
			int ans = 0;
			for(int i = 1; i < rows - 1; i++){
				for(int j = 1; j < columns-1; j++){
					if(goodStamp(i,j)) ans++;
				}
			}
			for(int i = 1; i < rows - 1; i++){
				for(int j = 1; j < columns-1; j++){
					if(badStamp(i,j)) ans--;
				}
			}
			String res = ""+ ans;
			for(int i = 0; i < rows; i++){
				for(int j = 0; j < columns; j++){
					if(paper[i][j] == 0){
						res = "impossible";
					}
				}
			}
			System.out.println("Image #" + (hhh + 1) + ": " + res);
			System.out.println();
		}
		sc.close();
	}
	public static boolean goodStamp(int i, int j){	
		if(paper[i][j] <=0 && paper[i-1][j] <=0 && paper[i+1][j] <=0 && paper[i][j+1]<=0 && paper[i][j-1] <=0){
			paper[i][j]--;
			paper[i-1][j]--;
			paper[i][j-1]--;
			paper[i+1][j]--;
			paper[i][j+1]--;
			return true;
		}
		else{
			return false;
		}	
	}
	public static boolean badStamp(int i, int j){
		if(paper[i][j] <=-2 && paper[i-1][j] <=-2 && paper[i+1][j]<=-2 && paper[i][j+1] <=-2 && paper[i][j-1]<=-2){
			paper[i][j]++;
			paper[i][j+1]++;
			paper[i+1][j]++;
			paper[i-1][j]++;
			paper[i][j-1]++;
			return true;
		}
		else{
			return false;
		}
	}
}
//numless++;
//if(paper[i][j] == 0){
//	num0++;
//}
//}
//if(paper[i-1][j] < 1){
//numless++;
//if(paper[i-1][j] == 0){
//	num0++;
//}
//}
//if(paper[i][j-1] < 1){
//numless++;
//if(paper[i][j-1] == 0){
//	num0++;
//}
//}
//if(paper[i+1][j] < 1){
//numless++;
//if(paper[i+1][j] == 0){
//	num0++;
//}
//}
//if(paper[i][j+1] < 1){
//numless++;
//if(paper[i][j+1] == 0){
//	num0++;
//}
//}
//if(numless == 5 && num0 >0){