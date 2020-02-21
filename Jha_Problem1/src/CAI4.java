import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {
	private static Scanner scanner = new Scanner(System.in);
	private static SecureRandom rand = new SecureRandom();
	private static int numq = 10;
	
	public static void quiz()
	{
		int difficulty = readDifficulty(); //new function, changes the the size of 
		//the random integers that are generated. 
		int correctResponse = 0;
		for(int i = 0; i<numq; i++)
		{
			 int correct_answer = askQuestion(difficulty);
			 int user_answer = readResponse();
			 correctResponse += isAnswerCorrect(correct_answer, user_answer);
			
		}
		
		 double percentage = (correctResponse*1.0/numq)*100;
		 displayCompletionMessage(percentage);
		
	
	}
	
	public static int generateQuestionArgument(int x) {
		
		//depending on x (difficulty), the size of the random
		//integer will be increased or decreased. 
		if(x == 1)
		{
			int rand_int = rand.nextInt(10);
			return rand_int;
		}
		else if (x == 2)
		{
			int rand_int = rand.nextInt(100);
			return rand_int;
		}
		else if (x == 3)
		{
			int rand_int = rand.nextInt(1000);
			return rand_int;
		}
		else if (x == 4)
		{
			int rand_int = rand.nextInt(10000);
			return rand_int;
		}
		return 0;
	}

	public static int readDifficulty() {
		System.out.println("What difficulty would you like to enter? (1-4)");
		int userInput = scanner.nextInt();
		
		//invalid input checker, terminates program.  
		if (userInput<0 || userInput>4)
		{
			System.out.print("Invalid input");
			System.exit(0);
			return 0;
		}
		else	
			return userInput;
	}
	
	public static int askQuestion(int difficulty)
	{
		int rand_int1 = generateQuestionArgument(difficulty);
		int rand_int2 = generateQuestionArgument(difficulty);
		System.out.printf("What is %d * %d\n", rand_int1, rand_int2);
		return rand_int1*rand_int2;
		
	}
	public static int readResponse()
	{
		int userInput = scanner.nextInt();
		return userInput;
	}
	
	public static int isAnswerCorrect(int canswer, int uanswer)
	{
		
		if (canswer == uanswer)
		{
			displayCorrectResponse();
			return 1;
		}
		else if (canswer != uanswer)
		{
			displayIncorrectResponse();
			return 0;
		}
			
		return 0;
		
	}
	
	public static void displayCorrectResponse()
	{
				int choice = rand.nextInt(5);
				if(choice == 0)
				{
					choice += 1;
				}
				switch(choice) {
				case 1:
					System.out.println("Very Good!");
					break;
				case 2:
					System.out.println("Excellent!");
					break;
				case 3:
					System.out.println("Nice work!");
					break;
				case 4:
					System.out.println("Keep up the good work!");
					break;
				}
	
	}
	
	public static void displayIncorrectResponse()
	{
		int choice = rand.nextInt(5);
		if(choice == 0)
		{
			choice += 1;
		}
		switch(choice) {
		case 1:
			System.out.println("No. Please try again.");
			break;
		case 2:
			System.out.println("Wrong. Try once more.");
			break;
		case 3:
			System.out.println("Don’t give up!");
			break;
		case 4:
			System.out.println("No. Keep trying.");
			break;
		}
	}
	
	public static void displayCompletionMessage(double percentage)
	{
		System.out.println("Your score: " + percentage + "%");
		if(percentage < 75.0)
		{
			System.out.printf("Please ask your teacher for extra help.\n");
		}
		else if (percentage > 75.0)
		{
			System.out.printf( "Congratulations, you are ready to go to the next level!\n");
		}
		
	
			
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		quiz();

		String choice = "y";
		while (choice.equals("y"))
		{
			System.out.print("Would you like to solve another set? (y/n): ");
			choice = scanner.next();
			if (choice.equals("y"))
			{
				quiz();
			}
		}
		

	}

}
