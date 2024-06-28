import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.io.IOException;

public class BattleshipFrame{
	
	public static Scanner sc = new Scanner(System.in);
	public static boolean turn = true;
	public static JFrame player = new JFrame("Your Board");
	public static JFrame target = new JFrame("Target Board");
	public static JButton tb[][] = new JButton[10][10];
	public static JButton pb[][] = new JButton[10][10];
	public static char eb[][] = new char[10][10];
	public static int placed = 0;
	public static int C = 5;
	public static int B = 4;
	public static int D = 3;
	public static int S = 3;
	public static int P = 2;
	public static int elive;
	public static int live = 17;
	
	
	public static void main(String[]args) throws IOException, InterruptedException{
		
		boolean loop = true;
		target.setSize(500,500);
		target.setResizable(false);
		target.setLayout(new GridLayout(10,10));
		target.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		player.setSize(500,500);
		player.setResizable(false);
		player.setLayout(new GridLayout(10,10));
		player.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		for(int i = 0; i < 10; i++){
			for(int l = 0; l < 10; l++){
				tb[i][l] = new JButton();
				tb[i][l].setBackground(Color.black);
				target.add(tb[i][l]);
				pb[i][l] = new JButton();
				pb[i][l].setBackground(Color.black);
				player.add(pb[i][l]);
				eb[i][l] = ' ';
			}
		}
		target.setVisible(true);
		player.setVisible(true);
		while(loop){
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			elive = C+B+D+S+P;
			System.out.println("Mason's Battleship v2.0\n");
			System.out.println("Black = enemy unknown/empty\nWhite = miss\nblue = your ship\nred = enemy sunk/hit\norange = enemy hit\n");
			/*for testing
			for(int i = 0; i < 10; i++){
				for(int l = 0; l < 10; l++){
					System.out.print(eb[i][l]);
				}
				System.out.println("");
			}
			System.out.println(C + " " + B + " " + D + " " + S + " " + P);
			*/
			if(placed != 5){
				setup();				
			}
			if(turn && placed == 5){
				shootTarget();
			}else if(turn == false && placed == 5){
				shootPlayer();
			}
			updateSunk();
			if(elive == 0){
				System.out.println("You have defeated the enemy fleet. Come back to HQ for your reward.");
				System.out.println("Would you like to play again?(y/n)");
				String choice = sc.next();
				if(choice.equals("y")){
					placed = 0;
					C = 5;
					B = 4;
					D = 3;
					S = 3;
					P = 2;
					live = 17;
					for(int i = 0; i < 10; i++){
						for(int l = 0; l < 10; l++){
							tb[i][l].setBackground(Color.black);
							pb[i][l].setBackground(Color.black);
							eb[i][l] = ' ';
						}
					}
				}else{
					System.exit(0);
				}
			}
			if(live == 0){
				System.out.println("You have been defeated by the enemy. May your men rest in piece.)");
				System.out.println("Would you like to play again?(y/n)");
				String choice = sc.next();
				if(choice.equals("y")){
					placed = 0;
					C = 5;
					B = 4;
					D = 3;
					S = 3;
					P = 2;
					live = 17;
					for(int i = 0; i < 10; i++){
						for(int l = 0; l < 10; l++){
							tb[i][l].setBackground(Color.black);
							pb[i][l].setBackground(Color.black);
							eb[i][l] = ' ';
						}
					}
				}else{
					System.exit(0);
				}
			}
		}
	}
	
	public static void updateSunk(){
		for(int i = 0; i < 10; i++){
			for(int l = 0; l < 10; l++){
				if(C == 0 && eb[i][l] == 'C'){
					tb[i][l].setBackground(Color.red);
				}
				if(B == 0 && eb[i][l] == 'B'){
					tb[i][l].setBackground(Color.red);
				}
				if(D == 0 && eb[i][l] == 'D'){
					tb[i][l].setBackground(Color.red);
				}
				if(S == 0 && eb[i][l] == 'S'){
					tb[i][l].setBackground(Color.red);
				}
				if(P == 0 && eb[i][l] == 'P'){
					tb[i][l].setBackground(Color.red);
				}
			}
		}
	}
	
	public static void setup()throws InterruptedException{
		switch(placed){
			case 0:
				placeShip("Carrier",5);
				break;
			case 1:
				placeShip("Battleship",4);
				break;
			case 2:
				placeShip("Destroyer",3);
				break;
			case 3:
				placeShip("Submarine",3);
				break;
			case 4:
				placeShip("Patrol Boat",2);
				break;
		}
	}
	
	public static String dir = "n";
	
