import java.util.Scanner;

public class compatibility{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String name1;
		String name2;
		text("Please give me a name");
		name1 = sc.next();
		text("Please give me another name");
		name2 = sc.next();
		text("thank you");
		compare(name1,name2);
		sc.close();
	}
	static void compare(String n1, String n2){
		text("the compatibility of " + n1 + " and " + n2 + " is " + n1.compareTo(n2));
	}
	static void text(String t){
		System.out.println(t);
	}
}