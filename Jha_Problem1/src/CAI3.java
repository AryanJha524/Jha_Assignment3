import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {

	private static Scanner scanner = new Scanner(System.in);
	private static SecureRandom rand = new SecureRandom();
	private static int numq = 10;
	
	public static void  quiz()
	{
		int correctResponse = 0;
		for(int i = 0; i<numq; i++)
		{
			 int correct_answer = askQuestion();
			 int user_answer = readResponse();
			 correctResponse += isAnswerCorrect(correct_answer, user_answer);
			
		}
		
		 double percentage = (correctResponse*1.0/numq)*100;
		 displayCompletionMessage(percentage);
		
	
	}
	
	public static int askQuestion()
	{
		int rand_int1 = rand.nextInt(10);
		int rand_int2 = rand.nextInt(10);
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
			System.out.println("Please ask your teacher for extra help.");
		}
		else if (percentage > 75.0)
		{
			System.out.println( "Congratulations, you are ready to go to the next level!");
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
