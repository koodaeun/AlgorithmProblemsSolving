package dfs.khk;

import java.util.*;

/**
 * 전력망을 둘로 나누기
 */
class Programmers_86971 {
	public static void main(String[] args) {
		int n = 3;
		int[][] wires = {{1,2} {2,3}, {3,4}};
		int result = solution(n, wires);
	}
	static int min;

	public int solution(int n, int[][] wires) {
		min = n;
		int[][] map = new int[n][n];

		//연결관계 맵 생성
		for (int i = 0; i < n-1; i++) {
			int x = wires[i][0] - 1;
			int y = wires[i][1] - 1;
			map[x][y] = 1;
			map[y][x] = 1;
		}

		//wires를 순회하며 해제할 전력망 선택
		for (int i = 0; i < n-1; i++) {
			int cnt = 1;
			int x = wires[i][0] - 1;
			int y = wires[i][1] - 1;
			map[x][y] = 0; //전력망 해제
			map[y][x] = 0;

			boolean[] visit = new boolean[n];
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(x);
			visit[x] = true;

			while (!queue.isEmpty()) {
				int idx = queue.poll();

				for (int j = 0; j < n; j++) {
					//연결되어 있지 않거나 이미 방문한 송전탑은 패스
					if (map[idx][j] == 0) continue;
					if (visit[j]) continue;
					queue.offer(j);
					visit[j] = true;
					cnt++;
				}
			}

			int left = n - cnt;
			int diff = Math.abs(cnt - left);
			min = Math.min(min, diff);
			map[x][y] = 1; //전력망 연결
			map[y][x] = 1;
		}

		return min;
	}
}