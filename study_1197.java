package study;

import java.util.*;
import java.io.*;

public class study_1197 {
    static int[] parent;
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int cost;
        public Edge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        parent = new int[node + 1];
        for(int i = 1; i <=node; i++){
            parent[i] = i;
        }

        List<Edge> edges = new ArrayList<>();
        for(int i =0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int start_node = Integer.parseInt(st.nextToken());
            int end_node = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start_node,end_node,cost));
        }
        Collections.sort(edges);

        int count = 0;
        int minCost = 0;
        for(Edge current_edge : edges){
            if(find(current_edge.start) != find(current_edge.end)){
                union(current_edge.start, current_edge.end);
                count++;
                minCost += current_edge.cost;
            }
            if(count == node - 1){
                break;
            }
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
