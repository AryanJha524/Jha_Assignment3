
public class SavingsAccount {
	
	//setting the class variables
	private static double annualInterestRate = 0.0;
	private double savingsBalance;
	
	public void calculateMonthlyInterestRate()
	{
		this.setSavingsBalance(this.getSavingsBalance() + (savingsBalance*annualInterestRate/12));
		
	}
	
	public static void modifyInterestRate(double newRate)
	{
		//adjusting interestRate value for the class is static
		//because interest rate applies to all instances of the class.
		//and doesn't require an account to be modified. 
		newRate = newRate / 100;
		annualInterestRate = newRate;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		//have to use this keyword to change value of savingsBalance of the instance
		//that called this method. 
		this.savingsBalance = savingsBalance;
	}
	

	
}
