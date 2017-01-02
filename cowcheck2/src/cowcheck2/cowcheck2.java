package cowcheck2;

public class cowcheck2 {
	public static int maxval = 0;
	public static void main(String[] args) {
		int[][] pvals = new int[1000000][2];
		for(int i = 1; i < pvals.length; i++){
			if(pvals[i][0] == 0){
				int l = maxval+1;
				pvals[i][1] = l;
				pvals[i][0] = i + l;
				pvals[pvals[i][0]][0] = i;
				maxval++;
			}
		}
	}

}
