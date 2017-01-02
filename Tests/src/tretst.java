import java.util.Set;
import java.util.TreeSet;

public class tretst {

	public static void main(String[] args) {
		Set integerSet = new TreeSet();
        integerSet.add(new Integer(5));			 
        integerSet.add(new Integer(1));			
        integerSet.add(new Integer(7));		
        integerSet.add(new Integer(9));
        System.out.println(integerSet.toString());


	}
	private int height;
	private int end;
	private int start;
	public void pair(int start, int end, int height){
		this.start = start;
		this.end = end;
		this.height = height;
	}
	public int getStart(){
		return start;
	}
	public void setStart(int start){
		this.start = start;
	}
	public int getEnd(){
		return end;
	}
	public void setEnd(int end){
		this.end = end;
	}
	public int getHeight(){
		return height;
	}
	public void setHeight(int height){
		this.height = height;
	}
}
