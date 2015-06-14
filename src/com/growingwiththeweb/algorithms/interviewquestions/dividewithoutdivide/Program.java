package com.growingwiththeweb.algorithms.interviewquestions.dividewithoutdivide;

public class Program {
	public static void main(String[] args) {
		assert divide(10,4) == 2;
		assert divide(11,4) == 2;
		assert divide(12,4) == 3;
		assert divide(13,4) == 3;
		assert divide(130,3) == 43;

		System.out.println("Tests passed");
	}

	public static double divide(double a, double b) {
		int sign = 1;
		if (a < 0) {
			a = -a;
			sign = -sign;
		}
		if (b < 0) {
			b = -b;
			sign = -sign;
		}
		double result = 0;
		while (a >= 0) {
			a -= b;
			result++;
		}
		return (result - 1) * sign;
	}
}
