import java.security.SecureRandom;
import java.util.Scanner;


public class CAI2 {
	
	private static Scanner scanner = new Scanner(System.in);
	private static SecureRandom rand = new SecureRandom();
	
	
	public static void  quiz()
	{
		 int correct_answer = askQuestion();
		 int user_answer = readResponse();
		 isAnswerCorrect(correct_answer, user_answer);
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
	
	public static void isAnswerCorrect(int canswer, int uanswer)
	{
		if (canswer == uanswer)
		{
			displayCorrectResponse();
		}
		else
			displayIncorrectResponse();
		
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
	
	
	
	
	

	public static void main(String[] args) {
		quiz();

	}

}
