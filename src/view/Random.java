package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.RandomController;

public class Random {
	/*随机系统交互*/
	RandomController random = new RandomController();
	Scanner s = new Scanner(System.in);

	public void view (){
		System.out.println("随机工具");
		System.out.println("1：随机抽取学号；\t2：随机抽取给定选项；\t0：退出；");
		System.out.print("请输入选择：");
		int item = Integer.valueOf(s.nextLine());
		while(item != 0){
			if(item == 1){
				System.out.print("请输入开始学号：");
				int start = Integer.valueOf(s.nextLine());
				System.out.print("请输入结束学号：");
				int end = Integer.valueOf(s.nextLine());
				try {
					System.out.println("随机结果为：" + random.randomNum(start, end));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
			else if(item == 2){
				List<String> str = new ArrayList<String>();
				System.out.println("请输入选项：（0为结束输入）");
				String strItem = s.nextLine();
				while(!(strItem.equals("0"))){
					str.add(strItem);
					System.out.println("请输入选项：（0为结束输入）");
					strItem = s.nextLine();
				}
				System.out.println("随机结果为：" + random.randomMatter(str));
			}
			System.out.println("随机工具");
			System.out.println("1：随机抽取学号；\t2：随机抽取给定选项；\t0：退出；");
			System.out.print("请输入选择：");
			item = Integer.valueOf(s.nextLine());
		}
	}
}
