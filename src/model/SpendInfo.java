package model;

import java.sql.Timestamp;
import java.util.Date;

public class SpendInfo extends Info {
	/*记账用的数据存储类*/
	protected double money;
	
	public SpendInfo(){
		
	}
	public SpendInfo(String title, String content, double money){
		this.title = title;
		this.content = content;
		Date date = new Date(); 
		this.createTime = new Timestamp(date.getTime());
		this.money = money;
	}

	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
}
