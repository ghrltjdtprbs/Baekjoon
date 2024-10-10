package day_6;
import java.io.*;
public class b_1769 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int change = 0;
        while(s.length() > 1){
            int s_tmp = 0;
            change++;
            for(int i = 0; i < s.length(); i++){
                s_tmp += s.charAt(i) - '0';
            }
            s = String.valueOf(s_tmp);
        }
        System.out.println(change);
        if(Integer.parseInt(s)%3 == 0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

}
