//Fraction.java
//Aman Jain
//Does stuff with fractions

public class Fraction implements FractionInterface{
	//Instance Variables-------------------------------------------------------------------------------------
	private int myNum; 		//Numerator
	private int myDenom;    //Denominator
	//Accessors----------------------------------------------------------------------------------------------
	//Returns numerator
	public int getNumerator(){
		return myNum;
	}
	//Returns denominator
	public int getDenominator(){
		return myDenom;
	}
	//Constructors-------------------------------------------------------------------------------------------
	//Default Constructor
	public Fraction(){
		this(0,1);	//uses the int constructor to make a new fraction
	}
	//Constructor using ints
	public Fraction(int n, int d){
		myNum = n;
		myDenom = d;
		this.simplify();
	}
	//Constructor using double
	//Public methods---------------------------------------------------------------------------------
	//Turns fraction into a double
	public double toDouble(){
		return (((double)myNum)/myDenom);
	}
	//Compares two fractions
	public int compareTo(Fraction f){
		if(toDouble() > f.toDouble()){
			return 1;
		}
		if(toDouble() < f.toDouble()){
			return -1;
		}
		else{
			return 0;
		}
	}
	//Adds fractions
	public Fraction add(Fraction f){
		return new Fraction(((this.myNum * f.myDenom + this.myDenom * f.myNum)),(this.myDenom * f.myDenom));
	}
	// Subtracts fractions
	public Fraction subtract(Fraction f){
		return new Fraction(((this.myNum * f.myDenom - this.myDenom * f.myNum)),(this.myDenom * f.myDenom)); //almost the same as add
	}
	//multiplies fractions
	public Fraction multiply(Fraction f){
		return new Fraction(((this.myNum * f.myNum)),(this.myDenom * f.myDenom)); //n1*n2 / d1*d2
	}
	//divides fractions

	public Fraction divide(Fraction f){
		return new Fraction(((this.myNum * f.myDenom)),(this.myDenom * f.myNum)); // multiplies reciprocal
	}
	//equals methods
	public boolean equals(Fraction f){
		return(this.myNum * f.myDenom == this.myDenom * f.myNum);
	}

	public boolean equals(int n, int d){
		return(this.equals(new Fraction(n,d))); //cheks equality by creating a new fraction n/d
	}
	public void print(){
		System.out.println(toString()); //prints the toString
	}
	public String toString(){
		return(myNum + "/" + myDenom); //turns into a string
	}
	
	//Double methods to print
	//equals double method
	public boolean equals(double d){
		return(Math.abs(this.toDouble() - d) <= 0.00000001); //converts to a double, and subtracts and finds the absolute value
	}
	//double Constructor
	public Fraction(double db){
		double n = db;
		double d = 1;
		while(true){
			if(((n * d) % 1) != 0){ //continues to multiply the denominaor by 10 until the numerator is a whole number
				d *= 10;
			}
			else{
				n *= d;
				break;
			}
		}
		myNum = (int)n;
		myDenom = (int)d;
		this.simplify();
	}
	
	//Simplify Mehtod---------------------------------------------------------------------------------
	private void simplify(){
		//Finds the GCD of the numerator and denominator, and then divides both by the GCD
		if(myDenom == 0){
			myNum = 0;
			myDenom = 1;
			System.out.println("You fool, quit dividing by zero!");
		}
		else{
			for(int i = Math.min(Math.abs(myNum),Math.abs(myDenom)); i> 0; i--){
				if(myNum%i == 0 && myDenom%i == 0){
					myNum /= i;
					myDenom /= i;
					break;
				}
			}
		}
		if(myDenom < 0){ //fixes a negative denominator
			myNum *= -1;
			myDenom *= -1;
		}
		if(myNum == 0){
			myDenom = 1;
		}
	}
	
}