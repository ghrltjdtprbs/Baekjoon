/*
(h, w)에서 상하좌우 네 방향을 탐색하여 동일한 색깔의 칸을 세어 count에 저장
 + 격자 범위를 벗어나지 않는지도 확인
 ??왜틀림?
 */

public class p250125 {
    public int solution(String[][] board, int h, int w) {
        int count = 0; // 같은 색으로 색칠된 칸의 개수

        // h와 w의 변화량 저장
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        // 주어진 칸 색깔
        String selectedColor = board[h][w];

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];

            // 탐색 위치가 격자 내에 있고, 선택한 칸과 같은 색이면 카운트 증가
            if (nh >= 0 && nh < board.length && nw >= 0 && nw < board[0].length) {
                if (board[nh][nw].equals(selectedColor)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        p250125 solution = new p250125();
        String[][] board1 = {
            {"blue", "red", "orange", "red"},
            {"red", "red", "blue", "orange"},
            {"blue", "orange", "red", "red"},
            {"orange", "orange", "red", "blue"}
        };
        System.out.println(solution.solution(board1, 1, 1)); // 결과 2

        String[][] board2 = {
            {"yellow", "green", "blue"},
            {"blue", "green", "yellow"},
            {"yellow", "blue", "blue"}
        };
        System.out.println(solution.solution(board2, 0, 1)); // 결과 1
    }
}
