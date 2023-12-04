package biz;

public abstract class Group implements Cloneable{
protected Square[] squares; // 方块组，中心方块存放在第一个位置
// 创建一个默认组合，没有实际意义，需要子类给出形状
protected Group() {
squares = new Square[]{new Square(),new Square(),new Square(),new Square()};
prepare(squares[0].getX(), squares[0].getY()); // 整理队形
}
/*
*
* 组合的运动系统，包括左移、右移、下移和转动；运动后向盒子对象请求放置，失败则撤销动作
*
* */
protected void left() {
for(int i = 0; i < squares.length; i++) {
squares[i].left(1);
}
}
protected void right() {
for(int i = 0; i < squares.length; i++) {
squares[i].right(1);
}
}
protected void down() {
for(int i = 0; i < squares.length; i++) {
squares[i].down(1);
}
}
protected void rotate() {
for(int i = 1; i < squares.length; i++) {
squares[i].rotateAround(squares[0]);
}
}
/*
*
* 组合的边界信息，包括左、右和下三个边缘坐标
*
* */
//左边界
public int minX() {
int x = Integer.MAX_VALUE;
for(Square s : getSquares()) {
if(s.getX() < x) x = s.getX();
}
return x;
}
//右边界
public int maxX() {
int x = 0;
for(Square s : getSquares()) {
if(s.getX() > x) x = s.getX();
}
return x;
}
//下边界
public int maxY() {
int y = 0;
for(Square s : getSquares()) {
if(s.getY() > y) y = s.getY();
}
return y;
}
// 以（x,y）为中心按特定形状准备方块组
public abstract void prepare(int x, int y);
// 部分Getter与Setter函数省略

public Group clone() {
    Group group = null;
    try {
        group = (Group) super.clone();
        Square[] squares = group.getSquares();
        Square[] temp = new Square[squares.length];
        for (int i = 0; i < squares.length; i++) {
            temp[i] = new Square(squares[i].getX(), squares[i].getY());
        }
        group.squares = temp;
    } catch (CloneNotSupportedException e) {
        e.printStackTrace();
    }
    return group;
}

public Square[] getSquares() {
    return squares;
}
}
