package controller;

public interface ICalculator {
	public double add(double a, double b);
	public double subtract(double a, double b);
	public double multiply(double a, double b);
	public double divide(double a, double b) throws Exception;
	public double square(double a, double b);
	public double factorial(double a) throws Exception;
}
