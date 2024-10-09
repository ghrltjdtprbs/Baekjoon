package day_4;
import java.util.*;
public class b_7785 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        Set<String> list = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < test_case; i++){
            String name = sc.next();
            String status = sc.next();
            if(status.equals("enter")){
                list.add(name);
            }else{
                list.remove(name);
            }
        }

        for(String name : list){
            System.out.println(name);
        }
    }

}
