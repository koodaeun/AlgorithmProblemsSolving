package exhaustivesearch.khk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * [BOJ] 10448 - 유레카 이론
 * https://www.acmicpc.net/problem/10448
 */
public class BOJ_10448 {
	//가능한 최대 숫자는 44
	static int[] triangleArr = new int[44];

	static void initArr() {
		for (int i = 1; i <= 44; i++) {
			triangleArr[i-1] = (i*i + i) / 2;
		}
	}

	public static void main(String[] args) {
		//1. 삼각수 값 초기화. 1000을 넘어서지 않는 가장 큰 수는 44이므로 44까지만 초기화
		initArr();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			//2. 반복 횟수 입력받음
			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				//3. 타겟 정수 입력받음
				int number = Integer.parseInt(br.readLine());
				//4. 판별 결과는 false로 초기화
				boolean result = false;
				int sum = 0;

				//5. 3개의 삼각수로 표현가능한 지 알기 위하여 3중 반복문 사용
				loop: for (int j = 0; j < 44; j++) {
					for (int k = 0; k < 44; k++) {
						for (int l = 0; l < 44; l++) {
							sum = triangleArr[j] + triangleArr[k] + triangleArr[l];
							//5. 세 삼각수의 합이 입력받은 정수와 같을 때 성공으로 결과 변경 및 전체 루프 탈출
							if (sum == number) {
								result = true;
								break loop;
							}
						}
					}
				}

				//6. 각 케이스별로 성공(true)일 시 1을, 실패한 경우 0을 출력
				if (result) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
