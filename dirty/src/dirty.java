import java.util.*;
public class dirty {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int h = sc.nextInt();
		int d = sc.nextInt();
		c += h/2;
		h = h%2;
		if(c == 0 && d == 0 && h == 0){
			System.out.println(0);
			return;
		}
		if((d >=1 && h == 1)||(h == 1 && d == 0)||(d == 0 && h == 0)){
			System.out.println(c+1);
		}
		else{
			System.out.println(c);
		}
		sc.close();
	}
}