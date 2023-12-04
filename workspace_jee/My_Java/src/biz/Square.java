package biz;

public class Square {
	private int x, y;
	public Square() {}
	public Square(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	// 坐标系：左下方向递增
		public void up(int step) {
		setY(getY() - step);
		}
		public void down(int step) {
		setY(getY() + step);
		}
		public void left(int step) {
		setX(getX() - step);
		}
		public void right(int step) {
		setX(getX() + step);
		}
		public int getY() {
			return y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}
	// 围绕目标方块顺时针转动90度
		public void rotateAround(Square s){
			int xDist = this.x - s.getX();
			int yDist = this.y - s.getY();
			if(yDist == 0) { // 和中心在同一行
			setX(s.getX()); // 转动后同一列，x相同
			setY(getY() + xDist); // 在右边，xDist为正，下移，在左边，xDist为负，上移
			}else if(xDist == 0){ // 和中心在同一列
			setY(s.getY()); // 转动后同一列，y相同
			setX(getX() - yDist); // 在下边，yDist为正，左移，在上边，yDist为负，右移
			}else { // 取巧：游戏里只存在九宫格四个角的情况
			if(xDist * yDist > 0) { // 符号相同，顺时针转动是沿X轴方向移动
			setX(getX() - 2 * xDist); // 同为正，则左移，同为负，则右移
			}else { // 符号不同，顺时针转动是沿Y轴方向移动
			setY(getY() + 2 * xDist); // xDist为正，则下移，为负，则上移
			}
			}
			}
}

