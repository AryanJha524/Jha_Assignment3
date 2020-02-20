import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	private static Scanner scanner = new Scanner(System.in);
	private static SecureRandom rand = new SecureRandom();
	private static int numq = 10;
	
	public static void quiz()
	{
		int qtype = readProblemType();
		int difficulty = readDifficulty();
		int correctResponse = 0;
		for(int i = 0; i<numq; i++)
		{
			 double correct_answer = askQuestion(difficulty, qtype);
			 double user_answer = readResponse();
			 correctResponse += isAnswerCorrect(correct_answer, user_answer);
			
		}
		
		 double percentage = (correctResponse*1.0/numq)*100;
		 displayCompletionMessage(percentage);
		
	
	}
	
	
	public static double generateQuestionArgument(int x) {
		if(x == 1)
		{
			double rand_int = rand.nextInt(10);
			return rand_int;
		}
		else if (x == 2)
		{
			double rand_int = rand.nextInt(100);
			return rand_int;
		}
		else if (x == 3)
		{
			double rand_int = rand.nextInt(1000);
			return rand_int;
		}
		else if (x == 4)
		{
			double rand_int = rand.nextInt(10000);
			return rand_int;
		}
		return 0;
	}
	
	
	public static int readProblemType() {
		System.out.println("1. Addition");
		System.out.println("2. Multiplication");
		System.out.println("3. Subtraction");
		System.out.println("4. Division");
		System.out.println("5. Mixed");
		System.out.println("What type of problem do you want to solve? (1-5)");
		int userInput = scanner.nextInt();
		return userInput;
	}
	
	
	public static int readDifficulty() {
		System.out.println("What difficulty would you like to enter? (1-4)");
		int userInput = scanner.nextInt();
		if (userInput<0 || userInput>4)
		{
			System.out.print("Invalid input");
			System.exit(0);
			return 0;
		}
		else	
			return userInput;
	}
	
	
	public static double askQuestion(int difficulty, int qtype)
	{
		double rand_int1 = generateQuestionArgument(difficulty);
		double rand_int2 = generateQuestionArgument(difficulty);
		char operators[] = {'+', '-', '/', '*'}; //list to choose a random operator from
		if(qtype == 1)
		{
			System.out.printf("What is %.0f + %.0f\n", rand_int1, rand_int2);
			return rand_int1+rand_int2;
		}
		else if (qtype == 2)
		{
			System.out.printf("What is %.0f * %.0f\n", rand_int1, rand_int2);
			return rand_int1*rand_int2;
		}
		else if (qtype == 3)
		{
			System.out.printf("What is %.0f - %.0f\n", rand_int1, rand_int2);
			return rand_int1-rand_int2;
		}
		else if (qtype == 4)
		{
			//check for integer division, and divide  by 0
			if(rand_int1 < rand_int2 || rand_int2 == 0)
			{
			while (rand_int2 == 0)
			{
				rand_int2 = generateQuestionArgument(difficulty);
			}
			
			}
		System.out.printf("What is %.0f / %.0f\n", rand_int1, rand_int2);
		return rand_int1/rand_int2;
		}
		else if (qtype == 5)
		{
			int ind = rand.nextInt(4);
			if (operators[ind] == '+')
			{
				System.out.printf("What is %.0f %c %.0f\n", rand_int1, operators[ind] ,rand_int2);
				return rand_int1+rand_int2;
			}
			else if (operators[ind] == '*')
			{
				System.out.printf("What is %.0f %c %.0f\n", rand_int1, operators[ind] ,rand_int2);
				return rand_int1*rand_int2;
			}
			else if (operators[ind] == '-')
			{
				System.out.printf("What is %.0f %c %.0f\n", rand_int1, operators[ind] ,rand_int2);
				return rand_int1-rand_int2;
			}
			else if (operators[ind] == '/')
			{
				
				//check for integer division, and divide  by 0
				if(rand_int1 < rand_int2 || rand_int2 == 0)
				{
				while (rand_int2 == 0)
				{
					rand_int2 = generateQuestionArgument(difficulty);
				}
				
				}
			System.out.printf("What is %.0f %c %.0f\n", rand_int1, operators[ind] ,rand_int2);
			return rand_int1/rand_int2;
			}
		}
		return 0;
	}
	
	
	public static double readResponse()
	{
		double userInput = scanner.nextDouble();
		return userInput;
	}
	
	
	public static int isAnswerCorrect(double canswer, double uanswer)
	{
		
		if (Math.abs(canswer - uanswer) < 0.01)
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
