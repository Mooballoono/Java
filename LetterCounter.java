import java.util.Scanner;
import java.io.IOException;

public class LetterCounter{
	public static void main(String[]args)throws IOException, InterruptedException{
		
		Scanner sc = new Scanner(System.in);
		String loop = "y";
		char letters[] = new char[26];
		int lettersCount[] = new int[26];
		int max = 0;
		int min = 100;
		int amount = 0;
		int vowels = 0;
		int consonants = 0;
		String sentence;
		for(int i = 0; i < letters.length; i++){
			letters[i] = (char)(65+i);
		}
		
		while(loop.equals("y")){
			for(int i = 0; i < lettersCount.length; i++){
				lettersCount[i] = 0;
			}
			max = 0;
			min = 100;
			vowels = 0;
			consonants = 0;
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println("Letter Counter v1.0");
			System.out.print("Please type a sentence: ");
			sentence = sc.nextLine();
			System.out.println("");
			for(int i = 0; i < letters.length; i++){
				for(int l = 0; l < sentence.length(); l++){
					if(letters[i] == sentence.charAt(l) || letters[i] == (sentence.charAt(l))-32){
						lettersCount[i]++;
						if(letters[i] == 'A'||letters[i] == 'E'||letters[i] == 'I'||letters[i] == 'O'||letters[i] == 'U'){
							vowels++;
						}else{
							consonants++;
						}
					}
				}
				System.out.println("     " + letters[i] + " : " + lettersCount[i]);
				if(lettersCount[i] > max){
					max = lettersCount[i];
				}
				if(lettersCount[i] < min){
					min = lettersCount[i];
				}
			}
			System.out.println("");
			System.out.println("There are " + sentence.replace(" ","").length() + " total letters");
			for(int i = 0; i < letters.length; i++){
				if(lettersCount[i] == max){
					System.out.print(letters[i] + " ");
					amount++;
				}
			}
			if(amount == 1){
				System.out.println("was the most used letter with " + max);
				amount = 0;
			}else{
				System.out.println("were the most used letters with " + max);
				amount = 0;
			}
			for(int i = 0; i < letters.length; i++){
				if(lettersCount[i] == min){
					System.out.print(letters[i] + " ");
					amount++;
				}
			}
			if(amount == 1){
				System.out.println("was the least used letter with " + min);
				amount = 0;
			}else{
				System.out.println("were the least used letters with " + min);
				amount = 0;
			}
			System.out.println("There were " + vowels + " vowels");
			System.out.println("There were " + consonants + " consonants");
			System.out.println("\nWould you like to try again?(y/n)");
			loop = sc.nextLine();
			System.out.println("");
		}
		sc.close();
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
}