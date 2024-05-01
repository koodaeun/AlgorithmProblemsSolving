package bitmasking.khk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 1182 - 부분수열의 합
 * https://www.acmicpc.net/problem/1182
 */
public class BOJ_1182 {
    private static int n;
    private static int s;
    private static int[] seq;
    private static boolean[] visit;
    private static int cnt;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            seq = new int[n];
            visit = new boolean[n];

            st = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int i = 0; i < n; i++) {
                seq[i] = Integer.parseInt(st.nextToken()); //수열 입력
            }

            //부분수열의 길이(1~n) 별로 수행
            for (int i = 1; i <= n; i++) {
                search(0, 0, i); //dfs
            }
            System.out.println(cnt);

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void search(int idx, int sum, int depth) {
        //할당받은 부분수열 크기를 모두 채웠으면 s와 값 비교 후 카운트
        if (depth == 0) {
            if (sum == s) cnt++;
            return;
        }
        //할당받은 부분수열 크기를 만족 못 했지만 더이상 추가 가능한 원소가 업을 때 종료
        if (idx > n-1) return;

        for (int i = idx; i < n; i++) {
            //이미 사용한 원소면 패스
            if (visit[i]) continue;

            visit[i] = true;
            search(i+1, sum+seq[i], depth-1);
            visit[i] = false;
        }
    }
}
