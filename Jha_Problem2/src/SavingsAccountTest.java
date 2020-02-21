
public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount();
		SavingsAccount saver2 = new SavingsAccount();
		
		saver1.setSavingsBalance(2000.00);
		saver2.setSavingsBalance(3000.00);
		SavingsAccount.modifyInterestRate(4);
		
		for (int i = 0; i < 12; i++)
		{
			saver1.calculateMonthlyInterestRate();
			saver2.calculateMonthlyInterestRate();
			System.out.printf("Saver 1 Balance for Month %d: %.2f\n", i+1, saver1.getSavingsBalance());
			System.out.printf("Saver 2 Balance for Month %d: %.2f\n", i+1, saver2.getSavingsBalance());
		}
		
		//adjusting the interest rate
		SavingsAccount.modifyInterestRate(5);
			saver1.calculateMonthlyInterestRate();
			saver2.calculateMonthlyInterestRate();
			
			System.out.printf("Saver 1 New Balance for Month %d: %.2f\n", 13, saver1.getSavingsBalance());
			System.out.printf("Saver 2 New Balance for Month %d: %.2f\n", 13, saver2.getSavingsBalance());
		
	}

}
