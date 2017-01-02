import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class war {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] caps = {"Arup" , "Matt" , "Travis" , "Eric" , "Timothy"};
		int n = sc.nextInt();
		int[] vals = new int[n];
		int[] cappow = new int[5];
		for(int i = 0; i < n; i++){
			vals[i] = sc.nextInt();
		}
		Arrays.sort(vals);
		for(int i = 1; i <= n; i++){
			if(i % 10 == 1 || i % 10 == 0){
				cappow[0] += vals[n - i];
			}
			if(i % 10 == 2 || i % 10 == 9){
				cappow[1] += vals[n - i];
			}
			if(i % 10 == 3 || i % 10 == 8){
				cappow[2] += vals[n - i];
			}
			if(i % 10 == 4 || i % 10 == 7){
				cappow[3] += vals[n - i];
			}
			if(i % 10 == 5 || i % 10 == 6){
				cappow[4] += vals[n - i];
			}
		}
		ArrayList<Integer> names = new ArrayList<Integer>();
		int max = 0;
		for(int i = 0; i < 5; i++){
			if(cappow[i] == max){
				names.add(i);
			}
			if(cappow[i] > max){
				names.clear();
				names.add(i);
				max = cappow[i];
			}
			
		}
		System.out.println(caps[names.get(0)]);
		sc.close();
	}

}
