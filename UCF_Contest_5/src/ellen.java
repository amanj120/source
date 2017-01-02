import java.util.*;
import java.io.*;
public class ellen {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if(m < 3) System.out.println("NO");
		boolean ans = false;
		for(int i = 0; i < n; i++)
			if(sc.next().contains("<><")) ans = true;
		if(ans) System.out.println("YES");
		else System.out.println("NO");
		sc.close();
	}
}