package study;
import java.util.*;
import java.io.*;
// 최소스패닝 정석
public class study_1922 {
    static int[] parent;
    //간선 정보 저장할 클래스
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int cost;
        public Edge(int start,int end,int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>();

        // find 메서드에서 사용할 부모 배열 초기화
        parent = new int[node+1];
        for(int i = 1; i <= node; i++){
            parent[i] = i;
        }

        // 간선 전부 edges에 넣고 정렬
        for(int i = 0; i < edge; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start_node = Integer.parseInt(st.nextToken());
            int end_node = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start_node,end_node,cost));
        }
        Collections.sort(edges);

        int minCost = 0;
        int count = 0;
        for(Edge e : edges){
            //부모가 같지 않아야 사이클 형성 x
            if(find(e.start) != find(e.end)){
                union(e.start, e.end);
                minCost += e.cost;
                count++;
            }
            //최소비용스패닝트리는 최종 간선이 노드 - 1개
            if(count == node - 1) break;
        }

        System.out.println(minCost);
    }
    private static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[a] = b;
        }
    }
}
