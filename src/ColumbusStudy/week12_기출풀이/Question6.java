package ColumbusStudy.week12_기출풀이;

import java.io.*;
import java.util.*;

public class Question6 {

    // https://www.acmicpc.net/problem/22948
    // 해당 문제 나오면 틀린다고 생각하고 다른문제 집중
    private static boolean[] visited;
    private static int[][] circles;
    private static int A, B;
    private static ArrayList<Integer>[] tree;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        visited = new boolean[N + 1];
        circles = new int[(N*2)][2];
        tree = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = scanner.nextInt();
            }
            circles[i * 2] = new int[]{arr[i][0], arr[i][1] - arr[i][2]};
            circles[i * 2 + 1] = new int[]{-arr[i][0], arr[i][1] + arr[i][2]};
        }

        A = scanner.nextInt();
        B = scanner.nextInt();

        scanner.close();

        Arrays.sort(circles, Comparator.comparingInt(a -> a[1]));
        stack.push(0);

        makeTree();
        visited[A] = true;
        dfs(A, new ArrayList<Integer>(Arrays.asList(A)));
    }

    private static void makeTree() {
        for (int[] c : circles) {
            if (c[0] < 0) {
                stack.pop();
            } else {
                tree[stack.peek()].add(c[0]);
                tree[c[0]].add(stack.peek());
                stack.push(c[0]);
            }
        }
    }

    private static void dfs(int cur, ArrayList<Integer> path) {
        if (cur == B) {
            System.out.println(path.size());
            path.forEach((node) -> System.out.print(node + " "));
        } else {
            for (int next : tree[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    ArrayList<Integer> newPath = new ArrayList<>(path);
                    newPath.add(next);
                    dfs(next, newPath);
                    visited[next] = false;
                }
            }
        }
    }
}
