import java.util.Scanner;
//수 이어 쓰기
/*
- 이중 while문 때문에 시간 초과?(수열을 처음부터 비교)
    -> 수열을 처음부터 탐색하되, 각 자기수에 대해 가능한 최대 숫자 찾음
    -> 메모리 초과
    -> 문자열 처리 최소화 String.substring() 삭제  -> 시간초과
*/
public class b1515 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String remainingNumbers = sc.nextLine();

        int n = 1;
        int index = 0;
        int length = remainingNumbers.length();

        while (index < length) {
            int num = n;
            int tempIndex = index;
            boolean isMatch = true;

            // 숫자 n의 각 자리수를 확인하며 주어진 수열과 비교
            for (int div = (int) Math.pow(10, (int) Math.log10(num)); div > 0; div /= 10) {
                if (tempIndex < length && (num / div) % 10 == remainingNumbers.charAt(tempIndex) - '0') {
                    tempIndex++;
                } else {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                // 현재 숫자(n)가 주어진 수열에 존재하는 경우
                index = tempIndex;
                n++;
            } else {
                // 현재 숫자(n)가 주어진 수열에 존재하지 않는 경우
                n++;
            }
        }

        // 가능한 N 중 최솟값 출력
        System.out.println(n - 1);
    }
}

/*    Scanner sc = new Scanner(System.in);
    String remainingNumbers = sc.nextLine();

    int n = 1;
    int index = 0;

        while (index < remainingNumbers.length()) {
    String currentNumber = String.valueOf(n);
    int nextIndex = index + currentNumber.length();

    if (nextIndex <= remainingNumbers.length() &&
    remainingNumbers.substring(index, nextIndex).equals(currentNumber)) {
    // 현재 숫자(n)가 주어진 수열에 존재하는 경우
    index = nextIndex;
    } else {
    // 현재 숫자(n)가 주어진 수열에 존재하지 않는 경우
    n++;
    }
    }

    // 가능한 N 중 최솟값 출력
    System.out.println(n);
    }
    */
