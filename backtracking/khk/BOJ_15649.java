package backtracking.khk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 백트래킹
 * [BOJ] 15649 - N과 M (1)
 * https://www.acmicpc.net/problem/15649
 */
public class BOJ_15649 {
    static int n, m;
    static int[] sequence;
    static boolean[] used;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            //수열 초기화
            sequence = new int[m];
            //사용여부 배열 초기화
            used = new boolean[n];
            //수열 생성 시작
            makeSequence(0, sequence);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void makeSequence(int depth, int[] sequence) {
        //m개를 다 골랐으면 수열 배열을 출력하고 종료
        if (depth > m-1) {
            for (int seq : sequence) {
                System.out.print(seq + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            //이미 사용된 수이면 패스
            if (used[i-1]) continue;
            //수열에 값 입력
            sequence[depth] = i;
            //사용 체크
            used[i-1] = true;
            //다음 단계로 이동
            makeSequence(depth+1, sequence);
            //사용 해제
            used[i-1] = false;
        }
    }
}