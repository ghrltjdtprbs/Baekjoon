import java.util.*;
/*
- 3개 주사위 숫자 입력
- 전부 같을 경우 if 처리
- 두개가 같을 경우 if 처리
- 모두 틀릴 경우 if 처리
*/
public class b_2480 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a == b && b == c){
            System.out.print(10000 + a * 1000);
        }else if((a == b && b != c) || (a == c && a != b) || (b == c && a != b)){
            if(a == b || a == c){
                System.out.print(1000 + a * 100);
            }else{
                System.out.print(1000 + b * 100);
            }
        }else{
            int maxNumber = Math.max(Math.max(a,b),c);
            System.out.print(maxNumber * 100);
        }
    }
}
