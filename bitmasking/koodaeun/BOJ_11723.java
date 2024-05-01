package bitmasking.koodaeun;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_11723 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> S = new HashSet<>();

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            String command = st.nextToken();
            int x;

            switch (command) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    S.add(x);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    S.remove(x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    // 결과 출력
                    if (S.contains(x)) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    if (S.contains(x)) {
                        S.remove(x);
                    } else {
                        S.add(x);
                    }
                    break;
                case "all":
                    S.clear();
                    for (int j = 1; j <= 20; j++) {
                        S.add(j);
                    }
                    break;
                case "empty":
                    S.clear();
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
