package view;

import java.util.Scanner;

import controller.CalculatorController;

public class Calculator {
	/*计算器系统交互*/
	CalculatorController calculator = new CalculatorController();
	Scanner s = new Scanner(System.in);
	
	public void view (){
		double result = 0;
		System.out.println("计算器");
		System.out.println("通过输入数字和+（加）、-（减）、*（乘）、/（除）、^（次方）、!（阶乘）操作计算器，直接输入运算符则对结果继续运算，输入‘C’清除结果，输入‘ESC’退出计算器。（目前只支持一次运算）");
		System.out.println("结果：" + result);
		System.out.println("请输入：");
		String item = s.nextLine();
		while(!(item.equals("ESC") || item.equals("esc"))){
			item = item.replace(" ", "");
			int add = item.indexOf("+");
			int subtract = item.indexOf("-");
			int multiply = item.indexOf("*");
			int divide = item.indexOf("/");
			int square = item.indexOf("^");
			int factorial = item.indexOf("!");
			if(add >= 0){
				if(add == 0){
					double a = Double.parseDouble(item.substring(add + 1));
					result = calculator.add(result, a);
				}
				else{
					double a = Double.parseDouble(item.substring(0,add));
					double b = Double.parseDouble(item.substring(add + 1));
					result = calculator.add(a, b);
				}
			}
			else if(subtract >= 0){
				if(subtract == 0){
					double a = Double.parseDouble(item.substring(subtract + 1));
					result = calculator.subtract(result, a);
				}
				else{
					double a = Double.parseDouble(item.substring(0,subtract));
					double b = Double.parseDouble(item.substring(subtract + 1));
					result = calculator.subtract(a, b);
				}
			}
			else if(multiply >= 0){
				if(multiply == 0){
					double a = Double.parseDouble(item.substring(multiply + 1));
					result = calculator.multiply(result, a);
				}
				else{
					double a = Double.parseDouble(item.substring(0,multiply));
					double b = Double.parseDouble(item.substring(multiply + 1));
					result = calculator.multiply(a, b);
				}
			}
			else if(divide >= 0){
				if(divide == 0){
					double a = Double.parseDouble(item.substring(divide + 1));
					try {
						result = calculator.divide(result, a);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
				}
				else{
					double a = Double.parseDouble(item.substring(0,divide));
					double b = Double.parseDouble(item.substring(divide + 1));
					try {
						result = calculator.divide(a, b);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
				}
			}
			else if(square >= 0){
				if(square == 0){
					double a = Double.parseDouble(item.substring(square + 1));
					result = calculator.square(result, a);
				}
				else{
					double a = Double.parseDouble(item.substring(0,square));
					double b = Double.parseDouble(item.substring(square + 1));
					result = calculator.square(a, b);
				}
			}
			else if(factorial >= 0){
				if(factorial == 0){
					try {
						result = calculator.factorial(result);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
				}
				else{
					double a = Double.parseDouble(item.substring(0,factorial));
					try {
						result = calculator.factorial(a);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
				}
			}
			else if(item.equals("C") || item.equals("c"))
				result = 0;
			System.out.println("结果：" + result);
			System.out.println("请输入：");
			item = s.nextLine();
		}
	}
}
