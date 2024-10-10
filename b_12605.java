package day_6;
import java.util.*;
import java.io.*;
public class b_12605 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int case_number = 1;
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<String> stack = new ArrayDeque<>();
            while(st.hasMoreTokens()){
                stack.addLast(st.nextToken());
            }
            System.out.print("Case #" + case_number + ": ");
            while(!stack.isEmpty()){
                String tmp = stack.removeLast();
                System.out.print(tmp + " ");
            }
            System.out.println();
            case_number++;
        }
    }

}
