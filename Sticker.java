package hw9_1;
import java.util.Scanner;
public class Sticker {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int T = scanner.nextInt();
	        //�׽�Ʈ���̽��� �����Է�

	        for (int i = 0; i < T; i++) {
	            int n = scanner.nextInt();//��ƼĿ �� �Է�
	            int[][] ary = new int[2][n + 1];
	            int[][] peb = new int[2][n + 1];//dp�� ���� ary�� �Ȱ��� ũ�� �迭 ����
	            for (int j = 0; j < 2; j++) { 
	                for (int k = 1; k <= n; k++) {
	                	ary[j][k] = scanner.nextInt();//ary�迭 �� �Է¹���
	                }
	            }
	            //peb�� ù���� ������ ������ �����Ƿ�=aryù��
	            peb[0][1] = ary[0][1];
	            peb[1][1] = ary[1][1];
	            for (int a = 2; a <= n; a++) {
	            	peb[0][a] = Math.max(peb[1][a - 1], peb[1][a - 2]) + ary[0][a];
	            	peb[1][a] = Math.max(peb[0][a - 1], peb[0][a - 2]) + ary[1][a];
	            }//peb�� ä����� ĭ�� �ٸ��� -1, -2ĭ �߿� ū �����ٰ� ary�� ���������� ���ؾ���
	            System.out.println(Math.max(peb[0][n], peb[1][n]));
	            //peb�� ������ �� �߿� �� ū ���� �ְ� �����̴�
	        }
	    }
	}