package exp5.stickman.entity;

import exp5.stickman.exception.JointIsNoneException;

public class Joint {
	private double x ,y;
	
	public Joint() {
		//this(0,0);
	}
	public Joint(double x, double y) {
		setX(x);
		setY(y);
	}
	
	// 绕目标中心顺时针旋转d度（弧度）
	public void rotate(Joint center, double d) {
		if (center == null) {
	        throw new JointIsNoneException();
	    }

		double x1 = getX() - center.getX();
		double y1 = -getY() - (-center.getY());
		
		double x2 = Math.cos(-d) * x1 - Math.sin(-d) * y1;
		double y2 = Math.sin(-d) * x1 + Math.cos(-d) * y1;

		update(center.getX() + x2, -(-center.getY() + y2));
	}
	
	// 平移
	public void move(double dx, double dy) {
		update(getX() + dx, getY() + dy);
	}
	
	// 更新坐标
	public void update(double x, double y) {
		setX(x);
		setY(y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}
