package main;

/**
 * スコア管理
 */
public class Score {

	/**
	 * コンストラクタ
	 */
	public Score() {
		this.win = 0;
		this.lose = 0;
		this.drow = 0;
	}

	/**
	 * 勝ち
	 */
	public int win;

	/**
	 * 負け
	 */
	public int lose;

	/**
	 * 引き分け
	 */
	public int drow;

	/**
	 * 勝ちを加算
	 */
	public void addWin() {
		this.win++;
	}

	/**
	 * 負けを加算
	 */
	public void addLose() {
		this.lose++;
	}

	/**
	 * 引き分けを加算
	 */
	public void addDrow() {
		this.drow++;
	}

	/**
	 * 描画
	 */
	public void draw() {
		System.out.println("勝ち：\t" + this.win);
		System.out.println("負け：\t" + this.lose);
		System.out.println("引き分け：\t" + this.drow);

	}
}
