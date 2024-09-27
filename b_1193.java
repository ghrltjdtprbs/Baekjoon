package day_2;

import java.util.Scanner;

/*
- 1씩 증가하는 count 선언
- if( 1 == 앞자리) 이면, 앞자리 증가 && 뒷자리 감소 -> count만큼 반복
- if( count == 앞자리) 이면, 앞자리 감소 && 뒷자리 증가 -> count만큼 반복
 */
public class b_1193 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int first = 1;
        int second = 1;
        int count = 1;

        while(n > count){
            n -= count;
            count++;
        }

        if(count % 2 == 0){
            first = n;
            second = count - n + 1;
        }else{
            second = n;
            first = count - n + 1;
        }

        System.out.println(first + "/" + second);
    }
}
/*
1/1 1

1/2 2
2/1 3

3/1 4
2/2 5
1/3 6

1/4 7
2/3 8
3/2 9
4/1 10

5/1 11
4/2 12
3/3 13
2/4 14
1/5 15
 */