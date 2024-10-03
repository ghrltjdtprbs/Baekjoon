package day_5;

import java.util.*;

public class b_10815 {
    static int[] arr;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            int tmp = sc.nextInt();
            System.out.print(binarySearch(tmp) + " ");
        }
    }

    private static int binarySearch(int tmp){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(tmp == arr[mid]){
                return 1;
            }else if(tmp > arr[mid]){
                left = mid + 1;
            }else if(tmp < arr[mid]){
                right = mid - 1;
            }
        }
        return 0;
    }
}
