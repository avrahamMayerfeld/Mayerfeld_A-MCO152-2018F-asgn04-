package gamblegamble;

public interface IRandomValueGenerator {

	

	public int getRandomNum();
	public int getRandomNumInRange(int min, int max);
	public boolean getHitProbability(double p);

}
