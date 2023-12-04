package map;
import java.util.List;
public class MapTool {
	//接收通用的Feature而不是特定的Point或者Line
	//尽管 Line 类的 move 函数和 MapTool 类的 move 函数有相似的名称
	//但它们是两个不同的函数，一个用于对线段中的点进行平移，另一个用于批量平移任何实现了 Feature 接口的对象。
	public static void move(List<Feature> list,double dx,double dy) {
		for(Feature feature: list) {
			feature.move(dx, dy);
		}
	}
}
