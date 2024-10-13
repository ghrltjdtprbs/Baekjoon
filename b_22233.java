package day_4;
import java.util.*;
public class b_22233 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int keyword = sc.nextInt();
        int blog = sc.nextInt();
        sc.nextLine();
        Set<String> set = new HashSet<>();
        for(int i = 0;i < keyword;i++){
            set.add(sc.nextLine());
        }
        for(int i = 0; i < blog; i++){
            String write = sc.nextLine();
            String[] list = write.split(",");
            for(int k = 0; k < list.length; k++){
                set.remove(list[k]);
            }
            System.out.println(set.size());

        }
    }
}
