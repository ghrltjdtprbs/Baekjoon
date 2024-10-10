package day_6;
import java.util.*;
import java.io.*;
public class b_10845 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            if(tmp.equals("push")){
                int current = Integer.parseInt(st.nextToken());
                queue.add(current);
            }else{
                if(tmp.equals("pop")){
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(queue.removeFirst());
                    }
                } else if (tmp.equals("size")) {
                    System.out.println(queue.size());
                } else if(tmp.equals("empty")){
                    if(queue.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                } else if (tmp.equals("front")) {
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(queue.getFirst());
                    }
                }else if (tmp.equals("back")) {
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(queue.getLast());
                    }
                }
            }
        }
    }
}
