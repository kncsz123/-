package biz;
import java.util.Arrays;

public class SquareBox{
private int width, height;
private int[][] tags; // 方块落地标记，1表示有方块，0表示没有
public SquareBox(int width, int height) {
	this.setWidth(width);
	this.setHeight(height);
	tags = new int[height][width];
}
public void setWidth(int width) {
	this.width = width;
}
public void setHeight(int height) {
	this.height = height;
}
public int getWidth() {
	return width;
}
public int getHeight() {
	return height;
} 
// 放置
public void place(Group group) {
	// 放下方块，更新盒子的状态
	for(Square s : group.getSquares()) {
	tags[s.getY()][s.getX()] = 1;
	}
	// 消除满格层
	int[][] temp = new int[height][width];
	int r = height - 1;
	for(int y = height - 1; y >= 0; y--) {
	boolean full = true;
	for(int x = 0; x < width; x++) {
	if(tags[y][x] == 0) {
	full = false;
	break;
	}
	}
	if(!full)
	temp[r--] = Arrays.copyOf(tags[y], width);
	}
	tags = temp;
	}

// 判断是否搁浅
public boolean stranded(Group g) {
	boolean stranded = false;
	if(g.maxY() == height - 1) {
		stranded = true;
	}else {
		for(Square s : g.getSquares()) {
			if(tags[s.getY() + 1][s.getX()] == 1) {
				stranded = true;
			}
		}
	}
	return stranded;
}

// 判断是否能放置
public boolean check(Group g) {
	if(g.minX() < 0 || g.maxX() >= width) {
		return false;
	}else{
		for(Square s : g.getSquares()) {
			if(tags[s.getY()][s.getX()] == 1) {
				return false;
			}
		}
	}
	return true;
}

// 复制一份tags用于显示
public int[][] copyTags() {
    int[][] copy = new int[height][width];
    for (int i = 0; i < height; i++) {
        copy[i] = tags[i].clone();
    }
    return copy;
	}
}
