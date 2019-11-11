package com.yizhuoyan.game.fiveinarow.model;

/**
 * 棋盘
 * 
 * @author Administrator
 *
 */
public class ChessBoard {
	/**
	 * 棋盘高宽
	 */
	private final int width;
	/**
	 * 棋盘上的所有点
	 */
	private final ChessPoint[][] points;
	/**
	 * 前盘上已有棋子的数量
	 */
	private int piecesCount = 0;
	/**
	 * 前盘最大放置棋子数量
	 */
	final private int MAX_PIECES_COUNT;

	public int getPiecesCount() {
		return piecesCount;
	}

	public ChessPoint[][] getPoints() {
		return points;
	}

	public int getWidth() {
		return width;
	}

	public ChessBoard(int width) {
		this.width = width;
		MAX_PIECES_COUNT = this.width * this.width;
		this.points = new ChessPoint[this.width][this.width];
		// 初始化棋盘
		this.initPoints();

	}

	private void initPoints() {
		// 定义为局部变量，提供操作效率
		ChessPoint[][] ps = this.points;
		for (int x = 0; x < ps.length; x++) {
			for (int y = 0; y < ps[x].length; y++) {
				ps[y][x] = new ChessPoint(x, y);

			}
		}

	}

	/**
	 * 绘制自己
	 */
	public void paint() {
		System.out.println();
		System.out.println();
		ChessPoint[][] ps = this.points;
		for (int x = 0; x < ps.length; x++) {
			for (int y = 0; y < ps[x].length; y++) {
				ChessPoint p = ps[x][y];
				p.paint();
			}
			System.out.println();
		}
	}

	/**
	 * 返回坐标(x，y)是否已存在棋子
	 * 
	 * @return
	 */
	public boolean isExistAt(int x, int y) {
		ChessPoint point = this.points[x][y];

		return point.getPieces() != null;
	}

	/**
	 * 放置棋子
	 * 
	 * @param cp
	 */
	public void setChessPiecesAt(ChessPieces cp) {
		int x = cp.getX();
		int y = cp.getY();
		// 在指定点放置棋子
		this.points[x][y].setPieces(cp);
		this.paint();
	}

	/**
	 * 棋盘是否已满
	 * 
	 * @return
	 */
	public boolean isFull() {
		return this.piecesCount == MAX_PIECES_COUNT;
	}

	/**
	 * 放置棋子
	 * 
	 * @param cp
	 */
	public ChessPieces setChessPiecesAt(int x, int y, int color) {
		ChessPieces cp = new ChessPieces(color,x,y);
		this.setChessPiecesAt(cp);
		return cp;
	}

	/**
	 * 返回指定玩家是否有五子连珠
	 * 
	 * @param color
	 * @return
	 */
	public boolean isFiveInALine(int color, int x, int y) {
		//水平
		if(isFiveInARow(color,x,y)) {
			return true;
		}
		//垂直
		if(isFiveInAColumn(color,x,y)) {
			return true;
		}
		//对角线(左上-右下)
		if(isFiveInALeftTop2RightBottom(color,x,y)) {
			return true;
		}
		//对角线(右上-左下)
		if(isFiveInARightTop2LeftBottom(color,x,y)) {
			return true;
		}
		return false;
	}
	private boolean isFiveInARow(int color, int x, int y) {
		int five=0;
		// 水平左方向
		for(int i=0;isExistColorAt(x-i, y, color);i++) {
			five++;
		}
		// 水平右方向
		for(int i=1;isExistColorAt(x+i, y, color);i++) {
			five++;
		}
		return five>=5;
	}
	private boolean isFiveInAColumn(int color, int x, int y) {
		int five=0;
		// 水平左方向
		for(int i=0;isExistColorAt(x, y-i, color);i++) {
			five++;
		}
		// 水平右方向
		for(int i=1;isExistColorAt(x, y+i, color);i++) {
			five++;
		}
		return five>=5;
	}
	//对角线(左上-右下)
	private boolean isFiveInALeftTop2RightBottom(int color, int x, int y) {
		int five=0;
		// 左上方向
		for(int i=0;isExistColorAt(x-i, y-i, color);i++) {
			five++;
		}
		// 右下方向
		for(int i=1;isExistColorAt(x+i, y+i, color);i++) {
			five++;
		}
		return five>=5;
	}
	//对角线(右上-左下)
	private boolean isFiveInARightTop2LeftBottom(int color, int x, int y) {
		int five=0;
		// 右上方向
		for(int i=0;isExistColorAt(x+1, y-i, color);i++) {
			five++;
		}
		// 左下方向
		for(int i=1;isExistColorAt(x-1, y+i, color);i++) {
			five++;
		}
		return five>=5;
	}
	/**
	 * 判断对应位置上是否有对应颜色的棋子
	 * 
	 * @param x
	 * @param y
	 * @param color
	 * @return
	 */
	private boolean isExistColorAt(int x, int y, int color) {
		if (x < 0 || x >= this.width) {
			return false;
		}
		if (y < 0 || y >= this.width) {
			return false;
		}
		ChessPoint point = this.points[x][y];
		return point.hasColor(color);
	}
}
