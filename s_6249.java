package softeer;
import java.util.*;
import java.io.*;
public class s_6249 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test_case = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        String[] ex = new String[test_case];

        for(int i = 0; i < test_case; i++){
            ex[i] = br.readLine();
        }
        int answer = 0;
        for(int i = 0; i < test_case; i++){
            String current = ex[i];
            for(int j = i + 1; j < test_case; j++){
                String next = ex[j];
                if(next.charAt(0) == '.' || next.charAt(0) == current.charAt(0)) {
                    boolean flag = true;
                    for (int k = 0; k < len; k++) {
                        if (next.charAt(k) != '.' && next.charAt(k) != current.charAt(k)) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
