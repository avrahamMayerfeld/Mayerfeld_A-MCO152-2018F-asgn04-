package gamblegamble;

public class RandomValueGenerator implements IRandomValueGenerator{
	
	double randomValue;
	
	
	public RandomValueGenerator() {
		randomValue =  Math.random();
	}
	
	@Override
	public double getRandomNum() {
		
		return randomValue;
	}

	@Override
	public double getRandomNumInRange(int min, int max) {
		double randomInRange=0;
		if(min <= max)
			randomInRange=(randomValue * ( (max-min) + 1)  + min);
		else
			try {
				throw new Exception();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
 		return randomInRange;
	}

	@Override 
	public boolean getHitProbability(double p) {
		
		return randomValue <= p;
	}

	
	

}
