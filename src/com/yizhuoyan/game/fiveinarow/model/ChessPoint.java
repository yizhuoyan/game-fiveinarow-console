package com.yizhuoyan.game.fiveinarow.model;

/**
 * 棋盘的点
 * @author Administrator
 *
 */
public class ChessPoint {
	/**
	 * 坐标
	 */
	public final int x,y;
	/**
	 * 点上的棋子
	 */
	private ChessPieces pieces;
	
	public ChessPoint(int x,int y) {
		this.x=x;
		this.y=y;
	}
	/**
	 * 返回此位置上是否有指定颜色的棋子
	 * @param color
	 * @return
	 */
	public boolean hasColor(int color) {
		if(this.pieces==null) {
			return false;
		}
		return this.pieces.sameColor(color);
	}

	

	public ChessPieces getPieces() {
		return pieces;
	}



	public void setPieces(ChessPieces pieces) {
		this.pieces = pieces;
	}



	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void paint() {
		if(this.pieces==null) {
			System.out.print("╋");
		}else {
			this.pieces.paint();
		}
	}
	
	
	
}
