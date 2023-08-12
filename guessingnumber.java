package first;
import java.util.Scanner;
import java.util.Random;
class Game {
	
	int systemInput;
	int userInput;
	int noOfGuesses = 0;
	
	Game() {
		Random random = new Random();
		this.systemInput = random.nextInt(100) + 1;
	}
	

	public boolean takeUserInput() {
		if ( noOfGuesses < 10 ) {
			System.out.print("GUESS THE NUMBER..." );
			this.userInput = guessingnumber.takeIntegerInput(100);
			noOfGuesses++;
			return false;
		}
		else {
			System.out.println("TOO MANY ATTEMPTS...BETTER LUCK NEXT TIME\n");
			return true;
		}
	}
	
	
	
	public boolean isCorrectGuess() {
		
		if ( systemInput == userInput ) {
			System.out.println("CONGRATS..YOU HAVE GUESS" + systemInput +
			" IN " + noOfGuesses + " GUSSES..");
			switch(noOfGuesses) {
				case 1:
				System.out.println("YOURS SCORE IS 100");
				break;
				case 2:
				System.out.println("YOURS SCORE IS 90");
				break;
				case 3:
				System.out.println("YOURS SCORE IS 80");
				break;
				case 4:
				System.out.println("YOURS SCORE IS 70");
				break;
				case 5:
				System.out.println("YOURS SCORE IS 60");
				break;
				case 6:
				System.out.println("YOURS SCORE IS 50");
				break;
				case 7:
				System.out.println("YOURS SCORE IS 40");
				break;
				case 8:
				System.out.println("YOURS SCORE IS 30");
				break;
				case 9:
				System.out.println("YOURS SCORE IS 20");
				break;
				case 10:
				System.out.println("YOURS SCORE IS 10");
				break;
			}
			System.out.println();
			return true;
		}
		else if ( noOfGuesses < 10 && userInput > systemInput ) {
			if ( userInput - systemInput > 10 ) {
				System.out.println("TOO HIGH");
			}
			else {
				System.out.println("LITTLE HIGH");
			}
		}
		else if ( noOfGuesses < 10 && userInput < systemInput ) {
			if ( systemInput - userInput > 10 ) {
				System.out.println("TOO LOW");
			}
			else {
				System.out.println("LITTLE LOW");
			}
		}
		return false;
	}
}


public class guessingnumber {
	
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("CHOOSE ANY NUMBER BETWEEN 1 TO" + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("ENTER ONLY INTEGER VALUE....");
				flag = false;
			}
		};
		return input;
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("1. START THE GAME \n2. EXIT");
		System.out.print("ENTER YOUR CHOICE : ");
		int choice = takeIntegerInput(2);
		int nextRound = 1;
		int noOfRound = 0;
		
		if ( choice == 1 ) {
			
			
			while ( nextRound == 1 ) {
				
				Game game = new Game();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.println("\nROUND" + ++noOfRound + " STARTS...");
				
				
				while ( !isMatched && !isLimitCross) {
					isLimitCross = game.takeUserInput();
					isMatched = game.isCorrectGuess();
				}
				
				System.out.println("1. NEXT ROUND\n2. EXIT");
				System.out.println("ENTER YOUR CHOICE: ");
				nextRound = takeIntegerInput(2);
				if ( nextRound != 1 ) {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}
