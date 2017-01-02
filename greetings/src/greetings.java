import java.util.*;
import java.io.*;

public class greetings {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("greetings.in"));
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] envelopes = new int[k][2];
		int[][] ePoss = new int[n * n][2];
		int[][] cards = new int[n][3];
		int[] cardsw = new int[n];
		int[] cardsl = new int[n];
		int[] chosen = new int[n*n];
		for(int i = 0; i < n; i++){
			cards[i][0] = cardsw[i] = sc.nextInt();
			cards[i][1] = cardsl[i] = sc.nextInt();
			cards[i][2] = sc.nextInt();
		}
		Arrays.sort(cardsl);
		Arrays.sort(cardsw);
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				ePoss[n*i + j][0] = cardsw[i];
				ePoss[n*i + j][1] = cardsl[j];
			}
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++){
			for(int j = k-1; j >=0; j--){
				if(envelopes[j][0] >= cards[i][0]  && envelopes[j][1] >= cards[i][1]){
					ans+= cards[i][2] * ((envelopes[j][0] * envelopes[j][1]) - (cards[i][0] * cards[i][1]));
					break;
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}

}
