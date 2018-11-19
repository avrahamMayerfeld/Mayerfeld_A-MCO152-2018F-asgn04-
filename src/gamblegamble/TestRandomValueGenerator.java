package gamblegamble;

import java.security.InvalidParameterException;

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
		int randomInRange=0;
		if(min <= max)
			randomInRange=(int) (randomValue * (max-min + 1)  + min);
		else {
			
				throw new InvalidParameterException("min cannot be greater than max");
		}
 		return randomInRange;
	}

	
	@Override
	public boolean getHitProbability(double p) {
		return randomValue <= p;
	}

	
	

	
	
}
