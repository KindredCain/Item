package controller;

public class CalculatorController implements ICalculator{
	/*计算器操作类*/
	@Override
	public double add(double a, double b) {
		// TODO Auto-generated method stub
		double result = 0;
		result = a + b;
		return result;
	}

	@Override
	public double subtract(double a, double b) {
		// TODO Auto-generated method stub
		double result = 0;
		result = a - b;
		return result;
	}

	@Override
	public double multiply(double a, double b) {
		// TODO Auto-generated method stub
		double result = 0;
		result = a * b;
		return result;
	}

	@Override
	public double divide(double a, double b) throws Exception {
		// TODO Auto-generated method stub
		double result = 0;
		if(b == 0)
			throw new Exception("除数为零");
		else
			result = a / b;
		return result;
	}

	@Override
	public double square(double a, double b) {
		// TODO Auto-generated method stub
		double result = 0;
		result = Math.pow(a, b);
		return result;
	}

	@Override
	public double factorial(double a) throws Exception {
		// TODO Auto-generated method stub
		double result = 1;
		if((a == (int)a) && a >= 0){
			for(int i = 1; i <= a; i++){
				result *= i;
			}
		}
		else
			throw new Exception("不为正整数");
		return result;
	}

}
