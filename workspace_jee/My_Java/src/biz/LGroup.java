package biz;

public class LGroup extends Group{
	// 以(x,y)为中心整理队形
	public void prepare(int x, int y) {
		squares[0].setX(x);squares[0].setY(y);
		squares[1].setX(x);squares[1].setY(y-1);
		squares[2].setX(x);squares[2].setY(y+1);
		squares[3].setX(x+1);squares[3].setY(y+1);
	}
	}
