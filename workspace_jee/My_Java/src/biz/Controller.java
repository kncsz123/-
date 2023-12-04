package biz;

public class Controller {
private ActionType action;
Group[] list = {new LGroup(), new ALGroup(),
new ZGroup(), new AZGroup(),
new TGroup(), new OGroup(), new IGroup()};
private Group group;
private SquareBox box;
public Controller(SquareBox box){
this.box = box;
this.action = ActionType.DOWN;
prepare();
}
// 动作类型的枚举
public static enum ActionType{
LEFT,RIGHT,DOWN,ROTATE
}

// 接受一个动作命令
public void receive(ActionType command){
action = command;
}

// 游戏单次运行逻辑
public void run() {
Group temp = group.clone();
switch(action) {
case LEFT: {
temp.left();
if(box.check(temp)) {
group.left();
}
}break;
case RIGHT:{
temp.right();
if(box.check(temp)) {
group.right();
}
}break;
case DOWN:{
temp.down();
if(box.check(temp)) {
group.down();
}
}break;
case ROTATE:{
temp.rotate();
if(box.check(temp)) {
group.rotate();
}
}
default:break;
}
action = ActionType.DOWN; // 恢复默认动作
if(box.stranded(group)) {
box.place(group);
prepare(); // 准备新方块组
}
}

// 随机准备一个方块组
public void prepare() {
group = list[(int) (Math.random() * list.length)];
group.prepare(3, box.getWidth() / 2);
}

// 返回显示信息
public int[][] show(){
int[][] resp = box.copyTags();
Square[] a = group.getSquares();
for(Square s : a) {
resp[s.getY()][s.getX()] = 1;
}
return resp;
}
}
