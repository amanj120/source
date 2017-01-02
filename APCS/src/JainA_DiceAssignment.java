import java.util.*;

public class JainA_DiceAssignment{
	public static void main(String[] args){
		KeyboardReader reader = new KeyboardReader();
		int next = 0; 
		do{
			next = reader.readInt("\nMenu\n1. DiceRoll\n2. 10,000 Rolls\n3. Craps\n4. Bonus\n0. Exit\n");
			switch(next){
				case 1:
					firstMethod();
					break;
				case 2:
					tenkTimes();
					break;
				case 3:
					craps();
					break;
				case 4:
					bonus();
					break;
				default:
					System.out.println("Enter a valid option");
				case 0:
					break;
			}
		}while(next != 0);
	}
	public static void firstMethod(){
		KeyboardReader reader = new KeyboardReader();
		char next = 'Y';
		do{
			int numRolls = reader.readInt("How many times would you like to roll the dice?\t");
			Dice die = new Dice(6);
			Dice die2 = new Dice(6);
			for(int i = 0; i < numRolls; i++){
				int firstDie = die.roll();
				int secondDie = die2.roll();
				System.out.println("Roll #" + (i+1) + ":\t" + firstDie + " + " + secondDie + " = " + (firstDie + secondDie));
				reader.pause();
			}
			next = reader.readChar("Would you like to play again?(Y/N)\n");
		}while(next == 'Y');
	}
	public static void tenkTimes(){
		Dice n = new Dice(6);
		int[] times = new int[6];
		for(int i = 0; i < 10000; i++)
			times[n.roll() -1]++;
		for(int i = 0; i < 6; i++)
			System.out.println("Number of times " + (i+1) + " was rolled: " + times[i]);
		
	}
	public static void craps(){
		KeyboardReader reader = new KeyboardReader();
		char next = 'Y';
		do{
			Dice die = new Dice(6);
			int firstDie = die.roll();
			int secondDie = die.roll();
			int sum = firstDie + secondDie; //rolls the two dice for the first time
			System.out.println("Player rolled " + firstDie + " + " + secondDie + " = " + (firstDie + secondDie));
			if(sum == 2 || sum == 3 || sum == 12){ //Checks to see if a first roll win occured
				System.out.println("Player loses.");
			}
			else if(sum == 7 || sum == 11){ //Checks to see if a first roll loss occured
				System.out.println("Player wins!");
			}
			else{ //goes onto the rest of the game
				System.out.println("Point is " + sum);
				int point = sum;// sets the current point value to something that can be accessed in the loop
				while(true){//infinite loop will go on until the game ends
					firstDie = die.roll();
					secondDie = die.roll();
					sum = firstDie + secondDie;//rolls the two dice again and captures it in sum
					System.out.println("Player rolled " + firstDie + " + " + secondDie + " = " + (firstDie + secondDie));
					if(sum == point){//if this occurs then a win happened and the loop will break
						System.out.println("Player wins!");
						break;
					}
					if(sum == 7){// if the two rolls add up to seven then a loss occurs and the loop will break
						System.out.println("Player loses.");
						break;	
					}
				}
			}
			next = reader.readChar("\nWould you like to play again?(Y/N)\n");
		}while(next == 'Y');
	}
	public static void bonus(){
		int[] probs = new int[4];
		String[] statements = {"Probability of winning on first roll: ","Probability of winning by making point: ","Probability of losing on first roll: ","Probability of losing by not mking point: " };
		//probs[0] = winning on first roll
		//probs[1] = winning by making point
		//probs[2] = losing on first roll
		//probs[3] = losing by rolling 7
		for(int i = 0; i < 100000; i++){
			Dice die = new Dice(6);
			int firstDie = die.roll();
			int secondDie = die.roll();
			int sum = firstDie + secondDie; //rolls the two dice for the first time
			if(sum == 2 || sum == 3 || sum == 12){ //Checks to see if a first roll loss occured
				probs[2]++;
			}
			else if(sum == 7 || sum == 11){ //Checks to see if a first roll win occured
				probs[0]++;
			}
			else{ //goes onto the rest of the game
				int point = sum;// sets the current point value to something that can be accessed in the loop
				while(true){//infinite loop will go on until the game ends
					firstDie = die.roll();
					secondDie = die.roll();
					sum = firstDie + secondDie;//rolls the two dice again and captures it in sum
					if(sum == point){//if this occurs then a win happened and the loop will break
						probs[1]++;
						break;
					}
					if(sum == 7){// if the two rolls add up to seven then a loss occurs and the loop will break
						probs[3]++;
						break;	
					}
				}
			}
		}
		for(int i = 0; i < 4; i++){
			System.out.println(statements[i] + (((double)probs[i])/100000.0));
		}
		System.out.println("The probability of winning is: 0." + (probs[1] + probs[0]));
		System.out.println("The probability of losing is: 0." + (probs[2] + probs[3]));
	}
}