package game;

import java.util.ArrayList;
import java.util.List;

import game.Hand.handType;

/**
 * 判定者
 */
public class Judger {

	/**
	 * ハンド種別リスト
	 */
	private List<HandKind> handKindList;

	/**
	 * ターゲットハンド種別
	 */
	private HandKind targetHandKind;

	/**
	 * プレイヤー
	 */
	private Player player;

	/**
	 * 敵
	 */
	private Player enemy;

	/**
	 * コンストラクタ
	 *
	 * @param player
	 * @param enemy
	 */
	public Judger(Player player, Player enemy) {
		this.player = player;
		this.enemy = enemy;
		this.handKindList = getHandKindList();
		this.targetHandKind = getTargetHandKind();
	}

	/**
	 * 対象となるハンド種別を取得する
	 *
	 * @return
	 */
	private HandKind getTargetHandKind() {
		for (HandKind h : this.handKindList) {
			if (h.key.equals(player.getHandKind())) {
				return h;
			}
		}
		return null;
	}

	/**
	 * ハンド種別リストを取得する
	 *
	 * @return
	 */
	private List<HandKind> getHandKindList() {
		List<HandKind> list = null;
		HandKind kind = null;

		list = new ArrayList<HandKind>();

		// グーの作成
		kind = new HandKind();
		kind.key = handType.goo;
		kind.win = handType.choki;
		kind.lose = handType.paa;
		list.add(kind);

		// チョキの作成
		kind = new HandKind();
		kind.key = handType.choki;
		kind.win = handType.paa;
		kind.lose = handType.goo;
		list.add(kind);

		// パーの作成
		kind = new HandKind();
		kind.key = handType.paa;
		kind.win = handType.goo;
		kind.lose = handType.choki;
		list.add(kind);

		return list;
	}

	/**
	 * プレイヤーが勝ちか
	 *
	 * @return
	 */
	public boolean isPlayerWin() {
		return this.targetHandKind.win.equals(enemy.getHandKind());
	}

	/**
	 * プレイヤーが負けか
	 *
	 * @return
	 */
	public boolean isPlayerLose() {
		return this.targetHandKind.lose.equals(enemy.getHandKind());
	}

	/**
	 * 引き分けか
	 *
	 * @return
	 */
	public boolean isDrow() {
		return this.targetHandKind.key.equals(enemy.getHandKind());
	}

}
