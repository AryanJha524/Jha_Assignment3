import java.security.SecureRandom;
import java.util.Scanner; 

public class CAI1 {
	
	private static Scanner scanner = new Scanner(System.in);
	public static void  quiz()
	{
		//logic is to ask question (return the right answer) and compare with user answer
		 int correct_answer = askQuestion(); 
		 int user_answer = readResponse();
		 isAnswerCorrect(correct_answer, user_answer);
	}
	
	public static int askQuestion()
	{
		SecureRandom rand = new SecureRandom();
		int rand_int1 = rand.nextInt(10);
		int rand_int2 = rand.nextInt(10);
		//asks the question to the user
		System.out.printf("What is %d + %d\n", rand_int1, rand_int2);
		return rand_int1+rand_int2;
		
		
	}
	
	public static int readResponse()
	{
		//take in the user input
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
		System.out.println("Very Good!");
	}
	
	public static void displayIncorrectResponse()
	{
		System.out.println("No. Please Try Again.");
	}
	
	
	
	public static void main(String[] args) 
	{
		quiz();
	}
	
}
