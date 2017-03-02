package main;

import constant.Constant;
import main.Hand.handType;

/**
 * 選択オブジェクト
 */
public class Select {

	/**
	 * 番号
	 */
	private int num;

	/**
	 * コンストラクタ
	 *
	 * @param num
	 */
	public Select(int num) {
		this.num = num;
	}

	/**
	 * 終了か
	 *
	 * @return
	 */
	public boolean isEnd() {
		return Constant.END == this.num;
	}

	/**
	 * ハンドタイプを取得する
	 *
	 * @return
	 */
	public handType getHandType() {
		if (isGoo()) {
			return Hand.handType.goo;
		}
		if (isChoki()) {
			return Hand.handType.choki;
		}
		if (isPaa()) {
			return Hand.handType.paa;
		}
		return null;
	}

	/**
	 * グーか
	 *
	 * @return
	 */
	public boolean isGoo() {
		return Constant.GOO == this.num;
	}

	/**
	 * パーか
	 *
	 * @return
	 */
	public boolean isPaa() {
		return Constant.PAA == this.num;
	}

	/**
	 * チョキか
	 *
	 * @return
	 */
	public boolean isChoki() {
		return Constant.CHOKI == this.num;
	}

	/**
	 * ジャンケンゲームの選択肢でないか
	 *
	 * @return
	 */
	public boolean isNotJanken() {
		if (this.num == Constant.GOO) {
			return false;
		}
		if (this.num == Constant.CHOKI) {
			return false;
		}
		if (this.num == Constant.PAA) {
			return false;
		}
		return true;
	}

	/**
	 * タイトルの選択肢でないか
	 * 
	 * @return
	 */
	public boolean isNotTitle() {
		if (this.num == Constant.START) {
			return false;
		}
		if (this.num == Constant.END) {
			return false;
		}
		return true;
	}
}
