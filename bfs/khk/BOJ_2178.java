package dfs.khk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로 탐색
 * */
public class Main {
	static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static boolean[][] visit;
	static int[][] riddle;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			riddle = new int[size[0]][size[1]];
			visit = new boolean[size[0]][size[1]];

			for (int i = 0; i < size[0]; i++) {
				riddle[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			}
			br.close();

			//시작점도 카운트에 포함
			visit[0][0] = true;
			bfs(0, 0);

			int result = riddle[size[0]-1][size[1]-1];
			System.out.println(result);
		} catch (IOException ie) { }

	}

	static void bfs(int x, int y) {
		Queue<Integer[]> queue = new LinkedList<>();
		Integer[] start = {x, y};
		queue.offer(start);

		while (!queue.isEmpty()) {
			Integer[] idx = queue.poll();

			//한 칸씩 이동 가능(상하좌우만 가능)
			for (int i = 0; i < direction.length; i++) {
				int nextX = idx[0] + direction[i][0];
				int nextY = idx[1] + direction[i][1];

				//x, y 좌표 중 끝 단을 넘어가면 패스, 길이 없으면 패스, 이미 방문했으면 패스
				if (nextX < 0 || nextY < 0 || nextX >= riddle.length || nextY >= riddle[0].length) continue;
				if (riddle[nextX][nextY] == 0) continue;
				if (visit[nextX][nextY]) continue;

				//가능한 경우 큐에 넣고 방문 처리
				queue.offer(new Integer[]{nextX, nextY});
				visit[nextX][nextY] = true;
				//누적된 방문 횟수는 직전 방문 횟수 + 1 과 같음
				riddle[nextX][nextY] = riddle[idx[0]][idx[1]] + 1;
			}
		}
	}
}