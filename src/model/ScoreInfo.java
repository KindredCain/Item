package model;

import java.sql.Timestamp;
import java.util.Date;

public class ScoreInfo extends Info {
	/*成绩统计用的数据存储类*/
	double score;
	double credit;
	
	public ScoreInfo(){
		
	}
	public ScoreInfo(String title, String content, double score, double credit){
		this.title = title;
		this.content = content;
		Date date = new Date(); 
		this.createTime = new Timestamp(date.getTime());
		this.score = score;
		this.credit = credit;
	}
	
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
}
