package lab1_1;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab1_1 : 최혜미");
		// factorial(n)을 호출하여 1부터 n까지 곱을 구하여 출력한다.
		System.out.println(factorial(1));
		System.out.println(factorial(5));
		System.out.println(factorial(10));
		// sum(n)을 호출하여 1부터 n까지 합을 구하여 출력한다.
		System.out.println(sum(1));
		System.out.println(sum(5));
		System.out.println(sum(10));
		// show(n)을 호출하여 1부터 n까지 출력한다.
		show(1);
		System.out.println();
		show(5);
		System.out.println();
		show(10);
	}
	// n을 매개변수로 받아 1부터 n까지 곱을 리턴하는 재귀 메소드 factorial
	private static int factorial(int n) {
		if(n == 1) {
			return 1;
		}
		else
			return n * factorial(n-1);
	}




	private static int sum(int n) {
		if(n==1) {
			return 1;
		}
		else {
			return n + sum(n-1);
		}
	}



	private static void show(int n) {
		if(n==1) {
			System.out.print(1);
		}
		else {
			show(n-1);
			System.out.print(" "+n);
		}
	}
}
