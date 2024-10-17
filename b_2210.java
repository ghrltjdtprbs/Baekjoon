package day_9;

import java.util.*;
import java.io.*;

public class b_2210 {
    static String[][] board = new String[5][5];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static Set<String> set = new HashSet<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                board[i][j] = st.nextToken();
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                dfs(i,j,0,"");
            }
        }

        System.out.println(set.size());

    }

    private static void dfs(int x, int y, int depth, String answer){
        if (depth == 6) {
            set.add(answer);
            return;
        }
        answer += board[x][y];

        for(int i = 0; i < 4; i ++){
            int tmp_x = x + dx[i];
            int tmp_y = y + dy[i];
            if(tmp_x >= 0 && tmp_y >= 0 && tmp_x < 5 && tmp_y < 5){
                dfs(tmp_x, tmp_y, depth + 1, answer);
            }
        }
    }
}
