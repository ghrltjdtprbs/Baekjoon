package day_4;
import java.util.*;
public class b_11478 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                set.add(s.substring(i,j));
            }
        }

        System.out.println(set.size());
    }
}
