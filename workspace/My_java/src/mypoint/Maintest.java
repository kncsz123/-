package mypoint;

public class Maintest {
    public static void main(String[] args) {
        // 创建两个点对象
        MyPoint point1 = new MyPoint(0, 0);
        MyPoint point2 = new MyPoint(10, 10);

        // 计算两点之间的距离
        double distance = point1.distance(point2);

        System.out.println("Point 1: (" + point1.getX() + ", " + point1.getY() + ")");
        System.out.println("Point 2: (" + point2.getX() + ", " + point2.getY() + ")");
        System.out.println("Distance between Point 1 and Point 2: " + distance);
    }
}
