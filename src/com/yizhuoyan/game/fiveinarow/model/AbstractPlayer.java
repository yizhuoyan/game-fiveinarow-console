package com.yizhuoyan.game.fiveinarow.model;

import java.io.Serializable;

/**
 * 游戏的玩家
 * @author Administrator
 *
 */
public abstract class AbstractPlayer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WHITE_PLAYER=1;
	public static final int BLACK_PLAYER=0;
	/**
	 * 玩家执棋的颜色
	 */
	private int color;
	
	
	
	

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String formatColor() {
		return this.color==0?"黑方":"白方";
	}
	/**
	 * 下子
	 * 返回放置的棋子
	 */
	public abstract ChessPieces move(ChessBoard board);
	
	
}
