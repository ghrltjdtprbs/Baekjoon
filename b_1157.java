package day_4;

import java.util.*;

public class b_1157 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.toUpperCase();

        Map<Character,Integer> map = new TreeMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                int tmp = map.get(s.charAt(i));
                tmp++;
                map.replace(s.charAt(i),tmp);
            }else{
                map.put(s.charAt(i),1);
            }
        }

        



    }
}
