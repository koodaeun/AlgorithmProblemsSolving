import java.util.*;

class Solution {

    int [] nx ={1,0,-1,0};
    int [] ny ={0,1,0,-1};

    static int n;
    static int m;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] maps = new int[n][m];
        int [][] visited = new int[n][m];
        sc.nextLine();


        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                maps[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(maps, visited);
        System.out.println(visited[n - 1][m - 1]);

    }


    public static void bfs(int[][] maps, int[][] visited){
        int [] nx ={1,0,-1,0};
        int [] ny ={0,1,0,-1};
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] current = queue.remove();
            int cX = current[0];
            int cY = current[1];

            for(int i = 0; i < 4; i++){
                int nX = cX + nx[i];
                int nY = cY + ny[i];

                if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1)
                    continue;

                if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
                    visited[nX][nY] = visited[cX][cY] + 1;
                    queue.add(new int[]{nX, nY});
                }
            }

        }

    }
}