package view;

import java.util.Scanner;

public class Home {
	/*主系统交互*/
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("日常辅助系统"); 
		System.out.println("1：随机工具");
		System.out.println("2：计算器");
		System.out.println("3：记事本");
		System.out.println("4：学分统计");
		System.out.println("5：记账工具");
		System.out.println("0：退出");
		System.out.print("请输入选择：");
		int item = Integer.valueOf(s.nextLine());
		while(item != 0){
			switch (item) {
			case 1:
				new Random().view();
				break;
			case 2:
				new Calculator().view();
				break;
			case 3:
				new Matter().view();
				break;
			case 4:
				new Score().view();
				break;
			case 5:
				new Spend().view();
				break;
			default:
				break;
			}
			System.out.println("日常辅助系统"); 
			System.out.println("1：随机工具");
			System.out.println("2：计算器");
			System.out.println("3：记事本");
			System.out.println("4：学分统计");
			System.out.println("5：记账工具");
			System.out.println("0：退出");
			System.out.print("请输入选择：");
			item = Integer.valueOf(s.nextLine());
		}
	}
}
