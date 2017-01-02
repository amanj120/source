package cardgame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class cardgame {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileReader("cardgame.input"));
		int N = sc.nextInt();
		int ans = 0;
		int[] card = new int[2* N];
		ArrayList<Integer> ehigh = new ArrayList<Integer>();
		ArrayList<Integer> elow = new ArrayList<Integer>();
		ArrayList<Integer> bhigh = new ArrayList<Integer>();
		ArrayList<Integer> blow = new ArrayList<Integer>();
		for(int i = 0; i < N; i++){
			int l = sc.nextInt();
			card[l-1] = 1;
			ehigh.add(l);
		}
		for(int i = N -1; i >=N/2; i--){
			elow.add(ehigh.get(i));
			ehigh.remove(i);
		}
		for(int i = 0; i < card.length; i++){
			if(card[i] == 0)blow.add(i+1);
		}
		for(int i = 0; i < N/2; i++){
			bhigh.add(blow.get(N/2));
			blow.remove(N/2);
		}
		Collections.sort(ehigh);
		Collections.sort(elow,Collections.reverseOrder());
		Collections.sort(blow, Collections.reverseOrder());
		for(int j = 0; j < N/2; j++){
			if(bhigh.get(0) > ehigh.get(0)){
				ans++;
				bhigh.remove(0);
				ehigh.remove(0);
			}
			else{
				bhigh.remove(0);
			}
			if(blow.get(0) < elow.get(0)){
				ans++;
				blow.remove(0);
				elow.remove(0);
			}
			else{
				blow.remove(0);
			}
		}
		System.out.println(ans);
		sc.close();
	}
}