import java.util.Scanner;
import java.io.IOException;

public class MatchMaker{
	public static void main(String[]args) throws IOException, InterruptedException{
		Scanner sc = new Scanner(System.in);
		String name1, name2;
		int compatNumber;
		int name1Value, name2Value;
		String playAgain = "y";
		
		//add a passcode
		System.out.print("Please enter passcode to continue:");
		@SuppressWarnings("unused")
		int passCode = sc.nextInt();
		System.out.println("");
		double sleepNumber = (Math.random()*30);
		for(int i = 0; i < sleepNumber; i++){
			Thread.sleep(300);
			if(i == 0){
				System.out.print("Checking for matching passcode");
			}else{
				System.out.print(". ");
			}
		}
		System.out.println("");
		
		//play again loop
		while(playAgain.equals("y")){
			
			//clears the screen
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		
			//intro
			System.out.println("Compatability Tester v0.5\n");
			
			//get names
			System.out.println("Please enter the first name");
			name1 = sc.next();
			System.out.println("Please enter the second name");
			name2 = sc.next();
			
			//easter egg
			if(name1.equals("Johnny") && name2.equals("Amber") || name2.equals("Johnny") && name1.equals("Amber")){
				//surprise goes here
				System.out.println("ERROR ERROR ERROR");
				System.out.println("COMPATIBILITY IS -9000");
				sleepNumber = (Math.random()*30);
				for(int i = 0; i < 10; i++){
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					System.out.print("WARNING! DO NOT MIX!");
					Thread.sleep(300);
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					Thread.sleep(300);
					}
			}else{
					
				
				//loading
				sleepNumber = (Math.random()*30);
				for(int i = 0; i < sleepNumber; i++){
					Thread.sleep(300);
					if(i == 0){
						System.out.print("Calculating");
					}else{
						System.out.print(". ");
					}
				}
				System.out.println("");
				
				//calculate compatibility
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
				System.out.println(name1 + " and " + name2 + " have a compatibility of " + compatNumber + "%");
				
				//comments
				if(compatNumber == 100){
					System.out.println("WOAH A PERFECT MATCH!");
				}else if(compatNumber > 90){
					System.out.println("Great match!");
				}else if(compatNumber > 80){
					System.out.println("Looks good, give it a try.");
				}else if(compatNumber > 70){
					System.out.println("Might work out, worth the effort.");
				}else if(compatNumber > 60){
					System.out.println("Maybe, be cautious.");
				}else if(compatNumber > 50){
					System.out.println("Could go both ways, be careful.");
				}else if(compatNumber > 40){
					System.out.println("Try at your own risk.");
				}else if(compatNumber > 30){
					System.out.println("Maybe try someone else...");
				}else if(compatNumber > 20){
					System.out.println("Please try someone else...");
				}else{
					System.out.println("Horrible idea... please tell me you arent actually gonna try?(y/n)");
					String check = sc.next();
					if(check.equals("y")){
						quit();
					}
				}
			}
			System.out.println();
			//ask to loop
			System.out.println("Would you like to try again?(y/n)");
			playAgain = sc.next();
		}
		sc.close();
		quit();
		
	}
	static void quit() throws IOException, InterruptedException{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		System.out.println("dont tell anyone.");
		System.exit(0);
	}
}