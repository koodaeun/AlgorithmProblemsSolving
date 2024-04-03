import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15900 {
    static List<Integer>[] list;
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];

        for(int i = 1;i < n + 1;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0;i < n - 1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        bfs(1,-1,0);

        bw.write(cnt % 2 == 0 ? "No" : "Yes");
        bw.flush();
        bw.close();
        br.close();

    }
    // 깊이 우선 탐색
    static void bfs(int current, int parent, int depth){
        for(int next : list[current]){
            if(next != parent){
                bfs(next, current, depth + 1);
            }
        }
        if(list[current].size() == 1){
            cnt += depth;
        }
    }
}

