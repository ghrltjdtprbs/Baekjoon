import java.util.Scanner;
public class Main_2563 {
    public static void main(String[] args) {
        //흰 도화지 생성
        int [][] array = new int[100][100];



        Scanner sc = new Scanner(System.in);
        int num;//색종이 갯수
        int left;//색종이와 왼쪽 변 사이의 거리
        int bottom;//색종이와 아래쪽 변 사이의 거리
        int result=0;

        num=sc.nextInt();
        for(int i=0;i<num;i++){

            left=sc.nextInt();
            bottom=sc.nextInt();
            for(int j =0;j<10;j++) {
                // System.out.println(j+"and");
                for(int a=0;a<10;a++) {
                    array[left+j][100-(bottom+a)] = 5;
                    // System.out.println(a);
                }
            }

        }
        //넓이 구하기
        for(int a=0;a<100;a++){
            for(int j=0;j<100;j++) {
                if(array[a][j]==5){
                    result++;
                }
            }
        }
        System.out.print(result);


    }
}
