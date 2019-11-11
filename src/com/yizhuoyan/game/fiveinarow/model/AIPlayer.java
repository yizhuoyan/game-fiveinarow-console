package com.yizhuoyan.game.fiveinarow.model;

import com.yizhuoyan.util.RandomUtil;

public class AIPlayer extends AbstractPlayer {

	@Override
	public ChessPieces move(ChessBoard board) {
		// 1 获取用户下子的坐标
		int x = RandomUtil.randomMinMax(0,board.getWidth());
		int y = RandomUtil.randomMinMax(0,board.getWidth());

		// 1.1 x和y对应的点没有放置棋子
		if (board.isExistAt(x, y)) {
			// 重新放子
			return move(board);
		}
		// 2 修改棋盘内部数组
		return board.setChessPiecesAt(x, y, this.getColor());

	}
}
