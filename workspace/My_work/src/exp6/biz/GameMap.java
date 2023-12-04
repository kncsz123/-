package exp6.biz;

import java.util.Map;
import java.util.HashMap;

public class GameMap {
	private int width, height;
	private Map<Integer, Integer> cells = new HashMap<Integer, Integer>();
	
	public GameMap(int w, int h) {
		width = w;
		height = h;
	}
	
	// 根据坐标计算地址编码
	public int locationCode(int x, int y) {
		return y * width + x;
	}
	// 设置地块状态值
	public void put(int x, int y, int codeValue) {
		cells.put(locationCode(x, y), codeValue);
	}
	// 获取地块状态值
	public int get(int x, int y) {
		Integer lc = locationCode(x, y);
		if(cells.containsKey(lc)) {
			//返回key值
			return cells.get(lc);
		}
		return 0;
	}

	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
}
