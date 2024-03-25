package dfs.khk;

import java.util.Stack;

/**
 * programmers-43162-네트워크
 *
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
 * 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
 * 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 *
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
 *
 * 제한사항
 * 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
 * 각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
 * i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
 * computer[i][i]는 항상 1입니다.
 *
 * 입출력 예
 * n	computers	return
 * 3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
 * 3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 * */

public class Programmers_43162 {
	static boolean[] visit;

	static int solution(int n, int[][] computers) {
		Stack<Integer> stack = new Stack<>();
		visit = new boolean[n];
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			if (visit[i] == true) continue;

			// 시작 노드 입력
			stack.push(i);

			// 시작 노드 방문
			visit[i] = true;

			// 스택이 비어있지 않으면 계속 반복
			while(!stack.isEmpty()) {

				// 노드 꺼내기
				int idx = stack.pop();

				// 꺼낸 노드와 인접한 노드 찾기
				for (int j = 0; j < n; j++) {
					if (idx == j) continue;

					// 인접한 노드를 방문하지 않았을 경우에 스택에 넣고 방문처리
					if(!visit[j] && computers[idx][j] == 1) {
						stack.push(j);
						visit[j] = true;
					}
				}
			}
			//네트워크 개수 카운트
			cnt++;
		}

		return cnt;
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] computer = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//		int[][] computer = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		int result = solution(n, computer);
	}
}
