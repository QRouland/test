package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTennisGame {
	private TennisGame game;
	@Before
	public void setup() throws Exception{
		game = new TennisGame();
	}
	
	@After
	public void tearDown() throws Exception{
		game = null;
	}

	@Test
	public void testStartTest() {
		assertEquals(game.currentScore(),"love - love");
	}
	
	@Test
	public void testDeuce()  throws Exception {
		assertEquals(game.currentScore(), "love - love");
		game.player1Scores();
		game.player2Scores();
		assertEquals(game.currentScore(), "fifteen - fifteen");
		game.player1Scores();
		game.player2Scores();
		assertEquals(game.currentScore(), "thirty - thirty");
		game.player1Scores();
		game.player2Scores();
		
		
		for (int i = 0; i < 7; i++) {
			game.player2Scores();
			assertNotEquals(game.currentScore(),"deuce");			
			game.player1Scores();
			assertEquals(game.currentScore(),"deuce");
		}
	}
	
	@Test
	public void testScoreJoueur1()  throws Exception
	{
		assertEquals(game.currentScore(), "love - love");
		game.player1Scores();
		assertEquals(game.currentScore(), "fifteen - love");
		game.player1Scores();
		assertEquals(game.currentScore(), "thirty - love");
		game.player1Scores();
		assertEquals(game.currentScore(), "forty - love");
		game.player1Scores();
		assertEquals(game.currentScore(), "game for player1");
		
	}
	
	@Test
	public void testScoreJoueur2() throws Exception
	{	
		game = new TennisGame();
		assertEquals(game.currentScore(), "love - love");
		game.player2Scores();
		assertEquals(game.currentScore(), "love - fifteen");
		game.player2Scores();
		assertEquals(game.currentScore(), "love - thirty");
		game.player2Scores();
		assertEquals(game.currentScore(), "love - forty");
		game.player2Scores();
		assertEquals(game.currentScore(), "game for player2");
		
	}
	
	@Test
	public void testWinAdvantageJoueur1()  throws Exception
	{	
		for (int i = 0; i < 3; i++) {
			game.player1Scores();
			game.player2Scores();
		}
		assertEquals(game.currentScore(),"deuce");
		game.player1Scores();
		game.player1Scores();
		assertEquals(game.currentScore(), "game for player1");
		
	}
	
	@Test
	public void testWinAdvantageJoueur2()  throws Exception
	{	
		game = new TennisGame();
		for (int i = 0; i < 3; i++) {
			game.player1Scores();
			game.player2Scores();
		}
		assertEquals(game.currentScore(),"deuce");
		game.player2Scores();
		game.player2Scores();
		assertEquals(game.currentScore(), "game for player2");
		
	}
	
	@Test
	public void testAdvantage()  throws Exception
	{
		for (int i = 0; i < 3; i++) {
			game.player1Scores();
			game.player2Scores();
		}
		assertEquals(game.currentScore(),"deuce");
		game.player1Scores();
		assertEquals(game.currentScore(), "advantage for player1");
		game.player2Scores();
		game.player2Scores();
		assertEquals(game.currentScore(), "advantage for player2");
		
	}
	
	@Test
	public void testScoreAfterWin() throws Exception
	{
		assertEquals(game.currentScore(), "love - love");
		game.player1Scores();
		assertEquals(game.currentScore(), "fifteen - love");
		game.player1Scores();
		assertEquals(game.currentScore(), "thirty - love");
		game.player1Scores();
		assertEquals(game.currentScore(), "forty - love");
		game.player1Scores();
		assertEquals(game.currentScore(), "game for player1");
		try {
			game.player1Scores();
			fail("Marquer un point apres qu'un joueur est gagné devrait lever une exception");
		}catch(Exception e) {
			assertTrue(true);
		}
		
		
	}
	
	
}
