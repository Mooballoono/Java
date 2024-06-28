import java.util.Scanner;

public class Calculator {
	public static void main( String[] args ) {
	Scanner keyboard = new Scanner(System.in);
	  boolean work = true;
	  String answer = "";
	  float num1 = 0;
	  float num2 = 0;
	  float sum = 0;
	 while(work){
	  String op;
	   System.out.println("Welcome to Mason's Calculator");
	   System.out.println("");
	   System.out.println("You can Add(+), Subtract(-), Multiply(*), and Divide(/) any 2 numbers.");
	   System.out.println("");
	   System.out.println("Please type what operator you want to use (+,-,*,/)");
	   op = keyboard.next();
	   if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")){
	   }else{
		   System.out.println(op + " is not an acceptable operator... Please try again");
		   op = keyboard.next();
		   if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")){
		   }else{
			   System.out.println(op + " is still not an acceptable operator... try again later");
			   System.exit(0);
		   }
	   }
	   System.out.println("Please type your first number");
	   num1 = keyboard.nextInt();
	   System.out.println("Please type your second number");
	   num2 = keyboard.nextInt();
		if(op.equals("+")){
			sum = num1 + num2;
		}
		if(op.equals("-")){
			sum = num1 - num2;
		}
		if(op.equals("*")){
			sum = num1 * num2;
		}
		if(op.equals("/")){
			sum = num1 / num2;
		}
	   System.out.println(num1 + " " + op + " " + num2 + " = " + sum);
	   System.out.println("do you want to do another calculation? (y/n)");
	   answer = keyboard.next();
	   if(answer.equals("y")){
	       work = true;
	   }else{
		   work = false;
	   }
	   keyboard.close();
	 }
	}
}