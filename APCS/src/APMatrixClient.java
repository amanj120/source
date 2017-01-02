
public class APMatrixClient {
	public static void main(String[] args){
		int[][] a = {{2,3,4},{1,2,3},{4,5,6},{2,2,2}};
		int[][] b = {{8,5,3},{6,1,2},{0,0,9}};
		APMatrix x = new APMatrix(a);
		APMatrix y = new APMatrix(b);
		System.out.println(x + "\n" + y);
		APMatrix z = x.matrixMultiply(y);
		System.out.println(z);
		System.out.println(z.removeCross(3, 2).removeCross(1, 1));
		int c = y.sumCross(2,2);
		System.out.println(c);
	}
}
