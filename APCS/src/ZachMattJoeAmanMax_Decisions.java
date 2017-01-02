import java.util.*;
public class ZachMattJoeAmanMax_Decisions{
	public static void main(String[] args){
		KeyboardReader reader = new KeyboardReader();
		int next = 0;
		do{
			next = reader.readInt("\n\tEnter\n1.\tSwitch\n2.\tLocal Variables\n3.\tIf Else Ladders\n4.\tNested Ifs\n5.\tIf/ If Else\n6.\tBoolean Control\n0.\tExit\n");
			switch(next){
				case 1:
					switches();	
					break;
				case 2:
					variablesLocalToIf();
					break;
				case 3:
					ifElseLadders();
					break;
				case 4:
					NestedIf();
					break;
				case 5:
					IfIfElse();
					break;
				case 6:
					BooleanControlExpression();
					break;
				default:
					System.out.println("not a valid choice");
					break;
				case 0:
					next = 0;
					break;
			}
		}while(next != 0);
	}
	public static void switches(){
		KeyboardReader reader = new KeyboardReader();
	
		System.out.println("Enter Type of Switch");
		int next = 0;
		boolean brakeCondition = false;
		while(!brakeCondition){
			next = reader.readInt("1. Integer \n2. Character \n3. Exit\n");
			// There are two basic types of switches that are used in this class(floats, longs tc are not used)
			switch(next){
				case 1:
					int switch1 = 1; // actual variable
					switch1 = reader.readInt("enter 1 or 2, or die!!!\n");
					switch(switch1){ // declares a switch 	
					case 1: // case where the integer is 1
						System.out.println("you entered 1. good job.\n");
						break;
					case 2:
						System.out.println("you entered 2. good job\n");
						break;
					default: // case where the integer is neither 1 nor 2
						System.out.println("not valid.\n");
						break;
					}
					break;
				case 2:
					char switchy = 'a';
					switchy = reader.readChar("enter either a or b or z to quit... or else\n");
					switch(switchy){
					case 'a':
						System.out.println("good job, you eneterd a\n");
						break;
					case 'b':
						System.out.println("good job you eneterd b\n");
						break;
					default:
						System.out.println("you eneterd the secret password to the elevator to hell. Welcome...\n\n\nmwahahahaha\n");
						break;
					case 'z':
						break;
					}
				break;
				default:
					System.out.println("not a valid option");
					break;
				case 3:
					brakeCondition = true;
					break;
			}
		}
	} 
	public static void variablesLocalToIf(){
		KeyboardReader reader = new KeyboardReader();
		int speed = reader.readInt("Enter the speed that your car is driving: ");
		if (speed >= 10)
		{
			// The variable "money" is only local to this specific if structure and does 
			//not exist in the rest of the program. 
			int money = speed - 5;
			System.out.println("You will have to pay " + money +  " dollars for speeding.");
		}
		else
		{
			System.out.println("Congrats on not speeding!");
		}
	}
	public static void ifElseLadders(){
		KeyboardReader reader = new KeyboardReader();
		/*Use an if else ladder to determine level of happiness that
		  corresponds with the number of squirrels in possession*/
		String happiness;
		int squirrels = reader.readInt("Please enter how many squirrels you have: ");
		//First if statement and condition
		if(squirrels >= 40)
			happiness = "maximum";
		/*Only one condition is necessary after 1st if statement,
		 *since squirrels was already confirmed to be less than previous number*/
		else if(squirrels >= 30)
			happiness = "extreme";
		else if(squirrels >= 20)
			happiness = "moderate";
		else if(squirrels >= 10)
			happiness = "inadequate";
		//Use as many else if statements as you have brackets
		//Last else statement makes sure variable happiness is initialized
		else
			happiness = "deprived";
		System.out.println("Happiness: " + happiness);
	}
	public static void IfIfElse(){
		KeyboardReader reader = new KeyboardReader();
		String name;
		name = reader.readLine("What is your name?\t");
		
		if (name.equals("Aman") || name.equals("Matt"))
		{
		System.out.println("Go for a run");
		}
		int score;
		score = reader.readInt("Enter Your AP Computer Science Score:\t");
		
		if (score == 5)
		{
			System.out.println("Congratulations!!!");
		}
		else
		{
			System.out.println("Maybe you should have paid more attention in class...");
		}
	}
	public static void BooleanControlExpression(){
		KeyboardReader reader = new KeyboardReader();
		boolean goodLooking;
	int attractiveness = reader.readInt("How attractive is the person to the right of you?");
	if (attractiveness >=6)
	{
		goodLooking = true;
	}
	
	else
	{
		goodLooking = false;
	}
	// To use boolean in an if/else structure, the set up would look like below
	if (goodLooking)
	{
		System.out.println("Dannggg");
	}
	// The code would still work properly if it was typed as 
	// if (goodLooking == true), but that is redundant. 
	}
	public static void NestedIf(){
		KeyboardReader reader = new KeyboardReader();
		double kimmel, colbert, fallon, corden;
		kimmel = reader.readDouble("on a scale of 1-10, how good is Jimmy Kimmel");
		colbert = reader.readDouble("on a scale of 1-10, how good is Stephen Colbert");
		fallon = reader.readDouble("on a scale of 1-10, how good is Jimmy Fallon");
		corden = reader.readDouble("on a scale of 1-10, how good is James Corden");
if (fallon > colbert && fallon > kimmel ) {
System.out.println("Jimmy Fallon is the King of late night TV.");
}else{
	System.out.println("NBC will want Jimmy Fallon to improve.");
	if (colbert < kimmel) {
		System.out.println("CBS executives will not be happy with Colbert.");
	} else{
		System.out.println("Colbert is doing Ok.");
		if (corden > colbert) {
			System.out.println("CBS may consider Corden for the coveted 11:35 time slot.");
	}
}
    }


	}
}