package study;
// 문자열을 순회하며 폭발 문자열과 동일한 글자가 있는지 찾아낸다.
// 이어붙인 글자에서 폭발문자열이 생길 수 있으니 폭발 문자열 가장 마지막 글자가 일치하면 검사시작
// 폭발 문자열이 맞으면 스택에서 제거

import java.util.*;
import java.io.*;

public class study_9935 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String base = br.readLine();
        String boom = br.readLine();

        Stack<Character> stack = new Stack<>();

        boolean flag = false;
        //문자열 검사
        for (int i = 0; i < base.length(); i++) {
            char current = base.charAt(i);
            stack.push(current);
            if (stack.size() >= boom.length()) {
                if (current == boom.charAt(boom.length() - 1)) {
                    flag = true;
                    for (int j = 0; j < boom.length(); j++) {
                        if (boom.charAt(j) != stack.get(stack.size() - boom.length() + j)) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    for (int j = 0; j < boom.length(); j++) {
                        stack.pop();
                    }
                    flag = false;
                }
            }
        }

        if (stack.size() == 0) {
            System.out.println("FRULA");
        } else {
            StringBuilder result = new StringBuilder();
            for (char c : stack) {
                result.append(c);
            }
            System.out.println(result.toString());
            // 특이사항 : 그냥 프린트하면 시간초과나고 stringbuilder로 만들어서 출력해야함...^^
        }

    }
}
