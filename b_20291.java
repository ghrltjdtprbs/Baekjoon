package day_4;
import java.util.*;
public class b_20291 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        sc.nextLine();
        Map<String,Integer> map = new TreeMap<>();

        for(int i = 0; i < test_case; i++){
            String file = sc.nextLine();
            String[] file_name = file.split("\\.");
            String extension = file_name[1];
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i) + " " + map.get(list.get(i)));
        }
    }

}
