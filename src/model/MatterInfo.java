package model;

import java.sql.Timestamp;
import java.util.Date;

public class MatterInfo extends Info {
	/*记事本用的数据存储类*/
	protected Timestamp remindTime;
	
	public MatterInfo(){
		
	}	
	public MatterInfo(String title, String content, Timestamp remindTime){
		this.title = title;
		this.content = content;
		Date date = new Date(); 
		this.createTime = new Timestamp(date.getTime());
		this.remindTime = remindTime;
	}

	public Timestamp getRemindTime() {
		return remindTime;
	}
	public void setRemindTime(Timestamp remindTime) {
		this.remindTime = remindTime;
	}
	
}
