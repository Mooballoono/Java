import java.util.Scanner;
import java.io.IOException;

public class GameOfLife{
	
	public static void main(String[]args)throws IOException, InterruptedException{

		//declaring variables
		Scanner sc = new Scanner(System.in);
		int gen = 0;
		char Board[][] = new char[20][40];
		char nBoard[][] = new char[20][40];
		String loop = "y";
		
		//setting a random seed to the board
		for(int i = 0; i < Board.length; i++){
			for(int l = 0; l < Board[i].length; l++){
				int rand = (int)Math.round(Math.random());
				if(rand == 1){
					Board[i][l] = '█';
				}else{
					Board[i][l] = ' ';
				}
			}
		}
		
		//looping the game
		while(loop.equals("y")){
			gen++;
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println("Mason's Game Of Life v0.1\n");
			System.out.println("Generation: " + gen);
			
			//printing the board and adding to the next board
			for(int i = 0; i < Board.length; i++){
				for(int l = 0; l < Board[i].length; l++){
					System.out.print(Board[i][l]);
					nBoard[i][l] = life(i,l,Board);
				}
				System.out.println("");
			}
			
			//turning the board into the next board for the next generation
			for(int i = 0; i < Board.length; i++){
				for(int l = 0; l < Board[i].length; l++){
					Board[i][l] = nBoard[i][l];
				}
			}
			
			//generation counter and ending loop
			if(gen % 50 == 0){
				System.out.println("Would you like to keep going?(y/n)");
				loop = sc.next();
			}
			Thread.sleep(100);
		}
		sc.close();
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
	
	//calculates if the tile will be living or dead
	public static char life(int i, int l, char[][] b){
		
		//declaring variables
		int amount = 0;
		int pos = i * 100 + l;
		
		//checks each adjacent tile and adds 1 to the amount if the tile is living
		for(int j = i-1; j <= i+1; j++){
			for(int t = l-1; t <= l+1; t++){
				int npos = j * 100 + t;
				//checks if tile is living and catches an error if array index isnt in the array
                try{
					if(b[j][t] == '█' && pos != npos){
						amount++;
					}
                }catch(ArrayIndexOutOfBoundsException E){
                }
			}
		}
		
		//if a living tile has more than 3 neighbors or less than 2 neighbors it dies
		if(b[i][l] == '█'){
			if(amount > 3 || amount < 2){
				return ' ';
			}
			return '█';
			
		//if a dead tile has 3 neighbors it comes to life
		}else{
			if(amount == 3){
				return '█';
			}
			return ' ';
		}
		
	}
}