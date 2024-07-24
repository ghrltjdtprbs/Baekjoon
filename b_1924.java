import java.util.*;

/*
 * month, day 입력받기
 * 배열 선언해서 month 일자 수 넣기
 * 월요일 기준으로 나누기(나머지 기준으로 mon ++)
 * */
public class b_1924 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();
        int totalDay = 0;
        int extraDay = 0;
        int[] monthday = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayName = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        if (month == 1) {
            if (day <= 7) {
                System.out.print(dayName[day]);
            } else {
                extraDay = day % 7;
                System.out.print(dayName[extraDay]);
            }
        } else {
            for (int i = 0; i < month - 1; i++) {
                totalDay += monthday[i];
            }
            extraDay = (totalDay + day) % 7;
            System.out.print(dayName[extraDay]);
        }
    }
}
