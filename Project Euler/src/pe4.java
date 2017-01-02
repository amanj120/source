

public class pe4 {

	public static void main(String[] args) {
		int ans = 0;
		for(int i = 999; i > 99; i--){
			for(int j = 999; j>99; j--){
				if(isPalindrome(i*j)){
					if (i*j> ans){
						ans = i*j;
					}
				}
			}
		}
		System.out.println(ans);
	}
	public static boolean isPalindrome(int n){
		if(n<100000){
			String P= "" + n;
			if(P.charAt(0) == P.charAt(4) && P.charAt(1) == P.charAt(3)){
				return true;
			}
		}
		if(n>99999){
			String P = "" + n;
			if(P.charAt(0) == P.charAt(5) && P.charAt(2)== P.charAt(3) && P.charAt(1) == P.charAt(4)){
				return true;
			}
		}
		return false;
	}
}
