
public class SavingsAccount {
	private static double annualInterestRate = 0.05;
	private double savingsBalance;
	
	public void calculateMonthlyInterestRate()
	{
		this.setSavingsBalance(this.getSavingsBalance() + (savingsBalance*annualInterestRate/12));
		
	}
	
	public static void modifyInterestRate(double newRate)
	{
		newRate = newRate / 100;
		annualInterestRate = newRate;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	

	
}
