import java.util.Scanner;

public class b_1926 {
    static int n, m;
    static int[][] canvas;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; // 상하좌우 이동
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        canvas = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                canvas[i][j] = sc.nextInt();
            }
        }

        int numberOfPictures = 0; // 그림 개수
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //새로운 그림 발견
                if (canvas[i][j] == 1 && !visited[i][j]) {
                    numberOfPictures++;
                    int area = dfs(i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        System.out.println(numberOfPictures);
        System.out.println(maxArea);
    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int area = 1; // 현재 위치도 포함하므로 초기값은 1

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (canvas[nx][ny] == 1 && !visited[nx][ny]) {
                    area += dfs(nx, ny);
                }
            }
        }

        return area;
    }
}
