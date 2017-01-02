/*
ID: amanj121
LANG: JAVA
TASK: castle
*/
import java.io.*;
import java.util.*;

public class castle {
	static class WallToRemove{
		int rowOfRoom;
		int colOfRoom;
		int directionOfWall;
		int sizeOfRoom;
		char dir;
		public WallToRemove(int r, int c, int d, int s){
			rowOfRoom = r;
			colOfRoom = c;
			directionOfWall = d;
			sizeOfRoom = s;
			dir = (directionOfWall == 1? 'S' : directionOfWall == 2? 'E' : directionOfWall == 3?'N':'W');
		}
		public String toString(){
			return rowOfRoom + "," + colOfRoom + " " + dir + " " + sizeOfRoom;
		}
		public int compareTo(WallToRemove a){
			return this.sizeOfRoom - a.sizeOfRoom;
		}
	}
	public static ArrayList<WallToRemove> rems = new ArrayList<WallToRemove>();
	public static int[][][]floorplan;
	public static int[][][] roomSizes;
	public static int rows,cols;
	public static int maxRoomSize = 0;
	public static int numRooms = 0;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("castle.in"));
		cols = sc.nextInt();
		rows = sc.nextInt();
		floorplan = new int[rows][cols][5];
		roomSizes = new int[rows][cols][2];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				roomSizes[i][j][0] = -1;
				floorplan[i][j][0] = sc.nextInt();
				String binary = toBinary(floorplan[i][j][0]);
				floorplan[i][j][1] = binary.charAt(0) - 48;//south
				floorplan[i][j][2] = binary.charAt(1) - 48;//east
				floorplan[i][j][3] = binary.charAt(2) - 48;//north
				floorplan[i][j][4] = binary.charAt(3) - 48;//west
			}
		}
		sc.close();
		boolean[][] floor = new boolean[rows][cols];
		findRooms(floor);
		findWalls();
		Collections.sort(rems, new Comparator<WallToRemove>() {
		    @Override
		    public int compare(WallToRemove o1, WallToRemove o2) {
		    	int a = o2.sizeOfRoom;
		    	int b = o1.sizeOfRoom;
		    	int c = o1.colOfRoom;
		    	int d = o2.colOfRoom;
		    	int e = o2.rowOfRoom;
		    	int f = o1.rowOfRoom;
		    	int g = o1.directionOfWall;
		    	int h = o2.directionOfWall;
		    	return(a!=b? a-b : c!=d? c-d : e!=f? e-f : g-h);
		    }
		});
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
		out.println(numRooms);
		out.println(maxRoomSize);
		out.println(rems.get(0).sizeOfRoom);
		out.println(rems.get(0).rowOfRoom+1 + " " +(int)(rems.get(0).colOfRoom + 1) + " " + rems.get(0).dir);
		out.close();
		System.exit(0);
	}
	
	public static void findRooms(boolean[][] floor){
		//int rooms = 0;
		for(int i = 0; i < floor.length; i++)
			for(int j = 0; j < floor[i].length; j++)
				if(!floor[i][j]){
					numRooms++;
					floor[i][j] = true;
					maxRoomSize = Math.max(fill(floor, i,j),maxRoomSize);
				}
	}
	
	public static int fill(boolean[][] floor, int i , int j){
		Queue<Integer> next = new LinkedList<Integer>();
		int x = i;
		int y = j;
		int parent = x*100 + y;
		next.add(x);
		next.add(y);
		int size = 0;
		while(!next.isEmpty()){
			int row = next.poll();
			int col = next.poll();
			if(floorplan[row][col][2] == 0 && col<cols - 1 && !floor[row][col+1]){//east
				next.add(row);
				next.add(col+1);
				floor[row][col+1] = true;
			}
			if(floorplan[row][col][4] == 0 && col>0 && !floor[row][col-1]){//west
				next.add(row);
				next.add(col-1);
				floor[row][col-1] = true;
			}
			if(floorplan[row][col][1] == 0 && row<rows - 1&& !floor[row+1][col]){//south
				next.add(row+1);
				next.add(col);
				floor[row+1][col] = true;
			}
			if(floorplan[row][col][3] == 0 && row>0&& !floor[row-1][col]){//north
				next.add(row-1);
				next.add(col);
				floor[row-1][col] = true;
			}
			size++;
		}
		for(int m = 0; m < rows; m++)
			for(int n = 0; n < cols; n++)
				if(floor[m][n] && roomSizes[m][n][0] == -1){
					roomSizes[m][n][0] = size;
					roomSizes[m][n][1] = parent;
				}
		return size;
	}
	
	public static String toBinary(int j){
		String ret = "";
		for(int i = 8; i >=1; i/=2){
			if(j/i == 1){
				ret+= "1";
				j-=i;
			}
			else ret+= "0";
		}
		return ret;
	}
	
	public static void findWalls(){
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols-1; j++)
				removeAllWalls(i,j);
	}
	
	public static void removeAllWalls(int row, int col){
		//1south.2east.3north.4west
		boolean w = (floorplan[row][col][4] == 1);
		boolean n = (floorplan[row][col][3] == 1);
		boolean e = (floorplan[row][col][2] == 1);
		boolean s = (floorplan[row][col][1] == 1);
		if(e)
			if(col!= (cols-1) && roomSizes[row][col][1] != roomSizes[row][col+1][1])
				rems.add(new WallToRemove(row, col, 2, roomSizes[row][col][0] + roomSizes[row][col+1][0]));
		if(w)
			if(col!= (0) && roomSizes[row][col][1] != roomSizes[row][col-1][1])
				rems.add(new WallToRemove(row, col, 4, roomSizes[row][col][0] + roomSizes[row][col-1][0]));
		if(n)
			if(row!= (0) && roomSizes[row][col][1] != roomSizes[row-1][col][1])
				rems.add(new WallToRemove(row, col, 3, roomSizes[row][col][0] + roomSizes[row-1][col][0]));
		if(s)
			if(row!= (rows-1) && roomSizes[row][col][1] != roomSizes[row+1][col][1])
				rems.add(new WallToRemove(row, col, 1, roomSizes[row][col][0] + roomSizes[row+1][col][0]));
	}
}