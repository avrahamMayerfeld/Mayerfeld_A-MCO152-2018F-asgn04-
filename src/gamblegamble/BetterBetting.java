package gamblegamble;

public class BetterBetting {
	
	private int balance=0;
    private int minBalance=0;
	private IRandomValueGenerator randGen;
    
	public BetterBetting(int minBalance, IRandomValueGenerator randGen) {
		this.randGen = randGen;
		
		if(minBalance < 0) {
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
		int randomNumber= (int) randGen.getRandomNumInRange(min, max);
		
		if (canBet(amnt)) {
			if ( !(selectedNumber == randomNumber) ) {
				amountChanged = -amnt;
				balance -= amnt;
			}
			else {
				amountChanged = ((max - min) * amnt) ;
				balance += amountChanged;
			}
		}
		return amountChanged;
	}
	
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

	public int getMinBalance() {
		return minBalance;
	}
	
}
