package com.yizhuoyan.game.fiveinarow.model;

/**
 * 游戏控制类
 * 
 * @author Administrator
 *
 */
public class Game {
	// 棋盘
	private final ChessBoard board;
	// 执黑棋的玩家
	private AbstractPlayer playerBlack;
	// 执白棋的玩家
	private AbstractPlayer playerWhite;

	public Game() {
		board = new ChessBoard(15);
	}

	public AbstractPlayer getPlayerBlack() {
		return playerBlack;
	}

	public void setPlayerBlack(AbstractPlayer playerBlack) {
		playerBlack.setColor(AbstractPlayer.BLACK_PLAYER);
		this.playerBlack = playerBlack;

	}

	public AbstractPlayer getPlayerWhite() {
		return playerWhite;
	}

	public void setPlayerWhite(AbstractPlayer playerWhite) {
		playerWhite.setColor(AbstractPlayer.WHITE_PLAYER);
		this.playerWhite = playerWhite;
	}

	public ChessBoard getBoard() {
		return board;
	}

	/**
	 * 游戏开始
	 */
	public void start() {
		// 1游戏说明
		paintWelcome();
		// 2检查 两个玩家是否准备好
		if (this.playerBlack == null || this.playerWhite == null) {
			System.out.println("游戏玩家未准备好，游戏无法开始");
			return;
		}
		// 3游戏回合开始
		// 3.1 绘制棋盘
		this.board.paint();

		AbstractPlayer winner = null;
		while (true) {

			// 3.2黑方下子并绘制棋盘
			ChessPieces p=this.playerBlack.move(this.board);
			// 1 棋盘满了
			if (board.isFull()) {
				// 平局 游戏结束
				break;
			}
			// 3.3 判断游戏是否结束
			if (isGameOver(p)) {
				winner = this.playerBlack;
				break;
			}

			// 3.4白方下子并绘制棋盘
			p=this.playerWhite.move(board);
			if (board.isFull()) {
				// 平局游戏结束
				break;
			}
			// 3.5 判断游戏是否结束
			if (isGameOver(p)) {
				winner = this.playerWhite;
				break;
			}

		}
		// 4显示输赢结果
		if (winner == null) {
			System.out.println("平局");
		} else {
			System.out.println("胜利者是:" + winner.formatColor());
		}
		// 5再见!
		System.out.println("再见!");
	}

	private void paintWelcome() {
		System.out.println("欢迎游戏五子棋!");
	}

	/**
	 * 根据color判断当前游戏是否需要结束
	 * 
	 * @param color
	 * @return
	 */
	private boolean isGameOver(ChessPieces p) {
		// 2 有一方五子连珠
		if (board.isFiveInALine(p.getColor(),p.getX(),p.getY())) {
			return true;
		}
		return false;
	}

}
