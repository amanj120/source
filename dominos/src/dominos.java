import java.util.*;

public class dominos {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] names = new String[n];
		for(int i = 0; i < n; i++){
			String name = sc.next();
			String nameint = "";
			for(int j = 0; j < name.length(); j++){
				if(name.charAt(j) == 'A' ||name.charAt(j) == 'E' ||name.charAt(j) == 'I' ||name.charAt(j) == 'O' ||name.charAt(j) == 'U' ||name.charAt(j) == 'T'){
					nameint += "1";
				}
				else{
					nameint += "0";
				}
			}
			names[i] = nameint;
		}
		for(int i = 0; i < n; i++){
			String ans = "YUM PIZZA";
			for(int j = 0; j < n; j++){
				if(i != j && names[i].equals(names[j])){
					ans = "CONFUSED";
					break;
				}
			}
			System.out.println(ans);
		}
	}

}
