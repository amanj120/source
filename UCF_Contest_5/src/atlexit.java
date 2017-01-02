import java.util.*;
import java.io.*;
public class atlexit {
	public static void main(String[] args) throws IOException {
		long max = 10010000;
		boolean[] pr = new boolean[(int) (max + 1)];
		Arrays.fill(pr, true);
		pr[0] = pr[1] = false;
		for(long i = 2; i*i < max+1; i++)
			for(long j = i*i; j < max+1; j += i)
				pr[(int) j] = false;
		Scanner sc = new Scanner(System.in);
		String res = "";
		long s = sc.nextInt();
		long e = sc.nextInt();
		if(pr[(int) (s + 2)] && pr[(int) (e + 2)]) res = s + " " + (s+2) + " " + 2 + " " + (e+2) + " " + e;
		if(pr[(int) (s + 2)] && pr[(int) (e - 2)]) res = s + " " + (s+2) + " " + 2 + " " + e;
		if(pr[(int) (s - 2)] && pr[(int) (e + 2)]) res = s + " " + 2 + " " + (e+2) + " " + e;
		if(pr[(int) (s - 2)] && pr[(int) (e - 2)]) res = (s + " " + 2 + " " + e);
		if((s + 2) == (e - 2) && pr[(int) (s+2)]) res = s + " " + (s+2) + " " + e;
		if((s - 2) == (e + 2) && pr[(int) (s-2)]) res = s + " " + (s-2) + " " + e;
		if(Math.abs(s - e) == 2) res = (s + " " + e);
		if(s == 2){
			if(pr[(int) (e + 2)]) res = 2 + " " + (e+2) + " " + e;
			if(pr[(int) (e-2)]) res = 2 + " " + e;
		}
		if(e == 2){
			if(pr[(int) (s + 2)]) res = s + " " + (s+2) + " " + 2;
			if(pr[(int) (s-2)]) res = s + " " + 2;
		}
		if(res.equals("")) System.out.println(-1);
		else System.out.println(res);
		sc.close();
	}
}