package day_6;
import java.util.*;
import java.io.*;
public class b_1406 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int cusor = sb.length();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("P")){
                String tmp = st.nextToken();
                sb.insert(cusor,tmp);
                cusor++;
            }else if(command.equals("L")){
                if(cusor != 0) cusor--;
            }else if(command.equals("D")){
                if(cusor != sb.length()) cusor++;
            }else if (command.equals("B")){
                if(cusor != 0) {
                    sb.deleteCharAt(cusor - 1);
                    cusor--;
                }
            }
        }
        System.out.println(sb);

    }
}
