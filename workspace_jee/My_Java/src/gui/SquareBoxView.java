package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SquareBoxView extends Canvas{
	private int gap = 5;
	private double cellSize;
	
	public SquareBoxView(int width, int height, double cellSize) {
		this.setWidth(width * cellSize + 2 * gap);
		this.setHeight(height * cellSize + 2 * gap);
		setCellSize(cellSize);
	}
	
	// 渲染标记
	public void render(int[][] tags) {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.clearRect(0, 0, this.getWidth(), this.getHeight()); // 清除
		gc.setLineWidth(10);
		gc.setFill(Color.BLACK);
		gc.fillRect(gap, gap, this.getWidth() - 2 * gap, this.getHeight() - 2 * gap);
		gc.setFill(Color.YELLOW);
		for(int i = 0; i < tags.length; i++) {
			for(int j = 0; j < tags[i].length; j++) {
				if(tags[i][j] == 1)
					gc.fillRect(j * cellSize + gap, i * cellSize + gap, cellSize, cellSize);
			}
		}
	}

	public double getCellSize() {
		return cellSize;
	}

	public void setCellSize(double cellSize) {
		this.cellSize = cellSize;
	}
}

