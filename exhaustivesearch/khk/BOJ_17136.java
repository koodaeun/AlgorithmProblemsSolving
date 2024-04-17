package exhaustivesearch.khk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 17136 - 색종이 붙이기
 * https://www.acmicpc.net/problem/17136
 */
public class BOJ_17136 {
	static int[][] paper = new int[10][10];
	static int[] types = {5,5,5,5,5};
	static int min = Integer.MAX_VALUE; //모든 색종이를 사용해도 최대값보다 작음

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			StringTokenizer stringTokenizer;
			for (int i = 0; i < 10; i++) {
				stringTokenizer = new StringTokenizer(reader.readLine(), " ");
				for (int j = 0; j < 10; j++) {
					paper[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}
			reader.close();
			
			//실행
			confetti(0, 0, 0);
			min = min == Integer.MAX_VALUE? -1 : min;
			System.out.println(min);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void confetti(int n, int m, int accumulateCnt) {
		//1. 누적개수가 최소값을 초과하면 해당 회차 종료
		if (accumulateCnt > min) return;
		//2. 마지막 열에 도착했을 때
		if (m > 9) {
			//3-1. 마지막 행이면 최소값에 누적개수 대입
			if (n == 9) {
				min = accumulateCnt;
			}
			//3-2. 마지막 행이 아니면 다음 행의 첫번째 열로 이동
			else {
				confetti(n+1, 0, accumulateCnt);
			}
			return;
		}

		int val = paper[n][m];
		//4. 해당 위치에 색종이를 붙일 수 없으면 다음 열로 이동
		if (val != 1) {
			confetti(n, m+1, accumulateCnt);
		}
		else {
			//5-1. 1 ~ 5 사이즈의 색종이를 순회하면서
			for (int i = 0; i < 5; i++) {
				//5-2. 해당 크기의 색종이 여유분이 없으면 다른 색종이로 패스
				if (types[i] < 1) continue;
				//5-3. n,m 위치로부터 해당 색종이를 붙일 공간이 없으면 다른 색종이로 패스
				if (!available(n, m, i+1)) continue;
				//5-4. 색종이를 붙이고 붙일 수 없도록 선점
				apply(n, m, i+1, 0);
				//5-5. 다음 열로 이동
				confetti(n, m+1, accumulateCnt+1);
				//5-6. 해당 위치의 하위 루프를 다 돌고 오면 선점 해제
				apply(n, m, i+1, 1);
			}
		}

	}

	static boolean available(int n, int m, int type) {
		int limitX = n + type;
		int limitY = m + type;
		//시작점으로부터 색종이 크기만큼 공간이 없으면 불가능
		if (limitX > 10 || limitY > 10) return false;

		for (int i = n; i < limitX; i++) {
			for (int j = m; j < limitY; j++) {
				int val = paper[i][j];
				//색종이 크기 내에 0이 하나라도 있으면 불가능
				if (val != 1) return false;
			}
		}
		return true;
	}

	static void apply(int n, int m, int type, int val) {
		int limitX = n + type;
		int limitY = m + type;

		//선점 했을 경우 해당 크기의 색종이 횟수 차감
		if (val == 0) {
			types[type-1] -= 1;
		} 
		//선점 해제 했을 경우 색종이 횟수 복구
		else {
			types[type-1] += 1;
		}

		//종이 내 숫자 변경
		for (int i = n; i < limitX; i++) {
			for (int j = m; j < limitY; j++) {
				paper[i][j] = val;
			}
		}
	}
}
