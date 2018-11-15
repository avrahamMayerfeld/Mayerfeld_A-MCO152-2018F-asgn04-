package gamblegamble;

public class TestRandomValueGenerator implements IRandomValueGenerator {
    double randomValue;
    
    public TestRandomValueGenerator() {
    	 randomValue = 0.00;
    }
   
    public void setRandomNum(double val) {
		randomValue = val;
	}
	
	@Override
	public double getRandomNum() {
		return randomValue;
	}

	@Override
	public double getRandomNumInRange(int min, int max) {
		 return (randomValue * ( (max-min) + 1)  + min);
	}

	
	@Override
	public boolean getHitProbability(double p) {
		return randomValue <= p;
	}

	
	

	
	
}
