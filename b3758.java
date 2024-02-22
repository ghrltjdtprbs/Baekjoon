import java.util.*;
/*
KCPC
각 팀의 점수와 관련 정보를 저장할 자료 구조를 만듦
로그 엔트리를 반복하면서 각 팀의 최고 점수와 제출 횟수를 업데이트.
모든 팀의 최종 점수를 계산한 후, 주어진 조건에 따라 순위를 결정
 */
class Team {
    int id, score, submissions, lastSubmissionTime;

    Team(int id) {
        this.id = id;
        this.score = 0;
        this.submissions = 0;
        this.lastSubmissionTime = 0;
    }
}
public class b3758 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();  // 테스트 케이스의 수

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt(); // 팀의 수
            int k = scanner.nextInt(); // 문제의 수
            int teamId = scanner.nextInt(); // 당신 팀의 ID
            int m = scanner.nextInt(); // 로그 엔트리의 수

            Map<Integer, Team> teams = new HashMap<>();
            for (int i = 0; i < n; i++) {
                teams.put(i + 1, new Team(i + 1));
            }

            int[][] scores = new int[n + 1][k + 1]; // 각 팀의 각 문제별 최고 점수

            for (int i = 0; i < m; i++) {
                int id = scanner.nextInt();
                int problem = scanner.nextInt();
                int score = scanner.nextInt();

                Team team = teams.get(id);
                if (score > scores[id][problem]) {
                    team.score += score - scores[id][problem];
                    scores[id][problem] = score;
                }

                team.submissions++;
                team.lastSubmissionTime = i;
            }

            List<Team> teamList = new ArrayList<>(teams.values());
            teamList.sort((a, b) -> {
                if (a.score != b.score) return b.score - a.score;
                if (a.submissions != b.submissions) return a.submissions - b.submissions;
                return a.lastSubmissionTime - b.lastSubmissionTime;
            });

            for (int i = 0; i < teamList.size(); i++) {
                if (teamList.get(i).id == teamId) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }

        scanner.close();
    }
}
