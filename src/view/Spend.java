package view;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import controller.SpendInfoManageController;
import model.Info;
import model.MatterInfo;
import model.SpendInfo;

public class Spend {
	/*记账系统交互*/
	SpendInfoManageController spend = new SpendInfoManageController();
	Scanner s = new Scanner(System.in);
	List<Info> list = new ArrayList<Info>();

	public void view (){
		System.out.println("记账系统");
		System.out.println("本月有" + spend.remind(list) + "财产。");
		System.out.println("1：添加记录；\t2：删除记录；\t3：详细信息；\t0：退出；");
		System.out.print("请输入选择：");
		int item = Integer.valueOf(s.nextLine());
		while (item != 0){
			switch (item) {
			case 1:
				this.add();
				break;
			case 2:
				this.delete();
				break;
			case 3:
				this.print(0);
				break;
			default:
				break;
			}
			System.out.println("本月有" + spend.remind(list) + "财产。");
			System.out.println("1：添加记录；\t2：删除记录；\t3：详细信息；\t0：退出；");
			System.out.print("请输入选择：");
			item = Integer.valueOf(s.nextLine());
		}
	}

	private void print(int flag) {
		int i = 0;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String start = year + "-" + month + "-1 00:00:00";
		String end = year + "-" + (month+1) + "-1 00:00:00";
		if(flag == 1){
			System.out.println("编号\t收支\t说明\t金额");
			for(i = 0; i < list.size(); i++){
				if((((SpendInfo)list.get(i)).getCreateTime().getTime() < Timestamp.valueOf(end).getTime()) && (((SpendInfo)list.get(i)).getCreateTime().getTime() >= Timestamp.valueOf(start).getTime())){
					System.out.println((i + 1) + "\t" + ((SpendInfo)list.get(i)).getTitle() + "\t" + ((SpendInfo)list.get(i)).getContent() + "\t" + ((SpendInfo)list.get(i)).getMoney());
				}
			}
		}
		else{
			System.out.println("编号\t收支\t说明\t创建时间\t金额");
			for(i = 0; i < list.size(); i++){
				if((((SpendInfo)list.get(i)).getCreateTime().getTime() < Timestamp.valueOf(end).getTime()) && (((SpendInfo)list.get(i)).getCreateTime().getTime() >= Timestamp.valueOf(start).getTime())){
					System.out.println((i + 1) + "\t" + ((SpendInfo)list.get(i)).getTitle() + "\t" + ((SpendInfo)list.get(i)).getContent() + "\t" + ((SpendInfo)list.get(i)).getCreateTime() + "\t" + ((SpendInfo)list.get(i)).getMoney());
				}
			}
		}
	}

	private void delete() {
		this.print(1);
		System.out.print("请输入编号选择：");
		int item = Integer.valueOf(s.nextLine());
		spend.delete(list, item-1);
	}

	private void add() {
		System.out.print("请选择（1：支出\t2：收入）：");
		int item = Integer.valueOf(s.nextLine());
		String title = "";
		if(item == 1)
			title = "支出";
		else if (item == 2)
			title = "收入";
		System.out.print("请输入说明：");
		String content = s.nextLine();
		System.out.print("请输入金额：");
		double money = Double.parseDouble(s.nextLine());
		Info spendInfo = new SpendInfo(title, content, money);
		spend.create(list, spendInfo);
	}
}
