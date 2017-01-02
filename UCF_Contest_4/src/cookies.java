import java.util.*;
public class cookies {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cookies = new int[sc.nextInt()];
		for(int i = 0; i < cookies.length; i++){
			cookies[i] = sc.nextInt();
		}
		int ans = 0;
		for(int i = 0; i <  sc.nextInt(); i++){
			for(int j = 0; j < cookies.length; j++){
				ans += sc.nextInt() * cookies[j];
			}
		}
		System.out.println(ans);
		sc.close();
	}
}