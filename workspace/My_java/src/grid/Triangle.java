package grid;

public class Triangle extends Shape {
	private int x1,x2,x3,y1,y2,y3;
	Triangle(int x1,int x2,int x3,int y1,int y2,int y3){
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
	}
	@Override
	public Raster raster() {
        // 创建一个空白的栅格对象
        int minX = Math.min(x1, Math.min(x2, x3));
        int minY = Math.min(y1, Math.min(y2, y3));
        int maxX = Math.max(x1, Math.max(x2, x3));
        int maxY = Math.max(y1, Math.max(y2, y3));
        int rasterWidth = maxX - minX + 1;
        int rasterHeight = maxY - minY + 1;
        Raster raster = new Raster(minX, minY, rasterWidth, rasterHeight);

        // 使用三角形的顶点坐标和边的信息来填充栅格
        int[][] values = raster.copyValues();
        for (int y = 0; y < values.length; y++) {
            for (int x = 0; x < values[y].length; x++) {
                if (isInTriangle(x + minX, y + minY)) {
                    raster.setValue(x + minX, y + minY, 1);
                }
            }
        }

        return raster;
    }
	 // 检查一个点是否在三角形内
    private boolean isInTriangle(int x, int y) {
        int areaTotal = triangleArea(x1, y1, x2, y2, x3, y3);
        int area1 = triangleArea(x, y, x2, y2, x3, y3);
        int area2 = triangleArea(x1, y1, x, y, x3, y3);
        int area3 = triangleArea(x1, y1, x2, y2, x, y);

        return areaTotal == area1 + area2 + area3;
    }
    //叉乘公式
    private int triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2);
    }
}
