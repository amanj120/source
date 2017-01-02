import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class polling {

	public static void main(String[] args)/*throws FileNotFoundException*/{
		Scanner sc = new Scanner(System.in/*new FileReader("polling.in")*/);
		int g = sc.nextInt();
		int[]votes = new int[g];
		String[] k = new String[g];
		for(int i = 0; i < g; i++){
			String cand = sc.next();
			for(int j = 0; j <k.length; j++){
				if(cand.equals(k[j])){
					votes[j]++;
					continue;
				}
			}
			k[i] = cand;
			votes[i]++;
		}
		int max = 0;
		ArrayList<Integer> maxIndex = new ArrayList<Integer>();
		for(int i = 0; i < votes.length; i++){
			if(votes[i] > max){
				max = votes[i];
				maxIndex.clear();
				maxIndex.add(i);
				continue;
			}
			if(votes[i] == max){
				maxIndex.add(i);
			}
		}
		String[] ans = new String[maxIndex.size()];
		for(int i = 0; i < maxIndex.size(); i++){
			ans[i] = k[maxIndex.get(i)];
		}
		Arrays.sort(ans);
		for(int i = 0; i < ans.length; i++){
			System.out.println(ans[i]);
		}
		
	}

}
