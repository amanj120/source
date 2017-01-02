import java.util.*;
public class cftheatre {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int j = sc.nextInt();
		int nA = 0;
		int lA = 0;
		while(n > 0){
			n-= j;
			nA++;
		}
		while(l > 0){
			l-= j;
			lA++;
		}
		System.out.println(nA * lA);
		sc.close();
	}

}
