import java.util.*;

public class b_4344 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int people = sc.nextInt();
            int[] score = new int[people];
            int totalScore = 0;
            int highPeople = 0;
            for (int j = 0; j < score.length; j++) {
                score[j] = sc.nextInt();
                totalScore += score[j];
            }
            double average = (double) totalScore / people;
            for (int c = 0; c < score.length; c++) {
                if (score[c] > average) {
                    highPeople++;
                }
            }

            double percentage = (double) highPeople / people * 100;
            System.out.printf("%.3f%%\n", percentage);
        }

        sc.close();
    }
}
