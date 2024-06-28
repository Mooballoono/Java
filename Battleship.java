import java.util.Scanner;
import java.io.IOException;

public class Battleship{
	//p is for player, c is for computer, t is for target, C is for Carrier, B is for Battleship, D is for Destroyer, S is for Submarine, and PB is for Patrol Boat
	public static Scanner sc = new Scanner(System.in);
	public static char[][] pBoard = new char[10][10];
	public static char[][] cBoard = new char[10][10];
	public static char[][] tBoard = new char[10][10];
	public static int row;
	public static int column;
	public static int pC = 5;
	public static int pB = 4;
	public static int pD = 3;
	public static int pS = 3;
	public static int pPB = 2;
	public static int cC = 5;
	public static int cB = 4;
	public static int cD = 3;
	public static int cS = 3;
	public static int cPB = 2;
	public static int lives = 17;
	public static int hits = 0;
	public static boolean loop = true;
	
	public static void main(String[]args)throws IOException, InterruptedException{

		for(int i = 0; i < pBoard.length; ++i){
			for(int l = 0; l < pBoard[i].length; ++l){
				pBoard[i][l] = 32;
				tBoard[i][l] = 32;
				cBoard[i][l] = 32;
			}
		}
		setup();
		
		while(loop){
			printBoards();
			pTurn();
			cTurn();
			if(lives == 0 ){
				System.out.println("You have been defeated by the enemy. may your men rest in peace");
				playAgain();
			}
			if(hits == 17){
				System.out.println("You have defeated the enemy! now come back to HQ for your reward.");
				playAgain();
			}
		}
	}
	
	public static void playAgain()throws IOException, InterruptedException{
		System.out.println("would you like to play again?(y/n)");
		if(sc.next().equals("y")){
			pC = 5;
			pB = 4;
			pD = 3;
			pS = 3;
			pPB = 2;
			cC = 5;
			cB = 4;
			cD = 3;
			cS = 3;
			cPB = 2;
			lives = 17;
			hits = 0;
			for(int i = 0; i < pBoard.length; ++i){
				for(int l = 0; l < pBoard[i].length; ++l){
					pBoard[i][l] = 32;
					tBoard[i][l] = 32;
					cBoard[i][l] = 32;
				}
			}
			setup();
		}else{
			loop = false;
		}
	}
	
	public static void setup() throws IOException, InterruptedException{
		printBoards();
		placeCarrier(false,pBoard);
		placeCarrier(true,cBoard);
		printBoards();
		placeBattleship(false, pBoard);
		placeBattleship(true, cBoard);
		printBoards();
		placeDestroyer(false, pBoard);
		placeDestroyer(true, cBoard);
		printBoards();
		placeSubmarine(false, pBoard);
		placeSubmarine(true, cBoard);
		printBoards();
		placePatrol(false, pBoard);
		placePatrol(true, cBoard);
	}
	
	public static void pTurn()throws IOException, InterruptedException{
		System.out.println("Where would you like to fire");
		row = sc.nextInt();
		column = sc.nextInt();
		hitCheck();
	}
	
	public static void cTurn()throws IOException, InterruptedException{
		row = (int)Math.round(Math.random()*10);
		if(row == 0){
			row = 1;
		}
		column = (int)Math.round(Math.random()*10);
		if(column == 0){
			column = 1;
		}
		chitCheck();
	}
	
