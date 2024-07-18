// 그짓말
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class b_1043 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        boolean[] people_know = new boolean[n+1];

        HashSet<Integer>[] parties = new HashSet[m+1];
        for (int i = 1; i <= m; i++) {
            parties[i] = new HashSet<>();
        }

        inputs = br.readLine().split(" ");
        int know_num = Integer.parseInt(inputs[0]);


        //진실 알고 잇는 사람들 true
        for (int i = 1; i <= know_num; i++) {
            int tmp = Integer.parseInt(inputs[i]);
            people_know[tmp] = true;
        }

        //부모 자기자신 가르키도록 parent 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int p = 1; p <= m; p++) {
            inputs = br.readLine().split(" ");
            int party_num = Integer.parseInt(inputs[0]); // 파티에 오는 사람 수

            if(party_num<=1) {
                parties[p].add(Integer.parseInt(inputs[1]));
                continue;
            }

            for (int j = 1; j < party_num; j++) { // 연관 관계 이어줌
                int a = Integer.parseInt(inputs[j]);
                int b = Integer.parseInt(inputs[j+1]);
                if (find(a) != find(b)) {
                    union(a,b);
                }

                parties[p].add(a); // 파티에 참여하는 사람 저장
                parties[p].add(b);
            }
        }

        //진실아는 사람이랑 연결되어 있으면 true
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if(people_know[i] && !visited[i]){
                int root = find(i);
                for (int j = 1; j <= n; j++){
                    if (find(j)==root) {
                        people_know[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        // 모든 파티 참석자가 F여야 과장된 얘기를 할 수 있음
        int result = 0;
        for (int i = 1; i <= m; i++) { // party
            boolean flag = false;
            for (int person : parties[i]) { // 참석자
                if(people_know[person]){
                    flag = true;
                    break;
                }
            }
            if(!flag) result++;
        }

        System.out.println(result);
    }

    public static int find(int idx) {
        if(parent[idx]==idx){
            return idx;
        }
        parent[idx] = find(parent[idx]);
        return parent[idx];
    }

    public static void union(int a, int b) {
        int parent_b = find(b);
        parent[parent_b] = a;
    }

}