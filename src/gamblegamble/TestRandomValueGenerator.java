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
	public int getRandomNumInRange(int min, int max) {
		 int r = (int) (randomValue * (max-min+1)  + min);
		 return r;
	}

	
	@Override
	public boolean getHitProbability(double p) {
		return randomValue <= p;
	}

	
	

	
	
}
