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
		assertTrue(better0_N1.canBet(101));
		assertFalse(better0_N1.canBet(-5));
	}
	
	@Test  //randomValue * (max-min + 1)  + min: amountChanged==(max-min)*amount , balance
	public void testBetOnANumberWin_1() {
		
		assertEquals(better2Dec_0.betOnANumber(20, 1, 100, 26),1980);
		assertEquals(better2Dec_0.betOnANumber(60, 2, 100, 26), 5880);
		assertEquals(better2Dec_0.betOnANumber(67, 3, 11, 5), 536);
		assertEquals(better2Dec_0.getCurrentBalance(),8496);
        //merely for testing purposes, not realistic
		assertEquals(better1_0.betOnANumber(50, 0, 100, 101),5000);
		//minimumBalance is negative 1
		assertEquals(better0_N1.betOnANumber(101, 2, 30, 2),2828);
		assertEquals(better9Dec_N1.betOnANumber(75, 6, 1000, 991), 74550);
		assertEquals(better9Dec_0.betOnANumber(80, 0, 12, 12), 960);
		//corner case, Math.random gives no negative generation(nor does the better allow negative values-see below)
	    assertEquals(betterND1_0.betOnANumber(20, 10, 70, -10), 1200);
	   
	}
	
	@Test
	public void testBetOnANumberLose() {
		//number out of range
		assertEquals(better0_0.betOnANumber(20, 4, 10, 1),-20);
		assertEquals(better1_N1.betOnANumber(34, 4, 14, 13),-34);    
		assertEquals(better9Dec_0.betOnANumber(70, 80, 101, 90 ),-70);
		assertEquals(better9Dec_0.getCurrentBalance(),30);
		}
	
	@Test
	public void testBetOnANumberWithNegativeMinReturn0() {
		//test win
		assertEquals(better2Dec_0.betOnANumber(50, -5, 14, 5),0);
		//test lose
		assertEquals(better2Dec_0.betOnANumber(50, -5, 14, 8),0);
		assertEquals(better1_0.betOnANumber(50, -10, 10, 21 ),0);
		assertEquals(betterND1_N1.betOnANumber(97, -7, -2, 1),0);
		assertEquals(betterND1_0.betOnANumber(72,-1000,0,669),0);
		assertEquals(betterND1_0.getCurrentBalance(),100);
	}
	
	@Test
	public void cantBetOnNumberReturn0() {
		//same test as when works, with too high bet
		assertEquals(better2Dec_0.betOnANumber(101, 1, 100, 26),0);
		assertEquals(better2Dec_0.betOnANumber(102, 2, 100, 26),0);
		assertEquals(better2Dec_0.betOnANumber(103, 3, 11, 5),0);
		assertEquals(better2Dec_0.getCurrentBalance(),100);
        assertEquals(better1_0.betOnANumber(101, 0, 100, 101),0);
		assertEquals(better0_N1.betOnANumber(102, 2, 30, 2),0);
		assertEquals(better9Dec_N1.betOnANumber(103, 6, 1000, 991),0);
		assertEquals(better9Dec_0.betOnANumber(101, 0, 12, 12),0);
		assertEquals(betterND1_0.betOnANumber(107, 10, 70, -10),0);
	   
	}

	@Test
	public void cantBetOnProbReturn0() {
	
	}
	
	
	
	
	
	@Test
	public void testBetOnProbWin() {
		
	}
	
	@Test
	public void testBetOnProbLose() {

	}
	
	@Test
	public void testBet100PercentOrMoreProbException() {
		
	}
	
	@Test
	public void testBetNEGATIVEProbException() {
		
	}

	@Test
	public void testBetZEROPercentProbLose() {
		
	}
	
	
	@Test
	public void TestgenMinGreaterThanMaxException(){
	
	}
	
	
}

