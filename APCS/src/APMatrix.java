import java.util.*;
public class APMatrix {
	//Private Variables-----------------------------------------------------------------------------
	private int[][] mat;
	//Accessors-------------------------------------------------------------------------------------
	public int getRows(){	return mat.length;	} //return number of rows
	public int getColumns(){	return mat[0].length;	} //returns number of columns
	//Constructors----------------------------------------------------------------------------------
	APMatrix(int r, int c, boolean enter){ //user entered values
		mat = new int[r][c];
		KeyboardReader reader = new KeyboardReader();
		if(enter)
			for(int i = 0; i < r; i++)
				for(int j = 0; j < c; j++)
					mat[i][j] = reader.readInt("enter a value to put into row " + (i+1)+ ", column " + (j+1) + ": ");
	}
	APMatrix(int[][] copy){ //copies a 2d matrix
		mat = new int[copy.length][copy[0].length];
		for(int i = 0; i < mat.length; i++)
			for(int j = 0; j < mat[0].length; j++)
				mat[i][j] = copy[i][j];
	}
	//Public methods--------------------------------------------------------------------------------
	public APMatrix matrixMultiply(APMatrix a){
		if(this.getColumns() == a.getRows()){
			int[][] reta = new int[this.getRows()][a.getColumns()];//creates a 2d array of the proper size
			for(int i = 0; i < this.getRows(); i++)//loops through all the rows of the first array
				for(int j = 0; j < a.getColumns(); j++)//loops through all the columns of the second array
					for(int k = 0; k < this.getColumns(); k++)
		//multiplies the kth value in the ith row of the first array by the kth value in the jth column of the second array
						reta[i][j] += (this.mat[i][k] * a.mat[k][j]);
			return new APMatrix(reta);
		}
		System.out.println("These two matrices cannot be multiplied");
		return null;
	}
	public String toString(){
		String ret = "";
		for(int i = 0 ; i < mat.length; i++){
			for(int j = 0; j < mat[0].length; j++)
				ret += ("" + mat[i][j] + "\t");
			ret+="\n";
		}
		return ret;
	}
	public int sumCross(int r, int c){
		if(r > this.getRows() || c > this.getColumns() || r < 0 || c < 0){
			System.out.println("According to my calculations you are out of bounds.");
			return -1;
		}
		int ret = -1 * (this.mat[r-1][c-1]); // intializes it to whatever mat[r][c] is but negative
		for(int i = 0; i < this.getColumns(); i++)
			ret += mat[r-1][i];
		for(int i = 0; i < this.getRows(); i++)
			ret+=mat[i][c-1];
		return ret;
	}
	public APMatrix removeCross(int r, int c){
		int[][] ret = new int[this.getRows() - 1][this.getColumns() - 1];
		r--;
		c--;
		if(r >= this.getRows() || c >= this.getColumns() || r <0 || c < 0){
			System.out.println("You are so out of bounds right now I literally can't even");
			return this;
		}
		if(ret.length > 0 && ret[0].length > 0){//partitions matrix into four seperate rectangles
			for(int i = 0; i < this.getRows(); i++){
				if(i < r)
					for(int j = 0; j < this.getColumns(); j++){
						if(j < c)//top left corner of matrix
							ret[i][j] = mat[i][j];
						if(j > c)//top right corner of matrix
							ret[i][j-1] = mat[i][j];
					}
				if(i >r)
					for(int j = 0; j < this.getColumns(); j++){
						if(j < c)//bottom left corner of matrix
							ret[i-1][j] = mat[i][j];
						if(j > c)//bottom right corner of matrix
							ret[i-1][j-1] = mat[i][j];
					}	
			}
			return new APMatrix(ret);
		}
		System.out.println("Your matrix is too small to remove anything from it");
		return null;
	}
}