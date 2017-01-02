//Aman Jain
//Rectangles.java
//Makes a rectangle object, which is a type of Polygons object
public class Rectangles extends Polygons{
		
	private boolean isSquare;
	
	public Rectangles(double w, double h){ //constuctor
		super(w,h); //creates a polygon object with w and h
		isSquare = (w == h); //checks to see if its a square
		//Milan don't copy my code
	}
	
	public void getIsSquare(){
		System.out.println(isSquare);
	}
	
	public double getArea(){ //The getArea() method is just w*h for this Polygons object
		return getWidth() * getHeight();
	}
	
	public void displayInfo(){
		System.out.println("\n\nSHAPE INFO:");
		System.out.println("The figure is a rectangle.");
		System.out.println("The area of this rectangle is: " + this.getArea());
		System.out.println("Square status: " + isSquare);
		super.displayInfo();		//What is this madness?  Is it calling itself?
		//Displays the width and height
	}

}
