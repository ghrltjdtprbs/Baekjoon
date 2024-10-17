package day_9;
import java.util.*;
import java.io.*;
public class b_16173 {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static boolean win = false;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        game(0,0);
        if(win){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }

    }
    private static void game(int x, int y){
        if(x == n - 1 && y == n - 1){
            win = true;
            return;
        }
        if(x > n - 1 || y > n - 1){
            return;
        }
        if(!visited[x][y]){
            int tmp = board[x][y];
            visited[x][y] = true;
            game(x + tmp, y);
            game(x,y + tmp);
        }
    }

}
