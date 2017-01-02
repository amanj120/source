import java.util.*;
import java.io.*;

public class Analyzer{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("input.in"));
		int i = 0;
		while(sc.hasNext()){
			dataObject a = (analyze(sc.nextLine()));
			System.out.println(a.toString());
			i++;
		}
		sc.close();
	}
	public static dataObject analyze(String n){
		int[][] rawVals = new int[15][2];
		double[] eff = new double[15];
		int trialIdx = n.indexOf(",");
		String trialSize = n.substring(0, trialIdx).trim();
		int t = Integer.valueOf(trialSize);
		n = n.replaceAll((trialSize + ","), "");
		for(int i = 1; i <=15; i++){
			n = n.replaceAll((i + ":"), "");
		}
		n = n.replaceAll("-", " ").trim();
		StringTokenizer st = new StringTokenizer(n);
		double e = 0;
		for(int i = 0; i < 15; i++){
			rawVals[i][0] = Integer.valueOf(st.nextToken().trim());//GPU
			rawVals[i][1] = Integer.valueOf(st.nextToken().trim());//CPU
			if(rawVals[i][0] == 0) rawVals[i][0]++;
			if(rawVals[i][1] == 0) rawVals[i][1]++;
			eff[i] = (double)rawVals[i][0] / (double)rawVals[i][1];
			e += eff[i];
		}
		e/= 15;
		double s = 0;
		for(int i = 0; i < 15; i++){
			s += ((eff[i] - e)*(eff[i] - e)/15);
		}
		s = Math.sqrt(s);
		return new dataObject(t,e, s);
	}
}
class dataObject{
	public int trialSize;
	public double Efficiency;
	public double StdDev;
	
	public dataObject(int t, double e, double s){
		trialSize = t;
		Efficiency =e;
		StdDev = s;
	}
	
	public String toString(){
		return trialSize + ":\t"  + Efficiency + "\t" + StdDev;
	}
	
}