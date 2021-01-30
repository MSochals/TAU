package com.journaldev.utils;

public interface Calculator {

	int add(int x, int y);
	int multiply(int x, int y);
}

public class MathUtils {

	private Calculator calc;
	
	public MathUtils(Calculator c) {
		this.calc = c;
	}
	
	public int add(int i, int j) {
		return this.calc.add(i, j);
	}
	
	public int multiply(int i, int j) {
		return this.calc.multiply(i, j);
	}
}
