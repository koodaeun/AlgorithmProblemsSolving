class Solution {
    private static int[][] points = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int min = 0;

    public int solution(int[][] maps) {
        min = maps.length * maps[0].length + 1;
        int[] start = {0, 0};
        moving(0, start, maps);
        if (min > maps.length * maps[0].length) {
            return -1;
        }
        return min;
    }

    public static void moving(int cnt, int[] now, int[][] maps) {
        int x = now[0];
        int y = now[1];
        if (maps[x][y] == 0 || maps[x][y] == 2) return;

        cnt++;
        maps[x][y] = 2;
        if (x == maps.length-1 && y == maps[0].length-1) {
            min = Math.min(min, cnt);
            return;
        }

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int newX = x + point[0];
            int newY = y + point[1];

            if (newX < 0 || newY < 0) continue;
            if (newX > maps.length-1 || newY > maps[0].length-1) continue;
            int[] next = {newX, newY};
            moving(cnt, next, maps);
        }
    }
}