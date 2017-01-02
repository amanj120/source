/*
ID: amanj121
LANG: JAVA
TASK: palsquare
*/
import java.util.*;
import java.io.*;

public class palsquare {
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(new FileReader("palsquare.in"));
		//PrintWriter out = new PrintWriter("input.in");
		//int B = sc.nextInt();
		int B = 8;
		for(int i = 1; i <= 300; i++){
			if(isPalin(intToBase((i * i),B))){
				System.out.println(intToBase(i, B) + " " + intToBase(i*i,B));
			}
		}
		//sc.close();
		//out.print("Hi");
		//intToBase(43, 6);
	}
	public static boolean isPalin(String num){
		boolean ret = true;
		//find length of n;
		for(int i = 0; i < num.length()/2; i++){
			if(num.charAt(i) != num.charAt(num.length() - (i+1))){
				ret = false;
			}
		}
		return ret;
	}
	public static String intToBase(int n, int base){
		String ret = "";
		int numDigits = 0;
		int numDigBase = 1;
		while(true){
			if(numDigBase < n){
				numDigBase *= base;
				numDigits++;
			}
			else{
				break;
			}
		}
		for(int k = numDigits - 1; k >= 0; k--){
			for(int j = base -1; j >= 0; j--){
				int coef = (int)(j * Math.pow((double)base,(double)k));
				if(coef <= n){
					n -= j * Math.pow((double)base,(double)k);
					ret += j + "";
					break;
				}
			}
		}
		return ret;
		
	}
}
