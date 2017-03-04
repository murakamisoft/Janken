package game;

import game.Hand.handType;

/**
 * プレイヤー
 */
public class Player {

	/**
	 * ハンド
	 */
	private handType handtype;

	/**
	 * ハンドタイプを設定する
	 *
	 * @param hand
	 */
	public void setHandType(handType hand) {
		this.handtype = hand;
	}

	/**
	 * ランダムなハンドタイプを設定する
	 */
	public void setRandomHandType() {
		// TODO
		this.handtype = Hand.handType.goo;

	}

	/**
	 * ハンドタイプを取得する
	 *
	 * @return
	 */
	public handType getHandKind() {
		return this.handtype;
	}

	/**
	 * 手の文字を取得する
	 *
	 * @return
	 */
	public String getHandString() {
		if (this.handtype.equals(Hand.handType.goo)) {
			return "グー";
		}
		if (this.handtype.equals(Hand.handType.paa)) {
			return "パー";
		}
		if (this.handtype.equals(Hand.handType.choki)) {
			return "チョキ";
		}
		return null;
	}
}
