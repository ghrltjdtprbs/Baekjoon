package day_5;

import java.io.*;
import java.util.*;

public class b_3986 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            for (int j = 0; j < tmp.length(); j++) {
                char current = tmp.charAt(j);
                if(!stack.isEmpty() && stack.getLast() == current){
                    stack.removeLast();
                }else{
                    stack.addLast(current);
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        System.out.println(answer);
    }

}
