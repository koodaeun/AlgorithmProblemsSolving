package bitmasking.khk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 11811 - 데스스타
 * https://www.acmicpc.net/problem/11811
 */
public class BOJ_11811 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] result = new int[n];

            for (int i = 0; i < n; i++) {
                String input = bufferedReader.readLine();
                StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
                for (int j = 0; j < n; j++) {
                    int val = Integer.parseInt(stringTokenizer.nextToken());
                    if (i == j) continue; //대각선은 무의미한 숫자이므로 패스
                    //and 연산된 행렬의 값이 1이면 연산에 사용된 모든 값들이 1이므로 or 연산을 통해 복제
                    result[i] = result[i] | val;
                    result[j] = result[j] | val;
                }
            }

            for (int i : result) {
                System.out.print(i + " ");
            }

            bufferedReader.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
