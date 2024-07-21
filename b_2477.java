import java.util.*;

public class b_2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cham = sc.nextInt();
        int[] dir = new int[6];
        int[] len = new int[6];
        int maxArea = 0;
        int smallArea = 0;

        for(int i = 0; i < 6; i++){
            dir[i] = sc.nextInt();
            len[i] = sc.nextInt();
        }

        if(dir[0] == dir[2] && dir[1] != dir[3]){
            smallArea = len[0] * len[1];
            maxArea = (len[0] + len[2]) * (len[1] + len[5]);
        }else{
            for(int i = 0; i < 6; i++){
                if(dir[i] == dir[i + 2]){
                    smallArea = len[i + 1] * len[i + 2];
                    System.out.println(smallArea);
                    maxArea = (len[i] + len[i + 2]) * (len[i + 1] + len[i + 3]);
                    break;
                }
            }
        }

        System.out.print(cham * (maxArea - smallArea));

    }
}
