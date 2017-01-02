// VehicleRunner
// McKeen
// Testing the Vehicle Class 

//import TerminalIO.KeyboardReader;  // only needed if KeyboardReader is not in your workspace already

import java.util.*;
import java.io.*;


public class VehicleRunner
{
	public static void main(String[] args)
	{
		KeyboardReader reader = new KeyboardReader();
		
		//CREATE A NEW VEHICLE and DO STUFF WITH IT
		Vehicle daquila = new Vehicle();
		daquila.displayInfo();
		double far = daquila.getRange();
		System.out.println("Daquila can go " + far + " miles on a full tank of gas.");
		
	}
}



























