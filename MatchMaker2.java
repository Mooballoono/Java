import java.util.Scanner;
import java.io.IOException;

public class MatchMaker2 {
	public static void main( String args[]) throws IOException, InterruptedException {
		
		//intialize scanner
		Scanner keyboard = new Scanner(System.in);
		
		// declare variables
		String name1, name2;
		int compatNumber;
		int name1Value, name2Value;
		String playAgain="y";
		int passCode;
		int sleepNumber;
		
		//clears the screen
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		//intro
			System.out.println("Welcome to the Compatability Tester");
			System.out.println("This program is highly scientific and should only be used by professionals");
			System.out.println();
		// add a passcode
		System.out.println("Please enter passcode to continue:");
		passCode = keyboard.nextInt();
		System.out.println("Checking security match. Please wait.");
		sleepNumber = ((int)(Math.random()*30)+1);
			for (int i=0; i < sleepNumber; i++){
				Thread.sleep(300);
				System.out.print("* ");
			}
			System.out.println();
		
		
		//play again loop
		while(playAgain.equals("y") && passCode == 123456 ){
		
			//clears the screen
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			
			//intro
			System.out.println("Compatability Tester v1.0");
			System.out.println();
			
			//get names
			System.out.println("Please enter the first name:");
			name1 = keyboard.next();
			System.out.println("Please enter the second name:");
			name2 = keyboard.next();
			
			//easter egg
			if (name1.equals("Johnny") && name2.equals("Amber")){
				//surprise goes here
				for (int i=0; i<10; i++){
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					System.out.println("Warning! Do Not Mix!");
					Thread.sleep(300);
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					Thread.sleep(300);
				}
			}
			else{
			
				//make it look like it is thinking
				System.out.println("Please wait while we calculate the results");
				sleepNumber = ((int)(Math.random()*30)+1);
				for (int i=0; i < sleepNumber; i++){
					Thread.sleep(300);
					System.out.print("* ");
				}
				System.out.println();
				
				/*//random version
				compatNumber = ((int)(Math.random()*100)+1);
				System.out.println("These two people are " + compatNumber + "% compatable");
				*/	
				
				// Mathematical version based on AscII values
				name1Value = 0;
				for ( int i=0; i < name1.length(); i++){
					name1Value += (int)name1.charAt(i);
				}
				name2Value = 0;
				for ( int i=0; i < name2.length(); i++){
					name2Value += (int)name2.charAt(i);
				}
				
				name1Value = name1Value*50/30;
				name2Value = name2Value*30/50;
				compatNumber = Math.abs(name1Value - name2Value);
				
				while (compatNumber > 100){  //check to see if number is too large
					compatNumber = compatNumber - 75;
				}
				
				//display results
				System.out.println("These two people are " + compatNumber + "% compatable");
			
				//comment section
				if(compatNumber > 90){
					System.out.println("Great Match!");
				}
				else if(compatNumber > 80){
					System.out.println("Looks good, give it a try.");
				}
				else if(compatNumber > 70){
					System.out.println("Might work out, worth the effort.");
				}
				else if(compatNumber > 60){
					System.out.println("Maybe, be cautious.");
				}
				else if(compatNumber > 50){
					System.out.println("Could go either way.");
				}
				else if(compatNumber > 40){
					System.out.println("Probably not a good idea.");
				}
				else if(compatNumber > 30){
					System.out.println("Should look somewhere else.");
				}
				else if(compatNumber > 20){
					System.out.println("NO, not going to work.");
				}
				else if(compatNumber > 10){
					System.out.println("Both people deserve better.");
				}
				else{
					System.out.println("Horrible idea! Avoid this!");
				}
			} // end easter egg
			//end play again loop
			System.out.println();
			System.out.println("Would you like to conduct a new test?(y/n)");
			playAgain = keyboard.next();
		}
		// shutting down
		keyboard.close();
		System.out.println("Erasing memory and shutting down.");
		sleepNumber = ((int)(Math.random()*30)+1);
			for (int i=0; i < sleepNumber; i++){
				Thread.sleep(300);
				System.out.print("* ");
			}
			System.out.println();
		//clears the screen
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	
	}
}