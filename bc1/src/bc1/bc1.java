package bc1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bc1 {
	public static ArrayList cows = new ArrayList<Integer>();
	public static ArrayList cowstemp = new ArrayList<Integer>();
	public static int[] ans;
	public static int n;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("bc1.input"));
		n = sc.nextInt();
		ans = new int[n];
		for(int i = 0; i < n; i++){
			String l = sc.next();
			char j = l.charAt(0);
			cows.add((int) j);
		}
		for(int i = 0; i < n; i++){
			int first = (int) cows.get(0);
			int last = (int) cows.get(cows.size() - 1);
			if(first < last){
				ans[i] = first;
				cows.remove(0);
			}
			if(last < first){
				ans[i] = last;
				cows.remove(cows.size() - 1);
			}
			if(last == first){
				cowstemp = new ArrayList<Integer>(cows.size());
				for(int  g= 0; g < cows.size(); g++){
					cowstemp.add(cows.get(g));
				}
				boolean x = findSmall();
				if(x){
					ans[i] = first;
					cows.remove(0);
				}
				if(!x){
					ans[i] = last;
					cows.remove(cows.size() - 1);
				}
			}
		}
		for(int i = 0; i < (n/80) + 1; i++){
			String k = "";
			for(int j = 0; j < Math.min(80,n - (80 * i)); j++){
				k += (char)(ans[(80 * i) + j]);
			}
			System.out.println(k);
		}
		sc.close();
	}
	public static boolean findSmall(){
		
		if(cowstemp.size() > 2){
			if((int) cowstemp.get(1) < (int) cowstemp.get(cowstemp.size() - 2))return true;
			if((int) cowstemp.get(1) > (int) cowstemp.get(cowstemp.size() - 2))return false;
			if((int) cowstemp.get(1) == (int) cowstemp.get(cowstemp.size() - 2)){
				cowstemp.remove(0);
				cowstemp.remove(cowstemp.size() - 1);
				return findSmall();
			}
		}
		if(cowstemp.size() == 2){
			if((int) cowstemp.get(0) < (int) cowstemp.get(1))return true;
			if((int) cowstemp.get(1) > (int) cowstemp.get(0))return false;
		}
		return true;
	}
}