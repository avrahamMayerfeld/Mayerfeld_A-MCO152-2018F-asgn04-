package gamblegamble;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TESTBetterBetting {
	
	TestRandomValueGenerator testGen = new TestRandomValueGenerator();
	
	BetterBetting 
	 better0_0   ,
	 better0_N1  ,              
	 better1_0   ,
	 better1_N1  ,
	 better2_0   ,
	 better2_N1  ,
	 betterN1_0  ,
	 betterN1_N1 , 
	 betterN2_0  ,
	 betterN2_N1 , 
     betterDec_0 ,
     betterDec_N1,
     betterNDec_0 ,
     betterNDec_N1;
     
	BetterBetting  better0_1, better1_1, betterN1_1; 
	
	
	@BeforeEach
	public void generateR_B(){
		testGen.setRandomNum(0);
		better0_0 = new BetterBetting(0,testGen);
		better0_N1 = new BetterBetting(-1,testGen);
		better0_0.addMoney(100);
	    better0_N1.addMoney(100);
		
		testGen.setRandomNum(0.1);
	    better1_0 = new BetterBetting(0,testGen);
		better1_N1 = new BetterBetting(-1,testGen);
		better1_0.addMoney(100);
	    better1_N1.addMoney(100);
	    
		testGen.setRandomNum(0.2);
		better2_0 = new BetterBetting(0,testGen);
		better2_N1 = new BetterBetting(-1,testGen);
		better2_0.addMoney(100);
	    better2_N1.addMoney(100);
	    
	    testGen.setRandomNum(-0.1)
	    betterN1_0 = new BetterBetting(0,testGen);
		betterN1_N1 = new BetterBetting(-1,testGen);
		betterN1_0.addMoney(100);
	    betterN1_N1.addMoney(100);
		
	    testGen.setRandomNum(-2);
	    betterN2_0 = new BetterBetting(0,testGen);
		betterN2_N1 = new BetterBetting(-1,testGen);
		betterN2_0.addMoney(100);
	    betterN2_N1.addMoney(100);

        testGen.setRandomNum(0.44);
        betterDec_0 = new BetterBetting(0,testGen);
        betterDec_N1 = new BetterBetting(-1,testGen);
        betterDec_0.addMoney(100);
        betterDec_N1.addMoney(100);
        

        testGen.setRandomNum(-0.44);
        betterNDec_0 = new BetterBetting(0,testGen);
        betterNDec_N1 = new BetterBetting(-1,testGen);
        betterNDec_0.addMoney(100);
        betterNDec_N1.addMoney(100);
        
	}      
	
	@Test
	public void checkMinZeroOrNegativeNotPositive() {
		
	better0_1 = new BetterBetting(1,testGen);	
	better1_1 = new BetterBetting(1,testGen);
	betterN1_1 = new BetterBetting(1,testGen);
	assertEquals(better0_1.getMinBalance(), 0);
	assertEquals(better1_1.getMinBalance(), 0);
	assertEquals(betterN1_1.getMinBalance(), 0);
	assertEquals(better2_N1.getMinBalance(), -1);
	assertEquals(better2_0.getMinBalance(), 0);
	
	}
	
	 
	
	
	@Test	
	public void testAddMoneyGetBalance() {
		 
		 assertEquals(better0_0.getCurrentBalance(),100);
		 assertEquals(better0_N1.getCurrentBalance(),100);       
		 assertEquals(better1_0.getCurrentBalance(),100);
		 assertEquals(better1_N1.getCurrentBalance(),100);
	     assertEquals(better2_0.getCurrentBalance(),100);
		 assertEquals(better2_N1.getCurrentBalance(),100);
		 assertEquals(betterN1_0.getCurrentBalance(),100);
		 assertEquals(betterN1_N1.getCurrentBalance(),100);
		 assertEquals(betterN2_0.getCurrentBalance(),100);
		 assertEquals(betterN2_N1.getCurrentBalance(),100);
		 assertEquals(betterDec_0.getCurrentBalance(),100);
		 assertEquals(betterDec_N1.getCurrentBalance(),100);
		
	 }
	
    @Test
    public void noAddingNegativeAmounts() {
    	better0_0.addMoney(-50);
    	better0_N1.addMoney(-50);
    	assertEquals(better0_0.getCurrentBalance(),100);
    	assertEquals(better0_N1.getCurrentBalance(),100);
    }
	
	
	@Test
	public void testCanBet() {
		assertTrue(better0_0.canBet(100));
		assertFalse(better0_0.canBet(101));
		assertFalse(better0_0.canBet(-5));
	}
	
	@Test   //(randomValue * ( (max-min) + 1)  + min)
	public void testBetOnANumberRandomIntWin() {
		int amountChanged;
		int balance;
		better1_0.betOnANumber(70, 4, 10, 5);
		better2_0.betOnANumber(70, 4, 10, 5);
		better2_0.betOnANumber(70, 4, 10, 5);
	}
	
	@Test
	public void testBetOnANumberWithNegativeInRangeWin() {
		int amountChanged;
		int balance;
		better0_0.betOnANumber(amnt, min, max, selectedNumber)
	}
	
	@Test
	public void cantBetOnNumber() {
		int amountChanged;
		int balance;
	}
	
	@Test
	public void cantBetOnProb() {
		int amountChanged;
		int balance;
	}
	
	@Test
	public void testBetOnANumberLose() {
		int amountChanged;
		int balance;
		better0_0.
	}
	
	
	
	@Test
	public void testBetOnProbWin() {
		int amountChanged;
		int balance;
		better0_0.
	}
	
	@Test
	public void testBetOnProbLose() {
		int amountChanged;
		int balance;
		better0_0.
	}
	
	@Test
	public void testBet100PercentOrMoreProbException() {
		int amountChanged;
		int balance;
		better0_0.
	}
	
	@Test
	public void testBetNEGATIVEProbException() {
		int amountChanged;
		int balance;
		better0_0.
	}

	@Test
	public void testBetZEROPercentProbLose() {
		int amountChanged;
		int balance;
		better0_0.
	}
	
	@Test
	public void minGreaterThanMaxException(){}
	
	
	
	
	    
	
}

