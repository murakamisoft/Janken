package main;

/**
 * ハンド
 */
public class Hand {
	enum handtype {
		goo, choki, pa;
	}

	public handtype getRandomHand() {
		return handtype.goo;
	}
}
