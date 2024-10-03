package day_5;
import java.util.*;
public class b_24265 {
    static int count = 0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n+1];
        MenOfPassion(A,n);
        System.out.println((long)count);
        System.out.println(2);
    }
    private static int MenOfPassion(int A[],int n){
        int sum = 0;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                sum += A[i] * A[j];
                count++;
            }
        }
        return sum;
    }

}
