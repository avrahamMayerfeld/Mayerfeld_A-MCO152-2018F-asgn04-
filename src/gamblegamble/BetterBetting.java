package gamblegamble;

public class BetterBetting {
	private int balance=0;
    private int minBalance;
	private IRandomValueGenerator randGen;
    public BetterBetting(int minBalance, IRandomValueGenerator randGen) {
		this.minBalance = minBalance;
		this.randGen = randGen;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public boolean canBet(int amnt) {
		return balance >= (minBalance + amnt); 
	}
	
	public void addMoney(int amnt) {
		if (amnt > 0)
		balance += amnt;
	}
	
	public int betOnANumber(int amnt, int min, int max, int selectedNumber) {
		int amountChanged = 0;
		if (canBet(amnt)) {
			if ( !(selectedNumber == randGen.getRandomNumInRange(min, max)) ) {
				amountChanged = -amnt;
				balance -= amnt;
			}
			else {
				amountChanged = ((max - min) * amnt) ;
				balance += amountChanged;
			}
			
		
		}
		else {
			System.out.println("Your balance is too low for that bet.");
		}
		
		return amountChanged;
	}
	
	public int betOnProbability(int amnt, double p)
	{
		int amountChanged = 0;
		if(canBet(amnt)) 
		{
			if(!(p<0 || p>1)) 
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
					throw new ImpossibleProbabilityException("Probability cannot be greater than 0 or less than 1.");
				} catch (ImpossibleProbabilityException e)
				{
				
					e.getMessage();
				}
			}
		}
		else 
		{
			System.out.println("Your balance is too low for that bet.");
		}
		return amountChanged;
	}

		
}
