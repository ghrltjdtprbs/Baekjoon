import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2607 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int result = 0;

        for(int i = 0; i < N - 1; i++) {
            String str = br.readLine();
            int[] wordCount = getWordCount(first);

            int matchedChars = 0; // 같은 단어 개수
            for(char c : str.toCharArray()) {
                if(wordCount[c - 'A'] > 0) {
                    matchedChars++;
                    wordCount[c - 'A']--;
                }
            }

            if (isSimilarWord(first.length(), str.length(), matchedChars)) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static int[] getWordCount(String word) {
        int[] wordCount = new int[26];
        for(char c : word.toCharArray()) {
            wordCount[c - 'A']++;
        }
        return wordCount;
    }

    private static boolean isSimilarWord(int lenFirst, int lenSecond, int matched) {
        return (lenFirst == lenSecond && (lenFirst == matched || lenFirst - 1 == matched))
            || (lenFirst == lenSecond - 1 && lenSecond - 1 == matched)
            || (lenFirst == lenSecond + 1 && lenSecond == matched);
    }
}