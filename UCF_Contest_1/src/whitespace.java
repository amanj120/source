import java.util.Scanner;

public class whitespace {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = n * 3;
		int ans = 0;
		while(k > 3){
			int j = k/4;
			k = k - j;
			ans++;
		}
		System.out.println(ans);
		sc.close();
	}

}
