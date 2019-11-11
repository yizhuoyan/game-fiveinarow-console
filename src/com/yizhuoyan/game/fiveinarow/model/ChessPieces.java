package com.yizhuoyan.game.fiveinarow.model;

/**
 * 一颗棋子
 * 
 * @author Administrator
 *
 */
public class ChessPieces {
	public static final int WHITE_CHESS = 1, BLACK_CHESS = 0;
	/**
	 * 0=黑色 1=白色
	 */
	private final int color;

	/**
	 * 坐标
	 */
	public final int x, y;

	public ChessPieces(int color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	

	public int getY() {
		return y;
	}

	

	public int getColor() {
		return color;
	}

	public boolean sameColor(int color) {
		return this.color == color;
	}
	public boolean isWhite() {
		return this.color==WHITE_CHESS;
	}
	public boolean isBlack() {
		return this.color==WHITE_CHESS;
	}

	public void paint() {
		if (this.color == WHITE_CHESS) {
			System.out.print("○");
		} else {
			System.out.print("●");
		}
	}

}
