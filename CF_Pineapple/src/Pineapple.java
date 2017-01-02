import java.util.Scanner;

public class Pineapple {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n = sc.nextInt();
		int x = sc.nextInt();
		if(t == x){
			System.out.println("YES");
			return;
		}
		boolean ans = false;
		int j = t + 1;
		while(j <= x){
			j -= 1;
			j += n;
			if( j == x){
				ans = true;
				break;
			}
			j += 1;
			if(j == x){
				ans = true;
				break;
			}
		}
		if(ans){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
		sc.close();
	}

}
