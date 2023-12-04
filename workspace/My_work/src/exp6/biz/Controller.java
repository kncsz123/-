package exp6.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Controller {
	private ViewArea viewArea;
	private List<Ball> selectedBalls = new ArrayList<Ball>();
	private List<Ball> balls = new ArrayList<Ball>();
	// 待执行的命令
	private List<Command> commands = new ArrayList<Command>();
	
	public Controller(ViewArea v) {
		viewArea = v;
	}
	
	/*
	 * 接受GUI层命令，并执行一个业务操作
	 * 
	 * */
	
	// 选择一个矩形范围的角色
	public void select(int x1, int y1, int x2, int y2) {
		selectedBalls.clear();
		for(Ball b : balls) {
			if(b.in(x1, y1, x2, y2)) {
				selectedBalls.add(b);
			}
		}
	}
	// 选择单个角色
	public void selectSingle(int x, int y) {
		selectedBalls.clear();
		for(Ball b : balls) {
			if(b.getX() == x && b.getY() == y) {
				selectedBalls.add(b);
				break;
			}
		}
	}
	
	// 接收GUI层移动命令
	public void moveTo(int targetX, int targetY) {
		for(Ball Ball : selectedBalls) {
			Move m = new Move(Ball, targetX + viewArea.getStartX(), targetY + viewArea.getStartY());
			if(commands.contains(m)) {
				commands.set(commands.indexOf(m), m);
			}else {
				commands.add(m);
			}
		}
	}

	// 可视区移动
	public void viewMove(int dx, int dy) {
		viewArea.move(-dx, -dy);
	}
	
	/*
	 * 执行所有命令
	 * 
	 * */
	public void executeAll() {
		Set<Command> doneCommands = new HashSet<Command>();
		for(Command c : commands) {
			c.execute();
			if(c.done()) {
				doneCommands.add(c);
			}
		}
		commands.removeAll(doneCommands);
	}
	
	/*
	 * 返回GUI层的数据
	 * 
	 * */
	
	// 地块的状态编码
	public int[][] codes(){
		int[][] codes = new int[viewArea.getWidth()][viewArea.getHeight()];
		for(int x = 0; x < codes.length; x++) {
			for(int y = 0; y < codes[x].length; y++) {
				codes[x][y] = viewArea.getCode(x, y);
			}
		}
		return codes;
	}
	
	// 选中的角色位置信息
	public int[][] selectedBalls() {
		int[][] info = new int[selectedBalls.size()][2];
		for(int i = 0; i < info.length; i++) {
			info[i][0] = selectedBalls.get(i).getX() - viewArea.getStartX();
			info[i][1] = selectedBalls.get(i).getY() - viewArea.getStartY();
		}
		return info;
	}
	
	// 所有角色的信息
	public int[][] balls() {
		int[][] info = new int[balls.size()][3];
		for(int i = 0; i < info.length; i++) {
			info[i][0] = balls.get(i).getX() - viewArea.getStartX();
			info[i][1] = balls.get(i).getY() - viewArea.getStartY();
			info[i][2] = balls.get(i).getState();
		}
		return info;
	}

	public ViewArea getViewArea() {
		return viewArea;
	}

	public void setViewArea(ViewArea viewArea) {
		this.viewArea = viewArea;
	}
	
	public void addBall(Ball r) {
		balls.add(r);
	}
	public void removeBall(Ball r) {
		balls.remove(r);
	}
}
