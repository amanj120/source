import java.util.*;

public class eggdrop {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] floors = new int[k];
		floors[0] = 1;
		floors[k-1] = 2;
		for(int i = 0; i < n; i++){
			int j = sc.nextInt() - 1;
			String l = sc.nextLine();
			if(l.equals(" SAFE")){
				floors[j] = 1;
			}
			else{
				floors[j] = 2;
			}
		}
		int u = 1;
		for(int i = k-1; i > 0; i--){
			if(floors[i-1] == 1){
				u += i;
				break;
			}
		}
		int h = k;
		for(int i = 0; i < k - 1; i++){
			if(floors[i + 1] == 2){
				h = i +1;
				break;
			}
		}
		System.out.println(u + " " + h);
		sc.close();
	}

}
