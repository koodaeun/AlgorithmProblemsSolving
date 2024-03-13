import java.util.*;

class Solution {
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] visited = new int[n][m];

        bfs(maps, visited, n, m);
        int answer = visited[n - 1][m - 1];

        return (answer > 0) ? answer : -1;
    }

    public static void bfs(int[][] maps, int[][] visited, int n, int m) {
        int x = 0, y = 0;
        visited[y][x] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 4; i++) {
                int dr = r + d[i][0];
                int dc = c + d[i][1];

                if (dr < 0 || dr >= n || dc < 0 || dc >= m) {
                    continue;
                }
                if (visited[dr][dc] == 0 && maps[dr][dc] == 1) {
                    queue.add(new int[]{dr, dc});
                    visited[dr][dc] = visited[r][c] + 1;
                }
            }
        }
    }
}
