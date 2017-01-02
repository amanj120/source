import java.util.Scanner;
import java.util.StringTokenizer;

public class barnicle {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringTokenizer tk = new StringTokenizer(sc.next(), ".e");
		String a = tk.nextToken();
		String b = tk.nextToken();
		int c = Integer.parseInt(tk.nextToken());
		String fullNo = a + b;
		String fullNoa = fullNo;
		while(c >=fullNo.length()){
			c--;
			fullNoa += "0";
			if(c == fullNo.length() - 1){
				System.out.println(fullNoa);
				return;
			}
		}
		if(c+1 < fullNo.length()){
			fullNo = fullNo.substring(0,c + 1) + "." + fullNo.substring(c + 1); 
		}
		System.out.println(fullNo);
		sc.close();
		
	}

}
