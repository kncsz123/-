package scoresheet;

//成绩记录类
//需求描述：假设一个成绩记录表（ScoreSheet）包含若干成绩记录（ScoreRecord），每条
//记录包含学号（sid）、姓名（name）、课程（course）、得分（score）等信息。绘制记录
//表和成绩记录类图，并实现两个类的定义。另外，在ScoreSheet类中设计一个过滤函数筛选
//出某一课程的所有成绩记录：
public class ScoreRecord {
	 private String sid;     // 学号
	 private String name;    // 姓名
	 private String course;  // 课程
	 private int score;       // 得分
	
	 // 构造函数
	 public ScoreRecord(String sid, String name, String course, int score) {
	     this.sid = sid;
	     this.name = name;
	     this.course = course;
	     this.score = score;
	 }
	
	 // Getter 和 Setter 方法
	 public String getSid() {
	     return sid;
	 }
	
	 public void setSid(String sid) {
	     this.sid = sid;
	 }
	
	 public String getName() {
	     return name;
	 }
	
	 public void setName(String name) {
	     this.name = name;
	 }
	
	 public String getCourse() {
	     return course;
	 }
	
	 public void setCourse(String course) {
	     this.course = course;
	 }
	
	 public int getScore() {
	     return score;
	 }
	
	 public void setScore(int score) {
	     this.score = score;
	 }
}
	
