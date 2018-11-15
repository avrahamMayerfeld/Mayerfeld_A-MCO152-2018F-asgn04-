package gamblegamble;

public class BetterBetting {
	
	private int balance=0;
    private int minBalance=0;
	private IRandomValueGenerator randGen;
    
	public BetterBetting(int minBalance, IRandomValueGenerator randGen) {
		this.randGen = randGen;
		
		if(minBalance <= 0) {
			this.minBalance = minBalance;
		}
		
	}
	
	public int getCurrentBalance() {
		return balance;
	}
	
	public boolean canBet(int amnt) {
		boolean canBet = false;
		if( (amnt>0) && (balance >= (minBalance + amnt)) )
		canBet = true;
			return canBet; 
	}
	
	public void addMoney(int amnt) {
		if (amnt >= 0)
		balance += amnt;
	}
	
	public int betOnANumber(int amnt, int min, int max, int selectedNumber) {
		int amountChanged = 0;
		int randomNumber = randGen.getRandomNumInRange(min, max);
		//eliminate range of 1; eliminate negative min, did not write functionality for that because
		// it would cause the winnings to be unfairly inflated, by subtracting a negative.
		if(max>min && min>=0) {
			if (canBet(amnt)) {
				if (selectedNumber == randomNumber) {
					amountChanged = (max - min) * amnt;
					balance += amountChanged;
				}
				else {
					amountChanged = -amnt;
					balance -= amnt;
				}
			}
			else {
				System.out.println("You cannot bet that amount with your balance.");
			}
		}
		else {
			System.out.println("You can only bet on a positive range numbers where max > min");
		}
		return amountChanged;
	}
	
	//100% is not allowed, you shouldn't be allowed make a bet like that. But 0% is allowed, You have a right to 
	//throw away your money.
	public int betOnProbability(int amnt, double p)
	{
		int amountChanged = 0;
		if(canBet(amnt)) 
		{
			if(!(p<0 || p>=1)) 
			{
				if(!randGen.getHitProbability(p))
				{
					amountChanged = -amnt;
					balance -= amnt;
				}
				else
				{
					amountChanged =   (int) (Math.pow(p, -1)-1) * amnt;
					balance += amountChanged;
				}
			}
			else 
			{
				try 
				{
					throw new ImpossibleProbabilityException("Probability cannot be 100 percent or greater or less than 0 percent.");
				} catch (ImpossibleProbabilityException e)
				{
				
					e.getMessage();
				}
			}
		
		}
		return amountChanged;
	}
    
	//for testing purposes
	public int getMinBalance() {
		return minBalance;
	}
	
	public IRandomValueGenerator getRandomGenerator() {
		return randGen;
	}
	
}
