package grid;

public class Raster {
	private int startX, startY, width, height;
	private int[][] values; // 0表示无值，1表示有值
	public Raster(int x, int y, int width, int height) {
		this.setStartX(x);
		this.setStartY(y);
		this.setWidth(width);
		this.setHeight(height);
		values = new int[height][width];
	}
	
	public void setValue(int x, int y, int value) {
		values[y - startY][x - startX] = value;
	}
	
	public int getValue(int x, int y) {
		if(x < startX || y < startY || x - startX > width - 1 || y - startY > height - 1) {
			return 0;
		}
		return values[y - startY][x - startX];
	}
	
	public int[][] copyValues() {
		int[][] copy = values.clone();
		for(int i = 0; i < copy.length; i++) {
			copy[i] = values[i].clone();
		}
		return copy;
	}
	
	// 两个栅格相交后生成重叠部分的栅格
	public Raster intersect(Raster other) {
		int startX = Math.min(this.getStartX(), other.getStartX());
		int startY = Math.min(this.getStartY(), other.getStartY());
		int endX = Math.max(this.getEndX(), other.getEndX());
		int endY = Math.max(this.getEndY(), other.getEndY());
		Raster intersected = new Raster(startX, startY, endX - startX, endY - startY);
		/*for(int y = startY; y < endY; y++) {
			for(int x = startX; x < endX; x++) {
				if(this.getValue(x, y) == 1 && other.getValue(x, y) == 1) {
					intersected.setValue(x, y, 1);
				}
			}
		}*/
		return project(intersected, new Raster[] {this, other}, (ins, x, y) ->{
			return ins[0].getValue(x, y) == 1 && ins[1].getValue(x, y) == 1;
		});
	}
	
	// 两个栅格对象融合后生成新的栅格对象
	public Raster merge(Raster other) {
		int startX = Math.min(this.getStartX(), other.getStartX());
		int startY = Math.min(this.getStartY(), other.getStartY());
		int endX = Math.max(this.getEndX(), other.getEndX());
		int endY = Math.max(this.getEndY(), other.getEndY());
		Raster merged = new Raster(startX, startY, endX - startX, endY - startY);
		return project(merged, new Raster[] {this, other}, (ins, x, y) ->{
			return ins[0].getValue(x, y) == 1 || ins[1].getValue(x, y) == 1;
		});
	}
	
	// 基于矩形区域裁剪栅格数据
	public Raster clip(Raster other) {
		int startX = Math.max(this.getStartX(), other.getStartX());
	    int startY = Math.max(this.getStartY(), other.getStartY());
	    int endX = Math.min(this.getEndX(), other.getEndX());
	    int endY = Math.min(this.getEndY(), other.getEndY());

	    if (startX >= endX || startY >= endY) {
	        // 如果裁剪区域没有交集，返回一个空的栅格
	        return new Raster(0, 0, 0, 0);
	    }

	    Raster clippedRaster = new Raster(startX, startY, endX - startX, endY - startY);

	    return project(clippedRaster, new Raster[] {this, other}, (ins, x, y) -> {
	        return ins[0].getValue(x, y) == 1 && ins[1].getValue(x, y) == 1;
	    });
	}
	
	// 带判断条件的值投影
	private Raster project(Raster out, Raster[] ins, Predicate pre) {
		for(int y = out.getStartY(); y < out.getEndY(); y++) {
			for(int x = out.getStartX(); x < out.getEndX(); x++) {
				if(pre.test(ins, x, y)) {
					out.setValue(x, y, 1);
				}
			}
		}
		return out;
	}
	
	@FunctionalInterface
	interface Predicate {
		boolean test(Raster[] ins, int x, int y);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}
	
	public int getEndX() {
		return startX + width;
	}
	public int getEndY() {
		return startY + height;
	}
}
