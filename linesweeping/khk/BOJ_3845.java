package inesweeping.khk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [BOJ] 3845 - 잔디깎기
 * https://www.acmicpc.net/problem/3845
 */
public class BOJ_3845 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int nx = Integer.parseInt(st.nextToken());
			int ny = Integer.parseInt(st.nextToken());
			double w = Double.parseDouble(st.nextToken()) / 2; //라인으로부터 폭의 절반씩 비교하므로 2로 나눔
			double[] xi = new double[nx];
			double[] yi = new double[ny];

      //종료 조건 입력 시 루프 종료
			if (nx == 0 && ny == 0 && w == 0.0) break;

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < nx; i++) {
				xi[i] = Double.parseDouble(st.nextToken());
			}
			Arrays.sort(xi); //정렬

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < ny; i++) {
				yi[i] = Double.parseDouble(st.nextToken());
			}
			Arrays.sort(yi); //정렬

      //가로-세로 모두 한 번 씩 지나가야 하므로 and 연산
			String result = lineSweeping(w, 75, xi) && lineSweeping(w, 100, yi) ? "YES" : "NO";
			System.out.println(result);
		}
		br.close();
	}

	private static boolean lineSweeping(double width, double limit, double[] inputs) {
		double tail = 0;
		boolean result = true;

    //이미 정렬된 배열이므로 앞에서부터 순차적으로 하나라도 틈새가 생기면 break
		for (double input : inputs) {
			if (input - width > tail) {
				result = false;
				break;
			}
			else {
				tail = input + width; //꼬리 갱신
			}
		}
		if (tail < limit) result = false; //순회 완료 후에도 끝지점 1회 체크 필요

		return result;
	}
}
