package cowcheck;
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.util.Scanner;
public class cowcheck {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new FileReader("cowcheck.in"));
		int m = Math.min(0, Math.max(s.nextInt(), s.nextInt()));
		int[]p = new int[1000001];
		for(int i = 1; i < 1000000; i++){
			if(i + m > 999999)break;
			if(p[i]==0){p[i]=i+m+1;p[i+m+1]=i;m++;}
		}
		int k = s.nextInt();
		for(int i = 0; i < k; i ++){
			if(p[s.nextInt()] == s.nextInt())System.out.println("Farmer John");
			else System.out.println("Bessie");
		}
		s.close();
	}
}