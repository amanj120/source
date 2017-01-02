import java.util.Scanner;

public class vowel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String k = sc.next();
		
		int vowels = 0;
		int non = 0;
		
		for(int i = 0; i < k.length(); i++){
			if(k.charAt(i) == 'a' || k.charAt(i) == 'e' || k.charAt(i) == 'i' || k.charAt(i) == 'o' || k.charAt(i) == 'u'){
				vowels++;
			}
			else{
				non++;
			}
		}
		if(vowels> non){
			System.out.println(1);
		}
		else{
			System.out.println(0);
		}
		sc.close();

	}

}
