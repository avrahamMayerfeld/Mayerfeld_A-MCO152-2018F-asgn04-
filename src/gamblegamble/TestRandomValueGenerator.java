package gamblegamble;

public class TestRandomValueGenerator implements IRandomValueGenerator {
    int randomValue;
    
    public void setRandommNum(int val) {
		randomValue = val;
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
