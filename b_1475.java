package day_2;

import java.util.Scanner;
/*
- 1~9 배열 생성
- 각 인덱스를 필요한 숫자라 치고, 해당 인덱스에 + 1(단 6,9일 경우 따로 처리)
- 최댓값 구하기
 */
public class b_1475 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int[] number = new int[10];
        int max = 0;

        for(int i = 0; i < n.length(); i++){
            int current = Integer.parseInt(String.valueOf(n.charAt(i)));
            if(current == 6 || current == 9){
                if(number[6] <= number[9]){
                    number[6] += 1;
                }else{number[9] += 1;}
                max = Math.max(max,Math.max(number[9],number[6]));
            }else{
                number[current]+=1;
                max = Math.max(max,number[current]);
            }
        }

        System.out.println(max);
    }

}
