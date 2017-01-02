import java.util.*;
public class top {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[][] names = new String[2][n];
		for(int i = 0; i < n*2; i++)
			names[i/n][i%n] = sc.next();
		HashSet<String> teams = new HashSet<String>();
		int ans = 0;
		for(int i = 0; i < n; i++){
			ans++;
			if(teams.contains(names[0][i])) teams.remove(names[0][i]);
			else teams.add(names[0][i]);
			if(teams.contains(names[1][i])) teams.remove(names[1][i]);
			else teams.add(names[1][i]);
			
			if(teams.size() == 0){
				System.out.println(ans);
				ans = 0;
			}
		}
		sc.close();
	}
}