package day_4;

import java.util.Scanner;

public class b_2908 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuffer a = new StringBuffer(sc.next());
        StringBuffer b = new StringBuffer(sc.next());

        int first = Integer.parseInt(a.reverse().toString());
        int second = Integer.parseInt(b.reverse().toString());

        System.out.println(Math.max(first,second));
    }
}
