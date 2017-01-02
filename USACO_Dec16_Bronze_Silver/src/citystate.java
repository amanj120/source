/*
ID: amanj120
LANG: JAVA
TASK: citystate
*/
import java.util.*;
import java.io.*;
public class citystate {
	public static void main(String[] args) throws IOException {
		HashMap<String,Integer> places = new HashMap<String,Integer>();
		Scanner sc = new Scanner(new FileReader("citystate.in"));
		int n = sc.nextInt();
		String[] citys = new String[n];
		for(int i = 0; i < n; i++){
			String city = sc.next().substring(0,2).trim();
			String state= sc.next().trim();
			if (state.equals(city))
				continue;
			citys[i] = state + city;
			if(places.containsKey(city+state))
				places.put(city+state, places.get(city+state) + 1);
			else
				places.put(city+state, 1);
		}
		sc.close();
		int ans = 0;
		for(int i = 0; i < n; i++)
			if(places.containsKey(citys[i]))ans+= places.get(citys[i]);
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		out.println(ans/2);
		out.close();
		System.exit(0);	
	}
}