package gamblegamble;

public class RandomValueGenerator implements IRandomValueGenerator{
	
	int randomValue;
	
	
	public RandomValueGenerator() {
		randomValue = (int) Math.random();
	}
	
	@Override
	public int getRandomNum() {
		
		return randomValue;
	}

	@Override
	public int getRandomNumInRange(int min, int max) {
		return (randomValue * ( (max-min) + 1)  + min);
	}

	@Override 
	public boolean getHitProbability(double p) {
		
		return randomValue <= p;
	}

}
