package gamblegamble;

public interface IRandomValueGenerator {

	

	public double getRandomNum();
	public double getRandomNumInRange(int min, int max);
	public boolean getHitProbability(double p);
	

}
