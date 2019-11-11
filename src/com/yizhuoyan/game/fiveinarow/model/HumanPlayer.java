package com.yizhuoyan.game.fiveinarow.model;

import com.yizhuoyan.util.ConsoleUtil;

/**
 * 人类玩家
 * @author Administrator
 *
 */
public class HumanPlayer extends AbstractPlayer{

	@Override
	public ChessPieces move(ChessBoard board) {
		//1 获取用户下子的坐标
		int x=getX(board.getWidth());
		int y=getY(board.getWidth());
		
		//1.1 x和y对应的点没有放置棋子
		if(board.isExistAt(x, y)) {
			System.out.println("对应位置已有棋子，请重新放置");
			//重新放子
			return move(board);
		}
		//2 修改棋盘内部数组  
		return board.setChessPiecesAt(x, y, this.getColor());
		
		
		
	}
	/**
	 * 获取玩家的x坐标
	 * 保证x不越界 
	 * @return
	 */
	private int getX(int maxX) {
		while(true) {
			int x=ConsoleUtil.readPositiveInt("请输入行x坐标(1-"+maxX+")");
			////数组下标从0开始，用户的坐标从1开始
			x-=1;
			if(x>maxX) {
				System.out.println("输出错误，超出x范围");
				continue; 
			}else {
				return x;
			}
		}
	}
	
	private int getY(int maxY) {
		while(true) {
			int y=ConsoleUtil.readPositiveInt("请输入列y坐标(1-"+maxY+")");
			//数组下标从0开始，用户的坐标从1开始
			y-=1;
			if(y>maxY) {
				System.out.println("输出错误，超出y范围");
				continue; 
			}else {
				return y;
			}
		}
	}
}
