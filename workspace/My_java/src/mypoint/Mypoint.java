package mypoint;

import java.lang.Math;

class MyPoint {
    private double x;
    private double y;

    // 无参数构造器，创建一个坐标为（0,0）的点对象
    public MyPoint() {
        this(0, 0);
    }

    // 带坐标参数的构造器
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter函数获取x坐标
    public double getX() {
        return x;
    }

    // Setter函数设置x坐标
    public void setX(double x) {
        this.x = x;
    }

    // Getter函数获取y坐标
    public double getY() {
        return y;
    }

    // Setter函数设置y坐标
    public void setY(double y) {
        this.y = y;
    }

    // 计算与其他点之间的距离
    public double distance(MyPoint otherPoint) {
        double deltaX = x - otherPoint.getX();
        double deltaY = y - otherPoint.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    // 计算与特定坐标距离的函数
    public double distance(double x, double y) {
        double deltaX = this.x - x;
        double deltaY = this.y - y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}



