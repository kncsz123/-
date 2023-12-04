package map;
import java.util.ArrayList;
import java.util.List;
//打印对象时，需要重写toString函数
public class Maintest {
	public static void main(String[] args) {
		//创建point对象
		Point point1 = new Point(1.0,2.0);
		Point point2 = new Point(3.0,4.0);
		
		//创建line对象
		Point point3 = new Point(1.0,1.0);
		Point point4 = new Point(2.0,2.0);
		List<Point> linepoints = new ArrayList<>();
		linepoints.add(point3);
		linepoints.add(point4);
		Line line = new Line(linepoints);
		
		//创建feature对象
		List<Feature> featurepoint = new ArrayList<>();
		featurepoint.add(point1);
		featurepoint.add(point2);
		featurepoint.add(line);
		
		for(Feature feature: featurepoint) {
			System.out.println("初始坐标"+feature);
		}
		MapTool.move(featurepoint, 2.0, 2.0);
		for(Feature feature: featurepoint) {
			System.out.println("修改后的坐标"+feature);
		}
	}
}
