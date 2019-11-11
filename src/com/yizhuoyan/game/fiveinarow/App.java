package com.yizhuoyan.game.fiveinarow;

import com.yizhuoyan.game.fiveinarow.model.AIPlayer;
import com.yizhuoyan.game.fiveinarow.model.Game;
import com.yizhuoyan.game.fiveinarow.model.HumanPlayer;

public class App {

	/**
	 * 1 有哪些对象参与?
	 * 		人类玩家 电脑玩家  棋盘  棋子 游戏控制类
	 * 2封装这些对象对应的类
	 * 		分析要封装的类的特性和行为 
	 * 3游戏流程
	 * 		 在game的start方法中编写主要流程
	 */
	public static void main(String[] args) {
		
		Game game=new Game();
		
		game.setPlayerBlack(new AIPlayer());
		game.setPlayerWhite(new AIPlayer());
		game.start();
		
	}
}
