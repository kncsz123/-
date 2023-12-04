package map;
import java.util.List;
import java.lang.StringBuilder;
public class Line implements Feature{
	private List<Point> points;
	Line(List<Point> points){
		this.points = points;
	}
	
	@Override
	public void move(double dx,double dy) {
		for(Point point: points) {
			point.move(dx,dy);
		}
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Line with points: ");
		for(Point point :points) {
			sb.append(point.toString()).append(", ");
		}
		if (!points.isEmpty()) {
	        sb.delete(sb.length() - 2, sb.length());
	    }
	    return sb.toString();
	}
	public List<Point> getPoint(){
		return points;
	}
}
//========
//关于for (Point point : points)的解释
//这行代码使用了 Java 的增强 for 循环（也称为 for-each 循环）来遍历一个存储 `Point` 对象的集合（通常是数组或列表），然后对每个 `Point` 对象调用 `move` 方法，将它们按给定的增量 `dx` 和 `dy` 进行平移。
//
//具体解释如下：
//
//1. `for (Point point : points)`：这是增强 for 循环的语法，其中 `Point` 是集合中的元素类型，`points` 是要遍历的集合（通常是一个列表或数组）。
//
//2. `point`：这是一个循环变量，它代表在每次迭代中集合中的一个 `Point` 对象。在每次迭代中，`point` 的值会被设置为集合中的下一个元素。
//
//3. `point.move(dx, dy)`：在每次循环迭代中，这行代码调用 `Point` 对象的 `move` 方法，将 `dx` 和 `dy` 作为参数传递给该方法。这意味着每个 `Point` 对象都会根据给定的增量值 `dx` 和 `dy` 进行平移。
//
//总之，这行代码的目的是对集合 `points` 中的每个 `Point` 对象进行循环遍历，并将它们按照给定的增量值 `dx` 和 `dy` 进行平移。这通常用于批量修改集合中的对象的状态或属性。