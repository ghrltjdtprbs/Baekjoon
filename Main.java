package lab1_1;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab1_1 : ������");
		// factorial(n)�� ȣ���Ͽ� 1���� n���� ���� ���Ͽ� ����Ѵ�.
		System.out.println(factorial(1));
		System.out.println(factorial(5));
		System.out.println(factorial(10));
		// sum(n)�� ȣ���Ͽ� 1���� n���� ���� ���Ͽ� ����Ѵ�.
		System.out.println(sum(1));
		System.out.println(sum(5));
		System.out.println(sum(10));
		// show(n)�� ȣ���Ͽ� 1���� n���� ����Ѵ�.
		show(1);
		System.out.println();
		show(5);
		System.out.println();
		show(10);
	}
	// n�� �Ű������� �޾� 1���� n���� ���� �����ϴ� ��� �޼ҵ� factorial
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
