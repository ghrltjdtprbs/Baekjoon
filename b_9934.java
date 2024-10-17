package day_9;

import java.util.*;

public class b_9934 {
    static int[] node;
    static List<List<Integer>> tree = new ArrayList<>();
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int nodeCount = (int)Math.pow(2, K) - 1;
        node = new int[nodeCount];

        for(int i = 0; i < nodeCount; i++){
            node[i] = sc.nextInt();
        }

        for(int i = 0; i < K; i++){
            tree.add(new ArrayList<>());
        }

        inOreder(0, nodeCount - 1, 0);

        for(List<Integer> level : tree){
            for(int i : level){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    private static void inOreder(int start, int end, int depth){
        if(start > end) return;
        int mid = (start + end) / 2;
        tree.get(depth).add(node[mid]);
        inOreder(start, mid - 1, depth + 1);
        inOreder(mid + 1, end, depth + 1);
    }
}



