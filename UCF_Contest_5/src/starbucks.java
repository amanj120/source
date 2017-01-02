import java.util.*;
import java.io.*;
public class starbucks {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();
		long ans = 0;
		for(long i = 0; i < 1000000000; i++){
			if((c - (i * a)) < 0) break;
			if((c - (i * a))%b == 0) ans++;
		}
		System.out.println(ans);
		sc.close();
	}
}