	public static void placeShip(String ship, int length)throws InterruptedException{
		if(!(dir.equals("v")) && !(dir.equals("h"))){
			System.out.println("Would you like your " + ship + " to be Horizontal or Vertical(h/v)");
			dir = sc.next();
		}
		System.out.println("Where would you like the top/left of your " + ship + " to be?(click on your board)");
		while(dir.equals("h")){
			if(dir.equals("h")){
				for(int i = 0; i < 10; i++){
					for(int l = 0; l < 10; l++){
						try{
							if(pb[i][l].getModel().isPressed()){
								for(int j = 0; j < length; j++){
									pb[i][l+j].setBackground(Color.blue);
									dir = "n";
								}
								placed++;
							}
						}catch(ArrayIndexOutOfBoundsException e){
							System.out.println("im sorry that location wont work. Please try again");
							Thread.sleep(2000);
							try{
								for(int j = 0; j < length; j++){
									pb[i][l+j].setBackground(Color.black);
								}
							}catch(ArrayIndexOutOfBoundsException ex){
								return;
							}
						}
					}
				}
			}
		}
		while(dir.equals("v")){
			if(dir.equals("v")){
				for(int i = 0; i < 10; i++){
					for(int l = 0; l < 10; l++){
						try{
							if(pb[i][l].getModel().isPressed()){
								for(int j = 0; j < length; j++){
									pb[i+j][l].setBackground(Color.blue);
									dir = "n";
								}
								placed++;
							}
						}catch(ArrayIndexOutOfBoundsException e){
							System.out.println("im sorry that location wont work. Please try again");
							Thread.sleep(2000);
							try{
								for(int j = 0; j < length; j++){
									pb[i+j][l].setBackground(Color.black);
								}
							}catch(ArrayIndexOutOfBoundsException ex){
								return;
							}
						}
					}
				}
			}
		}
		int hv = (int)Math.round(Math.random());
		int i = (int)Math.round(Math.random()*9);
		int l = (int)Math.round(Math.random()*(10-length));
		for(int j = 0; j < length; j++){
			if(hv == 1){
				if(eb[i][l+j] == 'C'){
					C--;
				}
				if(eb[i][l+j] == 'B'){
					B--;
				}
				if(eb[i][l+j] == 'D'){
					D--;
				}
				if(eb[i][l+j] == 'S'){
					S--;
				}
				eb[i][l+j] = ship.charAt(0);
			}else{
				if(eb[l+j][i] == 'C'){
					C--;
				}
				if(eb[l+j][i] == 'B'){
					B--;
				}
				if(eb[l+j][i] == 'D'){
					D--;
				}
				if(eb[l+j][i] == 'S'){
					S--;
				}
				eb[l+j][i] = ship.charAt(0);
			}
		}
	}
	
	public static void shootTarget()throws InterruptedException{
		System.out.println("Click on the target board to shoot");
		while(turn == true){
			for(int i = 0; i < 10; i++){
				for(int l = 0; l < 10; l++){
					if(tb[i][l].getModel().isPressed() && tb[i][l].getBackground() != Color.white && tb[i][l].getBackground() != Color.red && tb[i][l].getBackground() != Color.orange){
						if(eb[i][l] == 'C'){
							tb[i][l].setBackground(Color.orange);
							C--;
						}
						if(eb[i][l] == 'B'){
							tb[i][l].setBackground(Color.orange);
							B--;
						}
						if(eb[i][l] == 'D'){
							tb[i][l].setBackground(Color.orange);
							D--;
						}
						if(eb[i][l] == 'S'){
							tb[i][l].setBackground(Color.orange);
							S--;
						}
						if(eb[i][l] == 'P'){
							tb[i][l].setBackground(Color.orange);
							P--;
						}
						if(eb[i][l] == ' '){
							tb[i][l].setBackground(Color.white);
						}
						turn = false;
						Thread.sleep(1000);
					}
				}
			}
		}
	}
	
	public static void shootPlayer()throws InterruptedException{
		int i = (int)Math.round(Math.random()*10);
		int l = (int)Math.round(Math.random()*10);
		try{
			if(pb[i][l].getBackground() != Color.white && pb[i][l].getBackground() != Color.red){
				if(pb[i][l].getBackground() == Color.blue){
					pb[i][l].setBackground(Color.red);
					live--;
				}
				if(pb[i][l].getBackground() == Color.black){
					pb[i][l].setBackground(Color.white);
				}
				turn = true;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			i = (int)Math.round(Math.random()*10);
			l = (int)Math.round(Math.random()*10);
		}
	}
}