import java.util.Scanner;

public class FormulaCalc{
	public static void main(String[]args){
	Scanner keyboard = new Scanner(System.in);
	
	  boolean loop = true;
	  double a = 0;
	  double b = 0;
	  double c = 0;
	  double x = 0;
	  double x2 = 0;
	  double deter = 0;
	  double sr = 0;
	  int choice;
	  String choice2;
	  
	   System.out.println("Welcome to Mason's Formula Calculator!");
		while(loop){
			System.out.println("Which formula would you like to use \n\nQuadratic formula(1) \nPythagorean Theorum(2) \narea of a circle(3)\n");
			choice = keyboard.nextInt();
			/*i learned JavaScript at home on tuesday and found out switches in JavaScript are also in Java so
			im using them here because they look cleaner than a ton of else if statements*/
			switch(choice){
				case 1:
				  System.out.println("You chose the Quadratic Formula!");
				  System.out.println("Please tell me the value of A, B, and C");
				  a = keyboard.nextInt();
				  b = keyboard.nextInt();
				  c = keyboard.nextInt();
				  deter = (b*b)-(4*a*c);
				  sr = Math.sqrt(deter);
				  if(deter > 0){
					  x = (-b + sr)/(2*a);
					  x2 = (-b - sr)/(2*a);
					  System.out.println("x = " + x + " or " + x2);
				  }else if(deter == 0){
					  System.out.println("x = " + x);
				  }else{
					  System.out.println("no...");
				  }
				  break;
				case 2:
				  System.out.println("You chose the Pythagorean Theorum");
				  System.out.println("Please tell me the value of A and B");
				  a = keyboard.nextInt();
				  b = keyboard.nextInt();
				  c = Math.sqrt(a*a+b*b);
				  System.out.println("C = " + c);
				  break;
				case 3:
				  System.out.println("You chose the Area of a Circle");
				  System.out.println("Please tell me the Radius");
				  a = keyboard.nextInt();
				  x = Math.PI*(a*a);
				  System.out.println("Area = " + x);
				  break;
				default:
				  System.out.println("I'm sorry but " + choice + " wasn't one of the options");
				  break;
			}
			System.out.println("Would you like to do another equation?(y/n)");
			choice2 = keyboard.next();
			if(choice2.equals("y")){
				loop = true;
			}else{
				keyboard.close();
				System.exit(0);
			}
		}
	}
}