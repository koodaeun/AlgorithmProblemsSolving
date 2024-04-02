package tree.khk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [BOJ] 9372 - 상근이의 여행
 * https://www.acmicpc.net/problem/9372
 *
 * 상근이는 겨울방학을 맞아 N개국을 여행하면서 자아를 찾기로 마음먹었다.
 * 하지만 상근이는 새로운 비행기를 무서워하기 때문에, 최대한 적은 종류의 비행기를 타고 국가들을 이동하려고 한다.
 * 이번 방학 동안의 비행 스케줄이 주어졌을 때, 상근이가 가장 적은 종류의 비행기를 타고 모든 국가들을 여행할 수 있도록 도와주자.
 * 상근이가 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도(심지어 이미 방문한 국가라도) 된다.
 *
 * 입력
 * 첫 번째 줄에는 테스트 케이스의 수 T(T ≤ 100)가 주어지고,
 *
 * 첫 번째 줄에는 국가의 수 N(2 ≤ N ≤ 1 000)과 비행기의 종류 M(1 ≤ M ≤ 10 000) 가 주어진다.
 * 이후 M개의 줄에 a와 b 쌍들이 입력된다. a와 b를 왕복하는 비행기가 있다는 것을 의미한다. (1 ≤ a, b ≤ n; a ≠ b)
 * 주어지는 비행 스케줄은 항상 연결 그래프를 이룬다.
 *
 * 출력
 * 테스트 케이스마다 한 줄을 출력한다.
 * 상근이가 모든 국가를 여행하기 위해 타야 하는 비행기 종류의 최소 개수를 출력한다.
 */
public class BOJ_9372 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				int nationCnt = Integer.parseInt(input.split(" ")[0]);
				int airlineCnt = Integer.parseInt(input.split(" ")[1]);
				int[][] airlines = new int[airlineCnt][2];

				for (int j = 0; j < airlineCnt; j++) {
					airlines[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				}

				/* ANSWER1. BFS */
				//bfs(nationCnt, airlines);

				/* ANSWER2. 모든 노드는 연결되어 있고, 모든 노드를 연결하는 최소의 간선 수는 N-1 개이기 때문에 그냥 nationCnt -1을 바로 출력한다. */
				System.out.println(nationCnt-1);
			}
			br.close();

		} catch (Exception e) {

		}

	}

	static void bfs(int nationCnt, int[][] airlines) {
		boolean[] visit = new boolean[nationCnt];
		int[][] map = new int[nationCnt][nationCnt];
		int cnt = 0;

		//맵 생성
		for (int[] airline : airlines) {
			int x = airline[0]-1;
			int y = airline[1]-1;
			map[x][y] = 1;
			map[y][x] = 1;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		visit[0] = true;

		while (!queue.isEmpty()) {
			int nation = queue.poll();
			for (int i = 0; i < nationCnt; i++) {
				if (visit[i]) continue;
				if (map[nation][i] == 0) continue;
				queue.offer(i);
				visit[i] = true;
				cnt++;
			}
		}

		//한 노선을 여러번 사용해도 1회만 카운트 되므로 모든 노드를 순회한 횟수와 같습니다.
		System.out.println(cnt);
	}
}
