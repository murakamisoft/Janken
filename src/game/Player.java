package game;

import common.NumberUtil;
import constant.Constant;
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
		int i = NumberUtil.getRndNo(3);
		if (i == Constant.GOO) {
			this.handtype = Hand.handType.goo;
		} else if (i == Constant.PAA) {
			this.handtype = Hand.handType.paa;
		} else if (i == Constant.CHOKI) {
			this.handtype = Hand.handType.choki;
		} else {
			System.err.println("想定外の値です。乱数：" + i);
		}
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
