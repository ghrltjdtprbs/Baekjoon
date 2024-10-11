package day_7;

import java.io.*;
import java.util.*;

public class b_9933 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder(br.readLine());
            set.add(sb.toString());
            String reverse = sb.reverse().toString();
            if(set.contains(reverse)){
                int len = reverse.length();
                int middle = len/2;
                System.out.print(len + " " + reverse.charAt(middle));
            }else{
                set.add(reverse);
            }
        }

    }
}
