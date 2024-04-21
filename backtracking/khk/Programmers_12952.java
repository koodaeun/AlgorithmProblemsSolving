package backtracking.khk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** 백트래킹 : 해를 찾는 도중 해가 아니어서 막히면, 되돌아가서 다시 해를 찾아가는 기법
 * Programmers-12952
 * https://school.programmers.co.kr/learn/courses/30/lessons/12952
 */
public class Programmers_12952 {
    static int cnt;
    static int n;
    static boolean[][] chess;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            n = Integer.parseInt(br.readLine());
            //체스판 초기화
            chess = new boolean[n][n];
            //백트래킹 시작
            backTracking(0);
            System.out.println(cnt);
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    static void backTracking(int depth) {
        //깊이가 크기를 넘어서면 성공한 것으로 판단하여 개수를 증가시키고 종료
        if (depth > n-1) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            //해당 위치에 퀸을 놓을 수 있는지 판별하는 함수
            if (!isPossible(depth, i)) continue;

            //퀸 셋업
            chess[depth][i] = true;
            //다음 단계로 이동
            backTracking(depth+1);
            //퀸 제거
            chess[depth][i] = false;
        }
    }

    //해당 위치에 퀸을 놓을 수 있는지 판별하는 함수
    //좌표를 입력으로 받음
    static boolean isPossible(int x, int y) {
        for (int i = 0; i < n; i++) {
            if (chess[x][i]) return false; //가로 탐색
            if (chess[i][y]) return false; //세로 탐색
        }

        int tmpX = x, tmpY = y;
        //대각선 탐색(-,-)
        while (true) {
            if (--tmpX < 0 || --tmpY < 0) break;
            if (chess[tmpX][tmpY]) return false;
        }

        tmpX = x; tmpY = y;
        //대각선 탐색(-,+)
        while (true) {
            if (--tmpX < 0 || ++tmpY > n-1) break;
            if (chess[tmpX][tmpY]) return false;
        }

        tmpX = x; tmpY = y;
        //대각선 탐색(+,-)
        while (true) {
            if (++tmpX > n-1 || --tmpY < 0) break;
            if (chess[tmpX][tmpY]) return false;
        }

        tmpX = x; tmpY = y;
        //대각선 탐색(+,+)
        while (true) {
            if (++tmpX > n-1 || ++tmpY > n-1) break;
            if (chess[tmpX][tmpY]) return false;
        }

        return true;
    }
}