import java.io.*;
import java.util.*;

public class BOJ_15900 {
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int totalDepth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++)
            tree.add(new ArrayList<>());

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        br.close();

        dfs(0, 1, 0);
        System.out.println(totalDepth % 2 == 1 ? "Yes" : "No");
    }

    static void dfs(int depth, int cur, int parent) {
        boolean check = false;

        for (int next : tree.get(cur)) {
            if (parent != next) {
                check = true;
                dfs(depth + 1, next, cur);
            }
        }

        if (!check)
            totalDepth += depth;
    }
}

