package day_9;
import java.util.*;
public class b_1388 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//세로
        int m = sc.nextInt();//가로
        int answer = 0;
        char[][] floor = new char[n][m];
        sc.nextLine();
        for(int i = 0; i < n; i ++){
            String tmp = sc.nextLine();
            for(int j = 0; j < m; j++){
                floor[i][j] = tmp.charAt(j);
            }
        }
        //가로구하기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(floor[i][j] == '-'){
                    answer++;
                    while(j < m && floor[i][j] == '-'){
                        j++;
                    }
                }
            }
        }

        //세로구하기
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(floor[j][i] == '|'){
                    answer++;
                    while(j < n && floor[j][i] == '|'){
                        j++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
