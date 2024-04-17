package exhaustivesearch.khk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 17484 - 진우의 달 여행 (Small)
 * https://www.acmicpc.net/problem/17484
 */
public class BOJ_17484 {
	static int[] directions = {-1, 0, 1};
	static int min = -1;
	static int n;
	static int m;
	static int[][] matrix;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			//1. 행렬 구조 입력받음
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			matrix = new int[n][m];

			for (int i = 0; i < n; i++) {
				//2. 행렬 데이터 입력받음
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			//3. 첫 행은 어디던지 시작할 수 있음
			for (int i = 0; i < m; i++) {
				int sum = matrix[0][i];
				int[] presLocation = {0, i};
				//4. 첫 행은 이전 방향이 없기 때문에 모든 방향으로 이동 가능하나 처음/마지막열은 증감 제약이 있음
				for (int j = 0; j < directions.length; j++){
					int direction = directions[j];
					if (i == 0 && direction == -1) continue;
					if (i == m-1 && direction == 1) continue;
					travel(direction, presLocation, sum);
				}
			}
			System.out.println(min);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void travel(int direction, int[] prevLocation, int sum) {
		//1. 직전 행이 마지막 행이면 최소값 비교 후 종료
		if (prevLocation[0] == n-1) {
			if (min < 0) min = sum;
			min = Math.min(min, sum);
			return;
		}

		//2. 직전 위치에서 다음 행으로 이동 및 전달받은 위치로 열 이동
		int presN = prevLocation[0]+1;
		int presM = prevLocation[1]+direction;
		int[] presLocation = {presN, presM};

		//3. 현재 위치의 비용 합산
		sum += matrix[presN][presM];

		//4. 다음 위치로 이동
		for (int i = 0; i < directions.length; i++) {
			int nextDirection = directions[i];
			//5-1. 현재 위치와 다음 위치가 같을 수 없음
			if (nextDirection == direction) continue;
			//5-2. 이동한 열의 위치가 0보다 적거나 m을 초과할 수 없음
			if (presM + nextDirection < 0 || presM + nextDirection >= m) continue;
			//5-3. 반복
			travel(nextDirection, presLocation, sum);
		}
	}
}
