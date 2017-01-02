import java.util.*;
public class hanoi {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
			for(int i = 0; i < k; i++){
			int d = sc.nextInt();
			int n = sc.nextInt();
			if(d > ((n-1) * (n-1) + 1)){
				System.out.println("Grid #" + (i+1) + ": " +"impossible");
			}
			else{
				System.out.println("Grid #" + (i+1) + ": " +(d * (2*(n-1))));
			}
			System.out.println();
		}
		sc.close();
	}

}
