package test;

public class TennisGame {
	private int scorePlayer1;
	private int scorePlayer2;
	public static final String tabScores[] = { "love", "fifteen", "thirty", "forty" };

	public TennisGame() {
		this.scorePlayer1 = 0;
		this.scorePlayer2 = 0;
	}

	public String currentScore() {
		if (this.player1Won())
			return "game for player1";
		if (this.player2Won())
			return "game for player2";
		if (this.gameThatLastsALongTime())
			return this.DeuceOrAdvantage();
		return tabScores[this.scorePlayer1] + " - " + tabScores[this.scorePlayer2];
	}

	private String DeuceOrAdvantage() {
		if (this.scorePlayer1 == this.scorePlayer2)
			return "deuce";
		else if (this.scorePlayer1 > this.scorePlayer2)
			return ("advantage for player1");
		else
			return ("advantage for player2");
	}

	private boolean gameThatLastsALongTime() {
		return (this.scorePlayer1 >= 3 && this.scorePlayer2 >= 3);
	}

	private boolean player1Won() {
		return playerWon(this.scorePlayer1, this.scorePlayer2);
	}

	private boolean player2Won() {
		return playerWon(this.scorePlayer2, this.scorePlayer1);
	}

	private boolean playerWon(int score1, int score2) {
		return (score1 >= 4 && score1 - score2 >= 2);
	}

	public void player1Scores() throws Exception {
		if (player1Won() || player2Won())
			throw new Exception();
		this.scorePlayer1 += 1;
	}

	public void player2Scores() throws Exception {
		if (player1Won() || player2Won())
			throw new Exception();
		this.scorePlayer2 += 1;
	}
}