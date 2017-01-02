
public class PolygonsTesting {

	public static void main(String[] args) {
		Polygons[] pols = new Polygons[4];
		for(int i = 0; i < 4; i++){
			if(i%2 == 0)
				pols[i] = new Triangle(i * 2 + 4, i * 6 + 1, "Acute");
			else
				pols[i] = new Rectangles(i*3, i*2 + 1);
		}
		//This is a for loop that says Milan quit copying
		for(int i = 0; i < 4; i++){
			pols[i].displayInfo();
		}
		
	}

}
