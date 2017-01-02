import java.util.*;

public class judget {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String time = sc.next();
		StringTokenizer tok = new StringTokenizer(time, ":");
		int start = 3600 * Integer.parseInt(tok.nextToken()) + 60 * Integer.parseInt(tok.nextToken()) + Integer.parseInt(tok.nextToken()); 
		int[] qu = new int[n];
		for(int i = 0; i < n; i++){
			StringTokenizer tk = new StringTokenizer(sc.next(), ":");
			int entry = 3600 * Integer.parseInt(tk.nextToken()) + 60 * Integer.parseInt(tk.nextToken()) + Integer.parseInt(tk.nextToken());
			qu[i] = entry;
		}
		Arrays.sort(qu);
		int ans = 0;
		while(qu[ans] < start){
			if(ans + 1 < n){
			ans++;
			}
			else{
				ans++;
				break;
			}
		}
		System.out.println(n - ans);
		sc.close();
	}

}
