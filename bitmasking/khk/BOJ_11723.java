package bitmasking.khk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 비트마스킹
 * [BOJ] 11723 - 집합
 * https://www.acmicpc.net/problem/11723
 */
public class BOJ_11723 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            int[] set = new int[20];
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String operator = st.nextToken();
                //Arrays.fill 1/0
                if (operator.equals("all")) {
                    Arrays.fill(set, 1);
                    continue;
                }
                else if (operator.equals("empty")) {
                    Arrays.fill(set, 0);
                    continue;
                }

                int x = Integer.parseInt(st.nextToken());
                if (operator.equals("add")) { //or(|)
                    set[x-1] = set[x-1]|1;
                }
                else if (operator.equals("remove")) { //and(&)
                    set[x-1] = set[x-1]&0;
                }
                else if (operator.equals("check")) {
                    sb.append(set[x-1] + "\n");
                }
                else if (operator.equals("toggle")) { //xor(^)
                    set[x-1] = set[x-1]^1;
                }
            }

            System.out.println(sb); //시간초과로 StringBuilder 사용
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
