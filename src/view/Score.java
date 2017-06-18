package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.ScoreInfoManageController;
import model.Info;
import model.ScoreInfo;

public class Score {
	/*成绩统计系统交互*/
	ScoreInfoManageController score = new ScoreInfoManageController();
	Scanner s = new Scanner(System.in);
	List<Info> list = new ArrayList<Info>();
	
	public void view (){
		System.out.println("记事本");
		System.out.print("目前有" + list.size() + "条记录。");
		if(list.size() != 0){
			System.out.println("其中，" + score.remind(list));
		}
		else{
			System.out.println();
		}
		System.out.println("1：添加成绩；\t2：删除成绩；\t3：修改成绩；\t4：成绩列表；\t0：退出；");
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
				this.update();
				break;
			case 4:
				this.print(0);
				break;
			default:
				break;
			}
			System.out.print("目前有" + list.size() + "条记录。");
			if(list.size() != 0){
				System.out.println("其中，" + score.remind(list));
			}
			else{
				System.out.println();
			}
			System.out.println("1：添加成绩；\t2：删除成绩；\t3：修改成绩；\t4：成绩列表；\t0：退出；");
			System.out.print("请输入选择：");
			item = Integer.valueOf(s.nextLine());
		}
	}

	private void print(int flag) {
		int i = 0;
		if(flag == 1){
			System.out.println("编号\t类型\t名字\t学分");
			for(i = 0; i < list.size(); i++){
				System.out.println((i + 1) + "\t" + ((ScoreInfo)list.get(i)).getTitle() + "\t" + ((ScoreInfo)list.get(i)).getContent() + "\t" + ((ScoreInfo)list.get(i)).getCredit());
			}
		}
		else{
			System.out.println("编号\t类型\t名字\t创建时间\t成绩\t学分");
			for(i = 0; i < list.size(); i++){
				System.out.println((i + 1) + "\t" + ((ScoreInfo)list.get(i)).getTitle() + "\t" + ((ScoreInfo)list.get(i)).getContent() + "\t" + ((ScoreInfo)list.get(i)).getCreateTime() + "\t" + ((ScoreInfo)list.get(i)).getScore() + "\t" + ((ScoreInfo)list.get(i)).getCredit());
			}
		}
	}

	private void delete() {
		this.print(1);
		System.out.print("请输入编号选择：");
		int item = Integer.valueOf(s.nextLine());
		score.delete(list, item-1);
	}

	private void add() {
		System.out.print("请选择类型（1：必修\t2：限选\t3：公选）：");
		int item = Integer.valueOf(s.nextLine());
		String title = "";
		if(item == 1)
			title = "必修";
		else if (item == 2)
			title = "限选";
		else if (item == 3)
			title = "公选";
		System.out.print("请输入学科名字：");
		String content = s.nextLine();
		System.out.print("请输入成绩：");
		double scores = Double.parseDouble(s.nextLine());
		System.out.print("请输入学分：");
		double credit = Double.parseDouble(s.nextLine());
		Info scoreInfo = new ScoreInfo(title, content, scores, credit);
		score.create(list, scoreInfo);
	}
	
	private void update() {
		this.print(1);
		System.out.print("请输入编号选择：");
		int i = Integer.valueOf(s.nextLine());
		i = i - 1;
		ScoreInfo scoreInfo = (ScoreInfo)list.get(i);
		System.out.println("当前信息：");
		System.out.println((i + 1) + "\t" + scoreInfo.getTitle() + "\t" + scoreInfo.getContent() + "\t" + scoreInfo.getCreateTime() + "\t" + scoreInfo.getScore() + "\t" + scoreInfo.getCredit());
		System.out.println("输入修改信息：");
		System.out.print("请选择类型（1：必修\t2：限选\t3：公选）：");
		int item = Integer.valueOf(s.nextLine());
		String title = "";
		if(item == 1)
			title = "必修";
		else if (item == 2)
			title = "限选";
		else if (item == 3)
			title = "公选";
		System.out.print("请输入学科名字：");
		String content = s.nextLine();
		System.out.print("请输入成绩：");
		double scores = Double.parseDouble(s.nextLine());
		System.out.print("请输入学分：");
		double credit = Double.parseDouble(s.nextLine());
		scoreInfo.setTitle(title);
		scoreInfo.setContent(content);
		scoreInfo.setScore(scores);
		scoreInfo.setCredit(credit);
		score.update(list, i, scoreInfo);
	}
}
