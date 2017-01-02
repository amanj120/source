/*
ID: amanj121
LANG: JAVA
TASK: milk
*/

import java.util.*;
import java.io.*;

public class milk {
	public static void main (String [] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("milk.in")); 
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));  
		
		int numUnits = sc.nextInt();
		int numFarmers = sc.nextInt();
		int[][] farmers = new int[numFarmers][2];
		int money = 0;
		
		for(int i = 0; i < numFarmers; i++){
			farmers[i][0] = sc.nextInt();
			farmers[i][1] = sc.nextInt();
		}
		
		java.util.Arrays.sort(farmers, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return a[0] - b[0];
		    }
		});
		
		int curFarmer = 0;
		
		while(numUnits != 0){
			if(farmers[curFarmer][1] <= numUnits){
				numUnits -= farmers[curFarmer][1];
				money += farmers[curFarmer][0] * farmers[curFarmer][1];
			}
			else{
				money += numUnits * farmers[curFarmer][0] ;
				numUnits = 0;
			}
			curFarmer++;
		}
		 
		out.println(money);
		
		out.close();                                  // close the output file
		sc.close();
		System.exit(0);                               // don't omit this!
	}
}

