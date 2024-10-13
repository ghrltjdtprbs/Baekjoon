package day_4;
import java.util.*;
public class b_17413 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean tag = false;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length();i ++){
            char current = s.charAt(i);
            if(tag == true){
                if(current == '>'){
                    sb.append(current);
                    System.out.print(sb);
                    sb.setLength(0);
                    tag = false;
                }else{
                    sb.append(current);
                }
            }else{
                if(current ==' '){
                    System.out.print(sb.reverse());
                    sb.setLength(0);
                    System.out.print(current);
                }else if(current == '<'){
                    tag = true;
                    System.out.print(sb.reverse());
                    sb.setLength(0);
                    sb.append(current);
                }else{
                    sb.append(current);
                }

            }
        }
        System.out.print(sb.reverse());
    }

}