	public static void printBoards()throws IOException, InterruptedException{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		System.out.println("Mason's Battleship v1.1");
		System.out.println("    1   2   3   4   5   6   7   8   9   10");
		System.out.println("  ╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
		for(int i = 0; i < tBoard.length; i++){
			for(int l = 0; l < tBoard[i].length; l++){
				if(l == 0){
					if(i != 9){
						System.out.print(i+1 + " " + "║ " + tBoard[i][l] + " ");
					}else if(i == 9){
						System.out.print(i+1 + "║ " + tBoard[i][l] + " ");
					}
				}else{
					System.out.print("║ " + tBoard[i][l] + " ");
				}
			}
			System.out.print("║");
			System.out.println("");
			if(i != 9){
				System.out.println("  ╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
			}else{
				System.out.println("  ╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
			}
		}
		System.out.println("  Target Board                              Hits are 'X', misses are 'M', and a boat sunk shows the letter(C,B,D,S,P)");
		System.out.println("  ═════════════════════════════════════════ to shoot type the row's number and then the column's number");
		System.out.println("  Your Board                                If your boat is hit it shows as 'X' and misses are marked as 'M'");
		System.out.println("    1   2   3   4   5   6   7   8   9   10");
		System.out.println("  ╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
		for(int i = 0; i < pBoard.length; i++){
			for(int l = 0; l < pBoard[i].length; l++){
				if(l == 0){
					if(i != 9){
						System.out.print(i+1 + " " + "║ " + pBoard[i][l] + " ");
					}else if(i == 9){
						System.out.print(i+1 + "║ " + pBoard[i][l] + " ");
					}
				}else{
					System.out.print("║ " + pBoard[i][l] + " ");
				}
			}
			System.out.print("║");
			System.out.println("");
			if(i != 9){
				System.out.println("  ╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
			}else{
				System.out.println("  ╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
			}
		}
	}
	
	public static void hitCheck()throws IOException, InterruptedException{
		if(tBoard[row-1][column-1] == 'M' || tBoard[row-1][column-1] == 'X'){
			pTurn();
			return;
		}else if(cBoard[row-1][column-1] == 'C'){
			cC--;
			hits++;
			tBoard[row-1][column-1] = 'X';
		}else if(cBoard[row-1][column-1] == 'B'){
			cB--;
			hits++;
			tBoard[row-1][column-1] = 'X';
		}else if(cBoard[row-1][column-1] == 'D'){
			cD--;
			hits++;
			tBoard[row-1][column-1] = 'X';
		}else if(cBoard[row-1][column-1] == 'S'){
			cS--;
			hits++;
			tBoard[row-1][column-1] = 'X';
		}else if(cBoard[row-1][column-1] == 'P'){
			cPB--;
			hits++;
			tBoard[row-1][column-1] = 'X';
		}else if(cBoard[row-1][column-1] == ' '){
			tBoard[row-1][column-1] = 'M';
		}
		if(cC == 0 && cBoard[row-1][column-1] == 'C'){
			for(int i = 0; i < cBoard.length; i++){
				for(int l = 0; l < cBoard[i].length; l++){
					if(cBoard[i][l] == 'C'){
						tBoard[i][l] = 'C';
					}
				}
			}
		}
		if(cB == 0 && cBoard[row-1][column-1] == 'B'){
			for(int i = 0; i < cBoard.length; i++){
				for(int l = 0; l < cBoard[i].length; l++){
					if(cBoard[i][l] == 'B'){
						tBoard[i][l] = 'B';
					}
				}
			}
		}
		if(cD == 0 && cBoard[row-1][column-1] == 'D'){
			for(int i = 0; i < cBoard.length; i++){
				for(int l = 0; l < cBoard[i].length; l++){
					if(cBoard[i][l] == 'D'){
						tBoard[i][l] = 'D';
					}
				}
			}
		}
		if(cS == 0 && cBoard[row-1][column-1] == 'S'){
			for(int i = 0; i < cBoard.length; i++){
				for(int l = 0; l < cBoard[i].length; l++){
					if(cBoard[i][l] == 'S'){
						tBoard[i][l] = 'S';
					}
				}
			}
		}
		if(cPB == 0 && cBoard[row-1][column-1] == 'P'){
			for(int i = 0; i < cBoard.length; i++){
				for(int l = 0; l < cBoard[i].length; l++){
					if(cBoard[i][l] == 'P'){
						tBoard[i][l] = 'P';
					}
				}
			}
		}
		printBoards();
		Thread.sleep(2000);
	}
	
	public static void chitCheck()throws IOException, InterruptedException{
		if(pBoard[row-1][column-1] == 'C'){
			pC--;
			lives--;
			pBoard[row-1][column-1] = 'X';
		}else if(pBoard[row-1][column-1] == 'B'){
			pB--;
			lives--;
			pBoard[row-1][column-1] = 'X';
		}else if(pBoard[row-1][column-1] == 'D'){
			pD--;
			lives--;
			pBoard[row-1][column-1] = 'X';
		}else if(pBoard[row-1][column-1] == 'S'){
			pS--;
			lives--;
			pBoard[row-1][column-1] = 'X';
		}else if(pBoard[row-1][column-1] == 'P'){
			pPB--;
			lives--;
			pBoard[row-1][column-1] = 'X';
		}else if(pBoard[row-1][column-1] == ' '){
			pBoard[row-1][column-1] = 'M';
		}else if(pBoard[row-1][column-1] == 'M' || pBoard[row-1][column-1] == 'X'){
			cTurn();
			return;
		}
		printBoards();
		System.out.println("The enemy shot at " + row + " " + column + "!");
		Thread.sleep(2000);
	}
	
	public static void placeCarrier(boolean c, char Board[][]){
		String hv = "";
		if(c == false){
			System.out.println("Would you like your Carrier(5 long) to be horizontal or vertical?(h/v)");
			hv = sc.next();
			System.out.println("What coordinates would you like the top/left of your Carrier(5 long) to start at?(row column)");
			row = sc.nextInt();
			column = sc.nextInt();
		}else{
			int rand = (int)Math.round(Math.random());
			if(rand == 1){
				hv = "h";
				row = (int)Math.round(Math.random()*10);
				column = (int)Math.round(Math.random()*6);
			}else{
				hv = "v";
				row = (int)Math.round(Math.random()*6);
				column = (int)Math.round(Math.random()*10);
			}
			if(row == 0){
				row = 1;
			}
			if(column == 0){
				column = 1;
			}
		}
		for(int i = 0; i < 5; i++){

			switch (hv){
				case "h":
					Board[row-1][column+i-1] = 'C';
					break;
				case "v":
					Board[row+i-1][column-1] = 'C';
					break;
			}
		}
	}
	
	public static void placeBattleship(boolean c, char Board[][]){
		String hv = "";
		if(c == false){
			System.out.println("Would you like your Battleship(4 long) to be horizontal or vertical?(h/v)");
			hv = sc.next();
			System.out.println("What coordinates would you like the top/left of your Battleship(4 long) to start at?(row column)");
			row = sc.nextInt();
			column = sc.nextInt();
		}else{
			int rand = (int)Math.round(Math.random());
			if(rand == 1){
				hv = "h";
				row = (int)Math.round(Math.random()*10);
				column = (int)Math.round(Math.random()*7);
			}else{
				hv = "v";
				row = (int)Math.round(Math.random()*7);
				column = (int)Math.round(Math.random()*10);
			}
			if(row == 0){
				row = 1;
			}
			if(column == 0){
				column = 1;
			}
		}
		for(int i = 0; i < 4; i++){
			switch (hv){
				case "h":
					if(Board[row-1][column+i-1] == 'C'){
						if(c){
							cC--;
							hits++;
						}else{
							pC--;
							lives--;
						}
					}
					Board[row-1][column+i-1] = 'B';
					break;
				case "v":
					if(Board[row+i-1][column-1] == 'C'){
						if(c){
							cC--;
							hits++;
						}else{
							pC--;
							lives--;
						}
					}
					Board[row+i-1][column-1] = 'B';
					break;
			}
		}
	}
	
	public static void placeDestroyer(boolean c, char Board[][]){
		String hv = "";
		if(c == false){
			System.out.println("Would you like your Destroyer(3 long) to be horizontal or vertical?(h/v)");
			hv = sc.next();
			System.out.println("What coordinates would you like the top/left of your Destroyer(3 long) to start at?(row column)");
			row = sc.nextInt();
			column = sc.nextInt();
		}else{
			int rand = (int)Math.round(Math.random());
			if(rand == 1){
				hv = "h";
				row = (int)Math.round(Math.random()*10);
				column = (int)Math.round(Math.random()*8);
			}else{
				hv = "v";
				row = (int)Math.round(Math.random()*8);
				column = (int)Math.round(Math.random()*10);
			}
			if(row == 0){
				row = 1;
			}
			if(column == 0){
				column = 1;
			}
		}
		for(int i = 0; i < 3; i++){

			switch (hv){
				case "h":
					if(Board[row-1][column+i-1] == 'C'){
						if(c){
							cC--;
							hits++;
						}else{
							pC--;
							lives--;
						}
					}
					if(Board[row-1][column+i-1] == 'B'){
						if(c){
							cB--;
							hits++;
						}else{
							pB--;
							lives--;
						}
					}
					Board[row-1][column+i-1] = 'D';
					break;
				case "v":
					if(Board[row+i-1][column-1] == 'C'){
						if(c){
							cC--;
							hits++;
						}else{
							pC--;
							lives--;
						}
					}
					if(Board[row+i-1][column-1] == 'B'){
						if(c){
							cB--;
							hits++;
						}else{
							pB--;
							lives--;
						}
					}
					Board[row+i-1][column-1] = 'D';
					break;
			}
		}
	}
	
	public static void placeSubmarine(boolean c, char Board[][]){
		String hv = "";
		if(c == false){
			System.out.println("Would you like your Submarine(3 long) to be horizontal or vertical?(h/v)");
			hv = sc.next();
			System.out.println("What coordinates would you like the top/left of your Submarine(3 long) to start at?(row column)");
			row = sc.nextInt();
			column = sc.nextInt();
		}else{
			int rand = (int)Math.round(Math.random());
			if(rand == 1){
				hv = "h";
				row = (int)Math.round(Math.random()*10);
				column = (int)Math.round(Math.random()*8);
			}else{
				hv = "v";
				row = (int)Math.round(Math.random()*8);
				column = (int)Math.round(Math.random()*10);
			}
			if(row == 0){
				row = 1;
			}
			if(column == 0){
				column = 1;
			}
		}
		for(int i = 0; i < 3; i++){

			switch (hv){
				case "h":
					if(Board[row-1][column+i-1] == 'C'){
						if(c){
							cC--;
							hits++;
						}else{
							pC--;
							lives--;
						}
					}
					if(Board[row-1][column+i-1] == 'B'){
						if(c){
							cB--;
							hits++;
						}else{
							pB--;
							lives--;
						}
					}
					if(Board[row-1][column+i-1] == 'D'){
						if(c){
							cD--;
							hits++;
						}else{
							pD--;
							lives--;
						}
					}
					Board[row-1][column+i-1] = 'S';
					break;
				case "v":
					if(Board[row+i-1][column-1] == 'C'){
						if(c){
							cC--;
							hits++;
						}else{
							pC--;
							lives--;
						}
					}
					if(Board[row+i-1][column-1] == 'B'){
						if(c){
							cB--;
							hits++;
						}else{
							pB--;
							lives--;
						}
					}
					if(Board[row+i-1][column-1] == 'D'){
						if(c){
							cD--;
							hits++;
						}else{
							pD--;
							lives--;
						}
					}
					Board[row+i-1][column-1] = 'S';
					break;
			}
		}
	}
	
	public static void placePatrol(boolean c, char Board[][]){
		String hv = "";
		if(c == false){
			System.out.println("Would you like your Patrol Boat(2 long) to be horizontal or vertical?(h/v)");
			hv = sc.next();
			System.out.println("What coordinates would you like the top/left of your Patrol Boat(2 long) to start at?(row column)");
			row = sc.nextInt();
			column = sc.nextInt();
		}else{
			int rand = (int)Math.round(Math.random());
			if(rand == 1){
				hv = "h";
				row = (int)Math.round(Math.random()*10);
				column = (int)Math.round(Math.random()*9);
			}else{
				hv = "v";
				row = (int)Math.round(Math.random()*9);
				column = (int)Math.round(Math.random()*10);
			}
			if(row == 0){
				row = 1;
			}
			if(column == 0){
				column = 1;
			}
		}
		for(int i = 0; i < 2; i++){

			switch (hv){
				case "h":
					if(Board[row-1][column+i-1] == 'C'){
						if(c){
							cC--;
							hits++;
						}else{
							pC--;
							lives--;
						}
					}
					if(Board[row-1][column+i-1] == 'B'){
						if(c){
							cB--;
							hits++;
						}else{
							pB--;
							lives--;
						}
					}
					if(Board[row-1][column+i-1] == 'D'){
						if(c){
							cD--;
							hits++;
						}else{
							pD--;
							lives--;
						}
					}
					if(Board[row-1][column+i-1] == 'S'){
						if(c){
							cS--;
							hits++;
						}else{
							pS--;
							lives--;
						}
					}
					Board[row-1][column+i-1] = 'P';
					break;
				case "v":
					if(Board[row+i-1][column-1] == 'C'){
						if(c){
							cC--;
							hits++;
						}else{
							pC--;
							lives--;
						}
					}
					if(Board[row+i-1][column-1] == 'B'){
						if(c){
							cB--;
							hits++;
						}else{
							pB--;
							lives--;
						}
					}
					if(Board[row+i-1][column-1] == 'D'){
						if(c){
							cD--;
							hits++;
						}else{
							pD--;
							lives--;
						}
					}
					if(Board[row+i-1][column-1] == 'S'){
						if(c){
							cS--;
							hits++;
						}else{
							pS--;
							lives--;
						}
					}
					Board[row+i-1][column-1] = 'P';
					break;
			}
		}
	}
}