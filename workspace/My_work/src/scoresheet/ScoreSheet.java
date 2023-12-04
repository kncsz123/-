package scoresheet;
//成绩记录表类
//需求描述：假设一个成绩记录表（ScoreSheet）包含若干成绩记录（ScoreRecord），每条
//记录包含学号（sid）、姓名（name）、课程（course）、得分（score）等信息。绘制记录
//表和成绩记录类图，并实现两个类的定义。另外，在ScoreSheet类中设计一个过滤函数筛选
//出某一课程的所有成绩记录：
import java.util.ArrayList;

public class ScoreSheet {
	private ArrayList<ScoreRecord> records;  // 成绩记录列表
	
	 // 构造函数
	 public ScoreSheet() {
	     this.records = new ArrayList<>();
	 }
	
	 // 添加成绩记录
	 public void addRecord(ScoreRecord record) {
	     records.add(record);
	 }
	
	 // 过滤函数，筛选出某一课程的所有成绩记录
	 public ScoreSheet filter(String course) {
	     ScoreSheet filteredSheet = new ScoreSheet();
	
	     for (ScoreRecord record : records) {
	         if (record.getCourse().equals(course)) {
	             filteredSheet.addRecord(record);
	         }
	     }
	
	     return filteredSheet;
	 }
}
