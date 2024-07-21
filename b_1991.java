//트리순회
import java.io.*;
import java.util.*;

public class b_1991 {
    static class Node {
        char left;
        char right;

        public Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    static Map<Character, Node> tree = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    // 루트 - 왼 - 오
    public static void preorder(char root) {
        if (root == '.') return;
        sb.append(root);
        preorder(tree.get(root).left);
        preorder(tree.get(root).right);
    }

    // 왼 - 루트 -오
    public static void inorder(char root) {
        if (root == '.') return;
        inorder(tree.get(root).left);
        sb.append(root);
        inorder(tree.get(root).right);
    }

    // 왼 - 오 - 루트
    public static void postorder(char root) {
        if (root == '.') return;
        postorder(tree.get(root).left);
        postorder(tree.get(root).right);
        sb.append(root);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.put(node, new Node(left, right));
        }

        preorder('A');
        sb.append('\n');
        inorder('A');
        sb.append('\n');
        postorder('A');
        System.out.println(sb.toString());
    }
}
