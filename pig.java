import java.util.Scanner;
import java.io.IOException;

public class pig{
	public static void main(String[]args)throws IOException, InterruptedException{
		
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		boolean turn = true;
		String P1;
		String P2;
		int P1Score = 0;
		int P2Score = 0;
		int tempScore = 0;
		int dice;
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		System.out.println("Pig v1.0\n");
		System.out.println("RULES \n 1: if you roll a 1 your turn is over and you gain no points \n 2: first player to reach 100 points wins \n 3: you can keep rolling the dice during your turn until you end it or you roll a 1\n");
		System.out.print("Player 1, what is your name? ");
		P1 = sc.nextLine();
		System.out.print("Player 2, what is your name? ");
		P2 = sc.nextLine();
		System.out.println(P1 + " " + P2);
		while(loop){
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println("Pig v1.0\n");
			System.out.println("RULES \n 1: if you roll a 1 your turn is over and you gain no points \n 2: first player to reach 100 points wins \n 3: you can keep rolling the dice during your turn until you end it or you roll a 1\n");
			System.out.println(P1 + "'s Score: " + P1Score);
			System.out.println(P2 + "'s Score: " + P2Score);
			System.out.println("");
			if(turn){
				dice = (int)(Math.random()*6)+1;
				if(dice == 7){
					dice = 6;
				}
				if(dice == 1){
					System.out.println(P1 + " rolled a 1 ending their turn");
					tempScore = 0;
					turn = false;
					Thread.sleep(3000);
				}else{
					tempScore += dice;
					System.out.println(P1 + " rolled a " + dice + " Bringing the total to " + tempScore);
					Thread.sleep(1000);
					System.out.print(P1 + ", would you like to roll again?(y/n): ");
					if(!(sc.next().equals("y"))){
						P1Score += tempScore;
						System.out.println(P1 + "'s score is now " + P1Score);
						tempScore = 0;
						turn = false;
						Thread.sleep(3000);
					}
				}
			}else{
				dice = (int)(Math.random()*6)+1;
				if(dice == 7){
					dice = 6;
				}
				if(dice == 1){
					System.out.println(P2 + " rolled a 1 ending their turn");
					tempScore = 0;
					turn = true;
					Thread.sleep(3000);
				}else{
					tempScore += dice;
					System.out.println(P2 + " rolled a " + dice + " Bringing the total to " + tempScore);
					Thread.sleep(1000);
					System.out.print(P2 + ", would you like to roll again?(y/n): ");
					if(!(sc.next().equals("y"))){
						P2Score += tempScore;
						System.out.println(P2 + "'s score is now " + P2Score);
						tempScore = 0;
						turn = true;
						Thread.sleep(3000);
					}
				}
			}
			if(P1Score >= 100){
				System.out.println(P1 + " wins!");
				System.out.println("Would you like to play again?(y/n): ");
				if(sc.next().equals("y")){
					main(args);
				}else{
					loop = false;
				}
			}
			if(P2Score >= 100){
				System.out.println(P2 + " wins!");
				System.out.println("Would you like to play again?(y/n): ");
				if(sc.next().equals("y")){
					main(args);
				}else{
					loop = false;
				}
			}
		}
		sc.close();
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
}