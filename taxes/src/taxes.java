import java.util.*;
public class taxes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How old are you?");
		int n = sc.nextInt();
		System.out.println("in 7 years you will be " + (n+7) + " years old");
		sc.close();
	}
}