package day_3;

import java.util.Scanner;

public class b_24417 {
    static int fib_n = 0;
    static int fibonacci_n = 0;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fib(n);
        int[] f = new int[n+1];
        fibonacci(f);

        System.out.println(fib_n%1000000007 + " " + fibonacci_n%1000000007);
    }

    private static int fib(int n){
        if(n == 1 || n == 2){
            fib_n++;
            return 1;
        }else{
            return(fib(n - 1) + fib(n - 2));
        }
    }

    private static int fibonacci(int[] f){
        f[1] = 1;
        f[2] = 1;
        for(int i = 3; i < f.length; i++){
            fibonacci_n++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[f.length - 1];
    }

}
