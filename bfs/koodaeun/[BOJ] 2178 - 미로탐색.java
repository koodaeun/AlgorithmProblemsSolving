import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(input[j]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) { 
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1]; 

            //위
            if (x - 1 >= 0 && maze[x - 1][y] == 1) {
                queue.add(new int[]{x - 1, y});
                maze[x - 1][y] = maze[x][y] + 1;
            }
            //아래
            if (x + 1 < N && maze[x + 1][y] == 1) {
                queue.add(new int[]{x + 1, y});
                maze[x + 1][y] = maze[x][y] + 1;
            }
            //왼
            if (y - 1 >= 0 && maze[x][y - 1] == 1) {
                queue.add(new int[]{x, y - 1});
                maze[x][y - 1] = maze[x][y] + 1;
            }
            //오
            if (y + 1 < M && maze[x][y + 1] == 1) {
                queue.add(new int[]{x, y + 1});
                maze[x][y + 1] = maze[x][y] + 1;
            }
        }
        System.out.println(maze[N - 1][M - 1]);
    }
}