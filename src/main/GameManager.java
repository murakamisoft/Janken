package main;

import common.ErrorMessageUtil;
import common.ScanUtil;
import constant.Constant;

/**
 * ゲームマネージャー
 */
public class GameManager {

	/**
	 * プレイヤー
	 */
	public Player player = null;

	/**
	 * 敵
	 */
	public Player enemy = null;

	/**
	 * スコア
	 */
	public Score score = null;

	/**
	 * コンストラクタ
	 */
	public GameManager() {
		this.player = new Player();
		this.enemy = new Player();
		this.score = new Score();
	}

	/**
	 * 実行
	 */
	public void execute() {

		while (true) {

			Select title = getSelectTitleNum();
			// 終了
			if (title.isEnd()) {
				return;
			}

			// ジャンケン実施
			Select janken = playJanken();
			player.setHandType(janken.getHandType());
			enemy.setRandomHandType();

			Judger judger = new Judger(player, enemy);

			System.out.println("あなたの手：" + player.getHandString());
			System.out.println("相手の手：" + enemy.getHandString());

			// プレイヤーが勝ち
			if (judger.isPlayerWin()) {
				System.out.println("勝ちです！");
				this.score.addWin();
			}
			// プレイヤーの負け
			if (judger.isPlayerLose()) {
				System.out.println("負けです！");
				this.score.addLose();
			}
			// 引き分け
			if (judger.isDrow()) {
				System.out.println("引き分けです！");
				this.score.addDrow();
			}

			// スコアを描画
			this.score.draw();
		}
	}

	/**
	 * ジャンケンをプレイする
	 *
	 * @return
	 */
	private Select playJanken() {
		// 選択オブジェクト
		Select select = null;
		while (true) {
			drawJunken();
			select = new Select(ScanUtil.inputNum());

			// エラー
			if (select.isNotJanken()) {
				ErrorMessageUtil.printInputError();
			}
			break;

		}
		return select;
	}

	/**
	 * タイトルで選択した番号を取得する
	 *
	 * @return
	 */
	private Select getSelectTitleNum() {
		// 選択オブジェクト
		Select select = null;

		while (true) {
			drawTitle();
			select = new Select(ScanUtil.inputNum());

			// エラー
			if (select.isNotTitle()) {
				ErrorMessageUtil.printInputError();
			} else {
				break;
			}

		}
		return select;
	}

	/**
	 * タイトルを描画する
	 */
	private void drawTitle() {
		System.out.println("**************************************");
		System.out.println("*               Janken               *");
		System.out.println("**************************************");
		System.out.println();
		System.out.println(Constant.START + "：開始");
		System.out.println(Constant.END + "：終了");
		System.out.print(">>");
	}

	/**
	 * じゃんけんを描画する
	 */
	private void drawJunken() {
		System.out.println();
		System.out.println("あなたが出す手を選択してください。");
		System.out.println();
		System.out.println(Constant.GOO + "：グー");
		System.out.println(Constant.CHOKI + "：チョキ");
		System.out.println(Constant.PAA + "：パー");
		System.out.print(">>");
	}
}
