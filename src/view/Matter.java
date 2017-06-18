package view;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.MatterInfoManageController;
import model.Info;
import model.MatterInfo;

public class Matter {
	/*记事本系统交互*/
	MatterInfoManageController matter = new MatterInfoManageController();
	Scanner s = new Scanner(System.in);
	List<Info> list = new ArrayList<Info>();

	public void view (){
		System.out.println("记事本");
		System.out.print("目前有" + list.size() + "条记录。");
		if(list.size() != 0){
			System.out.println("其中" + matter.remind(list) + "后到来");
		}
		else{
			System.out.println();
		}
		System.out.println("1：添加备忘；\t2：删除备忘；\t3：详细信息；\t0：退出；");
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
			System.out.print("目前有" + list.size() + "条记录。");
			if(list.size() != 0){
				System.out.println("其中" + matter.remind(list) + "后到来");
			}
			else{
				System.out.println();
			}
			System.out.println("1：添加备忘；\t2：删除备忘；\t3：详细信息；\t0：退出；");
			System.out.print("请输入选择：");
			item = Integer.valueOf(s.nextLine());
		}
	}

	public void add(){
		System.out.print("请输入标题：");
		String title = s.nextLine();
		System.out.print("请输入内容：");
		String content = s.nextLine();
		System.out.print("请输入提醒时间（年-月-日 时:分）：");
		String time = s.nextLine();
		time = time.replace("：", ":");
		time += ":00";
		try {
			Timestamp remindTime = Timestamp.valueOf(time);
			Info matterInfo = new MatterInfo(title, content, remindTime);
			matter.create(list, matterInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("输入数据错误");
		}
	}
	public void delete(){
		this.print(1);
		System.out.print("请输入编号选择：");
		int item = Integer.valueOf(s.nextLine());
		matter.delete(list, item-1);
	}
	public void print(int flag){
		int i = 0;
		if(flag == 1){
			System.out.println("编号\t标题\t提醒时间");
			for(i = 0; i < list.size(); i++){
				System.out.println((i + 1) + "\t" + ((MatterInfo)list.get(i)).getTitle() + "\t" + ((MatterInfo)list.get(i)).getRemindTime());
			}
		}
		else{
			System.out.println("编号\t标题\t内容\t创建时间\t提醒时间");
			for(i = 0; i < list.size(); i++){
				System.out.println((i + 1) + "\t" + ((MatterInfo)list.get(i)).getTitle() + "\t" + ((MatterInfo)list.get(i)).getContent() + "\t" + ((MatterInfo)list.get(i)).getCreateTime() + "\t" + ((MatterInfo)list.get(i)).getRemindTime());
			}
		}
	}
}
