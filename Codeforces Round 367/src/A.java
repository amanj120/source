import java.util.*;
public class A {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int nc = sc.nextInt();
		double ans = 1000000000;
		for(int i = 0; i < nc; i++){
			int xc = sc.nextInt();
			int yc = sc.nextInt();
			int speed = sc.nextInt();
			double dist = Math.hypot(x - xc, y - yc);
			double time = dist/speed;
			ans = Math.min(ans, time);
		}
		System.out.println(ans);
		sc.close();
	}
}
