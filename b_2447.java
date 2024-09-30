package day_3;
import java.util.Scanner;
public class b_2447 {
    static char[][] arr;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new char[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = '*';
            }
        }
        draw(0,0,N);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    private static void draw(int x, int y, int len){
        if(len == 1) return;
        int newLen = len/3;
        for(int i = x + newLen; i < x + newLen*2; i++){
            for(int j = y + newLen; j < y + newLen*2; j++){
                arr[i][j] = ' ';
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == 1 && j == 1) continue;
                draw(x + newLen*i,y+newLen*j,newLen);
            }
        }
    }

}
