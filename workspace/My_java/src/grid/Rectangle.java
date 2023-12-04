package grid;

public class Rectangle extends Shape{
	private int startX, startY, width, height;
	
	public Rectangle(int x, int y, int width, int height) {
		setStartX(x);
		setStartY(y);
		setWidth(width);
		setHeight(height);
	}
	
	@Override
	public Raster raster() {
		 int rasterW = getWidth();
		    int rasterH = getHeight();
		    Raster r = new Raster(getStartX(), getStartY(), rasterW, rasterH);
		    
		    for (int x = 0; x < rasterW; x++) {
		        for (int y = 0; y < rasterH; y++) {
		            r.setValue(getStartX() + x, getStartY() + y, 1);
		        }
		    }
		    
		    return r;
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
	
}
