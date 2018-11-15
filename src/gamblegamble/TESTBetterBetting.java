package gamblegamble;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TESTBetterBetting {
	
	TestRandomValueGenerator testGen1 = new TestRandomValueGenerator();
	TestRandomValueGenerator testGen2 = new TestRandomValueGenerator();
	TestRandomValueGenerator testGen3 = new TestRandomValueGenerator();
	TestRandomValueGenerator testGen4 = new TestRandomValueGenerator();
	TestRandomValueGenerator testGen5 = new TestRandomValueGenerator();
	TestRandomValueGenerator testGen6 = new TestRandomValueGenerator();
	
	BetterBetting 
	 better0_0    ,
	 better0_N1   ,              
	 better1_0    ,
	 better1_N1   ,
	 better2Dec_0 ,
	 better2Dec_N1,
	 betterND1_0  ,
	 betterND1_N1 , 
	 better9Dec_0 ,
     better9Dec_N1;
     
   	BetterBetting  better0_1, better1_1, betterN1_1; 
	
	@BeforeEach
	public void generateR_B(){
		testGen1.setRandomNum(0.00);
		better0_0 = new BetterBetting(0,testGen1);
		better0_N1 = new BetterBetting(-1,testGen1);
		better0_0.addMoney(100);
	    better0_N1.addMoney(100);
		
		testGen2.setRandomNum(1.00);
	    better1_0 = new BetterBetting(0,testGen2);
		better1_N1 = new BetterBetting(-1,testGen2);
		better1_0.addMoney(100);
	    better1_N1.addMoney(100);
	    
		testGen3.setRandomNum(0.25);
		better2Dec_0 = new BetterBetting(0,testGen3);
		better2Dec_N1 = new BetterBetting(-1,testGen3);
		better2Dec_0.addMoney(100);
		better2Dec_N1.addMoney(100);
	    
	    testGen4.setRandomNum(-0.33);
	    betterND1_0 = new BetterBetting(0,testGen4);
		betterND1_N1 = new BetterBetting(-1,testGen4);
		betterND1_0.addMoney(100);
	    betterND1_N1.addMoney(100);
		
	    testGen5.setRandomNum(0.99);
        better9Dec_0 = new BetterBetting(0,testGen5);
        better9Dec_N1 = new BetterBetting(-1,testGen5);
        better9Dec_0.addMoney(100);
        better9Dec_N1.addMoney(100);
        

	}      
	
	@Test
	public void checkMinZeroOrNegativeNotPositive() {
		
	better0_1 = new BetterBetting(1,testGen6);	
	better1_1 = new BetterBetting(1,testGen6);
	betterN1_1 = new BetterBetting(1,testGen6);
	assertEquals(better0_1.getMinBalance(), 0);
	assertEquals(better1_1.getMinBalance(), 0);
	assertEquals(betterN1_1.getMinBalance(), 0);
	assertEquals(better2Dec_N1.getMinBalance(), -1);
	assertEquals(better2Dec_0.getMinBalance(), 0);
	
	}
	  
	 
	
	
	@Test	
	public void testAddMoneyGetBalance() {
		 
		 assertEquals(better0_0.getCurrentBalance(),100);
		 assertEquals(better0_N1.getCurrentBalance(),100);       
		 assertEquals(better1_0.getCurrentBalance(),100);
		 assertEquals(better1_N1.getCurrentBalance(),100);    
		 assertEquals(better2Dec_0.getCurrentBalance(),100);
		 assertEquals(better2Dec_N1.getCurrentBalance(),100);
		 assertEquals(betterND1_0.getCurrentBalance(),100);
		 assertEquals(betterND1_N1.getCurrentBalance(),100);
		 assertEquals(better9Dec_0.getCurrentBalance(),100);
		 assertEquals(better9Dec_N1.getCurrentBalance(),100);
		 
	}       
	
    @Test  //Test that no negatives can be added to balance manually
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
	
	@Test  //randomValue * (max-min + 1)  + min: amountChanged==(max-min)*amount , balance
	public void testBetOnANumberWin_1() {
		
		assertEquals(better2Dec_0.betOnANumber(20, 1, 100, 26),1980);
		assertEquals(better2Dec_0.betOnANumber(60, 2, 100, 26), 5880);
		assertEquals(better2Dec_0.betOnANumber(67, 3, 11, 5), 536);
		assertEquals(better2Dec_0.getCurrentBalance(),8496);
        
		//assertEquals(better2Dec_0.getCurrentBalance(),6416);
		//merely for testing purposes, not realistic
		assertEquals(better1_0.betOnANumber(50, 0, 100, 101),5000);
		
		
		assertEquals(better0_N1.betOnANumber(101, 2, 30, 2),2828 );
		assertEquals(better9Dec_N1.betOnANumber(75, 6, 1000, 991), 74550  );
		assertEquals(better9Dec_0.betOnANumber(80, 0, 12, 12), 960  );
		
		//corner case, Math.random gives no negative generation(nor does the better allow negative values-see below)
	    assertEquals(betterND1_0.betOnANumber(20, 10, 70, -10), 1200);
	   
	}
	
	/*@Test
	public void testBetOnANumberLose() {
		assertNotEquals(better0_0.betOnANumber(20, 4, 10, 8),8)
		asssertNOtEquals    all of them with wrong number
		assert not equals getbalance same numbers
	}
	@Test
	public void testBetOnANumberWithNegativeMinReturn0() {
		
	}
	
	@Test
	public void cantBetOnNumber() {
		//amountChenged, balance
		better0_0    ,
		 better0_N1   ,              
		 better1_0    ,
		 better1_N1   ,
		 better2Dec_0 ,
		 better2Dec_N1,
		 betterND1_0  ,
		 betterND1_N1 , 
		 better9Dec_0 ,
	     better9Dec_N1;
	}
	
	@Test
	public void cantBetOnProb() {
		int amountChanged;
		int balance;
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
	public void TestgenMinGreaterThanMaxException(){
	
	}
	
	
	*/
	
	    
	
}

