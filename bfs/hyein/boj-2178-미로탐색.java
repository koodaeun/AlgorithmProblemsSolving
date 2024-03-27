import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(map[N - 1][M - 1]);
    }

    public static void bfs() {
        var queue = new LinkedList<int[]>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            var cur = queue.poll();
            var cy = cur[0];
            var cx = cur[1];

            visited[cy][cx] = true;

            for (int i = 0; i < 4; i++) {
                var ny = cy + direction[i][0];
                var nx = cx + direction[i][1];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    map[ny][nx] += map[cy][cx];
                    queue.add(new int[]{ny, nx});
                }

            }
        }
    }
}

