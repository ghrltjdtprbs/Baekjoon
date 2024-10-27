package softeer;

import java.io.*;
import java.util.*;

public class s_277730 {
    static int n = 0;
    static int[][] trees;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int answer = 0;
  public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());

      trees = new int[n][n];
      visited = new boolean[n][n];

      for(int i = 0; i < n; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j = 0; j < n; j++){
              trees[i][j] = Integer.parseInt(st.nextToken());
          }
      }
      backTracking(0,0);
      System.out.println(answer);

  }
  private static void backTracking(int tmpValue,int depth){
      if(depth == 4){
          answer = Math.max(answer,tmpValue);
          return;
      }

      for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
              if(!visited[i][j]){
                  visited[i][j] = true;
                  for(int k = 0; k < 4; k++){
                      int x_tmp = j + dx[k];
                      int y_tmp = i + dy[k];
                      if(x_tmp >= 0 && y_tmp >= 0 && x_tmp < n && y_tmp < n && !visited[y_tmp][x_tmp]){
                          visited[y_tmp][x_tmp] = true;
                          int newValue = tmpValue + trees[i][j] + trees[y_tmp][x_tmp];
                          backTracking(newValue,depth + 1);
                          visited[y_tmp][x_tmp] = false;
                      }
                  }
                  visited[i][j] = false;
              }
          }
      }
      answer = Math.max(answer,tmpValue);

  }
}
